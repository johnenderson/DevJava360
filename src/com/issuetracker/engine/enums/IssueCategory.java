package com.issuetracker.engine.enums;

public enum IssueCategory {
    CATEGORIA_ACESSOS(1, "Acessos"), CATEGORIA_APLICACOES(2, "Aplicações"),
    CATEGORIA_MOBILE(3, "Mobile"), CATEGORIA_DESKTOP(4, "Desktop"),
    CATEGORIA_CONECTIVIDADE(5, "Conectividade"), CATEGORIA_EQUIPAMENTOS(6, "Equipamentos"),
    CATEGORIA_EQUIPAMENTOS_LOJAS(7, "Equipamentos Lojas"),
    CATEGORIA_IMPRESSORAS(8, "Impressoras"), CATEGORIA_INTERNET(9, "Internet");

    IssueCategory(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    private int categoryId;
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
