package fr.epsi.gl.quizz;

import fr.epsi.gl.quizz.web.configuration.FabriqueApplication;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class Main {

    public static void main(String[] args)  {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8080);
        component.getDefaultHost().attach(new FabriqueApplication().configure());
        try {
            component.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
