<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

	<c:import url="/WEB-INF/views/equipmentType/formEquiType.jsp">
		<c:param name="equipmentsType" value="${equipmentsType}" />
		
	</c:import>
