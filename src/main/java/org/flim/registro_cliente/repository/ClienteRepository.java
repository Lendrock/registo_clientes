package org.flim.registro_cliente.repository;

import org.flim.registro_cliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    //Puede sustituir al Dao
    //Una interfaz que tiene todos los metodos genericos del CRUD o mantenimiento
}
