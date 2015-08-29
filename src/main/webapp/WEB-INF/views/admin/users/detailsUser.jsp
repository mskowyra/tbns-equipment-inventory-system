<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>



<div class="col-md-6">
	<div class="box box-solid">
		<div class="box-header with-border">
			<i class="glyphicon glyphicon-user"></i>
			<h3 class="box-title">Szczegóły użytkownika</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<dl class="dl-horizontal">								
				<dt>Login:</dt>
				<dd><c:out value="${user.name}" /></dd>
				<dt>Status:</dt>
				<dd>
					<c:choose>
							<c:when test="${user.status == true}"><span class="label label-success ">Aktywny</span></c:when>
    						<c:otherwise><span class="label label-danger">Nieaktywny</span></c:otherwise>
				    </c:choose>
				</dd>
				<dt></dt>
				<dd></dd>	
				<dt>Imię i Nazwisko:</dt>
				<dd><c:out value="${user.first_name} ${user.last_name}" /></dd>					        
				<dt>Email:</dt>
				<dd><c:out value="${user.email}" /></dd>
				<dd>Donec id elit non mi porta gravida at eget metus.</dd>
				<dt>Malesuada porta</dt>
				<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
				<dt>Felis euismod semper eget lacinia</dt>
				<dd>Fusce dapibus, tellus ac cursus commodo, tortor mauris
					condimentum nibh, ut fermentum massa justo sit amet risus.</dd>
			</dl>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->
</div>
<div class="row">
	<div class="col-md-6">
		<div class="box box-solid">
			<div class="box-header with-border">
				<i class="fa fa-text-width"></i>
				<h3 class="box-title">Description</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<dl>
					<dt>Description lists</dt>
					<dd>A description list is perfect for defining terms.</dd>
					<dt>Euismod</dt>
					<dd>Vestibulum id ligula porta felis euismod semper eget
						lacinia odio sem nec elit.</dd>
					<dd>Donec id elit non mi porta gravida at eget metus.</dd>
					<dt>Malesuada porta</dt>
					<dd>Etiam porta sem malesuada magna mollis euismod.</dd>
				</dl>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.box -->
	</div>
	<!-- ./col -->
</div>
<!-- ./row -->
