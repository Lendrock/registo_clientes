package org.flim.registro_cliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity ( name = "Clientes")
//Lombok
@Data//Generar los setters y getters
@NoArgsConstructor//el constructor vacio
@AllArgsConstructor//el constructor lleno
@ToString//El metodo sobrecargado toString
@EqualsAndHashCode//El metodo para trabajar
public class Cliente {

    private Integer codigoCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String genero;
    private String edad;
}
