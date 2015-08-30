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
				<i class="glyphicon glyphicon-menu-hamburger"></i>
				<h3 class="box-title">Dodawanie nowego przedmiotu</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form:form commandName="equipment" cssClass="form-horizontal form-register ">
				<div class="box-body form-register">
					
					<div class="form-group has-feedback">
						<label for="name" class="col-xs-3 control-label">Nazwa:</label>
						<div class="input-group col-xs-8">
							<form:input path="name" cssClass="form-control"	placeholder="Nazwa" />
							 
							<form:errors path="name"  />							
						</div>
					</div>
					
					<div class="form-group has-feedback">
						<label for="serialNumber" class="col-xs-3 control-label">Numer seryjny:</label>
						<div class="input-group col-xs-8">
							<form:input path="serialNumber" cssClass="form-control"	placeholder="Numer seryjny" />
							 
							<form:errors path="serialNumber"  />							
						</div>
					</div>
					
					<div class="form-group has-feedback">
						<label for="equipmentsNumber" class="col-xs-3 control-label">Numer ewidencyjny:</label>
						<div class="input-group col-xs-8">
							<form:input path="equipmentsNumber" cssClass="form-control"	placeholder="Numer ewidencyjny" />
							 
							<form:errors path="equipmentsNumber"  />							
						</div>
					</div>					
										
					<div class="form-group has-feedback">
						
						  <label for="description" class="col-xs-3 control-label">Opis:</label>
						<div class="input-group col-xs-8">						
							<form:textarea path="description" class="form-control" rows="3" placeholder="Wpisz . . ."/>
							<form:errors path="description" cssClass="alert alert-warning" />
						</div>
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
