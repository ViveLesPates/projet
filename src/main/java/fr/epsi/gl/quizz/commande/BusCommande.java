package fr.epsi.gl.quizz.commande;

import javax.inject.Inject;

public class BusCommande {

    @Inject
    public BusCommande(FournisseurMongoSession fournisseurSession ) {
        this.fournisseurSession = fournisseurSession;
    }

    public <T> T execute(Commande<T> commande) {
        try {
            return commande.execute();
        } finally {
            fournisseurSession.nettoie();
        }
    }

    private FournisseurMongoSession fournisseurSession;
}
