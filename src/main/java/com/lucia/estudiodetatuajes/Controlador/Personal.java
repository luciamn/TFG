package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Repositorio.PersonalRepo;
import com.lucia.estudiodetatuajes.Servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/personal")
public class Personal {

    @Autowired
    private PersonalServicio personalServicio;

    @Autowired
    private PersonalRepo personalRepo;

   /** @GetMapping("/find/{id}")
    public ResponseEntity<Personal> getAllPersonal(@PathVariable("id") Long id) {
        List<com.lucia.estudiodetatuajes.Modelo.Personal> personal = personalServicio.listarPersonal();
        return new ResponseEntity<>(personal, HttpStatus.OK);
    }
   */
}
