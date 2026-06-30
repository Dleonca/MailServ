package com.app.mailsender.mailserv.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {
    private String destinatario;
    private String asunto;
    private String mensaje;
    private List<MultipartFile> attachments;
    
    public void setAttachments(List<MultipartFile> attachments) {
        this.attachments = attachments;
    }
    public List<MultipartFile> getAttachments() {
        return attachments;
    }
    public String getDestinatario() {
        return destinatario;
    }
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    
}
