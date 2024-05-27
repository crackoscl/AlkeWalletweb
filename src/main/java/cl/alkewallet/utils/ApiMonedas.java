package cl.alkewallet.utils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cl.alkewallet.model.Moneda;

/**
 * Obtiene los indicadores de monedas desde la API de Mindicador.
 */
public class ApiMonedas {
	private HashMap<String, Moneda> monedas = new HashMap<>();

	public ApiMonedas() {
	}

	public ApiMonedas(HashMap<String, Moneda> monedas) {
		this.monedas = monedas;
	}

	public void GetIndicadores() {

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
				JsonObject dolar = jsonObject.getAsJsonObject("dolar");
				JsonObject euro = jsonObject.getAsJsonObject("euro");
				monedas.put(dolar.get("codigo").getAsString(),
						new Moneda());
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Moneda> getMonedas() {
		return monedas;
	}
}
