package com.japb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiRestTemplateApplicationTests {


    private final ApplicationContext applicationContext;

    ApiRestTemplateApplicationTests(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    void testMain() {
        // Invocar el método main
        ApiRestTemplateApplication.main(new String[] {});
    }

    @Test
    void contextLoads() {
        // Verifica que el contexto de la aplicación se carga correctamente
        assertThat(applicationContext).isNotNull();
    }

    @Test
    void restTemplateBeanIsAvailable() {
        // Verifica que el bean RestTemplate está disponible en el contexto
        RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);
        assertThat(restTemplate).isNotNull();
    }

}
