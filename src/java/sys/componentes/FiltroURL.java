/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.componentes;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jeffa
 */
public class FiltroURL implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        //Creamos un obejto facesContext y va a permitir tomar el contexto de la aplicacion para tomar sus recursos
        FacesContext facesContext = event.getFacesContext();

        //Captura el nombre de la pagina actual
        String currentPage = facesContext.getViewRoot().getViewId();

        //Creamos una variable booleana para comprobar si es la pagina de login la que se capturo
        boolean isPageLogin = currentPage.lastIndexOf("Login.xhtml") > -1;

        //Obtenemos la sesion
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        //recuperamos un object del String que se guardo, para ello se toma de la session al usuario que se
        //definio en el loginBean
        Object usuario = session.getAttribute("usuario");

        if (!isPageLogin && usuario == null) {
            //si no es la pagina de logueo y el usuario es nulo, lo redirigimos a la página
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/Login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent event
    ) {
        //borrado porque debe ir vacio
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
