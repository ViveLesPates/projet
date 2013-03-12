package fr.espi.gl.quizz.web.resource;

import org.restlet.data.MediaType;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.inject.Inject;

public class HelloResource extends ServerResource {

    @Inject
    public HelloResource(final TemplateEngine engine) {
        this.engine = engine;
    }

    @Get
    public StringRepresentation hello() {
        return new StringRepresentation(engine.process("/accueil", new Context()), MediaType.TEXT_HTML);
    }

    private TemplateEngine engine;
}
