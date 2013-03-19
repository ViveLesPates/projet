package fr.epsi.gl.quizz.commande;

import org.mongolink.MongoSession;

import javax.inject.Inject;

public class BusCommande {

    @Inject
    public BusCommande(FournisseurMongoSession fournisseurSession ) {
        this.fournisseurSession = fournisseurSession;
    }

    public <T> T execute(Commande<T> commande) {
       MongoSession session = fournisseurSession.get();
        session.start();
        try {
            return commande.execute();
        } finally {
            session.stop();
        }
    }

    private FournisseurMongoSession fournisseurSession;
}
