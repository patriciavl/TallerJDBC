package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicios {

    public static void ejercicio1(Connection connection, Statement statement) throws SQLException {
        // 1. btener todos los clientes de la clinica y mostrar sus datos por pantalla
    }

    public static void ejercicio2(Connection connection, Statement statement) throws SQLException {
        // 2. Insertarnos a nosotros como nuevo propietario de una mascota

    }

    public static void ejercicio3(Connection connection, Statement statement) throws SQLException {
        // 3. Modificar nuestra ciudad por Sevilla
        int numeroDeFilasModificadas = -1;
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void ejercicio4(Connection connection) throws SQLException {
        // 4. Crear una variable de tipo String y buscar todos los Owner que coincidan en nombre o apellido.

    }

    public static void ejercicio5(Connection connection) throws SQLException {
        // 5. Crear a partir de las variables nombre, apellido, direccion, ciudad y teléfono (todas de tipo
        // String), un nuevo owner
        int numeroDeFilasModificadas = -1;
        System.out.println("Se han modificado " + numeroDeFilasModificadas + " rows.");

    }

    public static void reto(Connection connection, Statement statement) throws SQLException {

    }

}
