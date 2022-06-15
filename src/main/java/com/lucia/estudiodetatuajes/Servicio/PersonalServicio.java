package com.lucia.estudiodetatuajes.Servicio;


import com.lucia.estudiodetatuajes.Modelo.Personal;
import com.lucia.estudiodetatuajes.Modelo.TipoTatuaje;
import com.lucia.estudiodetatuajes.Repositorio.PersonalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServicio {

    @Autowired
    private PersonalRepo personalRepo;


    public Personal findByDni(String dni){
        return personalRepo.findByDni(dni);
    }


    public Personal findByTipoTatuaje(TipoTatuaje tipoTatuaje) {
        return personalRepo.findByTipoTatuaje(tipoTatuaje);
    }



   public Personal addPersonal(Personal personal){
        return personalRepo.save(personal);
    }

    public List<Personal> listarPersonal(){
        return personalRepo.findAll();
    }

    public Personal updatePersonal(Personal personal){
        return personalRepo.save(personal);
    }



    public void deletePersonal(Long id){
         personalRepo.deleteById(id);
    }


//    public ArrayList<Personal> obtenerPersonal(){
//        return (ArrayList<Personal>) personalRepo.findAll();
//    }





}
