package org.example.dao;

import org.example.Model.Servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiciosDAOImpl implements ServiciosDAO {

    private final Connection connection;

    public ServiciosDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(Servicios servicio) {

        String sql = "INSERT INTO Servicios (Nombre, Precio) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombre());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Servicios leer(int servicioID) {

        String sql = "SELECT * FROM Servicios WHERE ServicioID=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servicioID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Servicios(
                        rs.getInt("ServicioID"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Servicios> listar() {

        List<Servicios> lista = new ArrayList<>();
        String sql = "SELECT * FROM Servicios";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Servicios(
                        rs.getInt("ServicioID"),
                        rs.getString("Nombre"),
                        rs.getDouble("Precio")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(Servicios servicio) {

        String sql = "UPDATE Servicios SET Nombre=?, Precio=? WHERE ServicioID=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, servicio.getNombre());
            stmt.setDouble(2, servicio.getPrecio());
            stmt.setInt(3, servicio.getServicioID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int servicioID) {

        String sql = "DELETE FROM Servicios WHERE ServicioID=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, servicioID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}