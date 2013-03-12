package fr.espi.gl.quizz.web.configuration;

import com.google.inject.Injector;
import fr.espi.gl.quizz.web.resource.HelloResource;
import fr.espi.gl.quizz.web.restlet.GuiceFinder;
import org.restlet.Context;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;
import org.restlet.routing.Router;

public class QuizzRouter extends Router {

    public QuizzRouter(Context context, Injector injector) {
        super(context);
        this.injector = injector;
        attacheRoutes();
    }

    private void attacheRoutes() {
        attach("/hello", HelloResource.class);
    }

    @Override
    public Finder createFinder(Class<? extends ServerResource> resourceClass) {
        return new GuiceFinder(getContext(), resourceClass, injector);
    }

    private Injector injector;
}
