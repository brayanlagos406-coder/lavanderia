package org.example.dao;



import org.example.Model.Vehiculos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehiculosDAOImpl implements VehiculosDAO {

    private final Connection connection;

    public VehiculosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Vehiculos vehiculo) {

        String sql = "INSERT INTO Vehiculos (ClienteID,Marca,Modelo,Placa,Color,Tipo) VALUES ( ?, ?, ?, ?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vehiculo.getClienteID());
            statement.setString(2, vehiculo.getMarca());
            statement.setString(3, vehiculo.getModelo());
            statement.setString(4, vehiculo.getPlaca());
            statement.setString(5, vehiculo.getColor());
            statement.setString(6, vehiculo.getTipo());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Vehiculos leer(int vehiculoID) {

        String sql = "SELECT * FROM Vehiculos WHERE VehiculoID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, vehiculoID);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Vehiculos(
                        rs.getInt("VehiculoID"),
                        rs.getInt("ClienteID"),
                        rs.getString("Marca"),
                        rs.getString("Modelo"),
                        rs.getString("Placa"),
                        rs.getString("Color"),
                        rs.getString("Tipo")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Vehiculos> listar() {

        List<Vehiculos> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vehiculos";

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Vehiculos(
                        rs.getInt("VehiculoID"),
                        rs.getInt("ClienteID"),
                        rs.getString("Marca"),
                        rs.getString("Modelo"),
                        rs.getString("Placa"),
                        rs.getString("Color"),
                        rs.getString("Tipo")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Vehiculos vehiculo) {

        String sql = "UPDATE Vehiculos SET Marca=?, Modelo=?, Placa=?, Color=?, Tipo=? WHERE VehiculoID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, vehiculo.getMarca());
            statement.setString(2, vehiculo.getModelo());
            statement.setString(3, vehiculo.getPlaca());
            statement.setString(4, vehiculo.getColor());
            statement.setString(5, vehiculo.getTipo());
            statement.setInt(6, vehiculo.getVehiculoID());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(int vehiculoID) {

        String sql = "DELETE FROM Vehiculos WHERE VehiculoID=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, vehiculoID);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}