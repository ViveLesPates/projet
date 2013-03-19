package fr.epsi.gl.quizz.commande.question;

import fr.epsi.gl.quizz.commande.Commande;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.domaine.question.FabriqueQuestion;
import fr.epsi.gl.quizz.domaine.question.Question;

import java.util.UUID;

public class CreationQuestionCommande implements Commande<UUID>{

    public CreationQuestionCommande(String libellé) {
        this.libellé = libellé;
    }

    @Override
    public UUID execute() {
        Question question = new FabriqueQuestion().nouvelle(libellé);
        Entrepots.questions().ajoute(question);
        return question.getId();
    }

    public final String libellé;
}
