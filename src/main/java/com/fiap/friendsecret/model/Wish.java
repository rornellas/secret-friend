package com.fiap.friendsecret.model;

public class Wish {

	private String nome;
	private String referencia;
	private String desejo;
	private String senha;

	public Wish(String nome, String referencia, String desejo, String senha) {
		this.nome = nome;
		this.referencia = referencia;
		this.desejo = desejo;
		this.senha = senha;
	}
	
	public Wish(String nome, String referencia) {
		this.nome = nome;
		this.referencia = referencia;
	}

	public String generateId() {
		String id = nome.replaceAll(" ", "").toLowerCase()+referencia.replaceAll(" ", "").toLowerCase();
		
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getReferencia() {
		return referencia;
	}
	
	public String getDesejo() {
		return desejo;
	}
	
	public String getSenha() {
		return senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((referencia == null) ? 0 : referencia.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wish other = (Wish) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (referencia == null) {
			if (other.referencia != null)
				return false;
		} else if (!referencia.equals(other.referencia))
			return false;
		return true;
	}

}
