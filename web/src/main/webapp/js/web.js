var web = web || {};

web.paging = {
    submitFormWhenClickPaging: function() {
        $(document).delegate(".form-filter-paging-FnButton-Paging", "click", function (e) {
            e.preventDefault();
            var val = $(this).closest("li").attr("data-value");
            $("#currentPage").attr("value", val);
            $("[name=form-filter-paging]").submit();
        });
    },
    submitFormWhenChangeSELECT_ITEMSPERPAGE_DEFAULT: function () {
        $(document).delegate("#SELECT_ITEMSPERPAGE_DEFAULT", "change", function (e) {
            e.preventDefault();
            $("#SELECT_ITEMSPERPAGE_DEFAULT").attr("value", 1);
            $("[name=form-filter-paging]").submit();
        })
    }
};
web.mediator = {
    init: function () {
        web.paging.submitFormWhenClickPaging();
        web.paging.submitFormWhenChangeSELECT_ITEMSPERPAGE_DEFAULT();
    }
};
$(function () {
    web.mediator.init();
    console.log("work");
});
