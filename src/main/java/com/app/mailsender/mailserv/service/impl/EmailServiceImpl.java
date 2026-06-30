package com.app.mailsender.mailserv.service.impl;

import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.mailsender.mailserv.dto.EmailRequest;
import com.app.mailsender.mailserv.service.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender ;
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void enviarCorreo(EmailRequest request) {
        
        
        try {
          //email plano// SimpleMailMessage email =  new SimpleMailMessage();
           MimeMessage mimeMessage = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
          
            helper.setTo(request.getDestinatario());
            helper.setSubject(request.getAsunto());
            helper.setText(request.getMensaje());
              // Agregar adjuntos
            if (request.getAttachments() != null) {
                for (MultipartFile archivo : request.getAttachments()) {
                    helper.addAttachment(
                    archivo.getOriginalFilename(),
                    archivo);
                }
            }

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            log.error("Error enviando correo a {}", request.getDestinatario(), e);
            throw new RuntimeException("No fue posible enviar el correo.", e);
        }

       
    

       
        
    }
}
