package org.example.dao;

import org.example.Model.Clientes;
import java.util.List;

public interface ClientesDAO {

    void crear(Clientes cliente);

    Clientes leer(int clienteID);

    List<Clientes> listar();

    void actualizar(Clientes cliente);

    void eliminar(int clienteID);
}