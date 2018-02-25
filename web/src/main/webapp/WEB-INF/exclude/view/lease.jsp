<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!Float f; %>
<html>
<head>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<div class="container mycontainer">
    <form name="form1" class="" role="form" action="/lease" method="get">
        <div class="panel panel-default filter">
            <div class="panel-heading">Filter</div>
            <div class="panel-body">
                <div class="row">
                    <div class="form-group col-xs-12">
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Min price, $</span>
                                <input name="priceMin" value="${(f = leaseDTO.filter.priceMin) == null ? "" : f}" type="text" class="form-control" placeholder="100.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max price, $</span>
                                <input name="priceMax" value="${(f = leaseDTO.filter.priceMax) == null ? "" : f}" type="text" class="form-control" placeholder="300.35">
                            </div>
                        </div>
                        <div class="form-group col-xs-4">
                            <div class="input-group">
                                <span class="input-group-addon">Count Items on the Page</span>
                                <select name="countItems" class="form-control">
                                    <option <c:out value="${leaseDTO.filter.countItems == 1 ? 'selected' : ''}" /> value="1">1</option>
                                    <option <c:out value="${leaseDTO.filter.countItems == 5 ? 'selected' : ''}" /> value="5">5</option>
                                    <option <c:out value="${leaseDTO.filter.countItems == 10 ? 'selected' : ''}" /> value="10">10</option>
                                    <option <c:out value="${leaseDTO.filter.countItems == 50 ? 'selected' : ''}" /> value="50">50</option>
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
                                <input name="squareMin" value="${(f = leaseDTO.filter.squareMin) == null ? "" : f}" type="text" class="form-control" placeholder="700.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max square, m2</span>
                                <input name="squareMax" value="${(f = leaseDTO.filter.squareMax) == null ? "" : f}" type="text" class="form-control" placeholder="1200.35">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Min $/m2</span>
                                <input name="pm2Min" value="${(f = leaseDTO.filter.pm2Min) == null ? "" : f}" type="text" class="form-control" placeholder="50.15">
                            </div>
                        </div>
                        <div class="form-group col-xs-3">
                            <div class="input-group">
                                <span class="input-group-addon">Max $/m2</span>
                                <input name="pm2Max" value="${(f = leaseDTO.filter.pm2Max) == null ? "" : f}" type="text" class="form-control" placeholder="700.35">
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
            <div class="table-responsive">
                <table class="table table-hover table-condensed table-bordered">
                    <thead>
                    <tr>
                        <th>Building</th>
                        <th>Room Name</th>
                        <th>Price</th>
                        <th>Square</th>
                        <th>price m2</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${leaseDTO.listLeaseAd.size() > 0}" >
                                <c:forEach var="leaseAd" items="${leaseDTO.listLeaseAd}">
                                    <tr class="">
                                        <td>${leaseAd.room.roomsObject.name}</td>
                                        <td>${leaseAd.room.name}</td>
                                        <td>${leaseAd.price}</td>
                                        <td>${leaseAd.room.square}</td>
                                        <td>${leaseAd.room.square == null ? "" : leaseAd.price/leaseAd.room.square}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr><td>Нет элементов</td></tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="container">
            <div class="center-block">
                <input type="hidden" name="currentPage" value="${leaseDTO.pagingInfo.currentPage}"/>
                <ul class="pagination">
                    <c:forEach var="pg" items="${leaseDTO.pagingInfo.pagerModel.pagerLinks}">
                        <c:choose>
                            <c:when test="${pg.value == leaseDTO.pagingInfo.currentPage}">
                                <li class="active" data-value="${pg.value}">
                                    <a href="#" class="">${pg.key}<span class="sr-only">(current)</span></a>
                                </li>
                            </c:when>
                            <c:when test="${pg.value == 0}">
                                <li class="disabled"><a href="#" class="">${pg.key}</a></li>
                            </c:when>
                            <c:when test="${pg.value == -1}">
                                <li class="disabled"><a href="#" class="">${pg.key}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li data-value="${pg.value}"><a href="#" class="te-table-FnButton-Paging">${pg.key}</a></li>
                            </c:otherwise>
                        </c:choose>
                        <tr class="">
                            <td>${leaseAd.room.roomsObject.name}</td>
                            <td>${leaseAd.room.name}</td>
                            <td>${leaseAd.price}</td>
                            <td>${leaseAd.room.square}</td>
                            <td>${leaseAd.room.square == null ? "" : leaseAd.price/leaseAd.room.square}</td>
                        </tr>
                    </c:forEach>
                </ul>
            </div>
        </div>

    </form>
</div>

<!-- jQuery -->
<script src="/js/jquery-1.10.2.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="/js/bootstrap.min.js"></script>
<script src="/js/web.js"></script>
</body>
</html>
