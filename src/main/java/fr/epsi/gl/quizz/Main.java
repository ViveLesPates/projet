package fr.epsi.gl.quizz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import fr.epsi.gl.quizz.domaine.Entrepots;
import fr.epsi.gl.quizz.web.QuizzApplication;
import fr.epsi.gl.quizz.web.configuration.GuiceProductionModule;
import org.restlet.Component;
import org.restlet.Context;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args)  {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8080);
        Injector injector = Guice.createInjector(Stage.PRODUCTION, new GuiceProductionModule());
        Entrepots.setInstance(injector.getInstance(Entrepots.class));
        component.getDefaultHost().attach(new QuizzApplication(new Context(), injector));
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
