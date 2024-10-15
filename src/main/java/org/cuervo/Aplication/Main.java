package org.cuervo.Aplication;

import org.cuervo.Aplication.Services.RopaService;
import org.cuervo.Infrastructure.FileRopaRepository;

public class Main {
    public static void main(String[] args) {
        FileRopaRepository repository = new FileRopaRepository();
        RopaService service = new RopaService(repository);


        Menu visual = new Menu(service);

        visual.iniciar();
    }
}
