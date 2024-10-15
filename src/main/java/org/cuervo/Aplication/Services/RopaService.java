package org.cuervo.Aplication.Services;

import org.cuervo.Domain.Ropa;
import org.cuervo.Interface.RopaRepository;


import java.util.List;

public class RopaService {

    private final RopaRepository ropaRepository;

    public RopaService(RopaRepository ropaRepository) {
        this.ropaRepository = ropaRepository;
    }

    public void crearRopa(Ropa ropa) {
        ropaRepository.saveRopa(ropa);
    }

    public List<Ropa> listarRopas() {
        return ropaRepository.findAll();
    }

    public void eliminarRopa(int id) {
        ropaRepository.deleteRopa(id);
    }

    public Ropa buscarRopaPorId(int id) {
        return ropaRepository.findRopaById(id);
    }

    public void actualizarRopa(Ropa ropa) {
        ropaRepository.updateRopa(ropa);
    }
}
