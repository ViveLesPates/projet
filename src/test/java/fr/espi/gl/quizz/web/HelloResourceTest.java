package fr.espi.gl.quizz.web;

import fr.espi.gl.quizz.web.representation.ModeleEtVue;
import fr.espi.gl.quizz.web.resource.HelloResource;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class HelloResourceTest {

    @Test
    public void ditbienHello() {
        ModeleEtVue coucou = new HelloResource().hello();

        assertThat(coucou.getTemplate()).isEqualTo("/accueil");
    }
}
