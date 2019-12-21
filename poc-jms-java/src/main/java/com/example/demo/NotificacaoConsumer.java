package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

import com.example.demo.model.EmailRequest;

public class NotificacaoConsumer {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Value("${queue.email}")
	private String queueEmail;

	@JmsListener(destination = "${queue.email}")
	public void receive(EmailRequest emailRequest) {
		try {
			System.out.println(emailRequest.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void send() {
		jmsTemplate.convertAndSend(queueEmail, entityToRequest());
		System.out.println("Enviando para a fila da notificação");
	}

	private Object entityToRequest() {
		EmailRequest builder = new EmailRequest();
		builder.setEmailFormatado("jecarpim@gmail.com");
		builder.setIdade("24");
		builder.setNome("Jessy");
		return builder;
	}
}
