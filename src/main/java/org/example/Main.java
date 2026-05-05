package org.example;

import org.example.Model.*;
import org.example.Util.ConexionBD;
import org.example.dao.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection connection = ConexionBD.obtenerConexion();
             Scanner scanner = new Scanner(System.in)) {

            ClientesDAO clientesDAO = new ClientesDAOImpl(connection);
            VehiculosDAO vehiculosDAO = new VehiculosDAOImpl(connection);
            ServiciosDAO serviciosDAO = new ServiciosDAOImpl(connection);
            RegistrosLavadoDAO registrosDAO = new RegistrosLavadoDAOImpl(connection);

            int opcion;

            do {
                System.out.println("\n===== MENU PRICIPAL DE LA LAVANDERIA =====");
                System.out.println("1. Menu de los Clientes");
                System.out.println("2. Menu de lso Vehiculos");
                System.out.println("3. Menu de los Servicios");
                System.out.println("4. Menu de los Registros de Lavado");
                System.out.println("0. Salir");
                System.out.print("Seleccione el menu correspondiente:" +
                        " ");

                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1 -> menuClientes(scanner, clientesDAO);
                    case 2 -> menuVehiculos(scanner, vehiculosDAO);
                    case 3 -> menuServicios(scanner, serviciosDAO);
                    case 4 -> menuRegistros(scanner, registrosDAO);
                }

            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= CLIENTES =================
    public static void menuClientes(Scanner scanner, ClientesDAO dao) {

        int opcion;

        do {
            System.out.println("\n===== MENU DE LOS CLIENTES =====");
            System.out.println("1. Crear cliente nuevo");
            System.out.println("2. Lista de los clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("0. Volver");
            System.out.print("Seleccione la opcion correspondiente:" +
                    " ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Telefono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Direccion: ");
                    String direccion = scanner.nextLine();

                    dao.crear(new Clientes(0, nombre, apellido, telefono, email, direccion));
                }

                case 2 -> dao.listar().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.leer(scanner.nextInt()));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Clientes c = dao.leer(id);

                    if (c != null) {
                        System.out.print("Nombre: ");
                        c.setNombre(scanner.nextLine());

                        System.out.print("Apellido: ");
                        c.setApellido(scanner.nextLine());

                        System.out.print("Telefono: ");
                        c.setTelefono(scanner.nextLine());

                        System.out.print("Email: ");
                        c.setEmail(scanner.nextLine());

                        System.out.print("Direccion: ");
                        c.setDireccion(scanner.nextLine());

                        dao.actualizar(c);
                    }
                }

                case 5 -> {
                    System.out.print("ID: ");
                    dao.eliminar(scanner.nextInt());
                }
            }

        } while (opcion != 0);
    }

    // ================= VEHICULOS =================
    public static void menuVehiculos(Scanner scanner, VehiculosDAO dao) {

        int opcion;

        do {
            System.out.println("\n===== MENU DE LOS VEHICULOS =====");
            System.out.println("1. Crear nuevo vehiculo");
            System.out.println("2. Lista de los vehiculos");
            System.out.println("3. Buscar el vehiculo");
            System.out.println("4. Actualizar el vehiculo");
            System.out.println("5. Eliminar el vehiculo");
            System.out.println("0. Volver");
            System.out.print("Seleccione la opcion correspondiente:" +
                    " ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("ClienteID: ");
                    int clienteID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Color: ");
                    String color = scanner.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();

                    dao.crear(new Vehiculos(0, clienteID, marca, modelo, placa, color, tipo));
                }

                case 2 -> dao.listar().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.leer(scanner.nextInt()));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Vehiculos v = dao.leer(id);

                    if (v != null) {
                        System.out.print("Marca: ");
                        v.setMarca(scanner.nextLine());

                        System.out.print("Modelo: ");
                        v.setModelo(scanner.nextLine());

                        System.out.print("Placa: ");
                        v.setPlaca(scanner.nextLine());

                        System.out.print("Color: ");
                        v.setColor(scanner.nextLine());

                        System.out.print("Tipo: ");
                        v.setTipo(scanner.nextLine());

                        dao.actualizar(v);
                    }
                }

                case 5 -> {
                    System.out.print("ID: ");
                    dao.eliminar(scanner.nextInt());
                }
            }

        } while (opcion != 0);
    }

    // ================= SERVICIOS =================
    public static void menuServicios(Scanner scanner, ServiciosDAO dao) {

        int opcion;

        do {
            System.out.println("\n===== MENU DE LOS SERVICIOS =====");
            System.out.println("1. Crear un nuevo servicio");
            System.out.println("2. Lista de los servicios");
            System.out.println("3. Buscar el servicio");
            System.out.println("4. Actualizar el servicio");
            System.out.println("5. Eliminar al servicio");
            System.out.println("0. Volver");
            System.out.print("Seleccione la opcion correspondiente:" +
                    " ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();

                    dao.crear(new Servicios(0, nombre, precio));
                }

                case 2 -> dao.listar().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.leer(scanner.nextInt()));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    Servicios s = dao.leer(id);

                    if (s != null) {
                        System.out.print("Nombre: ");
                        s.setNombre(scanner.nextLine());

                        System.out.print("Precio: ");
                        s.setPrecio(scanner.nextDouble());

                        dao.actualizar(s);
                    }
                }

                case 5 -> {
                    System.out.print("ID: ");
                    dao.eliminar(scanner.nextInt());
                }
            }

        } while (opcion != 0);
    }

    // ================= REGISTROS =================
    public static void menuRegistros(Scanner scanner, RegistrosLavadoDAO dao) {

        int opcion;

        do {
            System.out.println("\n===== MENO DE LOS REGISTROS DE LAVADO =====");
            System.out.println("1. Crear un nuevo registro");
            System.out.println("2. Lista de los registros");
            System.out.println("3. Buscar el registro");
            System.out.println("4. Eliminar el registro");
            System.out.println("0. Volver");
            System.out.print("Seleccione la opcion correspondiente:" +
                    " ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1 -> {
                    System.out.print("VehiculoID: ");
                    int vehiculoID = scanner.nextInt();

                    System.out.print("ServicioID: ");
                    int servicioID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Fecha (YYYY-MM-DD): ");
                    Date fecha = Date.valueOf(scanner.nextLine());

                    System.out.print("Hora Inicio (HH:MM:SS): ");
                    Time inicio = Time.valueOf(scanner.nextLine());

                    System.out.print("Hora Fin (HH:MM:SS): ");
                    Time fin = Time.valueOf(scanner.nextLine());

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();

                    dao.crear(new RegistrosLavado(0, vehiculoID, servicioID, fecha, inicio, fin, precio));
                }

                case 2 -> dao.listar().forEach(System.out::println);

                case 3 -> {
                    System.out.print("ID: ");
                    System.out.println(dao.leer(scanner.nextInt()));
                }

                case 4 -> {
                    System.out.print("ID: ");
                    dao.eliminar(scanner.nextInt());
                }
            }

        } while (opcion != 0);
    }
}