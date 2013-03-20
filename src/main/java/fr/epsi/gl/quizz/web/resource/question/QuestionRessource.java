package fr.epsi.gl.quizz.web.resource.question;

import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.question.Question;
import fr.epsi.gl.quizz.web.representation.ModeleEtVue;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

import java.util.UUID;

public class QuestionRessource extends ServerResource
{

    @Override
    protected void doInit() throws ResourceException {
        UUID id = UUID.fromString(getRequestAttributes().get("id").toString());
        question = Entrepots.questions().get(id).get();
    }

    @Get
    public ModeleEtVue représente() {
        return ModeleEtVue.crée("/question/question").avec("question", question);
    }

    private Question question;
}
