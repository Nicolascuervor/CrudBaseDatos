package org.cuervo.Domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Ropas")

public class Ropa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private int precio;



    public Ropa(String marca, String tipo, int precio) {
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
      
    }


    public Ropa() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Ropa: " +
                "ID = |" + id + "| \t" +
                "Marca = |" + marca + "| \t" +
                "Tipo = |" + tipo + "| \t" +
                "Precio = |" + precio + "| \t";
    }
}
