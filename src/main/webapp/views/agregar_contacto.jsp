<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
if (session.getAttribute("name") == null) {
	response.sendRedirect(request.getContextPath()+"/views/login.jsp");
}
%>

<html>
<head>
<meta charset="UTF-8">
<title>Agregar Contacto</title>
<jsp:include page="../base/head.jsp" />
</head>
<body>

    <div class="wrapper">
  <jsp:include page="../base/menu.jsp" />
  
  
      <div class="main p-4">
        <div class="row justify-content-md-center">
          <form
            id="addUserForm" action="${pageContext.request.contextPath}/AgregarContacto"
            class="form-contact col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6"
          method="post" >
            <h1 class="h3 mb-3 font-weight-normal">Agregar Contacto</h1>
            
            <label for="inputCuenta" class="sr-only">Nombre</label>
            <input
              type="text"
              id="inputNombre"
              class="form-control mb-2"
              placeholder="Nombre"
              name="nombre"
              required
            >
            
            
            <label for="inputCuenta" class="sr-only">Rut</label>
            <input
              type="text"
              id="inputRut"
              class="form-control mb-2"
              placeholder="Rut"
              name="rut"
              required
            >
            
            <label for="inputEmail" class="sr-only">Email</label>
            <input
              type="email"
              id="inputEmail"
              class="form-control mb-2"
              placeholder="Email"
              required
              name="email"
              autofocus
            >
            
           
            
            <label for="inputCuenta" class="sr-only">Numero de cuenta</label>
            <input
              type="text"
              id="inputCuenta"
              class="form-control mb-2"
              placeholder="N°cuenta"
              name="num_cuenta"
              required
            >
           
            <button class="btn btn-smal btn-primary btn-block mb-3" type="submit">
              Agregar
            </button>

            <div id="alertMensaje" role="alert" style="display: none;">
              Mensaje
          </div>            
          </form>
        </div>
      </div>
      <!--main-->
    </div>
    <!--wrapper-->
<jsp:include page="../base/footer.jsp" />
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