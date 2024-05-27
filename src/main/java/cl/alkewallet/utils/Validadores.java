package cl.alkewallet.utils;

public class  Validadores {
	
	/**
     * Valida si una cadena es un string válido (solo letras).
     * @param string La cadena a validar.
     * @return true si la cadena es válida, false de lo contrario.
     */

	public static boolean validarEmail(String email) {
		String emailRegex = "^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+[\\w-]+$";
		return email.matches(emailRegex);
	}
	
	/**
     * Valida si un RUT chileno es válido.
     * @param rut El RUT a validar.
     * @return true si el RUT es válido, false de lo contrario.
     */
	public static boolean validarRut(String rut) {
		boolean validacion = false;
        rut =  rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }
    return validacion;
	}
	
	
	public static double parseDouble(String cantidad) {
		try {
		    double monto  = Double.parseDouble(cantidad);
		    return monto;
		} catch (NumberFormatException e) {
		    // Manejar el caso en que el parámetro no sea un número válido
		    e.printStackTrace();
		}
		return 0;
		
	}
	
	
}
