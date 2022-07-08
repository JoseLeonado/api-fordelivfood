package com.jlcb.fordelivfood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	
	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não econtrada");
	
	private String uri;
	private String title;
	
	private ProblemType(String path, String title) {
		this.uri = "https://api-fordelivfood" + path;
		this.title = title;
	}

}
