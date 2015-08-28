<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>



<c:import url="/WEB-INF/views/admin/users/registriFormUser.jsp">
	<c:param name="user" value="${user}" />
	<c:param name="formAction" value="/admin/users/register" />
	<c:param name="formValidate" value="/admin/users/is-available" />	
</c:import> 

<script>
	$('.confirm').click(function () {
		$('form').submit();
	});
</script>