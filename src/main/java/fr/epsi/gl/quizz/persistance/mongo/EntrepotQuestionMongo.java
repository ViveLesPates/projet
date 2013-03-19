package fr.epsi.gl.quizz.persistance.mongo;

import com.google.common.base.Optional;
import fr.epsi.gl.quizz.domaine.question.EntrepotQuestions;
import fr.epsi.gl.quizz.domaine.question.Question;
import org.mongolink.MongoSession;

public class EntrepotQuestionMongo implements EntrepotQuestions {
    public EntrepotQuestionMongo(MongoSession session) {
        this.session = session;
    }

    @Override
    public Optional<Question> get(Object id) {
        return Optional.fromNullable(session.get(id, Question.class));
    }

    @Override
    public Question ajoute(Question aggregat) {
        session.save(aggregat);
        return aggregat;
    }

    @Override
    public void supprime(Question aggregat) {
        session.delete(aggregat);
    }

    private MongoSession session;
}
