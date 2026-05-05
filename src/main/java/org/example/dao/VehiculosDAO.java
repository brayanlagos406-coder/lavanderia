package org.example.dao;

import org.example.Model.Clientes;
import org.example.Model.Vehiculos;

import java.util.List;

public interface VehiculosDAO {

    void crear(Vehiculos vehiculo);

    Vehiculos leer (int vehiculoID);

    List<Vehiculos> listar();

    void actualizar(Vehiculos vehiculo);

    void eliminar(int vehiculoID);
}