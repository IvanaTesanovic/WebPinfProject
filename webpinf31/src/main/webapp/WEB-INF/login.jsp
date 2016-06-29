<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html data-ng-app="Login">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code='project.name' /></title>
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	      <!--[if lt IE 9]>
	         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
	<![endif]-->
	
</head>
<body id="login_body" data-ng-controller="LoginController">

	<div class="container">
		<div class="loginFormWrapper">
			<form name="form" id="loginForm" method="post" action="j_spring_security_check" class="css-form data-ng-dirty data-ng-invalid data-ng-invalid-required mediators-search-form" novalidate>
			
				<c:if test="${param.error == '1' }">
					 <div id="errors" class="alert-warning" >
			        	<spring:message code="login.error.incorectUserNameOrPassword" />
			        </div>
				</c:if>
			
				<div>
					<fieldset>

						<!-- Username -->       
			        	<div class="row rvr_bottom_padding">
					        <div class="form-group">
					        	<label class="registerLabel control-label col4" for="j_username"><spring:message code="login.username" /> <span class="required">*</span></label>
						        <div class="col6">
						            <input id="j_username" class="form-control" type="text" name="j_username" data-ng-model="user.username" data-ng-maxlength="50" required>
						            <div data-ng-show="form.j_username.$dirty && form.j_username.$invalid" class="registerUserFieldError">
						            </div>
						        </div>
							</div>
					    </div>
					    
					    <!-- Password -->       
			        	<div class="row rvr_bottom_padding">
					        <div class="form-group">
					        	<label class="registerLabel control-label col4" for="j_password"><spring:message code="login.password" /> <span class="required">*</span></label>
						        <div class="col6">
						            <input id="j_password" class="form-control" type="password" name="j_password" data-ng-model="user.password" data-ng-maxlength="30" required>
						            <div data-ng-show="form.j_password.$dirty && form.j_password.$invalid" class="registerUserFieldError">
					                 </div>
						        </div>
							</div>
					    </div>
					    
					</fieldset>
					
					<div>
						<button id="submit_button" class="btn btn-rvr-reverse pull-left" type="submit" name="submit" data-ng-disabled="form.$invalid">
							<spring:message code="login.login" />
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
	
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/controllers/loginController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/iframeResizer.contentWindow.min.js"></script> 
</body>
</html>