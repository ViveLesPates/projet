package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.question.FabriqueQuestion;
import fr.epsi.gl.quizz.domaine.question.Question;
import fr.epsi.gl.quizz.persistance.fake.AvecEntrepots;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import fr.epsi.gl.quizz.web.resource.RessourceHelper;
import org.junit.Rule;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;
import static org.fest.assertions.MapAssert.*;

public class QuestionRessourceTest {

    @Rule
    public AvecEntrepots entrepots = new AvecEntrepots();

    @Test
    public void peutAfficherLaQuestion() {
        Question test = new FabriqueQuestion().nouvelle("test");
        Entrepots.questions().ajoute(test);
        QuestionRessource ressource = new QuestionRessource();
        RessourceHelper.initialise(ressource).avec("id", test.getId());

        ModeleEtVue modeleEtVue = ressource.représente();

        assertThat(modeleEtVue).isNotNull();
        assertThat(modeleEtVue.getTemplate()).isEqualTo("/question/question");
        assertThat(modeleEtVue.getData()).includes(entry("question", test));
    }
}
