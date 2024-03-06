package com.example.producer.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.dto.MessageDTO;
import com.example.producer.service.MessageService;

@RestController
public class MessageController {
    
	 private final MessageService messageService;
	    
	    public MessageController(MessageService messageService) {
	        this.messageService = messageService;
	    }
	    
    @PostMapping("/mensagem")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> sendMessage(@RequestBody MessageDTO messageDTO) {
        if (messageDTO == null || messageDTO.getMessage() == null || messageDTO.getMessage().isEmpty()) {
            return ResponseEntity.badRequest().body("A mensagem não pode ser nula ou vazia.");
        }
        
        try {
            messageService.sendMessage(messageDTO.getMessage());
            return ResponseEntity.ok().body("Mensagem enviada com sucesso: " + messageDTO.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar a mensagem: " + e.getMessage());
        }
    }
}