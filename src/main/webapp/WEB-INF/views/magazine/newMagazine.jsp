<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>


<c:import url="/WEB-INF/views/magazine/formMagazine.jsp">
   	<c:param name="magazine" value="${magazine}" />   		
</c:import> 