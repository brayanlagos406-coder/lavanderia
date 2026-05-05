package org.example.dao;

import org.example.Model.Servicios;

import java.util.List;

public interface ServiciosDAO {
    void crear(Servicios servicio);

    Servicios leer(int servicioID);

    List<Servicios> listar();

    void actualizar(Servicios servicio);

    void eliminar(int servicioID);
}
