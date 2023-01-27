package com.issuetracker.engine.enums;

public enum TipoLocalizacao {
	LOJA(1, "LOJA", "Loja"),
	FABRICA(2, "FABRICA", "Fabrica"),
	ESCRITORIO(3, "ESCRITORIO", "Escritorio"),
	WRONG(0, "WRONG", "Wrong");

	private int codLocalizacao;
	private String localizacaoUpperCase;
	private String localizacao;

	TipoLocalizacao(int codLocalizacao, String localizacaoUpperCase, String localizacao) {
		this.codLocalizacao = codLocalizacao;
		this.localizacaoUpperCase = localizacaoUpperCase;
		this.localizacao = localizacao;
	}

	public String getUpperCaseValue() {
		return localizacaoUpperCase;
	}

	public String getValue() {
		return localizacao;
	}

	public int getCodLocalizacao() {
		return codLocalizacao;
	}

	public TipoLocalizacao findEnum(String value) {
		if (value.equals("LOJA") || value.equals("Loja")) {
			return LOJA;
		}
		if (value.equals("FABRICA") || value.equals("Fabrica")) {
			return FABRICA;
		}
		if (value.equals("ESCRITORIO") || value.equals("Escritorio")) {
			return ESCRITORIO;
		}
		return WRONG;
	}

	public TipoLocalizacao findEnum(int value) {
		if (value == 1) {
			return LOJA;
		}
		if (value == 2) {
			return FABRICA;
		}
		if (value == 3) {
			return ESCRITORIO;
		}

		return WRONG;
	}

}
