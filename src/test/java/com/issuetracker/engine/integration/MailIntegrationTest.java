package com.issuetracker.engine.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailIntegrationTest {

    @Autowired
    private MailIntegration mailIntegration;

    @Test
    void createMailIntegration() {
        mailIntegration.send("johnenderson@gmail.com", "Hello!!", "Acesso liberado!!!");
    }

}
