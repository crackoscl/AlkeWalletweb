package cl.alkewallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String BBDD = "jdbc:mysql://localhost/Alke_Wallet_web";
	private static final String USER = "root";
	private static final String PASS = "Password123@!";
	private static Connection conex = null;
	protected static ResultSet rs = null;
	private static Statement stmt = null;

	public static Connection conexion() {

		try {

			if (conex == null) {
				Class.forName(DRIVER);
				conex = DriverManager.getConnection(BBDD, USER, PASS);
			}

		} catch (Exception e) {
			System.out.println("Error al conectarse a la base de datos");
		}

		return conex;

	}

	public static void cerrarConexion(Connection conex) {
		try {
			conex.close();
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexion");
		}
	}

	public static void realizarConsulta(String consulta) {
		try {
			conex = conexion();
			Statement stmt = conex.createStatement();
			rs = stmt.executeQuery(consulta);
		} catch (SQLException sql) {
			System.out.println("Error al realizar la consulta" + sql.getMessage());
		}
	}

	public static int actualizarBaseDatos(String consulta) {
		int resultado = 0;
		try {
			conex = conexion();
			stmt = conex.createStatement();
			resultado = stmt.executeUpdate(consulta);
		} catch (SQLException sql) {
			System.out.println(sql.getMessage());
			System.out.println("Error al actualizar en base de datos");
		}

		return resultado;
	}

}
