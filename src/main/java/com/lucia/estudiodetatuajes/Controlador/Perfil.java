package com.lucia.estudiodetatuajes.Controlador;

import com.lucia.estudiodetatuajes.Servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Perfil {

    @Autowired
    ClienteServicio clienteServicio;

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
