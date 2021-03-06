package action;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hilfsklassen.Bedingung;
import menu.MenuManager;
import objekte.Interessent;
import objekte.Mitarbeiter;
import objekte.Suchanfrage;
import objekte.Wohnung;

public class SuchanfrageWohnungSuchenAction extends MenuManager implements Action, Serializable {

    static boolean fenster = false;
    static boolean window = false;
    static int such_kundenID;
    static int such_mitarbeiterID;

    @Override
    public void action() {

        System.out.println("________________________________________ Suchanfrage: Wohnung suchen ________________________________________\n");

        SuchanfrageWohnungSuchenAction.such_kundenID = -100;
        SuchanfrageWohnungSuchenAction.such_mitarbeiterID = -100;

        boolean suchVorgang = true;

        double such_zimmeranzahl = -100;
        char zimmeranzahl_rela = ' ';

        double such_fl�che = -100;
        char fl�che_rela = ' ';

        double such_kosten = -100;
        char kosten_rela = ' ';

        double such_etage = -100;
        char etage_rela = ' ';

        boolean such_balkon = false;

        boolean such_fu�bodenheizung = false;

        String such_aussicht = "-";

        String[] kategorie = { "Zimmeranzahl", "Fl�che", "Kosten", "Etage", "Balkon", "Fu�bodenheizung", "Aussicht" };

        ArrayList<Bedingung> bedingungList = new ArrayList<>();
        ArrayList<Wohnung> erg = new ArrayList<>();

        char zeichen = '-';

        String auswahl = " ";

        int �nderung = -99;

        �nderung = -98;

        auswahl_InteressentenID_MitarbeiterID(�nderung);

        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... W�hlen Sie die zu suchende Eigenschaft aus! ...............................");
            System.out.println("........... Aktuelle Suche nach: ...........");
            if (SuchanfrageWohnungSuchenAction.such_mitarbeiterID != -100) {
                System.out.println("   Mitarbeiter-ID:  " + SuchanfrageWohnungSuchenAction.such_mitarbeiterID);
            } else {
                System.out.println("   Mitarbeiter-ID:  " + "-");
            }
            if (SuchanfrageWohnungSuchenAction.such_kundenID != -100) {
                System.out.println("   Kunden-ID:       " + SuchanfrageWohnungSuchenAction.such_kundenID);
            } else {
                System.out.println("   Kunden-ID:       " + "-");
            }
            if (such_zimmeranzahl != -100) {
                System.out.println("1. Zimmeranzahl:    " + zimmeranzahl_rela + such_zimmeranzahl);
            } else {
                System.out.println("1. Zimmeranzahl:    " + "-");
            }
            if (such_fl�che != -100) {
                System.out.println("2. Fl�che:          " + fl�che_rela + such_fl�che);
            } else {
                System.out.println("2. Fl�che:          " + "-");
            }
            if (such_kosten != -100) {
                System.out.println("3. Kosten:          " + kosten_rela + such_kosten);
            } else {
                System.out.println("3. Kosten:          " + "-");
            }
            if (such_etage != -100) {
                System.out.println("4. Etage:           " + etage_rela + such_etage);
            } else {
                System.out.println("4. Etage:           " + "-");
            }
            System.out.println("5. Balkon:          " + such_balkon);
            System.out.println("6. Fu�bodenheizung: " + such_fu�bodenheizung);
            System.out.println("7. Aussicht:        " + such_aussicht);
            System.out.println("8. Best�tigen ");
            System.out.println("0. Abbruch ");
            System.out.println("");

            try {
                int eingabe = s.nextInt();

                // Eingabe zum Abbruch der Suche
                if (eingabe == 0) {
                    suchVorgang = false;
                }

                // Eingabe um die Zimmeranzahl der Suchanfrage festzulegen
                if (eingabe == 1) {
                    int rela = 0;

                    auswahl = einlesen_Wort(kategorie, eingabe);
                    if (auswahl.equals("" + 0)) {
                    } else {

                        zeichen = auslesen_Zeichen(auswahl);
                        zimmeranzahl_rela = zeichen;

                        auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

                        such_zimmeranzahl = Integer.parseInt(auswahl);

                        if (zeichen == '<') {
                            rela = 0;
                        }
                        if (zeichen == '=') {
                            rela = 1;
                        }
                        if (zeichen == '>') {
                            rela = 2;
                        }
                        if (zeichen == ' ') {
                            rela = 3;
                        }

                        l�schen(eingabe, bedingungList);
                        bedingungList.add(new Bedingung(eingabe, rela, such_zimmeranzahl));
                    }
                }

                if (eingabe == 2) {

                    int rela = 0;

                    auswahl = einlesen_Wort(kategorie, eingabe);
                    if (auswahl.equals("" + 0)) {
                    } else {

                        zeichen = auslesen_Zeichen(auswahl);
                        fl�che_rela = zeichen;

                        auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

                        such_fl�che = Integer.parseInt(auswahl);

                        if (zeichen == '<') {
                            rela = 0;
                        }
                        if (zeichen == '=') {
                            rela = 1;
                        }
                        if (zeichen == '>') {
                            rela = 2;
                        }
                        if (zeichen == ' ') {
                            rela = 3;
                        }

                        l�schen(eingabe, bedingungList);
                        bedingungList.add(new Bedingung(eingabe, rela, such_fl�che));
                    }
                }

                if (eingabe == 3) {

                    int rela = 0;

                    auswahl = einlesen_Wort(kategorie, eingabe);
                    if (auswahl.equals("" + 0)) {
                    } else {

                        zeichen = auslesen_Zeichen(auswahl);
                        kosten_rela = zeichen;

                        auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

                        such_kosten = Integer.parseInt(auswahl);

                        if (zeichen == '<') {
                            rela = 0;
                        }
                        if (zeichen == '=') {
                            rela = 1;
                        }
                        if (zeichen == '>') {
                            rela = 2;
                        }
                        if (zeichen == ' ') {
                            rela = 3;
                        }

                        l�schen(eingabe, bedingungList);
                        bedingungList.add(new Bedingung(eingabe, rela, such_kosten));
                    }
                }

                if (eingabe == 4) {

                    int rela = 0;

                    auswahl = einlesen_Wort(kategorie, eingabe);
                    if (auswahl.equals("" + 0)) {
                    } else {

                        zeichen = auslesen_Zeichen(auswahl);
                        etage_rela = zeichen;

                        auswahl = auswahl.substring(auswahl.indexOf('=') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('<') + 1, auswahl.length());
                        auswahl = auswahl.substring(auswahl.indexOf('>') + 1, auswahl.length());

                        such_etage = Integer.parseInt(auswahl);

                        if (zeichen == '<') {
                            rela = 0;
                        }
                        if (zeichen == '=') {
                            rela = 1;
                        }
                        if (zeichen == '>') {
                            rela = 2;
                        }
                        if (zeichen == ' ') {
                            rela = 3;
                        }

                        l�schen(eingabe, bedingungList);
                        bedingungList.add(new Bedingung(eingabe, rela, such_etage));
                    }
                }

                if (eingabe == 5) {

                    int rela = 1;
                    int wahl = 0;
                    Scanner q = new Scanner(System.in);
                    System.out.println("W�heln Sie, ob ein Balkon vorhanden sein soll: '1' nein, '2' ja");

                    try {
                        String ausWahl = q.next();
                        if (ausWahl.equals("" + 0)) {
                        } else {

                            wahl = Integer.parseInt(ausWahl);

                            if (wahl == 1) {
                                such_balkon = false;
                            }
                            if (wahl == 2) {
                                such_balkon = true;
                            }

                            l�schen(eingabe, bedingungList);
                            bedingungList.add(new Bedingung(eingabe, rela, wahl));

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }

                if (eingabe == 6) {

                    int rela = 1;
                    int wahl = 0;
                    Scanner q = new Scanner(System.in);
                    System.out.println("W�heln Sie, ob eine Fu�bodenheizung vorhanden sein soll: '1' nein, '2' ja");

                    try {
                        String ausWahl = q.next();
                        if (ausWahl.equals("" + 0)) {
                        } else {

                            wahl = Integer.parseInt(ausWahl);

                            if (wahl == 1) {
                                such_fu�bodenheizung = false;
                            }
                            if (wahl == 2) {
                                such_fu�bodenheizung = true;
                            }

                            l�schen(eingabe, bedingungList);
                            bedingungList.add(new Bedingung(eingabe, rela, wahl));

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }

                if (eingabe == 7) {

                    int rela = 1;
                    int wahl = 0;
                    Scanner q = new Scanner(System.in);
                    System.out.println("W�heln Sie ihre Wunschaussicht: '1' Park, '2' Spree, '3' Schienen, '4' Stra�e");

                    try {
                        String ausWahl = q.next();
                        if (ausWahl.equals("" + 0)) {
                        } else {

                            wahl = Integer.parseInt(ausWahl);

                            if (wahl == 1) {
                                such_aussicht = "Park";
                            }
                            if (wahl == 2) {
                                such_aussicht = "Spree";
                            }
                            if (wahl == 3) {
                                such_aussicht = "Schienen";
                            }
                            if (wahl == 4) {
                                such_aussicht = "Stra�e";
                            }

                            l�schen(eingabe, bedingungList);
                            bedingungList.add(new Bedingung(eingabe, rela, wahl));

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                    }
                }

                if (eingabe == 8) {
                    suchVorgang = false;

                    erg = xxx(MenuManager.getFlatList(), bedingungList);

                    MenuManager.add(new Suchanfrage(SuchanfrageWohnungSuchenAction.such_mitarbeiterID, SuchanfrageWohnungSuchenAction.such_kundenID, zimmeranzahl_rela, such_zimmeranzahl, fl�che_rela, such_fl�che, kosten_rela, such_kosten, etage_rela, such_etage, such_balkon, such_fu�bodenheizung, such_aussicht));

                    for (Wohnung flat : erg) {

                        if (flat.getWohnungsID() != -100) {
                            System.out.println("Wohnungsnummer: " + flat.getWohnungsID());
                        } else {
                            System.out.println("Wohnungsnummer: " + "-");
                        }
                        if (flat.getZimmeranzahl() != -100) {
                            System.out.println("Zimmeranzahl: " + flat.getZimmeranzahl());
                        } else {
                            System.out.println("Zimmeranzahl: " + "-");
                        }
                        if (flat.getFl�che() != -100) {
                            System.out.println("Fl�che: " + flat.getFl�che());
                        } else {
                            System.out.println("Fl�che: " + "-");
                        }
                        if (flat.getKosten() != -100) {
                            System.out.println("Kosten: " + flat.getKosten());
                        } else {
                            System.out.println("Kosten: " + "-");
                        }
                        if (flat.getEtage() != -100) {
                            System.out.println("Etage: " + flat.getEtage());
                        } else {
                            System.out.println("Etage: " + "-");
                        }
                        System.out.println("Balkon: " + flat.getBalkon());
                        System.out.println("Fu�bodenheizung: " + flat.getFu�bodenheizung());
                        System.out.println("Aussicht: " + flat.getAussicht());
                        if (flat.getAdresse() != null) {
                            System.out.println("Adresse: " + flat.getAdresse());
                        } else {
                            System.out.println("Adresse: " + "-");
                        }
                        System.out.println("Status: " + flat.getStatus());
                        if (flat.getLetztesRenovierungsdatum() != null) {
                            System.out.println("letztes Renovierungsdatum: " + flat.getLetztesRenovierungsdatum());
                        } else {
                            System.out.println("letztes Renovierungsdatum: " + "--.--.----");
                        }
                        if (flat.getRenovierungsanzahl() != -100) {
                            System.out.println("Renovierungsanzahl: " + flat.getRenovierungsanzahl());
                        } else {
                            System.out.println("Renovierungsanzahl: " + "-");
                        }
                        System.out.println("letze Renovierungdetails: " + flat.getLetzeRenovierung_Details());
                        System.out.println("Handwerkerauftrag-ID: " + flat.getHandwerkerauftrag().getAuftragsID());
                        if (flat.getZugeordneterMitarbeiter() != null) {
                            System.out.println("zugeordneter Mitarbeiter: " + flat.getZugeordneterMitarbeiter().getName());
                        } else {
                            System.out.println("zugeordneter Mitarbeiter: " + "-");
                        }
                        System.out.println("");
                    }
                }
                if (eingabe > 8) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
                }
            }

            catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }

    }

    /**
     * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag jedes einzelnen Elements in einer ArrayList
     *
     * @param �nderung
     *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt (ob eine Wohnung, etc. bearbeitet wird)
     */
    private void auswahl_InteressentenID_MitarbeiterID(final int �nderung) {
        SuchanfrageWohnungSuchenAction.window = false;
        SuchanfrageWohnungSuchenAction.such_mitarbeiterID = 0;

        JFrame meinRahmen = new JFrame();
        meinRahmen.setSize(250, 250);

        JPanel meinPanel = new JPanel();
        meinRahmen.setLocationRelativeTo(null);

        JComboBox combo2 = new JComboBox();

        if (�nderung == -99) {
            meinRahmen.setTitle("Interessenten ID");
            JLabel frage = new JLabel("F�r welchen Interessenten wird ein Suchauftrag ausgef�hrt?");
            meinPanel.add(frage);
            for (Interessent interest : MenuManager.getInterestList()) {
                combo2.addItem(interest.getKundenID());
            }
        }

        if (�nderung == -98) {
            meinRahmen.setTitle("Mitarbeiter ID");
            JLabel frage = new JLabel("Von welchem Mitarbeiter wird ein Suchauftrag ausgef�hrt?");
            meinPanel.add(frage);
            for (Mitarbeiter worker : MenuManager.getWorkerList()) {
                combo2.addItem(worker.getMitarbeiterID());
            }
        }

        meinRahmen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                SuchanfrageWohnungSuchenAction.window = true;
            }
        });

        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (�nderung == -99) {
                    SuchanfrageWohnungSuchenAction.such_kundenID = (int) combo2.getSelectedItem();
                }
                if (�nderung == -98) {
                    SuchanfrageWohnungSuchenAction.such_mitarbeiterID = (int) combo2.getSelectedItem();
                }
            }

        };
        meinPanel.add(combo2);
        meinRahmen.add(meinPanel, BorderLayout.SOUTH);
        meinRahmen.pack();
        meinRahmen.setVisible(true);
        while (SuchanfrageWohnungSuchenAction.window == false) {
            combo2.addActionListener(cbActionListener);

        }
    }

    private void l�schen(final int aktuellesKriterium, final ArrayList<Bedingung> listeVonBedingungen) {
        Iterator<Bedingung> iter = listeVonBedingungen.iterator();

        while (iter.hasNext()) {
            Bedingung str = iter.next();

            if (str.getKrit() == aktuellesKriterium) {
                iter.remove();
            }
        }

    }

    private ArrayList<Wohnung> xxx(final ArrayList<Wohnung> alleWohnungen, final ArrayList<Bedingung> anfrage) {
        /**
         * kriterium .. zimmeranzahl, miete, etage, etc Relation .. <, <=, =, >=, >, (ohne zeichen bedeutet '=') 0 1 2 3 4 5 wert .. irgendeine zahl bedingung: (krit, rela, wunschwert) anfrage:
         * ((krit1, rela1, wunschwert1), (krit2, rela2, wunschwert2), ...) ListOfWohnung
         **/

        ArrayList<Wohnung> erg = alleWohnungen;
        for (Bedingung b : anfrage) {

            erg = filter(erg, b);
        }

        return erg;
    }

    private ArrayList<Wohnung> filter(final ArrayList<Wohnung> wohnungen, final Bedingung b) {
        ArrayList<Wohnung> erg = new ArrayList<>();

        for (Wohnung flat : wohnungen) {
            double aktWert = 0;
            boolean bedingungErf�llt = false;

            switch (b.getKrit()) {
                case 1 /* Zimmeranzahl */:
                    aktWert = flat.getZimmeranzahl();
                    break;
                case 2 /* Fl�che */:
                    aktWert = flat.getFl�che();
                    break;
                case 3 /* Kosten */:
                    aktWert = flat.getKosten();
                    break;
                case 4 /* Etage */:
                    aktWert = flat.getEtage();
                    break;
                case 5 /* Balkon */:
                    if (flat.getBalkon() == false) {
                        aktWert = 1;
                    } else {
                        aktWert = 2;
                    }
                    break;
                case 6 /* Fu�bodenheizung */:
                    if (flat.getFu�bodenheizung() == false) {
                        aktWert = 1;
                    } else {
                        aktWert = 2;
                    }
                    break;
                case 7 /* Aussicht */:
                    if (flat.getAussicht().equals("Park")) {
                        aktWert = 1;
                    }
                    if (flat.getAussicht().equals("Spree")) {
                        aktWert = 2;
                    }
                    if (flat.getAussicht().equals("Schienen")) {
                        aktWert = 3;
                    }
                    if (flat.getAussicht().equals("Stra�e")) {
                        aktWert = 4;
                    }
                    break;
                default:
                    throw new RuntimeException("unbekanntes Kriterium abgefragt, Krit=" + b.getKrit());
            }

            switch (b.getRela()) {
                case 1 /* '=' */:
                case 3 /* ohne relation entspr '=' */:
                    bedingungErf�llt = aktWert == b.getWunschwert();
                    break;
                case 0 /* '<' */:
                    bedingungErf�llt = aktWert < b.getWunschwert();
                    break;
                case 2 /* '>' */:
                    bedingungErf�llt = aktWert > b.getWunschwert();
                    break;
                default:
                    throw new RuntimeException("unbekannte Relation eingegeben, Rela=" + b.getRela());
            }

            if (bedingungErf�llt) {
                erg.add(flat);
            }

        }

        return erg;
    }

    private String einlesen_Wort(final String[] auswahl, final int z�hler) {

        Scanner s = new Scanner(System.in);

        boolean korrekteEingabe = false;
        String suchWert = "";

        while (korrekteEingabe == false) {
            System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);

            suchWert = s.next();
            char t = suchWert.charAt(0);

            try {

                if (suchWert.equals("" + 0)) {
                    korrekteEingabe = true;
                    break;
                }

                if (Integer.valueOf(suchWert) instanceof Integer) {
                    System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
                }
            } catch (NumberFormatException e) {
                if (suchWert.length() < 2) {
                    System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
                } else {
                    int fehlerErkennung = 0;

                    for (int i = 1; i < suchWert.length(); i++) {
                        char u = suchWert.charAt(i);
                        int uToInt = Character.getNumericValue(u);

                        if (t == '<' || t == '>' || t == '=') {
                            if (uToInt == -1 || uToInt >= 9) {
                                fehlerErkennung = 1;

                            }
                        } else {
                            fehlerErkennung = 1;
                        }
                    }
                    if (fehlerErkennung == 1) {
                        System.out.println("Typ wurde falsch eingegeben! Geben Sie ein: '<' '>' '=' und eine Zahl! ");
                    } else {
                        korrekteEingabe = true;
                    }
                }
            }
        }

        return suchWert;

    }

    private char auslesen_Zeichen(final String zeichen) {

        char t = zeichen.charAt(0);
        return t;
    }
}
