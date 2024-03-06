package com.example.producer.controllerTests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.producer.controller.MessageController;
import com.example.producer.dto.MessageDTO;
import com.example.producer.service.MessageService;

public class MessageControllerTest {
	 
	 @Test
	    public void testSendMessageSuccess() {
	        // Mock do MessageService
	        MessageService messageService = mock(MessageService.class);
	        
	        // Criar instância do controlador e injetar o MessageService
	        MessageController messageController = new MessageController(messageService);
	        
	        // Preparar dados de entrada
	        MessageDTO messageDTO = new MessageDTO();
	        messageDTO.setMessage("Teste de mensagem");
	        
	        // Executar o método
	        ResponseEntity<String> response = messageController.sendMessage(messageDTO);
	        
	        // Verificar o resultado
	        assert response.getStatusCode() == HttpStatus.OK;
	        assert response.getBody().contains("Mensagem enviada com sucesso");
	        
	        // Verificar se o método sendMessage do MessageService foi chamado
	        verify(messageService, times(1)).sendMessage("Teste de mensagem");
	    }
	}