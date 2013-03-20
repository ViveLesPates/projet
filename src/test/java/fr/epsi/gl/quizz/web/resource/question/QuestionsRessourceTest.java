package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.question.CreationQuestionCommande;
import fr.epsi.gl.quizz.web.resource.RessourceHelper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.restlet.data.Form;
import org.restlet.data.Reference;
import org.restlet.data.Status;

import java.util.UUID;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class QuestionsRessourceTest {

    @Before
    public void setUp() throws Exception {
        bus = mock(BusCommande.class);
        ressource = new QuestionsRessource(bus);
        RessourceHelper.initialise(ressource);
    }

    @Test
    public void peutCréerUneQuestion() {
        Form formulaire = new Form();
        formulaire.add("libelle", "Ceci est une question");

        ressource.crée(formulaire);

        ArgumentCaptor<CreationQuestionCommande> capteur = ArgumentCaptor.forClass(CreationQuestionCommande.class);
        verify(bus).execute(capteur.capture());
        CreationQuestionCommande commande = capteur.getValue();
        assertThat(commande.libellé).isEqualTo("Ceci est une question");
    }

    @Test
    public void peutRediriger() {
        UUID idQuestion = UUID.randomUUID();
        when(bus.execute(any(CreationQuestionCommande.class))).thenReturn(idQuestion);

        ressource.crée(new Form());

        assertThat(ressource.getStatus()).isEqualTo(Status.SUCCESS_ACCEPTED);
        assertThat(ressource.getLocationRef()).isEqualTo(new Reference("http://localhost/questions/" + idQuestion));
    }

    private BusCommande bus;
    private QuestionsRessource ressource;
}
