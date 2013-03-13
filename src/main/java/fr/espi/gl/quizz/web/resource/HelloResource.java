package fr.espi.gl.quizz.web.resource;

import fr.espi.gl.quizz.web.representation.ModeleEtVue;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloResource extends ServerResource {

    @Get
    public ModeleEtVue hello() {
        return ModeleEtVue.crée("/accueil");
    }


}
