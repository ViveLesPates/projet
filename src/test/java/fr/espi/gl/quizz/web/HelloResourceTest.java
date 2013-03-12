package fr.espi.gl.quizz.web;

import fr.espi.gl.quizz.web.resource.HelloResource;
import org.junit.Test;
import org.restlet.representation.StringRepresentation;
import org.thymeleaf.TemplateEngine;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class HelloResourceTest {

    @Test
    public void ditbienHello() {
        StringRepresentation coucou = new HelloResource(mock(TemplateEngine.class)).hello();

        assertThat(coucou.toString()).isEqualTo("hello world!!!");

    }
}
