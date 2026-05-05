package org.example.dao;

import org.example.Model.RegistrosLavado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrosLavadoDAOImpl implements RegistrosLavadoDAO {

    private final Connection connection;

    public RegistrosLavadoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crear(RegistrosLavado r) {

        String sql = "INSERT INTO RegistrosLavado (VehiculoID, ServicioID, FechaLavado, HoraInicio, HoraFin, PrecioTotal) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, r.getVehiculoID());
            ps.setInt(2, r.getServicioID());
            ps.setDate(3, r.getFechaLavado());
            ps.setTime(4, r.getHoraInicio());
            ps.setTime(5, r.getHoraFin());
            ps.setDouble(6, r.getPrecioTotal());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RegistrosLavado leer(int registroID) {

        String sql = "SELECT * FROM RegistrosLavado WHERE RegistroID = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, registroID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new RegistrosLavado(
                        rs.getInt("RegistroID"),
                        rs.getInt("VehiculoID"),
                        rs.getInt("ServicioID"),
                        rs.getDate("FechaLavado"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"),
                        rs.getDouble("PrecioTotal")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<RegistrosLavado> listar() {

        List<RegistrosLavado> lista = new ArrayList<>();
        String sql = "SELECT * FROM RegistrosLavado";

        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new RegistrosLavado(
                        rs.getInt("RegistroID"),
                        rs.getInt("VehiculoID"),
                        rs.getInt("ServicioID"),
                        rs.getDate("FechaLavado"),
                        rs.getTime("HoraInicio"),
                        rs.getTime("HoraFin"),
                        rs.getDouble("PrecioTotal")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public void actualizar(RegistrosLavado r) {

        String sql = "UPDATE RegistrosLavado SET VehiculoID=?, ServicioID=?, FechaLavado=?, HoraInicio=?, HoraFin=?, PrecioTotal=? WHERE RegistroID=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, r.getVehiculoID());
            ps.setInt(2, r.getServicioID());
            ps.setDate(3, r.getFechaLavado());
            ps.setTime(4, r.getHoraInicio());
            ps.setTime(5, r.getHoraFin());
            ps.setDouble(6, r.getPrecioTotal());
            ps.setInt(7, r.getRegistroID());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int registroID) {

        String sql = "DELETE FROM RegistrosLavado WHERE RegistroID=?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, registroID);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}