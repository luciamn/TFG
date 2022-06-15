package com.lucia.estudiodetatuajes;

import com.lucia.estudiodetatuajes.Servicio.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EstudioDeTatuajesApplication {

    @Autowired
    private EmailSenderService senderService;

    public static void main(String[] args) {
        SpringApplication.run(EstudioDeTatuajesApplication.class, args);
    }
}


