
function alertMensaje(mensaje, errorType, fade) {
  $("#alertMensaje").removeClass();
  $("#alertMensaje").addClass("alert alert-" + errorType);
  $("#alertMensaje").text("!" + mensaje);
  $("#alertMensaje").fadeIn(1000);
  if (fade) {
    setTimeout(function () {
      $("#alertMensaje").fadeOut(1000);
    }, 5000);
  }
}
