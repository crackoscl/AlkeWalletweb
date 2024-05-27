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
<title>Depositar</title>
<jsp:include page="../base/head.jsp" />
</head>
<body>

    <div class="wrapper">
  <jsp:include page="../base/menu.jsp" />
  
  
      <div class="main p-4">
        <div class="row justify-content-md-center">
          <form
            id="addUserForm" action="${pageContext.request.contextPath}/Depositar"
            class="form-contact col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6"
          method="post" >
            <h1 id="saldo" class="h3 mb-3 font-weight-normal">Saldo: ${cuenta.saldo}</h1>
            
            <label for="inputMonto" class="sr-only">Ingrese un Monto</label>
            <input
              type="number"
              id="inputMonto"
              class="form-control mb-2"
              placeholder="Monto"
              name="monto"
              required
            >
            
            <input
              type="hidden"
              name="num_cuenta"
              value="${cuenta.num_cuenta}"
              required
            >
            
            <input
              type="hidden"
              name="oldsaldo"
              value="${cuenta.saldo}"
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
var oldsaldo = parseInt('<%=request.getAttribute("oldsaldo")%>');
var num_cuenta = '<%=request.getAttribute("num_cuenta")%>';
var status = '<%=request.getAttribute("status")%>';
var mensaje = '<%=request.getAttribute("mensaje")%>';

if (status == "success") {
    alertMensaje(mensaje, "success", false)
} else if(status == "failed") {
    alertMensaje(mensaje, "danger", true)
}

if(oldsaldo > 0){
    console.log(oldsaldo)
    console.log(num_cuenta)
    $("#saldo").text("Saldo:"+oldsaldo);
    $('[name="num_cuenta"]').val(num_cuenta);
    $('[name="oldsaldo"]').val(oldsaldo);
}
	</script>
</body>
</html>