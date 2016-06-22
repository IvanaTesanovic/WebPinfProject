<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org" id="ng-app" data-ng-app="WebPinf31" class="tolkvertalerApp">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code='project.name'/></title>
	
</head>
<body>
	<div class="container" id="appContainer">
		
		<div data-ng-view>
			<!-- Pages will be inserted here -->
		</div>
		
	</div>
	
	<!-- LIBRARIES -->
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/angular.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/angular-route.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/jquery-1.11.1.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/ui-bootstrap-tpls-1.3.3.min.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/lib/iframeResizer.contentWindow.min.js' />"></script>
	
	<!-- APP -->
	<script type="text/javascript" src="<spring:url value='${version}/js/app.js' />"></script>
	
	<!-- CONTROLLERS -->
	<script type="text/javascript" src="<spring:url value='${version}/js/controllers/homePageController.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/controllers/loginController.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/controllers/defaultController.js' />"></script>
	
	<!-- SERVICES -->
	<script type="text/javascript" src="<spring:url value='${version}/js/service/homePageService.js' />"></script>
	<script type="text/javascript" src="<spring:url value='${version}/js/service/loginService.js' />"></script>

	<!-- CSS -->
	<script type="text/javascript" src="<spring:url value='${version}/resources/css/bootstrap.min.css' />"></script>
	
</body>
</html>