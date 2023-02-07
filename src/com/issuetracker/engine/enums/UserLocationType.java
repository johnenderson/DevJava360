package com.issuetracker.engine.enums;

public enum UserLocationType {
	LOJA(1, "LOJA", "Loja"),
	FABRICA(2, "FABRICA", "Fabrica"),
	ESCRITORIO(3, "ESCRITORIO", "Escritorio"),
	WRONG(0, "WRONG", "Wrong");

	private final int locationTypeId;
	private final String locationTypeUpperCase;
	private final String locationTypeName;

	UserLocationType(int codLocalizacao, String locationTypeUpperCase, String locationType) {
		this.locationTypeId = codLocalizacao;
		this.locationTypeUpperCase = locationTypeUpperCase;
		this.locationTypeName = locationType;
	}

	public String getUpperCaseValue() {
		return locationTypeUpperCase;
	}

	public String getLocationTypeName() {
		return locationTypeName;
	}

	public int getLocationTypeId() {
		return locationTypeId;
	}

	public UserLocationType findEnum(String value) {
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

	public UserLocationType findEnum(int value) {
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
