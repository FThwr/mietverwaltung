package action;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import menu.MenuManager;
import objekte.Interessent;

public class InteressentSuchenAction extends MenuManager implements Action, Serializable {

    @Override
    public void action() {

        System.out.println("________________________________________ Interessent suchen ________________________________________\n");

        boolean suchVorgang = true;

        // Variablen zum R�cksetzen, falls 0 eingegeben wurde
        int interessentenID = -100;
        String name = "-";
        String vorname = "-";
        String EMail = "-";
        String stra�e = "-";
        int plz = -100;
        String telefon = "-";

        // Variablen zur Speicherung des Suchwertes
        int such_interessentenID = interessentenID;
        String such_name = name;
        String such_vorname = vorname;
        String such_EMail = EMail;
        String such_adresse_stra�e = "-";
        int such_adresse_plz = -100;
        String such_telefon = telefon;

        String[] kategorie = { "Interessenten ID", "Name", "Vorname", "E-Mail", "Adresse", "Telefonnummer" };

        /*
         * Mit der Variable wird �berpr�ft, welche Attribut-Abfragen der Nutzer
         * benutzt hatte. Es wird immer ein Buchstabe gespeichert, wodruch die
         * Variable wei�, dass er in der Abfrage was ausgew�hlt hatte. Sp�ter
         * wird anhand dieses Kriteriums die Suche erm�glicht.
         */

        String check = "";
        String[] savecheck = new String[7];

        /*
         * Solange der Suchvorgang nicht beendet ist, wird immer eine �bersicht
         * �ber die zu suchenden Werte ausgegeben, sofern das Attribut
         * ausgew�hlt wurde. Wenn das Attribut nicht ausgew�hlt wurde, wird ein
         * '-' angezeigt. Es wird pro Durchlauf immer 1 Attribut ausgew�hlt,
         * welches man draufhin ver�ndern kann.
         */
        while (suchVorgang == true) {

            Scanner s = new Scanner(System.in);
            System.out.println("............................... W�hlen Sie die zu suchende Eigenschaft aus! ...............................");

            System.out.println("........... Aktuelle Suche nach: ...........");
            if (such_interessentenID != -100) {
                System.out.println("1. Interessenten ID:          " + such_interessentenID);
            } else {
                System.out.println("1. Interessenten ID:          " + "-");
            }
            System.out.println("2. Name:                      " + such_name);
            System.out.println("3. Vorname:                   " + such_vorname);
            System.out.println("4. E-Mail:                    " + such_EMail);
            System.out.println("5. Adresse:                   ");
            System.out.println("   Stra�e:                    " + such_adresse_stra�e);
            if (plz != -100) {
                System.out.print("   Adresse Platz:             " + such_adresse_plz);
            } else {
                System.out.println("   Adresse Platz:             " + "-");
            }
            System.out.println("6. Telefonnummer:             " + such_telefon);
            System.out.println("7. Suche best�tigen");
            System.out.println("999. um die zu suchende Eigenschaft zur�ckzusetzen");
            System.out.println("0. Abbruch ");
            System.out.println("");

            /*
             * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
             * Zeichen, wo Zahlen erwartet werden.
             */
            try {

                /*
                 * Variable zur Auswahl des zu bearbeitenden Attributs.
                 */
                int eingabe = s.nextInt();

                // Abbruch
                if (eingabe == 0) {
                    System.out.println("-------------------------------Suchvorgang wurde abgebrochen!-------------------------------\n");
                    suchVorgang = false;
                }

                // Interessenten-ID
                if (eingabe == 1) {

                    int einlese = einlesen_Zahl(kategorie, eingabe);
                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese == 999) {
                        savecheck[eingabe - 1] = "";
                        such_interessentenID = interessentenID;

                    }
                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese == 0) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird �bernommen
                        such_interessentenID = einlese;
                        savecheck[eingabe - 1] = "a";
                    }
                }

                // Name
                if (eingabe == 2) {
                    such_name = name;

                    String einlese = einlesen_Wort(kategorie, eingabe);

                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                    }
                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }
                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird �bernommen
                        such_name = einlese;
                        savecheck[eingabe - 1] = "b";
                    }
                }

                // Vorname
                if (eingabe == 3) {

                    String einlese = einlesen_Wort(kategorie, eingabe);
                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_vorname = vorname;

                    }
                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }
                    // Eingabe weder 0 noch 999
                    else {

                        // Die Eingabe wird �bernommen
                        such_vorname = einlese;
                        savecheck[eingabe - 1] = "c";
                    }
                }

                // E-Mail
                if (eingabe == 4) {

                    String einlese = einlesen_Wort(kategorie, eingabe);

                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe - 1] = "";
                        such_EMail = EMail;

                    }
                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird �bernommen
                        such_EMail = einlese;
                        savecheck[eingabe - 1] = "d";
                    }
                }

                // Adresse
                if (eingabe == 5) {
                    System.out.println("Spezialisierung der zu suchenden Adresse: ");
                    System.out.println("Dr�cke '1'  f�r Stra�e: " + such_adresse_stra�e);
                    System.out.println("Dr�cke '2'  f�r Platz: " + such_adresse_plz);
                    System.out.println("Dr�cke '3'  zum best�tigen");
                    System.out.println("Dr�cke '0'  f�r Abbruch: ");

                    String buchstabe_einf�gen_stra�e = "";
                    String buchstabe_einf�gen_plz = "";

                    String[] auswahl = { "Stra�e", "Platz" };
                    boolean adresseingabe = true;

                    while (adresseingabe == true) {

                        Scanner q = new Scanner(System.in);
                        int z�hler = q.nextInt();

                        if (z�hler == 1) {

                            String einlese = einlesen_Wort(auswahl, z�hler);

                            /*
                            * 999 = r�ckg�ngig machen des Attributes + l�schen des
                            * Buchstabens
                            */
                            if (einlese.equals("" + 999)) {
                                savecheck[eingabe - 1] = "";
                                such_adresse_stra�e = stra�e;
                            }
                            // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                            else if (einlese.equals("" + 0)) {
                            }
                            // Eingabe weder 0 noch 999
                            else {

                                // Die Eingabe wird �bernommen
                                such_adresse_stra�e = einlese;
                                buchstabe_einf�gen_stra�e = buchstabe_einf�gen_stra�e + "y";

                            }
                        }
                        if (z�hler == 2) {

                            /*
                            * 999 = r�ckg�ngig machen des Attributes + l�schen des
                            * Buchstabens
                            */
                            int einlese = einlesen_Zahl(auswahl, z�hler);
                            if (einlese == 999) {
                                savecheck[eingabe] = "";

                                such_adresse_plz = plz;
                            }
                            // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                            else if (einlese == 0) {
                            }
                            // Eingabe weder 0 noch 999
                            else {
                                // Die Eingabe wird �bernommen
                                such_adresse_plz = einlese;
                                buchstabe_einf�gen_plz = buchstabe_einf�gen_plz + "z";
                            }
                        }
                        if (z�hler == 3) {
                            check = check + savecheck;
                            savecheck[eingabe - 1] = buchstabe_einf�gen_stra�e;
                            savecheck[eingabe] = buchstabe_einf�gen_plz;
                        }
                        if (z�hler == 0) {
                            adresseingabe = false;
                        }
                        if (z�hler > 3) {
                            System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!");
                        }
                    }
                }

                // Telefonnummer
                if (eingabe == 6) {
                    String einlese = einlesen_Wort(kategorie, eingabe);
                    /*
                    * 999 = r�ckg�ngig machen des Attributes + l�schen des
                    * Buchstabens
                    */
                    if (einlese.equals("" + 999)) {
                        savecheck[eingabe] = "";
                        such_telefon = telefon;
                    }

                    // 0 = keine Ver�nderung, nur Abbruch der Abfrage
                    else if (einlese.equals("" + 0)) {
                    }
                    // Eingabe weder 0 noch 999
                    else {
                        // Die Eingabe wird �bernommen
                        such_telefon = einlese;
                        savecheck[eingabe] = "e";
                    }
                }

                // Suche abschlie�en
                if (eingabe == 7) {
                    suchVorgang = false;

                    // Vergleichsvariablen zu den Suchvariablen
                    int vgl_interessentenID = -100;
                    String vgl_name = "-";
                    String vgl_vorname = "-";

                    String vgl_adresse_stra�e = "-";
                    int vgl_adresse_plz = -100;

                    String vgl_EMail = "-";
                    String vgl_telefon = "-";

                    for (int i = 0; i < savecheck.length; i++) {
                        if (savecheck[i] != null) {
                            check = check + savecheck[i];
                        }
                    }

                    /*
                     * Wenn 'check' ein Buchstaben enth�lt war der Nutzer bei
                     * einer bestimmten Attributver�nderung. Wenn ein Buchstabe
                     * nicht enthalten ist, so ist der Suchwert und der
                     * Vergleichswert gleich. Wenn nun ein Buchstabe enthalten
                     * ist wird in jedem Interessentenobjekt nach der zu
                     * suchenden Eigenschaft gesucht und wenn diese gefunden
                     * wurde, wird das dazugeh�rige Objekt ausgegeben. Bei
                     * mehreren Buchstaben m�ssen alle eingegebene Suchattribute
                     * in einem Interessentenobjekt vorhanden sein, damit eine
                     * Ausgabe erm�glicht werden kann.
                     */
                    for (Interessent interest : MenuManager.getInterestList()) {

                        if (check.contains("a")) {
                            vgl_interessentenID = interest.getKundenID();
                        }
                        if (check.contains("b")) {
                            vgl_name = interest.getName();
                        }
                        if (check.contains("c")) {
                            vgl_vorname = interest.getVorname();
                        }
                        if (check.contains("d")) {
                            vgl_EMail = interest.getEmail();
                        }
                        if (check.contains("y")) {
                            vgl_adresse_stra�e = interest.getAdresse().getStrasse();
                        }
                        if (check.contains("z")) {
                            vgl_adresse_plz = interest.getAdresse().getPlz();
                        }
                        if (check.contains("e")) {
                            vgl_telefon = interest.getTelefonnummer();
                        }

                        /*
                         * Wenn alle Suchwerte mit den Vergleichswerten
                         * �bereinstimmen wird der Interessent ausgegeben.
                         */
                        if (vgl_interessentenID == such_interessentenID && vgl_name.contains(such_name) && vgl_vorname.contains(such_vorname) && vgl_EMail.contains(such_EMail) && vgl_adresse_stra�e.contains(such_adresse_stra�e) && vgl_adresse_plz == such_adresse_plz && vgl_telefon.contains(such_telefon)) {
                            System.out.println("Interessenten ID:          " + interest.getKundenID());
                            System.out.println("Name:                      " + interest.getName());
                            System.out.println("Vorname:                   " + interest.getVorname());
                            if (interest.getGeburtsdatum() != null) {
                                System.out.println("Geburtsdatum:              " + interest.getGeburtsdatum());
                            } else {
                                System.out.println("Geburtsdatum:              " + "-");
                            }
                            System.out.println("E-Mail:                    " + interest.getEmail());
                            System.out.println("Adresse:                   " + interest.getAdresse());
                            System.out.println("Telefonnummer:             " + interest.getTelefonnummer());
                            System.out.println("");
                        }
                    }
                }
                // Eingabe > 7
                if (eingabe > 7) {
                    System.out.println("\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit existiert nicht!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
            }
        }

    }

    /**
     * Methode zum Einlesen einer Zahl vom Nutzer
     *
     * @param auswahl
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param z�hler
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return die eingelesene Zahl
     */

    private int einlesen_Zahl(final String[] auswahl, final int z�hler) {
        Scanner s = new Scanner(System.in);
        int zahl = -100;
        while (zahl == -100) {
            try {

                do {
                    System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
                    zahl = s.nextInt();
                    if (zahl < 0) {
                        System.out.println("\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
                    }
                } while (zahl < 0);
            } catch (InputMismatchException e) {

                String eingabeString = s.nextLine();
                if (eingabeString.equals("Januar")) {
                	zahl = 1;
                } else if (eingabeString.equals("Februar")) {
                	zahl = 2;
                } else if (eingabeString.equals("M�rz")) {
                	zahl = 3;
                } else if (eingabeString.equals("April")) {
                	zahl = 4;
                } else if (eingabeString.equals("Mai")) {
                	zahl = 5;
                } else if (eingabeString.equals("Juni")) {
                	zahl = 6;
                } else if (eingabeString.equals("Juli")) {
                	zahl = 7;
                } else if (eingabeString.equals("August")) {
                	zahl = 8;
                } else if (eingabeString.equals("September")) {
                	zahl = 9;
                } else if (eingabeString.equals("Oktober")) {
                	zahl = 10;
                } else if (eingabeString.equals("November")) {
                	zahl = 11;
                } else if (eingabeString.equals("Dezember")) {
                	zahl = 12;
                } else {
                	System.out.println("\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
                }
                
            }
            }
            return zahl;
    }

    /**
     * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
     *
     * @param auswahl
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des Index des Arrays)
     * @param z�hler
     *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des Index des Arrays)
     * @return das eingelesene Wort
     */
    private String einlesen_Wort(final String[] auswahl, final int z�hler) {
        System.out.println("Erstellen: " + auswahl[z�hler - 1]);
        Scanner s = new Scanner(System.in);
        String wort = s.nextLine();
        return wort;
    }
}
