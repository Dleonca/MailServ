package com.app.mailsender.mailserv.service;


import com.app.mailsender.mailserv.dto.EmailRequest;

public interface EmailService {
     void enviarCorreo(
            EmailRequest request );//dto

    
}
