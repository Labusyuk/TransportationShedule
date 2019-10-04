<%@ page import="com.labus.showcase.entity.Ways" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="msapplication-TileColor" content="#0061da">
    <meta name="theme-color" content="#1643a3">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico">


    <!-- Title -->
    <title>Gemicle - Vinnytsia Logistics</title>
		
	<link href="\views\assets\css\bootstrap.css" rel="stylesheet">
	<link href="\views\assets\css\bootstrap-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="\views\assets\fonts\fonts\font-awesome.min.css">

    <!-- Font Family -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <!-- Dashboard Css -->
    <link href="\views\assets\css\dashboard.css" rel="stylesheet">

    <!-- c3.js Charts Plugin -->
    <link href="\views\assets\plugins\charts-c3\c3-chart.css" rel="stylesheet">

    <!-- select2 Plugin -->
    <link href="\views\assets\plugins\select2\select2.min.css" rel="stylesheet">

    <!-- Time picker Plugin -->
    <link href="\views\assets\plugins\time-picker\jquery.timepicker.css" rel="stylesheet">

    <!-- Date Picker Plugin -->
    <link href="\views\assets\plugins\date-picker\spectrum.css" rel="stylesheet">

    <!-- Custom scroll bar css-->
    <link href="\views\assets\plugins\scroll-bar\jquery.mCustomScrollbar.css" rel="stylesheet">

    <!---Font icons-->
    <link href="\views\assets\plugins\iconfonts\plugin.css" rel="stylesheet">

</head>
<body class="">
<div id="global-loader"></div>
<div class="page">
    <div class="page-main">
        <div class="header py-4">
            <div class="container">
                <div class="d-flex">
                    <a class="header-brand" href="#">
                        Vinnytsia Logistics
                    </a>
                    <div class="d-flex order-lg-2 ml-auto">
                        <div class="dropdown">
                            <a href="#" class="nav-link pr-0 leading-none" data-toggle="dropdown">
                            </a>
                            <!--    <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                   <a class="dropdown-item" href="">
                                       Выход
                                   </a>
                               </div> -->
                        </div>
                    </div>
                    <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse" data-target="#headerMenuCollapse">
                        <span class="header-toggler-icon"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="my-3 my-md-5">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <form method="post" class="card">
                            <div class="card-header">
                                <h3 class="card-title">Побудова маршрута</h3>
                            </div>
                            <div class="card-body">
							<table class="table table-condensed">

                                <div class="row d-flex justify-content-center">
 <tbody>
  <tr class="info">
    <td>Початкова зупинка</td>
    <td>Кінцева зупинка</td>
  </tr>
    <tr class="success">
    <td><select name="staying1" class="form-control input-sm">
        <c:forEach var="staying" items="${stayings}">
        <option <c:if test="${staying1==staying.getName()}">selected</c:if>>${staying.getName()}</option>
        </c:forEach>
      </select></td>

    <td><select name="staying2"class="form-control input-sm">
        <c:forEach var="staying" items="${stayings}">
            <option <c:if test="${staying2==staying.getName()}">selected</c:if>>${staying.getName()}</option>
        </c:forEach>
      </select></td>
  </tr>
  <tr class="success">
  <td colspan="2">
  <center>
  <p><input type="checkbox" name="useTime" value="true">Планувати точний час</p>
  <input name="time" type="time">
  <p><input type="checkbox" name="weekend" value="true">Вихідний день</p>
  <center>
  </td>
  </tr>
  
 </tbody>
</table>                        						
                            
                                <div class="d-flex">
                                    <!-- <a href="javascript:void(0)" class="btn btn-link">Cancel</a> -->
                                    <button type="submit" class="btn btn-primary ml-auto">Побудувати</button>
                                </div>
                           <hr>
						   <table class="table table-bordered">
<thead>
<tr>
<th>#</th>
<th colspan="2">Остановка 1</th>
<th colspan="2">Остановка 2 (Пересадка)</th>
<th colspan="2">Остановка 3</th>

</tr>
</thead>
<tbody>
<% int i=0; %>
<c:forEach var="ways" items="${waysList}">
<tr>
<td rowspan="3"><%=++i%></td>
    <c:forEach var="transport" items="${ways}">
        <c:if test="${ways.size()==1}">
        <td colspan="6">${transport.getName()}<span class="label">${transport.getForward().getDuration()}мин</span></td>
        </c:if>
        <c:if test="${ways.size()==2}">
            <td colspan="3">${transport.getName()}<span class="label">${transport.getForward().getDuration()}мин</span></td>
        </c:if>
    </c:forEach>
<%--<td colspan="6">77 Автобус <span class="label">21мин</span></td>--%>
</tr>
<tr>
            <c:if test="${ways.size()==1}">
                <c:forEach var="transport" items="${ways}">
        <td colspan="3"><span class="label label-info">${transport.getForward().getStartTime()}</span> ${transport.getForward().getFirst().getName()}</td>
        <td colspan="3">${transport.getForward().getLast().getName()}<span class="label label-info"> ${transport.getForward().getFinishTime()}</span></td>
                </c:forEach>
            </c:if>
            <c:if test="${ways.size()>1}">
                <td colspan="2"><span class="label label-info">${ways.get(0).getForward().getStartTime()} </span>${ways.get(0).getForward().getFirst().getName()}</td>
                <td colspan="2"><span class="label label-info">${ways.get(0).getForward().getFinishTime()} </span>${ways.get(0).getForward().getLast().getName()} <span class="label label-info"> ${ways.get(1).getForward().getStartTime()}</span></td>
                <td colspan="2">${ways.get(1).getForward().getLast().getName()}<span class="label label-info"> ${ways.get(1).getForward().getFinishTime()}</span></td>
            </c:if>

</tr>
<tr class="warning">
<td colspan="6">
    <c:if test="${ways.size()>1}">
        ${ways.get(0).getForward().getDuration()+ways.get(1).getForward().getDuration()}
    </c:if>
    <c:if test="${ways.size()==1}">
        ${ways.get(0).getForward().getDuration()}
    </c:if>
    мин</td>
</tr>
</c:forEach>
</tbody>

</table>
<%--<c:forEach var="ways" items="${waysList}">
    <c:forEach var="transport" items="${ways}">
        ${transport.getForward().getFirst().getName()}
        ${transport.getForward().getLast().getName()}
    </c:forEach>
</c:forEach>--%>
						   <div class="row-fluid">
                               <span class="label">Приблизний час</span>
                               <br />
                               <span class="label label-info">Точний час</span>
							 <br />
							</div>
                            </div>
                        </form>

                        <!--footer-->
                        <!--    <footer class="footer">
                             <div class="container">
                               <div class="row align-items-center flex-row-reverse">
                                 <div class="col-lg-12 col-sm-12 mt-3 mt-lg-0 text-center">
                                   Copyright © 2018 <a href="#">Vobilet</a>. Designed by <a href="#">Spruko</a> All rights reserved.
                                 </div>
                               </div>
                             </div>
                           </footer> -->
                        <!-- End Footer-->
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Back to top -->
<!-- <a href="#top" id="back-to-top" style="display: inline;"><i class="fa fa-angle-up"></i></a> -->
<!-- Dashboard Css -->
<script src="\views\assets\js\vendors\jquery-3.2.1.min.js"></script>
<script src="\views\assets\js\vendors\bootstrap.bundle.min.js"></script>
<script src="\views\assets\js\vendors\jquery.sparkline.min.js"></script>
<script src="\views\assets\js\vendors\selectize.min.js"></script>
<script src="\views\assets\js\vendors\jquery.tablesorter.min.js"></script>
<script src="\views\assets\js\vendors\circle-progress.min.js"></script>
<script src="\views\assets\plugins\rating\jquery.rating-stars.js"></script>
<!--Select2 js -->
<script src="\views\assets\plugins\select2\select2.full.min.js"></script>

<!-- Timepicker js -->
<script src="\views\assets\plugins\time-picker\jquery.timepicker.js"></script>
<script src="\views\assets\plugins\time-picker\toggles.min.js"></script>

<!-- Datepicker js -->
<script src="\views\assets\plugins\date-picker\spectrum.js"></script>
<script src="\views\assets\plugins\date-picker\jquery-ui.js"></script>
<script src="\views\assets\plugins\input-mask\jquery.maskedinput.js"></script>

<!-- Inline js -->
<script src="\views\assets\js\select2.js"></script>

<!-- Custom scroll bar Js-->
<script src="\views\assets\plugins\scroll-bar\jquery.mCustomScrollbar.concat.min.js"></script>

<!-- Custom Js-->
<script src="\views\assets\js\custom.js"></script>

</body>
</html>


