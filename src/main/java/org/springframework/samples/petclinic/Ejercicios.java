package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;

public class Ejercicios {

	public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
		// 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
		statement = connection.createStatement();
		String sql = "SELECT * FROM owners;";
		ResultSet rs = statement.executeQuery(sql);

		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String address = rs.getString("address");
			String city = rs.getString("city");
			String telephone = rs.getString("telephone");

			System.out.println("Id: " + id);
			System.out.println(", Nombre: " + firstName);
			System.out.println(", Apellidos: " + lastName);
			System.out.println(", Adress: " + address);
			System.out.println("city: " + city);
			System.out.println("telephone: " + telephone);

		}
		rs.close();
	}

	public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
		// 2. Insertarnos a nosotros como nuevo propietario de una mascota

		statement = connection.createStatement();
		String sql = "INSERT INTO owners(id, first_name, last_name, address, city, telephone) VALUES (null, 'Patricia', 'Vila Luz', 'Lisboa', 'Lisboa', '12345')";
		int a = statement.executeUpdate(sql);
	}

	public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
		// 3. Modificar nuestra ciudad por Sevilla
		statement = connection.createStatement();
		String sql = "UPDATE owners SET city = 'Sevilla' WHERE id=11";
		statement.executeUpdate(sql);

	}

	public static void ejercicio4(Connection connection) throws SQLException {
		// 4. Crear una variable de tipo String y buscar todos los Owner que coincidan
		// en nombre o apellido.
		PreparedStatement preparedStatement = null;
		String name = "Patricia";
		String sql = "SELECT * FROM owners WHERE first_name=? OR last_name=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, name);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			int id = rs.getInt("id");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");

			System.out.println("Id: " + id);
			System.out.println(", Nombre: " + firstName);
			System.out.println(", Apellidos: " + lastName);
		}
		rs.close();
	}

	public static void ejercicio5(Connection connection) throws SQLException {
		// 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y
		// teléfono (todas de tipo
		// String), un nuevo owner

		String nombre = "aaa";
		String apellido = "bbb";
		String direccion = "ccc";
		String ciudade = "ddd";
		String telefono = "eee";
		String sql = "INSERT INTO owners VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, nombre);
		preparedStatement.setString(2, apellido);
		preparedStatement.setString(3, direccion);
		preparedStatement.setString(4, ciudade);
		preparedStatement.setString(5, telefono);
		preparedStatement.executeUpdate();

	}

	public static void reto(Connection connection, Statement statement) throws SQLException {
		Owner patricia = new Owner();
		Pet elephant = new Pet();
		Date data = new Date();
		
		patricia.setId(null);
		patricia.setLastName("manel");
		patricia.setFirstName("manel");
		patricia.setAddress("debaixo da ponte");
		patricia.setCity("china");
		patricia.setTelephone("12345");
		
		String sql = "INSERT INTO owners VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, patricia.getFirstName());
		preparedStatement.setString(2, patricia.getFirstName());
		preparedStatement.setString(3, patricia.getAddress());
		preparedStatement.setString(4, patricia.getCity());
		preparedStatement.setString(4, patricia.getTelephone());
		preparedStatement.executeUpdate();
		
		elephant.setId(null);
		elephant.setName("ze cao");
		elephant.setBirthDate(data);

		String sql = "INSERT INTO pets VALUES (null, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, elephant.getName());
		preparedStatement.setString(2, elephant.getBirthDate());
		
	
		String sql = "DELETE FROM owners WHERE id=?";
	}
}
