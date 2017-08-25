package action;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import menu.MenuManager;
import objekte.Mitarbeiter;
import objekte.Wohnung;

public class neueWohnungAction extends MenuManager implements Action {

    @Override
    public void action() {

        boolean erstellVorgang = true;

        int ID = -100;
        int eingabe_ID = -100;

        int zimmeranzahl = -100;
        int eingabe_zimmeranzahl = -100;

        double fläche = -100;
        double eingabe_fläche = -100;

        double kosten = -100;
        double eingabe_kosten = -100;

        int etage = -100;
        int eingabe_etage = -100;

        boolean balkon = false;
        boolean eingabe_balkon = false;

        boolean fußbodenheizung = false;
        boolean eingabe_fußbodenheizung = false;

        String aussicht = "-";
        String eingabe_aussicht = "-";

        // String adresse = "";
        String status = "-";
        String eingabe_status = "-";

        String letztesRenovierungsdatum = "-";
        String eingabe_letzesRenovierungsdatum = "-";

        int renovierungsanzahl = -100;
        int eingabe_renovierungsanzahl = -100;

        String letzeRenovierung_Details = "-";
        String eingabe_letzteRenovierung_Details = "-";

        String zugeordneterMitarbeiter = "-";
        String eingabe_zugeordneterMitarbeiter = "-";

        while (erstellVorgang == true) {

            String[] buttons = { "ID", "ZA", "Fl", "KT", "EG", "BK", "FBH", "AS", "ST", "LRDT", "RA", "LRI", "ZM", "erstellen", "abbruch" };

            int ok = JOptionPane.showOptionDialog(null, "Wählen Sie ein zu bearbeitenden Wert! " + "\n\nID:                " + ID + "\n\nZA:               " + zimmeranzahl + "\n\nFL:                " + fläche + "\n\nKT:                " + kosten + "\n\nEG:                " + etage + "\n\nBK:                " + balkon + "\n\nFBH:              " + fußbodenheizung + "\n\nAS:                 "
                    + aussicht + "\n\nST:                 " + status + "\n\nLRDT:            " + letztesRenovierungsdatum + "\n\nRA:                " + renovierungsanzahl + "\n\nLRI:                " + letzeRenovierung_Details + "\n\nZM:                " + zugeordneterMitarbeiter, "Wohnungserstellung", JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons);

            if (ok == 0) {
                ID = int_eingabe(eingabe_ID, buttons, ok);
                for (Wohnung flat : MenuManager.flatList) {
                    if (flat.getWohnungsID() == ID) {

                        String[] knopf = { "Ok" };

                        JOptionPane.showOptionDialog(null, "Die Wohnung mit der Nummer: " + "'" + ID + "'" + " existiert bereits!", "Wohnungserstellung", JOptionPane.WARNING_MESSAGE, 0, null, knopf, knopf);
                        ID = -100;
                    }
                }
            }
            if (ok == 1) {
                zimmeranzahl = int_eingabe(eingabe_zimmeranzahl, buttons, ok);
            }
            if (ok == 2) {
                fläche = double_eingabe(eingabe_fläche);
            }
            if (ok == 3) {
                kosten = double_eingabe(eingabe_kosten);
            }
            if (ok == 4) {
                etage = int_eingabe(eingabe_etage, buttons, ok);
            }
            if (ok == 5) {
                balkon = boolean_eingabe(eingabe_balkon);
            }
            if (ok == 6) {
                fußbodenheizung = boolean_eingabe(eingabe_fußbodenheizung);
            }
            if (ok == 7) {
                aussicht = String_eingabe(eingabe_aussicht);
            }
            if (ok == 8) {
                status = String_eingabe(eingabe_status);
            }
            if (ok == 9) {
                letztesRenovierungsdatum = String_eingabe(eingabe_letzesRenovierungsdatum);
            }
            if (ok == 10) {
                renovierungsanzahl = int_eingabe(eingabe_renovierungsanzahl, buttons, ok);
            }
            if (ok == 11) {
                letzeRenovierung_Details = String_eingabe(eingabe_letzteRenovierung_Details);
            }
            if (ok == 12) {
                zugeordneterMitarbeiter = String_eingabe(eingabe_zugeordneterMitarbeiter);
            }
            if (ok == 13) {
                erstellVorgang = false;
                MenuManager.flatList.add(new Wohnung(ID, zimmeranzahl, fläche, kosten, etage, balkon, fußbodenheizung, aussicht, status, letztesRenovierungsdatum, "", renovierungsanzahl, letzeRenovierung_Details, new Mitarbeiter(zugeordneterMitarbeiter)));
            }
            if (ok == 14) {
                erstellVorgang = false;
            }
        }
    }

    public int int_eingabe(int bearbeitungsknopf, final String[] buttons, final int ok) {
        JOptionPane jop = new JOptionPane();
        jop.setWantsInput(true);
        jop.setMessage("Eingabe vom Feld: " + buttons[ok]);
        // in der Klammer den Namen des Fensters eingeben
        JDialog dialog = jop.createDialog("Wohnungserstellung");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
        bearbeitungsknopf = Integer.parseInt(eingabe);
        return bearbeitungsknopf;
    }

    public String String_eingabe(String bearbeitungsknopf) {
        JOptionPane jop = new JOptionPane();
        jop.setWantsInput(true);
        jop.setMessage("Eingabe vom Feld: " + bearbeitungsknopf);
        // in der Klammer den Namen des Fensters eingeben
        JDialog dialog = jop.createDialog("Wohnungserstellung");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
        bearbeitungsknopf = eingabe;
        return bearbeitungsknopf;
    }

    public boolean boolean_eingabe(boolean bearbeitungsknopf) {
        JOptionPane jop = new JOptionPane();
        jop.setWantsInput(true);
        jop.setMessage("Eingabe vom Feld: " + bearbeitungsknopf);
        // in der Klammer den Namen des Fensters eingeben
        JDialog dialog = jop.createDialog("Wohnungserstellung");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();
        if (eingabe.equals("vorhanden")) {
            bearbeitungsknopf = true;
        }
        if (eingabe.equals("nicht vorhanden")) {
            bearbeitungsknopf = false;
        }
        return bearbeitungsknopf;
    }

    public double double_eingabe(double bearbeitungsknopf) {

        JOptionPane jop = new JOptionPane();
        jop.setWantsInput(true);
        jop.setMessage("Eingabe vom Feld: " + bearbeitungsknopf);
        // in der Klammer den Namen des Fensters eingeben
        JDialog dialog = jop.createDialog("Wohnungserstellung");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);

        String eingabe = jop.getInputValue() == JOptionPane.UNINITIALIZED_VALUE ? null : (String) jop.getInputValue();

        bearbeitungsknopf = Double.parseDouble(eingabe);
        return bearbeitungsknopf;
    }
}
