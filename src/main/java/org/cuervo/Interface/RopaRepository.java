package org.cuervo.Interface;

import org.cuervo.Domain.Ropa;

import java.util.List;

public interface RopaRepository {
    void saveRopa(Ropa ropa);
    void updateRopa(Ropa ropa);

    void deleteRopa(int id);

    Ropa findRopaById(int id);
    List<Ropa> findAll();
}
