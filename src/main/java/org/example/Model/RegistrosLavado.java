package org.example.Model;

import java.sql.Date;
import java.sql.Time;

public class RegistrosLavado {

    private int RegistroID;
    private int VehiculoID;
    private int ServicioID;
    private Date FechaLavado;
    private Time HoraInicio;
    private Time HoraFin;
    private double PrecioTotal;

    public RegistrosLavado() {
    }

    public RegistrosLavado(int registroID, int vehiculoID, int servicioID,
                           Date fechaLavado, Time horaInicio, Time horaFin, double precioTotal) {
        RegistroID = registroID;
        VehiculoID = vehiculoID;
        ServicioID = servicioID;
        FechaLavado = fechaLavado;
        HoraInicio = horaInicio;
        HoraFin = horaFin;
        PrecioTotal = precioTotal;
    }

    public int getRegistroID() {
        return RegistroID;
    }

    public void setRegistroID(int registroID) {
        RegistroID = registroID;
    }

    public int getVehiculoID() {
        return VehiculoID;
    }

    public void setVehiculoID(int vehiculoID) {
        VehiculoID = vehiculoID;
    }

    public int getServicioID() {
        return ServicioID;
    }

    public void setServicioID(int servicioID) {
        ServicioID = servicioID;
    }

    public Date getFechaLavado() {
        return FechaLavado;
    }

    public void setFechaLavado(Date fechaLavado) {
        FechaLavado = fechaLavado;
    }

    public Time getHoraInicio() {
        return HoraInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        HoraInicio = horaInicio;
    }

    public Time getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(Time horaFin) {
        HoraFin = horaFin;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        PrecioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "RegistrosLavado{" +
                "RegistroID=" + RegistroID +
                ", VehiculoID=" + VehiculoID +
                ", ServicioID=" + ServicioID +
                ", FechaLavado=" + FechaLavado +
                ", HoraInicio=" + HoraInicio +
                ", HoraFin=" + HoraFin +
                ", PrecioTotal=" + PrecioTotal +
                '}';
    }
}