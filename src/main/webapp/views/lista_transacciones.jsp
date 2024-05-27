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
<title>Transacciones</title>
<jsp:include page="../base/head.jsp" />
</head>
<body>
 <div class="wrapper">
    <jsp:include page="../base/menu.jsp" />
      <div class="main p-4">
        <div class="row">
          <div class="col-12 col-xl-12 mb-4 mb-lg-0">
            <div class="card">
              <h5 class="card-header">Movimientos</h5>
              <div class="card-body">
                <div class="table-responsive">
                  <table id="transactions" class="table">
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
                    <tbody></tbody>
                  </table>
                </div>
                <div
                  id="alertMensaje"
                  role="alert"
                  style="display: none"
                >
                  Mensaje
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--main-->
    </div>
    <!--wrapper-->
<jsp:include page="../base/footer.jsp" />
</body>
</html>