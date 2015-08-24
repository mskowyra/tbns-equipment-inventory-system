<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>

<aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="/resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>Alexander Pierce</p>
              <a href="#"><i class="fa fa-circle text-success"></i> Online 
              		<c:if test="${pageContext.request.userPrincipal.name != null}"> 
						<p>Witaj, ${pageContext.request.userPrincipal.name}  
						</p>       
					</c:if></a>
            </div>
          </div>
          <!-- search form
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          -->
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
           
             
            <li>
              <a href="/">
                <i class="fa fa-th"></i> <span>Start</span> 
              </a>
            </li>
          	
          	<security:authorize access="hasRole('ROLE_ADMIN')">
          	<li class="treeview">
              <a href="#">
                <i class="fa fa-dashboard"></i> <span>Panel Administarcyjny</span> <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li class="active"><a href="/users"><i class="fa fa-circle-o"></i> Urzytkownicy</a></li>
                <li><a href="/register"><i class="fa fa-circle-o"></i> Dodaj urzytkownika</a></li>
              </ul>
            </li>
            </security:authorize>
            
            <li class="treeview">
              <a href="#">
                <i class="fa fa-folder"></i>
                <span>Narzędzia</span>
                 <i class="fa fa-angle-left pull-right"></i>                
              </a>
              <ul class="treeview-menu">
              	<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
                <li><a href="pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> Dodaj nowe</a></li>
                </security:authorize>
                <li><a href="pages/layout/boxed.html"><i class="fa fa-circle-o"></i> Przeglądaj</a></li>
                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
                <li><a href="pages/layout/fixed.html"><i class="fa fa-circle-o"></i> Odrzucone</a></li>
                <li><a href="pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> Akceptowane</a></li>
                </security:authorize>
              </ul>
            </li>
                       
            <li class="treeview">
              <a href="#">
                <i class="fa fa-folder"></i>
                <span>Grupy narzędzi</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
              	<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
                <li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> Dodaj nowe</a></li>
                </security:authorize>
                <li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> Przeglądaj</a></li>                
              </ul>
            </li>
            <li class="treeview">
              <a href="#">
                <i class="fa fa-building-o"></i>
                <span>Magazyny</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MODERATOR')">
                <li><a href="pages/UI/general.html"><i class="fa fa-circle-o"></i> Dodaj nowe</a></li>
                </security:authorize>
                <li><a href="pages/UI/icons.html"><i class="fa fa-circle-o"></i> Przeglądaj</a></li>
                <li><a href="pages/UI/buttons.html"><i class="fa fa-circle-o"></i> Archiwum</a></li>              
              </ul>
            </li>  
             <li class="treeview">
              <a href="#">
                <i class="fa fa-book"></i>
                <span>Konto</span>
                <i class="fa fa-angle-left pull-right"></i>
              </a>
              <ul class="treeview-menu">
                <li><a href="/account"><i class="fa fa-circle-o"></i> Moje konto</a></li>
                <li><a href="/logout"><i class="fa fa-circle-o"></i> Wyloguj</a></li>                             
              </ul>
            </li>            
           </ul> 
        </section>
        <!-- /.sidebar -->
      </aside>