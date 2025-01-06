package com.weverson.helpdesk.domain.enums;

public enum Status {
	
	ADMIN(0,"ABERTO"),
	ANDAMENTO(1,"ANDAMENTO"),
	ENCERRAMENTO(2,"ENCERRAMENTO");
	
	private Integer codigo;
	private String descricao;
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Perfil Inválido");
	}

	
	
	
	

}
