package fr.espi.gl.quizz.web;

import com.google.inject.Injector;
import fr.espi.gl.quizz.web.configuration.QuizzRouter;
import org.restlet.Application;
import org.restlet.Restlet;

public class QuizzApplication extends Application {


    public QuizzApplication(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Restlet createInboundRoot() {
        return new QuizzRouter(getContext(), injector);
    }

    private Injector injector;
}
