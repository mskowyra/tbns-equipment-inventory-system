<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="formMethod"
	value="${empty param.formMethod ? 'post' : param.formMethod}" />
<c:set var="formAction"
	value="${empty param.formAction ? '' : param.formAction}" />
<c:set var="formButtonLabel"
	value="${empty param.formButtonLabel ? 'SAVE' : param.formButtonLabel}" />

<div class="box box-danger">
	<div class="box-header">
		<div class="box-body pull-left">
			<h3 class="box-title">Options</h3>
		</div>
		<div class="box-body pull-right">
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-ok"></span>
				<c:out value="${formButtonLabel}" />
			</button>
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-remove"></span> CANCEL
			</button>
		</div>
	</div>
</div>


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
			<form:form method="${formMethod}" action="${formAction}"
				commandName="user" role="form">
				<div class="box-body">
					<div class="form-group">
						<form:label path="login" cssClass="control-label">Login</form:label>
						<form:input path="login" cssClass="form-control"
							placeholder="Login" />
						<form:errors path="login" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="control-label">Password</form:label>
						<form:input path="password" cssClass="form-control"
							placeholder="Password" />
						<form:errors path="password" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						
					</div>
					<div class="form-group">
						<form:label path="first_name" cssClass="control-label">First Name</form:label>
						<form:input path="first_name" cssClass="form-control"
							placeholder="First Name" />
						<form:errors path="first_name" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="last_name" cssClass="control-label">Laste Name</form:label>
						<form:input path="last_name" cssClass="form-control"
							placeholder="Last Name" />
						<form:errors path="last_name" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="email" cssClass="control-label">Email</form:label>
						<form:input path="email" cssClass="form-control"
							placeholder="email" />
						<form:errors path="email" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="mobilePhone" cssClass="control-label">Mobile Phone</form:label>
						<form:input path="mobilePhone" cssClass="form-control"
							placeholder="Mobile Phone" />
						<form:errors path="mobilePhone" cssClass="alert alert-warning" />
					</div>
	
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
				
				<div class="box box-danger">
	<div class="box-header">
		<div class="box-body pull-left">
			<h3 class="box-title">Options</h3>
		</div>
		<div class="box-body pull-right">
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-ok"></span>
				<c:out value="${formButtonLabel}" />
			</button>
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-remove"></span> CANCEL
			</button>
		</div>
	</div>
</div>
				
				
				</div>
			</form:form>
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