package com.lucia.estudiodetatuajes.Controlador;


import com.lucia.estudiodetatuajes.Modelo.Cliente;
import com.lucia.estudiodetatuajes.Modelo.Personal;
import com.lucia.estudiodetatuajes.Servicio.ClienteServicio;
import com.lucia.estudiodetatuajes.Servicio.PersonalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginCliente {

    @Autowired
    private ClienteServicio clienteServicio;

    @Autowired
    private PersonalServicio personalServicio;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "login";
    }

    @PostMapping("/Postlogin")
    public String Postlogin(@RequestParam("username") String email, @RequestParam("password") String passwordUncode, HttpSession session) {
        Cliente c = clienteServicio.findByEmail(email);
        String passwdCode = c.getContrasena();
        if (passwordEncoder.matches(passwordUncode, passwdCode)) {
            session.setAttribute("usuario", clienteServicio.findByEmail(email));
            return "index";
        } else {
            return "redirect:/login";
        }
    }


    @GetMapping("/cliente")
    public String GetregistroCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "registro";
    }

    @PostMapping("/cliente")
    public String PostregistroCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
        if (model.getAttribute("cliente") != null) {
            model.addAttribute("cliente", clienteServicio.registrar(cliente, passwordEncoder));
        }
        return "redirect:/login";
    }
}
