<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="formMethod"
	value="${empty param.formMethod ? 'post' : param.formMethod}" />
<c:set var="formAction"
	value="${empty param.formAction ? '' : param.formAction}" />
<c:set var="formButtonLabel"
	value="${empty param.formButtonLabel ? 'SAVE' : param.formButtonLabel}" />

<!-- /.box-body -->
<div class="row">
	<!-- left column -->
	<div class="col-md-6">
		<!-- general form elements -->
		<div class="box box-primary">
			<div class="box-header">
				<h3 class="box-title">Creat New User</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form:form method="${formMethod}" action="${formAction}" commandName="user" role="form">
				<div class="box-body">
					<div class="form-group">
						<form:label path="name" cssClass="col-sm-2  control-label">Login</form:label>
						<div class="col-sm-10">
						<form:input path="name" cssClass="form-control" placeholder="Login" />
						<form:errors path="name" cssClass="alert alert-warning" />
					</div>
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="col-sm-2 control-label">Password</form:label>
						<div class="col-sm-10">
						<form:input path="password" cssClass="form-control"	placeholder="Password" />
						<form:errors path="password" cssClass="alert alert-warning" />
					</div>
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="col-sm-2 control-label">Password</form:label>
						<div class="col-sm-10">
						<form:input path="password" name="password_again" id="password_again"  cssClass="form-control" placeholder="Password" />						
					</div>
					</div>					
					<div class="form-group">
						<form:label path="first_name" cssClass="col-sm-2 control-label">First Name</form:label>
						<div class="col-sm-10">
						<form:input path="first_name" cssClass="form-control"
							placeholder="First Name" />
						<form:errors path="first_name" cssClass="alert alert-warning" />
					</div>
					</div>
					<div class="form-group">
						<form:label path="last_name" cssClass="col-sm-2 control-label">Laste Name</form:label>
						<div class="col-sm-10">
						<form:input path="last_name" cssClass="form-control"
							placeholder="Last Name" />
						<form:errors path="last_name" cssClass="alert alert-warning" />
					</div>
					</div>
					<div class="form-group">
						<form:label path="email" cssClass="col-sm-2 control-label">Email</form:label>
						<div class="col-sm-10">
						<form:input path="email" cssClass="form-control"
							placeholder="email" />
						<form:errors path="email" cssClass="alert alert-warning" />
					</div>
					</div>				
					
					
					<div class="box-body pull-right">
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-ok"></span>
				<c:out value="${formButtonLabel}" />
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
	<div class='col-md-6'>
	

	</div>
	<!-- /.col-->
</div>
<!-- ./row -->





<!--/.col (right) -->

<!-- /.row -->


<!-- Bootstrap WYSIHTML5 -->
<!-- bootstrap wysihtml5 - text editor -->
<script type="text/javascript">
	$(function() {
		//bootstrap WYSIHTML5 - text editor
		$(".textarea").wysihtml5();
	});
</script>