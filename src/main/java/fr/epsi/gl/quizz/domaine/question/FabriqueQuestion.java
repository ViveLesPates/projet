package fr.epsi.gl.quizz.domaine.question;

import java.util.UUID;

public class FabriqueQuestion {

    public Question nouvelle(String libellé) {
        Question question = new Question(UUID.randomUUID());
        question.setLibellé(libellé);
        return question;
    }
}
