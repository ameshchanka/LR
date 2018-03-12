var nb = nb || {}

nb.utilities = (function() {
    // isArray
    if(typeof Array.isArray === "undefined"){
        Array.isArray = function(arg) {
            return Object.prototype.toString.call(arg) === "[object Array]";
        }
    }
    // get the value for a key from an array of objects
    if(typeof Array.arrayObjectGetValue === "undefined"){
        Array.arrayObjectGetValue = function(array, search) {
            var i = array.length;
            while (i--) {
                if (array[i].key === search) {
                    return array[i].value;
                }
            }
        }
    }
}());

nb.region = {
    map: {},
    options: {
        lat: 51.50485,
        lon: -0.113698,
        d_lat: 0.0034, // 700 м
        d_lon: 0.0052, // 700 м
        contentString: function( name, bikes, emptyDocks) {
            return '<div class="nbDocks">' +
                '<div class="nbDockName">' + name + '</div>' +
                '<div class="nbBikes">bikes available: ' + bikes + '</div>' +
                '<div class="emptyDocks">spaces: ' + emptyDocks + '</div>' +
                '</div>';
        }
    },
    paintData: {
        userLocation: null,
        poligon: null,
        arrCircleBP: [],
        arrInfoWindow: []
    },
    //userLocation: null,
    clearMap: function() {
        var obj = nb.region.paintData;
        // delete old bikePoint and poligon
        if(obj.poligon){
            obj.poligon.setMap(null);
            obj.poligon = null;
        }
        if(obj.arrInfoWindow.length > 0){
            $.each(obj.arrInfoWindow, function (index, o) {
                if(o){
                    o.setMap(null);
                }
            });
            obj.arrInfoWindow = [];
        }
        if(obj.arrCircleBP.length > 0){
            $.each(obj.arrCircleBP, function (index, o) {
                if(o){
                    google.maps.event.clearListeners(o, 'click');
                    o.setMap(null);
                }
            });
            obj.arrCircleBP = [];
        }
        // delete old center (the user's location)
        if(obj.userLocation){
            obj.userLocation.setMap(null);
            obj.userLocation = null;
        }
    },
    drawBikePoints: function(arr) {
        var ob = nb.region,
            opt = nb.region.options,
            pai = nb.region.paintData,
            name,
            bikes,
            emptyDocks,
            listener = [],
            // Construct the polygon.
            poligonCoords = [
                {lat: opt.lat - opt.d_lat, lng: opt.lon - opt.d_lon},
                {lat: opt.lat - opt.d_lat, lng: opt.lon + opt.d_lon},
                {lat: opt.lat + opt.d_lat, lng: opt.lon + opt.d_lon},
                {lat: opt.lat + opt.d_lat, lng: opt.lon - opt.d_lon},
                {lat: opt.lat - opt.d_lat, lng: opt.lon - opt.d_lon}
            ];
        pai.poligon = new google.maps.Polygon({
            paths: poligonCoords,
            strokeColor: '#0000FF',
            strokeOpacity: 0.2,
            strokeWeight: 3,
            fillColor: '#0000FF',
            fillOpacity: 0.02,
            clickable: false
        });

        if(Array.isArray(arr) && arr.length > 0){
            $.each(arr, function(index, r){
                pai.arrCircleBP[index] = new google.maps.Circle({
                    strokeColor: '#FF0000',
                    strokeOpacity: 0.90,
                    strokeWeight: 3,
                    fillColor: '#0000FF',
                    fillOpacity: 0.4,
                    map: ob.map,
                    center: {lat: r.lat, lng: r.lon},
                    radius: 8
                });
                if(Array.isArray(r.additionalProperties)){
                    name = r.commonName;
                    bikes = Array.arrayObjectGetValue(r.additionalProperties, "NbBikes");
                    emptyDocks = Array.arrayObjectGetValue(r.additionalProperties, "NbEmptyDocks");
                    pai.arrInfoWindow[index] = new google.maps.InfoWindow({
                        content: opt.contentString(name, bikes, emptyDocks),
                        position: {lat: r.lat, lng: r.lon}
                    });
                    listener[index] = new google.maps.event.addListener(pai.arrCircleBP[index], 'click', function(){
                        pai.arrInfoWindow[index].open(ob.map, pai.arrCircleBP[index]);
                    });
                }
            });
        }
        pai.poligon.setMap(ob.map);
    },
    // drawCenter: function() {
    //     var ob = nb.region,
    //         latC = ob.options.lat,
    //         lngC = ob.options.lon;
    //     ob.paintData.userLocation = new google.maps.Circle({
    //         strokeColor: '#0F0FF0',
    //         strokeOpacity: 0.90,
    //         strokeWeight: 2,
    //         fillColor: '#0FAF00',
    //         fillOpacity: 0.90,
    //         map: ob.map,
    //         center: {lat: latC, lng: lngC},
    //         radius: 7
    //     });
    //     ob.map.setCenter({lat: latC, lng: lngC});
    // },
    initMap: function () {
        var latCenter = nb.region.options.lat,
            lngCenter = nb.region.options.lon;
        // Create the map.
        nb.region.map = new google.maps.Map(document.getElementById('map'), {
            zoom: 16,
            center: {lat: latCenter, lng: lngCenter},
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });
    },
    scriptMaps: function(callback) {
        var key = nb.constant.get("GMJsAPI_AppKEY");
        return  "<script src='https://maps.googleapis.com/maps/api/js?key=" + key + "&callback="+ callback +"' async defer></script>";
    }
}
nb.mediator = {
    testNumber: 0,
    // getBikePointsLatLon: function() {
    //     var objUser = nb.userLatLng,
    //         obj = nb.region,
    //         opt,
    //         swLat, swLon, neLat, neLon,
    //         arrUserLatLng = objUser.getUserLatLng(objUser, nb.mediator.testNumber)["testLatLng_i"];
    //     obj.options = $.extend(obj.options, arrUserLatLng);
    //     opt = obj.options;
    //     swLat = opt.lat - opt.d_lat;
    //     swLon = opt.lon - opt.d_lon;
    //     neLat = opt.lat + opt.d_lat;
    //     neLon = opt.lon + opt.d_lon;
    //     nb.bikePoint.getBikePointsLatLon(swLat, swLon, neLat, neLon, function(arrbp){
    //         obj.clearMap();
    //         obj.drawCenter();
    //         obj.drawBikePoints(arrbp);
    //
    //         /* // display all InfoWindow about bikepoint
    //         for(var i = 0; i < obj.paintData.arrCircleBP.length; i++){
    //             console.log('i = ' + i);
    //             google.maps.event.trigger(nb.region.paintData.arrCircleBP[i], 'click', {});
    //         }
    //         */
    //     });
    // },
    events: function(){
        // Test data - user location
        // $(document).delegate("#updateButton", "click", function (e) {
        //     e.preventDefault();
        //     if(nb.mediator.testNumber === 2){
        //         nb.mediator.testNumber = 0;
        //     }
        //     else{
        //         nb.mediator.testNumber += 1;
        //     }
        //     nb.mediator.getBikePointsLatLon();
        // })
    },
    init: function(){

    },
    initMap: function() {
        nb.region.initMap();
        nb.mediator.events();
    }
};

$(function() {
    //nb.mediator.init();
    $("body").append(nb.region.scriptMaps("nb.mediator.initMap"));
});