<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

	<c:import url="/WEB-INF/views/admin/registerUser/registriForm.jsp">
		<c:param name="user" value="${user}" />
		<c:param name="formMethod" value="post" />
		<c:param name="formAction" value="/users" />
		<c:param name="formButtonLabel" value="Aktualizuj" />
	
	</c:import>
	
	
	
