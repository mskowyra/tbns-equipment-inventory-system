<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div class="user-panel">
					<div class="pull-left image">
						<img src="/resources/img/avatar3.png" class="img-circle" alt="User Image" />
					</div>
					<div class="pull-left info">
		
					<c:if test="${pageContext.request.userPrincipal.name != null}"> 
						<p>Witaj, ${pageContext.request.userPrincipal.name}  
						</p>       
					</c:if>		 
								
						<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
					</div>
				</div>
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<security:authorize access="!isAuthenticated()">
					<li class="active"><a href="index.html"> <i	class="fa fa-dashboard"></i> <span>Start</span>
					</a></li>
					</security:authorize>
					<li><a href="pages/widgets.html"> <i class="fa fa-th"></i>
							<span>Start</span> <small class="badge pull-right bg-green">new</small>
					</a></li>
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<li class="treeview"><a href="#"> <i class="fa fa-book"></i>
							<span>Panel Administarcyjny</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="/admin/users"><i	class="fa fa-angle-double-right"></i> Urzytkownicy</a></li>
							<li><a href="/users"><i class="fa fa-angle-double-right"></i> Lorem ispum</a></li>
							<li><a href="/book/id/"><i class="fa fa-angle-double-right"></i> Lorem ispum</a></li>
						</ul></li>
					</security:authorize>
					<security:authorize access="!isAuthenticated()">
					<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
							<span>Narzędzia</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<security:authorize access="hasRole('ROLE_ADMIN','ROLE_MODERATOR' )">
							<li><a href="pages/forms/general.html"><i class="fa fa-angle-double-right"></i> Dodaj nowe</a></li>
							</security:authorize>
							<li><a href="pages/forms/advanced.html"><i class="fa fa-angle-double-right"></i> Przeglądaj</a></li>
							<li><a href="pages/forms/editors.html"><i class="fa fa-angle-double-right"></i> Odrzucone</a></li>
							<security:authorize access="hasRole('ROLE_ADMIN','ROLE_MODERATOR' )">
							<li><a href="pages/forms/editors.html"><i class="fa fa-angle-double-right"></i> Akceptowane</a></li>
							</security:authorize>
						</ul></li>
					</security:authorize>
					<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
							<span>Grupy narzędzi</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/forms/general.html"><i class="fa fa-angle-double-right"></i> Dodaj nowe</a></li>
							<li><a href="pages/forms/advanced.html"><i class="fa fa-angle-double-right"></i> Przeglądaj</a></li>							
						</ul></li>
					
					<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
							<span>Magazyny</span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="pages/tables/simple.html"><i class="fa fa-angle-double-right"></i> Dodaj nowe</a></li>
							<li><a href="pages/tables/data.html"><i	class="fa fa-angle-double-right"></i> Przeglądaj</a></li>
							<li><a href="pages/tables/data.html"><i	class="fa fa-angle-double-right"></i> Archiwum</a></li>
						</ul></li>
					<li><a href="pages/calendar.html"> <i	class="fa fa-book"></i> <span>Konto</span> <small
							class="badge pull-right bg-red">3</small>
					</a></li>					
					
				</ul>
			</section>
			<!-- /.sidebar -->
		</aside>