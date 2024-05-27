<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
if (session.getAttribute("name") == null) {
	response.sendRedirect(request.getContextPath()+"/views/login.jsp");
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enviar dinero</title>
<jsp:include page="../base/head.jsp" />
</head>
<body>
 <div class="wrapper">
   <jsp:include page="../base/menu.jsp" />
      <div class="main p-4">
        <div class="row justify-content-md-center">
          <form
            id="sendAmount" action="${pageContext.request.contextPath}/Enviar"
            class="form-contact col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6"
          >
            <h1 class="h3 mb-3 font-weight-normal">Saldo: ${cuenta.saldo}</h1>
            <label class="sr-only">Cuenta</label>
            <select id="selectUsers"  class="form-select" aria-label="Default select example" required>
              <option value="">Seleccionar contacto</option>
              <c:forEach items="${cuentas}" var="c">
		        <option value="${c.usuario.user_id}">Nombre: ${c.usuario.nombre} - N° Cuenta: ${c.num_cuenta}</option>
		    	</c:forEach>
            </select>
            
            <label class="sr-only">Moneda</label>
            <select id="selectMonedas"  class="form-select" aria-label="Default select example" required>
              <option value="">Seleccionar Moneda</option>
		        <option value=""></option>
            </select>
            <label class="sr-only"> Monto a enviar</label>
            <input
              type="number"
              id="monto"
              class="form-control mb-2"
              placeholder="Monto"
              required
            >
            <button class="btn btn-smal btn-primary btn-block mb-3" type="submit">
              Enviar
            </button>
            <div id="alertMensaje" role="alert" style="display: none;">
              Mensaje.
          </div>
          </form>
        </div>
      </div><!--main-->
    </div><!--wrapper-->
 <jsp:include page="../base/footer.jsp" />
</body>
</html>