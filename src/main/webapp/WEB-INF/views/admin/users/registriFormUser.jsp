<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="formButtonLabel"
	value="${empty param.formButtonLabel ? '  Zapisz' : param.formButtonLabel}" />

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
			<form:form commandName="user" cssClass="form-horizontal form-register ">
				<div class="box-body form-register">
					
					<div class="form-group">
						<label for="name" class="col-xs-3 control-label">Login:</label>
						<div class="col-xs-8">
							<form:input path="name" cssClass="form-control"	placeholder="Login" />
							<form:errors path="name" type="password" />
						</div>
					</div>
										
					<div class="form-group">
						
						  <label for="email" class="col-xs-3 control-label">Email:</label>
						<div class="col-xs-8">
							<form:input path="email" cssClass="form-control" placeholder="Email" />
							<form:errors path="email" cssClass="alert alert-warning" />
						</div>
					</div>
					<div class="form-group">	
						<label for="password" class="col-xs-3 control-label">Hasło:</label>
						<div class="col-xs-8">
							<form:input path="password" type="password" cssClass="form-control" placeholder="Hasło"	 />
							<form:errors path="password" type="password"  />
						</div>
					</div>
					<div class="form-group">
						<label for="password" class="col-xs-3 control-label">Hasło:</label>
						<div class="col-xs-8">
							<input type="password" name="password_again" id="password_again" class="form-control" placeholder="Powtórz hasło" />
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
<script type="text/javascript">
    $(document).ready(function () {
        $(".form-register").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3,
                            remote :  {
                                url: "<spring:url value='/admin/users/is-available' />",
                                type: "get",
                                data : {
                                    username: function(){
                                        return $("#name").val();
                                    }
                                }
                            }
                        },
                        email: {
                            required: true,
                            email: true
                        },
                        password: {
                            required: true,
                            minlength: 5
                        },
                        password_again: {
                            required: true,
                            minlength: 5,
                            equalTo: "#password"
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    },
                    messages: {
                        name: {
                            remote: "Such username already exists!"
                        }
                    }
                }
        )
    });
</script>