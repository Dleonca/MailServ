package com.app.mailsender.mailserv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.mailsender.mailserv.dto.EmailRequest;
import com.app.mailsender.mailserv.service.EmailService;
@Controller
public class EmailController {
     private final EmailService emailService;

    public EmailController(
            EmailService emailService) {

        this.emailService = emailService;
    }

    @GetMapping("/")
    public String mostrarFormulario() {
        return "formulario";
    }

    @PostMapping("/enviar")
    public String enviarCorreo( @ModelAttribute EmailRequest request) {

        emailService.enviarCorreo(request);

        return "redirect:/";
    }
}

