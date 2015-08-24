<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="login-box">
      <div class="login-logo">
        <a href="/"><b>TBNS</b>Panel</a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
      <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check"/>" method="POST">
        <p class="login-box-msg">Zaloguj się, aby rozpocząć swoją sesję</p>
        
        <fieldset>
              			<c:if test="${not empty error}">
							<div class="alert alert-danger alert-dismissable">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="alert alert-info alert-dismissable">${msg}</div>
						</c:if>
        
          <div class="form-group has-feedback">
          	<input type="text" name="j_username" class="form-control" placeholder="Login" required autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" name="j_password" class="form-control" placeholder="Hasło" required>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          </fieldset>
          <div class="row">
            <div class="col-xs-12">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox" name="_spring_security_remember_me">  Pamiętaj mnie
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-12">
              <button type="submit" class="btn btn-primary btn-block btn-flat">Zaloguj</button>
            </div><!-- /.col -->
          </div>
        </form>

        
        <a href="#">Przypomnienie hasła</a><br>
        
      </div><!-- /.login-box-body -->
    <div class="margin text-center">
                <span>Technobud Nowy Sącz</span>             
            </div>
    </div><!-- /.login-box -->
   