package com.jes.aulas.constants;

public enum TicketConstants {
        WELCOME_SYSTEM_TICKETS("Seja bem vindo ao sistema de chamados, insira seu nome para iniciar:"),
        EMAILS_TO_BE_NOTIFIED("E-mails adicionais a serem notificados, separados por ';'. (Ex: e-mail1@teste.com; email2@teste.com");
        private final String value;

        TicketConstants(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

}
