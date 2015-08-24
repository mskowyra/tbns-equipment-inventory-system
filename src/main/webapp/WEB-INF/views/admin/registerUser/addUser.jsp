<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
			<form:form commandName="user" cssClass="form-horizonal form-register">
    <div class="box-body">
        <c:if test="${param.success eq true}">
            <div class="alert alert-success">Registration successfull!</div>
        </c:if>

        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">Name:</label>

            <div class="col-sm-10">
                <form:input path="name" cssClass="form-control"/>
                <form:errors path="name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email:</label>

            <div class="col-sm-10">
                <form:input path="email" cssClass="form-control"/>
                <form:errors path="email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password:</label>

            <div class="col-sm-10">
                <form:password path="password" cssClass="form-control"/>
                <form:errors path="password"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password again:</label>

            <div class="col-sm-10">
                <input type="password" name="password_again" id="password_again" class="form-control"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-2">
                <input type="submit" value="Save" class="btn btn-lg btn-primary"/>
            </div>
        </div>
    </div>
</form:form>

<script type="text/javascript">
    $(document).ready(function () {
        $(".form-register").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3,
                            remote :  {
                                url: "<spring:url value='/register/is-available' />",
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
			
			
			
			
			
			
			
			<form:form method="${formMethod}" action="${formAction}"
				commandName="user" role="form">
				<div class="box-body">
					<div class="form-group">
						<form:label path="name" cssClass="control-label">Login</form:label>
						<form:input path="name" cssClass="form-control"
							placeholder="Login" />
						<form:errors path="name" cssClass="alert alert-warning" />
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
						<form:label path="email" cssClass="control-label">First Name</form:label>
						<form:input path="email" cssClass="form-control"
							placeholder="First Name" />
						<form:errors path="email" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="password" cssClass="control-label">Laste Name</form:label>
						<form:input path="password" cssClass="form-control"
							placeholder="Last Name" />
						<form:errors path="password" cssClass="alert alert-warning" />
					</div>
					<div class="form-group">
						<form:label path="password_again" cssClass="control-label">Email</form:label>
						<form:input path="password_again" cssClass="form-control"
							placeholder="email" />
						<form:errors path="password_again" cssClass="alert alert-warning" />
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