var web = web || {}

(function () {
    $(document).delegate(".te-table-FnButton-Paging", "click", function (e) {
        e.preventDefault();
        if ($(this).closest("li").hasClass("disabled")) return;
        var val = $(this).closest("li").attr("data-value");
        $("#currentPage").attr("value", val);
        $("[name=form1]").submit();
    });

    $(document).delegate("#countItems", "change", function (e) {
        e.preventDefault();
        $("#currentPage").attr("value", 1);
        $("[name=form1]").submit();
    })
}());
