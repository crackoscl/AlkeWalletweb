package cl.alkewallet.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


/**
 * Obtiene los indicadores de monedas desde la API de Mindicador.
 */
public class ApiMonedas {


	public ApiMonedas() {
	}


	public  static JsonObject GetIndicadores() {

		try {
			URL url = new URL("https://mindicador.cl/api");
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			conexion.setRequestMethod("GET");
			int codRespuesta = conexion.getResponseCode();

			if (codRespuesta != 200) {
				throw new RuntimeException("ocurrio un error" + codRespuesta);
			} else {
				BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				String jsonString = response.toString();

				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
				
				return jsonObject;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
		
	}

}
