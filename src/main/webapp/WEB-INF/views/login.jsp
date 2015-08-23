<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <div class="header">Logowanie</div>
                  
            <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check"/>" method="POST">
                      	
               <div class="panel-body bg-gray">	             			
              		<fieldset>
              			<c:if test="${not empty error}">
							<div class="alert alert-danger error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="alert alert-success msg">${msg}</div>
						</c:if>
                    <div class="form-group">
                           <input type="text" name="j_username" class="form-control" placeholder="Login" required autofocus>
                    </div>
                    <div class="form-group">
                        <input type="password" name="j_password" class="form-control" placeholder="Hasło" required>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Pamiętaj mnie
                    </div>
                    </fieldset>
               </div>
                <div class="footer">
                    <button class="btn bg-olive btn-block"  type="submit">Zaloguj</button>
                    <p><a href="#">Przypomnienie hasła</a></p>
                </div>
            </form>

            <div class="margin text-center">
                <span>Technobud Nowy Sącz</span>             
            </div>
