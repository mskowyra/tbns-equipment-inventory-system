<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminPanel | TBNS</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- bootstrap 3.3.1 -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="//code.ionicframework.com/ionicons/1.5.2/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link rel="stylesheet" type="text/css" href="/resources/css/AdminLTE.css"/>
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>

<!-- jQuery 2.0.2 -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<!-- AdminLTE App -->
<script type="text/javascript" src="<c:url value='/resources/js/AdminLTE/app.js'/>"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"
	type="text/javascript"></script>
<!-- Bootstrap WYSIHTML5 -->
<script
	src="resources/js/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"
	type="text/javascript"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
</head>
<body class="skin-black">
	<!-- theme style can be black-->
	<!-- header logo: style can be found in header.less -->
	
<tiles:insertAttribute name="header"/>

	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->

<tiles:insertAttribute name="menu"/>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					<small>Control panel</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Blank page</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">

<tiles:insertAttribute name="body" />

			</section>
			<!-- /.content -->
		</aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->
</body>
</html>
