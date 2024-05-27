<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	


<%
if (session.getAttribute("name") == null) {
	response.sendRedirect(request.getContextPath()+"/views/login.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AlkeWallet</title>
<jsp:include page="../base/head.jsp" />
</head>

<body>
	<div class="wrapper">
		<jsp:include page="../base/menu.jsp" />

		<div class="main p-4">
			<div class="row">
				<div class="col-md-8">
					<h1>Alke Wallet Dashboard</h1>
		
					<p>Nombre: ${cuenta.usuario.nombre} - N° Cuenta: ${cuenta.num_cuenta}</p>
				</div>

			</div>
			<div class="row my-4">
				<div class="col-12 col-md-6 col-lg-3 mb-4 mb-lg-0">
					<div id="saldo" class="card">
						<h5 class="card-header">Saldo disponible</h5>
						<div class="card-body">
							<h5 class="card-title">${cuenta.saldo}</h5>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6 mb-4 mb-lg-0 col-lg-3">
					<div id="depositos" class="card">
						<h5 class="card-header">Depositos</h5>
						<div class="card-body">
							<h5 class="card-title">0</h5>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6 mb-4 mb-lg-0 col-lg-3">
					<div id="transferencias" class="card">
						<h5 class="card-header">Transferencias</h5>
						<div class="card-body">
							<h5 class="card-title">0</h5>
						</div>
					</div>
				</div>
				<div class="col-12 col-md-6 mb-4 mb-lg-0 col-lg-3">
					<div class="card">
						<h5 class="card-header">Propaganda del banco</h5>
						<div class="card-body">
							<h5 class="card-title">&#128521;</h5>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-xl-12 mb-4 mb-lg-0">
					<div class="card">
						<h5 class="card-header">Latest transactions</h5>
						<div class="card-body">
							<div class="table-responsive">
								<table id="ultimastrans" class="table">
									<thead>
										<tr>
											<th scope="col">#</th>
											<th scope="col">fecha</th>
											<th scope="col">cuenta</th>
											<th scope="col">nombre</th>
											<th scope="col">email</th>
											<th scope="col">monto</th>
											<th scope="col">tipo</th>
										</tr>
									</thead>
									<tbody>

									</tbody>
								</table>
							</div>
							<a href="#" class="btn btn-block btn-light">Ver Mas...</a>
						</div>
						<div id="alertMensaje" role="alert" style="display: none;">
							Mensaje</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../base/footer.jsp" />
</body>
</html>