<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
if (session.getAttribute("name") != null) {
	response.sendRedirect(request.getContextPath());
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AlkeWallet Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/main.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/boostrap/bootstrap.min.css" />
</head>
<body class="d-flex text-center">
	<form id="login-register" action="${pageContext.request.contextPath}/Login"
		class="form-login" method="post">
		<svg xmlns="http://www.w3.org/2000/svg"
			class="icon icon-tabler icon-tabler-wallet" width="50" height="50"
			viewBox="0 0 24 24" stroke-width="1.5" stroke="#2c3e50" fill="none"
			stroke-linecap="round" stroke-linejoin="round">
        <path stroke="none" d="M0 0h24v24H0z" fill="none" />
        <path
				d="M17 8v-3a1 1 0 0 0 -1 -1h-10a2 2 0 0 0 0 4h12a1 1 0 0 1 1 1v3m0 4v3a1 1 0 0 1 -1 1h-12a2 2 0 0 1 -2 -2v-12" />
        <path d="M20 12v4h-4a2 2 0 0 1 0 -4h4" />
      </svg>

		<h1 class="h3 mb-3 font-weight-normal">Alke Wallet Login</h1>
		<label for="inputEmail" class="sr-only">Email</label> <input
			type="email" id="inputEmail" class="form-control mb-2"
			placeholder="Email" name="email" required> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" id="inputPassword" class="form-control mb-2"
			placeholder="Password" name="password" required>
		<!-- <div class="checkbox mb-3">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div> -->
		<button class="btn btn-lg btn-primary btn-block mb-3" type="submit">
			Enviar</button>

		<a href="${pageContext.request.contextPath}/Registrar"
			class="btn btn-lg btn-primary btn-block mb-3">Registrar</a>

		<div id="alertMensaje" role="alert" style="display: none"></div>
	</form>

	<script
		src="${pageContext.request.contextPath}/static/boostrap/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
		

	<script src="${pageContext.request.contextPath}/static/js/mensaje.js"></script>

	<script>
var status = '<%=request.getAttribute("status")%>'
var mensaje = '<%=request.getAttribute("mensaje")%>'
		if (status == "success") {
			alertMensaje(mensaje, "success", false)
		} else if(status == "failed") {
			alertMensaje(mensaje, "danger", true)
		}
	</script>

</body>
</html>