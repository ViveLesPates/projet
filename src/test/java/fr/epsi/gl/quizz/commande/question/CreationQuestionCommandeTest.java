package fr.epsi.gl.quizz.commande.question;

import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.persistance.fake.AvecEntrepots;
import org.junit.Rule;
import org.junit.Test;

import java.util.UUID;

import static org.fest.assertions.Assertions.*;

public class CreationQuestionCommandeTest {

    @Rule
    public AvecEntrepots entrepots = new AvecEntrepots();

    @Test
    public void peutCréerQuestion() {
        CreationQuestionCommande commande = new CreationQuestionCommande("Ceci est une question");

        UUID idQuestion = commande.execute();

        assertThat(idQuestion).isNotNull();
        assertThat(Entrepots.questions().get(idQuestion)).isNotNull();
        assertThat(Entrepots.questions().get(idQuestion).get().getLibellé()).isEqualTo("Ceci est une question");
    }
}
