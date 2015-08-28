<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="formMethod"
	value="${empty param.formMethod ? 'post' : param.formMethod}" />
<c:set var="formAction"
	value="${empty param.formAction ? '' : param.formAction}" />
<c:set var="formButtonLabel"
	value="${empty param.formButtonLabel ? 'Zapisz' : param.formButtonLabel}" />
<c:set var="formValidate"
	value="${empty param.formValidate ? '' : param.formValidate}" />

<!-- /.box-body -->
<div class="row">
	<!-- left column -->
	<div class="col-md-6">
		<!-- general form elements -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Dodawanie nowego urzytkownika</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form:form method="${formMethod}" action="${formAction}"
				commandName="user" role="form"
				cssClass="registrationForm form-horizontal">
				<div class="box-body form-register">
					
					<!--
					<c:if test="${param.success eq true}">
        				    <div class="alert alert-success">Rejstracja powiodła się!</div>
        			</c:if>
					-->

					<div class="form-group">
						<form:label path="name" cssClass="col-xs-2  control-label">Login</form:label>
						<div class="col-xs-10">
							<form:input path="name" cssClass="form-control"
								placeholder="Login" />
							<form:errors path="name"
								cssClass="form-control alert alert-warning" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="col-xs-2 control-label">Hasło</form:label>
						<div class="col-xs-10">
							<form:input path="password" cssClass="form-control"
								placeholder="Hasło" />
							<form:errors path="password" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="col-xs-2 control-label">Powtórz hasło</form:label>
						<div class="col-xs-10">
							<form:input path="password" name="password_again"
								id="password_again" cssClass="form-control"
								placeholder="Powtórz hasło" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="first_name" cssClass="col-xs-2 control-label">Imię</form:label>
						<div class="col-xs-10">
							<form:input path="first_name" cssClass="form-control"
								placeholder="Imię" />
							<form:errors path="first_name" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="last_name" cssClass="col-xs-2 control-label">Nazwisko</form:label>
						<div class="col-xs-10">
							<form:input path="last_name" cssClass="form-control"
								placeholder="Nazwisko" />
							<form:errors path="last_name" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="email" cssClass="col-xs-2 control-label">Email</form:label>
						<div class="col-xs-10">
							<form:input path="email" cssClass="form-control"
								placeholder="email" />
							<form:errors path="email" cssClass="alert alert-warning" />
						</div>
					</div>


					<div class="box-body pull-right">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-ok"></span>
							<c:out value="  ${formButtonLabel}" />
						</button>
					</div>
				</div>
			</form:form>
			<!-- /.box-body -->
		</div>
	</div>
	<!--/.col (left) -->
	<!--************************************************************************************************************************!-->
	<!-- right column -->
	<div class='col-md-6'></div>
	<!-- /.col-->
</div>
<!-- ./row -->

<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$(".registrationForm")
								.validate(
										{
											rules : {
												name : {
													required : true,
													minlength : 3,
													remote : {   
														url : "<spring:url value='${formValidate}' />",
														type : "get",
														data : {
															username : function() {
																return $(
																		"#name")
																		.val();
															}
														}
													}
												},
												email : {
													required : true,
													email : true
												},
												password : {
													required : true,
													minlength : 5
												},
												confirmPassword : {
													required : true,
													minlength : 5,
													equalTo : "#password"
												}
											},
											highlight : function(element) {
												$(element).closest(
														'.form-group')
														.removeClass(
																'has-success')
														.addClass('has-error');
											},
											unhighlight : function(element) {
												$(element)
														.closest('.form-group')
														.removeClass(
																'has-error')
														.addClass('has-success');
											},
											messages : {
												name : {
													remote : "Urzytkownik o takiej nazwie już istnieje w bazie!"
												}
											}
										})
					});
</script> 