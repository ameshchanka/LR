<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container mycontainer">
    <form class="" role="form" action="/lease" method="get">
        <div class="panel panel-default">
            <div class="panel-heading">Filter</div>
            <div class="panel-body">
                <div class="row">
                    <div class="form-group col-xs-12">
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Min price, $</span>
                                <input name="priceMin" value="${leaseDTO.filter.priceMin}" type="text" class="form-control" placeholder="100.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max price, $</span>
                                <input name="priceMax" value="<c:out value="#{leaseDTO.filter.priceMax}" />" type="text" class="form-control" placeholder="300.35">
                            </div>
                        </div>
                        <div class="form-group col-xs-4">
                            <div class="input-group">
                                <span class="input-group-addon">Count Items on the Page</span>
                                <select name="maxResult" class="form-control">
                                    <option <c:out value="${leaseDTO.maxResult == 1 ? 'selected' : ''}" /> value="1">1</option>
                                    <option <c:out value="${leaseDTO.maxResult == 5 ? 'selected' : ''}" /> value="5">5</option>
                                    <option <c:out value="${leaseDTO.maxResult == 10 ? 'selected' : ''}" /> value="10">10</option>
                                </select>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Min square, m2</span>
                                <input name="squareMin" value="<c:out value="${leaseDTO.squareMin}" />" type="text" class="form-control" placeholder="700.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max square, m2</span>
                                <input name="squareMax" value="<c:out value="${leaseDTO.squareMax}" />" type="text" class="form-control" placeholder="1200.35">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Min $/m2</span>
                                <input name="pm2Min" value="<c:out value="${leaseDTO.pm2Min}" />" type="text" class="form-control" placeholder="50.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max $/m2</span>
                                <input name="pm2Max" value="<c:out value="${leaseDTO.pm2Max}" />" type="text" class="form-control" placeholder="700.35">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-2">
                        <button type="submit" id="apply" name="apply" value="apply" class="btn btn-success btn-sm">Apply</button>
                    </div>
                </div>
            </div>
        </div>
        <hr />
        <!-- TABLE -->
        <div class="tab-content">
            <%--<ul class="nav navbar-left nav-stacked" style="min-width: 330px;">--%>
            <%--<c:forEach var="lv" items="${leaseview}" >--%>
            <%--<li>--%>
            <%--<a href='do?command=shoppingcenter&id=<c:out value="${lv.shoppingCenter.id}" />'>--%>
            <%--<c:out value="${lv.address}" />&nbsp;&nbsp;&nbsp;--%>
            <%--Shopping Center &nbsp;--%>
            <%--<c:out value="${lv.shoppingCenter.name}" />--%>
            <%--<span class="badge pull-right">--%>
            <%--<c:out value="${lv.count}" />--%>
            <%--</span>--%>
            <%--</a>--%>
            <%--</li>--%>
            <%--</c:forEach>--%>
            <%--</ul>--%>
            <div class="table-responsive">
                <table class="table table-hover table-condensed table-bordered">
                    <thead>
                    <tr>
                        <th>Build</th>
                        <th>Room Name</th>
                        <th>Price</th>
                        <th>Square</th>
                        <th>price m2</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr class="info">
                        <td>Build</td>
                        <td>Room Name</td>
                        <td>Price</td>
                        <td>Square</td>
                        <td>price m2</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</div>

<!-- jQuery -->
<script src="/js/jquery-1.10.2.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
