package com.issuetracker.engine.test;

import com.issuetracker.engine.enums.UserLocationType;

public class TesteEnum {

	public static void main(String[] args) {
		System.out.println(UserLocationType.LOJA.getLocationTypeName());
		System.out.println(UserLocationType.ESCRITORIO.getLocationTypeName());
		System.out.println(UserLocationType.FABRICA.getLocationTypeName());
		System.out.println(UserLocationType.LOJA);
		System.out.println(UserLocationType.ESCRITORIO);
		System.out.println(UserLocationType.FABRICA);

	}

}
