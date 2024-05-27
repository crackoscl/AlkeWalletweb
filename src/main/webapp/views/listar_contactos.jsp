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
<title>Listar Contactos</title>
<jsp:include page="../base/head.jsp" />
</head>
<body>
<div class="wrapper">
       <jsp:include page="../base/menu.jsp" />  
      <div class="main p-4">
        <div class="row justify-content-md-center">
          <div class="col-md-10">
            <h1>Lista de Contactos</h1>
            
              <c:choose>
       		 <c:when test="${not empty cuentas}">
      
      		 
            <table id="tablecontactos" class="table table-striped">
              <thead>
                <tr>
                  <th scope="col">#</th>
                  <th scope="col">cuenta</th>
                  <th scope="col">nombre</th>
                   <th scope="col">rut</th>
                  <th scope="col">email</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody>

             <c:forEach items="${cuentas}" var="c" varStatus="loop">
                        <tr>
                        	<td>${loop.index + 1}</td>
                            <td>${c.num_cuenta}</td>
                            <td>${c.usuario.nombre}</td>
                            <td>${c.usuario.rut}</td>
                            <td>${c.usuario.correo_electronico}</td>
                            <td>
                            <button class="btn btn-primary">Editar</button>
                            <button class="btn btn-danger">Eliminar</button>
                            </td>
                           
                        </tr>
             </c:forEach>
              </tbody>
            </table>
            </c:when>
             <c:otherwise>
            <p
              id="alertMensaje"
              role="alert"
              style="display: none"
            >
              Mensaje
            </p>
        </c:otherwise>
        </c:choose>
            
          </div>
        </div>
      </div>
      <!--main-->
    </div>
    <!--wrapper-->
<jsp:include page="../base/footer.jsp" />

<script >
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