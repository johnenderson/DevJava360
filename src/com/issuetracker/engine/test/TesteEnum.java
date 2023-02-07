package com.issuetracker.engine.test;

import com.issuetracker.engine.enums.IssueLocationType;

public class TesteEnum {

	public static void main(String[] args) {
		System.out.println(IssueLocationType.LOJA.getlocationTypeName());
		System.out.println(IssueLocationType.ESCRITORIO.getlocationTypeName());
		System.out.println(IssueLocationType.FABRICA.getlocationTypeName());
		System.out.println(IssueLocationType.LOJA);
		System.out.println(IssueLocationType.ESCRITORIO);
		System.out.println(IssueLocationType.FABRICA);

	}

}
