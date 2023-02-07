package com.issuetracker.engine.test;

import com.issuetracker.engine.enums.UserLocationType;

public class TesteEnum {

	public static void main(String[] args) {
		System.out.println(UserLocationType.LOJA.getlocationTypeName());
		System.out.println(UserLocationType.ESCRITORIO.getlocationTypeName());
		System.out.println(UserLocationType.FABRICA.getlocationTypeName());
		System.out.println(UserLocationType.LOJA);
		System.out.println(UserLocationType.ESCRITORIO);
		System.out.println(UserLocationType.FABRICA);

	}

}
