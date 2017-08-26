package action;

import java.io.Serializable;

import menu.MenuManager;
import objekte.Suchanfrage;

public class SuchanfragenAnzeigenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        for (Suchanfrage search : MenuManager.getSearchList()) {
            System.out.println("Mitarbeiter-ID:  " + search.getMitarbeiterID());
            System.out.println("Kunden-ID:       " + search.getKundenID());
            System.out.println("Zimmeranzahl:    " + search.getRelaZimmeranzahl() + search.getZimmeranzahl());
            System.out.println("Fläche:          " + search.getRelaFläche() + search.getFläche());
            System.out.println("Kosten:          " + search.getRelaKosten() + search.getKosten());
            System.out.println("Etage:           " + search.getRelaEtage() + search.getEtage());
            System.out.println("Balkon:          " + search.getBalkon());
            System.out.println("Fußbodenheizung: " + search.getFußbodenheizung());
            System.out.println("Aussicht:        " + search.getAussicht());
            System.out.println("");
        }

    }

}
