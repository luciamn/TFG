package com.lucia.estudiodetatuajes.Controlador;


import com.lucia.estudiodetatuajes.Servicio.EmailSenderService;
import com.lucia.estudiodetatuajes.Modelo.*;
import com.lucia.estudiodetatuajes.Repositorio.CitaRepo;
import com.lucia.estudiodetatuajes.Servicio.CitaServicio;
import com.lucia.estudiodetatuajes.upload.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
public class CitaController {

    @Autowired
    private CitaServicio citaServicio;

    @Autowired
    private CitaRepo citaRepo;

    @Autowired
    private EmailSenderService senderService;

    @Autowired
    StorageService storageService;





    @GetMapping("/auth/cita")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("usuario") == null) {
            return "redirect:/login";
        } else {
            model.addAttribute("cita", new Cita());
            return "citaHTML";
        }
    }


    @PostMapping("/auth/cita")
    public String cita(@Validated @ModelAttribute("cita") Cita cita, @RequestParam("file") MultipartFile file, BindingResult result, Model model, HttpSession session, HttpServletRequest request){
        if (session.getAttribute("usuario") != null){
            if (result.hasErrors()){
                return "redirect:/";
            }else
            if (!file.isEmpty()) {
                String imagen = storageService.store(file);
                cita.setFoto(MvcUriComponentsBuilder
                        .fromMethodName(FilesController.class, "serveFile", imagen).build().toUriString());
            }
            {
                boolean hora = citaServicio.citasHoras(cita);
                boolean fecha = citaServicio.citasFechas(cita);
                if (hora && fecha){
                    return "errorCita";

                }else{
                    model.addAttribute("cita", citaServicio.registrarCita(cita, session));
                    return "index";
                }

            }
        }else{
            return "redirect:/login";
        }
    }

    //sacar las citas de un cliente
    @GetMapping("/miCita/{id}")
    public String ver(@PathVariable("id") int id, Model model, HttpSession session) {
        List<Cita> citasCliente = citaRepo.citasCliente(id);
        model.addAttribute("cita", citasCliente);
        return "miCita";
    }

    //eliminar una cita
    @GetMapping("/miCita/eliminar/{id}")
    public String eliminarCita(@PathVariable("id") Cita cita, Long id, HttpSession session){
        citaRepo.deleteById(cita.getId());
        return "index";
    }


    @GetMapping("/miCita/actualizar/{id}")
    public ModelAndView actualizarCita(@PathVariable("id") Long id, Cita citas){
        ModelAndView modelAndView = new ModelAndView("citaHTML");
        Optional<Cita> cita = citaRepo.findById(citas.getId());
        modelAndView.addObject("cita", cita);

        return modelAndView;
    }
}