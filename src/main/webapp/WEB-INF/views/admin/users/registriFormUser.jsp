<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="formButtonLabel"
	value="${empty param.formButtonLabel ? 'Zapisz' : param.formButtonLabel}" />

<!-- /.box-body -->
<div class="row">
	<!-- left column -->
	<div class="col-md-6">
		<!-- general form elements -->
		<div class="box box-primary">
			<div class="box-header">
				<i class="glyphicon glyphicon-user"></i>
				<h3 class="box-title">Dodawanie nowego urzytkownika</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form:form commandName="user" cssClass="form-horizontal form-register ">
				<div class="box-body form-register">
					
					<div class="form-group has-feedback">
						<label for="name" class="col-xs-3 control-label">Login:</label>
						<div class="input-group col-xs-8">
							<form:input path="name" cssClass="form-control"	placeholder="Login" />
							 <span class="input-group-addon"><i class="fa fa-user"></i></span>
							<form:errors path="name"  />							
						</div>
					</div>
										
					<div class="form-group has-feedback">
						
						  <label for="email" class="col-xs-3 control-label">Email:</label>
						<div class="input-group col-xs-8">
							<form:input path="email" cssClass="form-control" placeholder="Email" />
							 <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
							<form:errors path="email" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group has-feedback">	
						<label for="password" class="col-xs-3 control-label">Hasło:</label>
						<div class="input-group col-xs-8">
							<form:input path="password" type="password" cssClass="form-control" placeholder="Hasło"	 />
							<form:errors path="password" type="password"  />
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>							
						</div>
					</div>
					<div class="form-group has-feedback">
						<label for="password" class="col-xs-3 control-label">Hasło:</label>
						<div class="input-group col-xs-8">
							<input type="password" name="password_again" id="password_again" class="form-control" placeholder="Powtórz hasło" />
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>	
						</div>
					</div>	
					
					<div class="form-group has-feedback">
						
					</div>
					
					<div class="form-group has-feedback">
						<label for="name" class="col-xs-3 control-label">Imię:</label>
						<div class="input-group col-xs-8">
							<form:input path="first_name" cssClass="form-control"	placeholder="Imię" />
							<form:errors path="first_name" />							
						</div>
					</div>
					
					<div class="form-group has-feedback">
						<label for="last_name" class="col-xs-3 control-label">Nazwisko:</label>
						<div class="input-group col-xs-8">
							<form:input path="first_name" cssClass="form-control"	placeholder="Nazwisko" />
							<form:errors path="first_name" />							
						</div>
					</div>
					
					<div class="form-group has-feedback">
						<label for="phone" class="col-xs-3 control-label">Telefon:</label>
						<div class="input-group col-xs-8">
							<form:input path="phone" cssClass="form-control" placeholder="Telefon" />
							<form:errors path="phone" />							
						</div>
					</div>
					<!-- checkbox -->
					<div class="form-group has-feedback">
						<label for="phone" class="col-xs-3 control-label">Typ urzytkownika:</label>
		                    <label class="checkbox-inline "><input type="checkbox" value="">USER</label>
							<label class="checkbox-inline "><input type="checkbox" value="">MODERATOR</label>
							<label class="checkbox-inline "><input type="checkbox" value="">ADMINISTRATOR</label>
					</div>		

				<div class="box-body pull-right">
						<button type="submit" class="btn btn-large btn-primary">
							<span class="glyphicon glyphicon-ok"></span>&emsp;	<c:out value="  ${formButtonLabel}" />
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
