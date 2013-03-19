package fr.epsi.gl.quizz.commande;


public interface Commande<T> {

    T execute();
}
