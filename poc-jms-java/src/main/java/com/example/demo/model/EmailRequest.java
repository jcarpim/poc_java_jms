package com.example.demo.model;

import lombok.Data;

@Data
public class EmailRequest {

	private String nome;
	private String idade;
	private String emailFormatado;

	public String toString() {
		return "nome: " + this.nome + " idade: " + this.idade + " email: " + this.emailFormatado;
	}

	public void setEmailFormatado(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setIdade(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setNome(String string) {
		// TODO Auto-generated method stub
		
	}
}
