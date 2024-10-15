package org.cuervo.Aplication;


import org.cuervo.Aplication.Services.RopaService;
import org.cuervo.Domain.Ropa;

import javax.swing.*;
import java.math.BigDecimal;

public class Menu {
    private final RopaService ropaService;


    public Menu(RopaService ropaService) {
        this.ropaService = ropaService;
    }



    public void iniciar() {
        while (true) {
            try {
                while (true) {
                    int opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija una opcion valida: \n" +
                            "1. Registrar ropa \n" +
                            "2. Borrar ropa \n" +
                            "3. Actualizar ropa \n" +
                            "4. Lista de ropa \n" +
                            "5. Buscar ropa \n" +
                            "6. Salir \n" ));

                    switch (opcion) {
                        case 1 -> crearRopa();
                        case 2 -> eliminarRopa();
                        case 3 -> actualizarRopa();
                        case 4 -> listaRopas();
                        case 5 -> buscarRopa();
                        case 6 -> {
                            return;
                        }
                        default -> JOptionPane.showMessageDialog(null, "Opcion no valida");
                    }

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Dato erroneo ingresado");
            }
        }
    }

    public void crearRopa() {

        String marca = JOptionPane.showInputDialog("Ingrese la marca de la prenda: ");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de prenda: ");
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de la prenda: "));


       Ropa ropa = new Ropa(marca, tipo, precio);

        ropaService.crearRopa(ropa);
        JOptionPane.showMessageDialog(null, "Ropa creada con exito");

    }

    public void eliminarRopa() {
        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ropa para borrarla del sistema"));

        Ropa ropa = ropaService.buscarRopaPorId(busqueda);

        if (ropa != null) {
            ropaService.eliminarRopa(busqueda);
            JOptionPane.showMessageDialog(null, "Se elimino el ropa con exito");
        }
        else{JOptionPane.showMessageDialog(null,"Ropa no encontrada");}
    }

    public void actualizarRopa() {
        int busqueda = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ropa para borrarla del sistema"));


        Ropa ropa = ropaService.buscarRopaPorId(busqueda);
        if (ropa != null) {
            String marcaNuvea = JOptionPane.showInputDialog("Ingrese la nueva marca de la prenda");
            if (!marcaNuvea.isEmpty()) {
                ropa.setMarca(marcaNuvea);
            }
            String tipoNuvea = JOptionPane.showInputDialog("Ingrese el nuevo tipo de prenda");
            if (!tipoNuvea.isEmpty()) {
                ropa.setTipo(tipoNuvea);
            }

            int precioNueva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio de la prenda: "));
                ropa.setPrecio(precioNueva);

            ropaService.actualizarRopa(ropa);
            JOptionPane.showMessageDialog(null,"Ropa actualizada con éxito");
        } else {
            JOptionPane.showMessageDialog(null,"Ropa no encontrada");
        }
    }

    public void listaRopas(){
        System.out.println("Lista de pacientes: \n");
        ropaService.listarRopas().forEach(System.out::println);
    }

    public void buscarRopa(){
        String busqueda = (JOptionPane.showInputDialog("Ingrese el ID de la ropa para buscarla en el sistema"));

        Ropa ropa = ropaService.buscarRopaPorId(Integer.parseInt(busqueda));

        if (ropa != null) {
            JOptionPane.showMessageDialog(null,"ROPA:" + " [ID = " + ropa.getId() + "]" + " [Marca = " + ropa.getMarca() + "]" + " [Tipp = " + ropa.getTipo() + "]" + " [Precio = " + ropa.getPrecio() + "]");
        } else JOptionPane.showMessageDialog(null,"ID de ropa no encontrada");

    }




}
