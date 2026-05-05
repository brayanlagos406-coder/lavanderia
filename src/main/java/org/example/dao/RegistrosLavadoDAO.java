package org.example.dao;

import org.example.Model.RegistrosLavado;
import java.util.List;

public interface RegistrosLavadoDAO {

    void crear(RegistrosLavado registro);

    RegistrosLavado leer(int registroID);

    List<RegistrosLavado> listar();

    void actualizar(RegistrosLavado registro);

    void eliminar(int registroID);
}