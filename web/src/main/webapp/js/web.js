var web = web || {}

(function () {
    $(document).delegate(".te-table-FnButton-Paging", "click", function (e) {
        e.preventDefault();
        if ($(this).closest("li").hasClass("disabled")) return;
        var val = $(this).closest("li").attr("data-value");
        $("[name=currentPage]").attr("value", val);
        $("[name=form1]").submit();
    });

    $(document).delegate("select[name=countItems]", "change", function (e) {
        e.preventDefault();
        $("[name=currentPage]").attr("value", 1);
        $("[name=form1]").submit();
    })
}());
