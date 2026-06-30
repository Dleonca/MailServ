package com.app.mailsender.mailserv.service;

public interface EmailService {
     void enviarCorreo(
            String destinatario,
            String asunto,
            String mensaje);
    
}
