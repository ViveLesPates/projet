package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.commande.BusCommande;
import fr.epsi.gl.quizz.commande.question.CreationQuestionCommande;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import javax.inject.Inject;
import java.util.UUID;

public class QuestionsRessource extends ServerResource{

    @Inject
    public QuestionsRessource(BusCommande busCommande) {
        this.busCommande = busCommande;
    }

    @Post
    public void crée(Form formulaire) {
        CreationQuestionCommande commande = new CreationQuestionCommande(formulaire.getFirstValue("libelle"));
        UUID idQuestion = busCommande.execute(commande);
        setStatus(Status.SUCCESS_ACCEPTED);
        setLocationRef("/questions/" + idQuestion);
    }

    private BusCommande busCommande;
}
