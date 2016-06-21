<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" id="ng-app" data-ng-app="WebPinf31" class="tolkvertalerApp">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code='project.name'/></title>
	
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	      <!--[if lt IE 9]>
	         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	
	<div class="container" id="appContainer">
		
		<div data-ng-view>
			<!-- Pages will be inserted here -->
		</div>
		
		
	</div>
	
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/angular.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/angular-route.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/jquery-1.11.1.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/ui-bootstrap-tpls-0.11.0.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/app.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/controllers/homePageController.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/service/homePageService.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/iframeResizer.contentWindow.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/resources/css/styles.css' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/resources/css/style.css' />"></script>
</body>
</html>