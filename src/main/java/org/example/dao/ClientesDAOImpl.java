package org.example.dao;

import org.example.Model.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAOImpl implements ClientesDAO {

    private final Connection connection;

    public ClientesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Clientes cliente) {
        String sql = "INSERT INTO Clientes (Nombre, Apellido, Telefono, Email, Direccion) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getDireccion());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Clientes leer(int clienteID) {
        String sql = "SELECT * FROM Clientes WHERE ClienteID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, clienteID);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Clientes(
                        rs.getInt("ClienteID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Telefono"),
                        rs.getString("Email"),
                        rs.getString("Direccion")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Clientes> listar() {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Clientes(
                        rs.getInt("ClienteID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Telefono"),
                        rs.getString("Email"),
                        rs.getString("Direccion")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Clientes cliente) {
        String sql = "UPDATE Clientes SET Nombre=?, Apellido=?, Telefono=?, Email=?, Direccion=? WHERE ClienteID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getApellido());
            statement.setString(3, cliente.getTelefono());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getDireccion());
            statement.setInt(6, cliente.getClienteID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int clienteID) {
        String sql = "DELETE FROM Clientes WHERE ClienteID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, clienteID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}