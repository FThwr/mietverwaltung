package mietverwaltung;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MietvertragBearbeitenAction extends MenueManager implements Action, Serializable {

	static boolean window = false;
	static String bearbeitungsAuswahl_MietvertragID;
	static int JFRame_mieterID_auswahl;
	static int JFrame_wohnungsnummer_auswahl;
	static int JFrame_mitarbeiterID_auswahl;

	@Override
	public void action() throws IOException {

		System.out.println(
				"________________________________________ Mietvertrag bearbeiten ________________________________________");

		/*
		 * Variable zum �ffnen des richtigen JFrames und zur Auswahl des zu
		 * bearbeitenden Attributs.
		 */
		int �nderung = -99;

		// Ausgabe aller Mietvertrag-IDs zur einfacheren Auswahl
		auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);

		// Variable enth�lt die ID des zu bearbeitenden Mietvertrags
		String zu_bearbeitenden_mietvertrag = bearbeitungsAuswahl_MietvertragID;

		boolean bearbeitungsVorgang = true;

		/*
		 * Array beeinhaltet alle Attribute, die ver�ndert werden k�nnen und
		 * dient zur Ausgabe durch Zugriff auf deren Index
		 */
		String[] kategorie = { "Mietvertrag-ID", "Wohnungs-ID", "Kunden-ID", "Mitarbeiter-ID", "Mietbeginn", "Mietende",
				"Status" };

		/*
		 * diese Variablen dienen sp�ter f�r eine tabellarische Ausgabe auf der
		 * Konsole
		 */
		String l�ngenAnpassung_mietvertragID = "";
		String l�ngenAnpassung_wohnungsID = "";
		String l�ngenAnpassung_kundenID = "";
		String l�ngenAnpassnung_mitarbeiterID = "";
		String l�ngenAnpassung_status = "";

		/*
		 * allgemeine Variablen alte = aktuelle Werte, neue = neue/ver�nderte
		 * Werte
		 */
		String aktuelleMietvertragsID = "";
		String neueMietvertragsID = "";

		int aktuelleWohnungsID = -100;
		int neueWohnungsID = -100;

		int aktuelleKundenID = -100;
		int neueKundenID = -100;

		int aktuelleMitarbeiterID = -100;
		int neueMitarbeiterID = -100;

		Datum aktuellerMietbeginn = null;
		Datum neuerMietbeginn = null;

		Datum aktuellesMietende = null;
		Datum neuesMietende = null;

		String aktuellerStatus = "";
		String neuerStatus = "";

		/*
		 * Variablen enthalten die Leerzeichen, die nach den Objekten (Daten)
		 * eingesetzt werden. Die L�ngen der einzelnen Komponenten der Objekte
		 * werden verwendet. MB = Mietbeginn , ME = Mietende.
		 */
		String MB_Leerzeichen = "";
		String ME_Leerzeichen = "";

		/*
		 * F�r jedes Element in der ArrayList 'contractList', welche alle
		 * aktiven Mietvertr�ge beeinhaltet, wir zeurst das Objekt in der
		 * ArrayList gesucht, welche der eben ausgew�hlten Vertrags-ID
		 * entspricht. Es werden neue Variablen angelegt, welche die einzelnen
		 * Werte des Objekts beeinhalten.
		 */
		for (Mietvertrag contract : contractList) {
			if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragID())) {

				aktuelleMietvertragsID = contract.getMietvertragID();
				neueMietvertragsID = aktuelleMietvertragsID;

				aktuelleWohnungsID = contract.getWohnungsID();
				neueWohnungsID = aktuelleWohnungsID;

				aktuelleKundenID = contract.getKundenID();
				neueKundenID = aktuelleKundenID;

				aktuelleMitarbeiterID = contract.getMitarbeiterID();
				neueMitarbeiterID = aktuelleMitarbeiterID;

				aktuellerMietbeginn = contract.getMietbeginn();
				neuerMietbeginn = aktuellerMietbeginn;

				aktuellesMietende = contract.getMietende();
				neuesMietende = aktuellesMietende;

				aktuellerStatus = contract.getStatus();
				neuerStatus = aktuellerStatus;

				/*
				 * Initialisierung der tabellarischen Variablen + Ausf�llung mit
				 * Leerzeichen (Umwandlung in die Tabelle)
				 */
				l�ngenAnpassung_mietvertragID = aktuelleMietvertragsID;
				l�ngenAnpassung_mietvertragID = l�nge_anpassen(l�ngenAnpassung_mietvertragID);

				l�ngenAnpassung_wohnungsID = "" + aktuelleWohnungsID;
				l�ngenAnpassung_wohnungsID = l�nge_anpassen(l�ngenAnpassung_wohnungsID);

				l�ngenAnpassung_kundenID = "" + aktuelleKundenID;
				l�ngenAnpassung_kundenID = l�nge_anpassen(l�ngenAnpassung_kundenID);

				l�ngenAnpassnung_mitarbeiterID = "" + aktuelleMitarbeiterID;
				l�ngenAnpassnung_mitarbeiterID = l�nge_anpassen(l�ngenAnpassnung_mitarbeiterID);

				l�ngenAnpassung_status = aktuellerStatus;
				l�ngenAnpassung_status = l�nge_anpassen(l�ngenAnpassung_status);

				MB_Leerzeichen = l�nge_anpassen_Datum(aktuellerMietbeginn);
				ME_Leerzeichen = l�nge_anpassen_Datum(aktuellesMietende);
			}
		}

		/*
		 * Solange der Bearbeitungsvorgang nicht beendet ist, wird immer eine
		 * �bersicht �ber den alten Wert und den neuen Wert des jeweiligen
		 * Attributs ausgegeben. Es wird pro Durchlauf immer 1 Attribut
		 * ausgew�hlt, welches man draufhin ver�ndern kann.
		 */
		while (bearbeitungsVorgang == true) {
			System.out.println(
					"............................... W�hlen Sie die zu bearbeitende Eigenschaft aus! ...............................");
			System.out.println("1. Mietvertrag-ID:       " + l�ngenAnpassung_mietvertragID
					+ "neue Mietvertrag-ID:       " + neueMietvertragsID);
			System.out.println("2. Wohnungs-ID:          " + l�ngenAnpassung_wohnungsID + "neue Wohnungs-ID:          "
					+ neueWohnungsID);
			System.out.println("3. Kunden-ID:            " + l�ngenAnpassung_kundenID + "neue Kunden-ID:            "
					+ neueKundenID);
			System.out.println("4. Mitarbeiter-ID:       " + l�ngenAnpassnung_mitarbeiterID
					+ "neue Mitarbeiter-ID:       " + neueMitarbeiterID);
			System.out.println("5. Mietbeginn:           " + aktuellerMietbeginn + MB_Leerzeichen
					+ "neuer Mietbeginn:          " + neuerMietbeginn);
			System.out.println("6. Mietende:             " + aktuellesMietende + ME_Leerzeichen
					+ "neues Mietende:            " + neuesMietende);
			System.out.println(
					"7. Status:               " + l�ngenAnpassung_status + "neuer Status:              " + neuerStatus);
			System.out.println("8. Best�tigen");
			System.out.println("0. Abbruch");
			System.out.println("");

			Scanner t = new Scanner(System.in);

			/*
			 * Die try-catch Klammer existiert f�r nicht erw�nschte Eingaben wie
			 * Zeichen, wo Zahlen erwartet werden.
			 */
			try {
				�nderung = t.nextInt();

				// Abbruch
				if (�nderung == 0) {
					System.out.println(
							"\n-------------------------------Bearbeitungsvorgang wurde abgebrochen!-------------------------------\n");
					bearbeitungsVorgang = false;
				}

				// Mietvertrag-ID
				if (�nderung == 1) {
					String eingabe = einlesen_Wort(kategorie, �nderung);
					if (eingabe.equals("" + 0)) {
					} else {

						int vorhanden = 0;
						/*
						 * F�r jedes Element in der Handwerkerliste der aktiven
						 * Auftr�ge wird geguckt, ob die eingegebende ID mit
						 * einer bereits existierenden �bereinstimmt.
						 */
						for (Mietvertrag contract : contractList) {
							if (eingabe.equals(contract.getMietvertragID())) {
								vorhanden = 1;
							}
						}

						/*
						 * F�r jedes Element in der Handwerkerliste der
						 * abgeschlossenen Auftr�ge wird geguckt, ob die
						 * eingegebende ID mit einer bereits existierenden
						 * �bereinstimmt.
						 */
						for (Mietvertrag abgeschlossenerMietvertrag : beendeteMietvertr�ge) {
							if (eingabe.equals(abgeschlossenerMietvertrag.getMietvertragID())) {
								vorhanden = 1;
							}
						}

						/*
						 * Wenn die Variable 'vorhanden' = 1, dann existierte
						 * ein Handwerkerauftrag mit dieser ID bereits. Sonst
						 * wird die eingegebene ID die ID des Auftrags.
						 */
						if (vorhanden == 1) {
							System.out.println(
									"\n------------------------------- Fehler! ------------------------------- \nMietvertrags-ID bereits vergeben!\n");
						} else {
							neueMietvertragsID = eingabe;
						}
					}
				}

				// Wohnungsnummer
				if (�nderung == 2) {
					auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
					neueWohnungsID = JFrame_wohnungsnummer_auswahl;
				}

				// Mieter-ID
				if (�nderung == 3) {
					auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
					neueKundenID = JFRame_mieterID_auswahl;
				}

				// Mitarbeiter-ID
				if (�nderung == 4) {
					auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(�nderung);
					neueMitarbeiterID = JFrame_mitarbeiterID_auswahl;
				}

				// Mietbeginn
				if (�nderung == 5) {
					neuerMietbeginn = Datum_Eingabe(neuerMietbeginn);
				}

				// Mietende
				if (�nderung == 6) {
					neuesMietende = Datum_Eingabe(neuesMietende);
				}

				// Status
				if (�nderung == 7) {
					System.out.println(
							"Geben Sie die Zahl vom gew�nschten Status aus: '1' = aktiv, '2' = ausgelaufen, '0' = Abbruch!");
					int eingabe = einlesen_Zahl(kategorie, �nderung);

					if (eingabe == 1) {
						neuerStatus = "aktiv";
					}
					if (eingabe == 2) {
						neuerStatus = "ausgelaufen";
					}
					if (eingabe == 0) {
					}

					// Jede andere Eingabe f�hrt zu einer Fehlermeldung.
					if (eingabe > 2) {
						System.out.println(
								"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
					}
				}

				// Bearbeitung abschlie�en
				if (�nderung == 8) {
					bearbeitungsVorgang = false;

					if (neuerStatus.equals("aktiv")) {
						/*
						 * Es werden nach dem Herausfinden, welcher Mietvertrag
						 * so eben bearbeitet wurde, die einzelnen ver�nderten
						 * Attribute nun ge�ndert.
						 */
						for (Mietvertrag contract : contractList) {
							if (zu_bearbeitenden_mietvertrag.equals(contract.getMietvertragID())) {
								contract.setMietvertragID(neueMietvertragsID);
								contract.setWohnungsID(neueWohnungsID);
								contract.setKundenID(neueKundenID);
								contract.setMitarbeiterID(neueMitarbeiterID);
								contract.setMietbeginn(neuerMietbeginn);
								contract.setMietende(neuesMietende);
								contract.setStatus(neuerStatus);
							}
						}
					}
					if (neuerStatus.equals("ausgelaufen")) {

						/*
						 * Da der Vertrag ausgelaufen ist, wird er der Liste der
						 * beendeten Vertr�ge hinzugef�gt.
						 */
						beendeteMietvertr�ge.add(new Mietvertrag(neueMietvertragsID, neueWohnungsID, neueKundenID,
								neueMitarbeiterID, neuerMietbeginn, neuesMietende, neuerStatus));

						/*
						 * Auderdem wird der Handwerkerautrag aus der Liste der
						 * aktiven Auftr�ge entfernt
						 */
						Iterator<Mietvertrag> iter = contractList.iterator();

						while (iter.hasNext()) {
							Mietvertrag str = iter.next();

							if (str.getMietvertragID().equals(zu_bearbeitenden_mietvertrag)) {
								iter.remove();

							}
						}
					}

					/*
					 * Es wird �berpr�ft, ob eine Wohnung besetzt ist und
					 * daraufhin der Status auf 'vermietet' gesetzt, wenn das
					 * der Fall ist und sonst auf 'frei'
					 */
					for (Wohnung flat : flatList) {
						int belegt = 0;
						for (Mietvertrag contract : contractList) {
							if (contract.getWohnungsID() == flat.getWohnungsID() && flat.getWohnungsID() != -100
									&& contract.getWohnungsID() != -100) {
								belegt = 1;
							}
						}
						if (belegt == 1) {
							flat.setStatus("vermietet");
						} else {
							flat.setStatus("frei");
						}
					}

					/*
					 * Es wird �berpr�ft wer alles einen Mietvertrag besitzt.
					 * Wenn jemand einen Mietvertrag besitzt, dann wird dem
					 * Mieter die Wohnungsnummer im Mieterprofil hinzugef�gt.
					 * Wenn er keinen bestizt, dann bekommt er einen Strich in
					 * sienem Profil an der Stelle der Wohnungsnummer.
					 */
					for (Mieter owner : ownerList) {
						if (owner.getWohnungsnummer() == aktuelleWohnungsID) {
						
							owner.setWohnungsnummer(-100);
						}
					}
				}

				// Eingabe > 8
				if (�nderung > 8) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nEingabem�glichkeit nicht vorhanden!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
			}
		}

	}

	/**
	 * Methode zur Eingabe des Datums
	 * 
	 * @param aktuellesDatum,
	 *            was der Handwerkerauftrag zu dem Zeitpunkt noch benutzt
	 * @return das neue Datum, welches weiterverwendet werden soll
	 */
	public Datum Datum_Eingabe(Datum aktuellesDatum) {

		System.out
				.println("Eingabe des Eingangdatums: W�hlen Sie bei einem Wert '0' und das Datum bleibt unver�ndert!");
		String[] auswahl = { "Jahr", "Monat", "Tag" };

		Datum neuesDatum = null;
		boolean datumsEingabeErfolgreich = false;

		int z�hler = 1;
		int jahr = einlesen_Zahl(auswahl, z�hler);

		z�hler = 2;
		int monat = 0;
		do {
			monat = einlesen_Zahl(auswahl, z�hler);
			if (monat > 12) {
				System.out.println(
						"\n------------------------------- Fehler! ------------------------------- \nMonat darf nicht h�her als 12 sein!");
			}
		} while (monat > 12);

		z�hler = 3;
		int tag = 0;
		do {
			tag = einlesen_Zahl(auswahl, z�hler);
			if (monat == 1 || monat == 3 || monat == 5 || monat == 7 || monat == 8 || monat == 10 || monat == 12) {
				if (tag > 31) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 31 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
				if (tag > 30) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 30 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}

			if (monat == 2) {
				if (tag > 29) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nIhr Monat hat maximal 29 Tage!");
				} else {
					datumsEingabeErfolgreich = true;
				}
			}
		} while (datumsEingabeErfolgreich == false);

		/*
		 * Wenn einer der Werte versucht wird zu �berspringen/ auszulassen, dann
		 * bleibt es beim unver�nderten Datum.
		 */
		if (tag == 0 || tag == -100 || monat == 0 || monat == -100 || jahr == 0 || jahr == -100) {
			neuesDatum = aktuellesDatum;
		} else {
			neuesDatum = new Datum(tag, monat, jahr);
		}
		return neuesDatum;
	}

	/**
	 * Methode zur Auswahl eines bereits existierend Attributs durch Vorschlag
	 * jedes einzelnen Elements in einer ArrayList
	 * 
	 * @param �nderung
	 *            = Z�hler des Attributs -> Bestimmung, welcher Fall eintritt
	 *            (ob eine Wohnung, etc. bearbeitet wird)
	 */
	private void auswahl_Mietvertrag_Wohnung_Kunde_Mitarbeiter(int �nderung) {
		window = false;
		bearbeitungsAuswahl_MietvertragID = "";
		JFrame_wohnungsnummer_auswahl = -100;
		JFRame_mieterID_auswahl = -100;
		JFrame_mitarbeiterID_auswahl = -100;

		JFrame meinRahmen = new JFrame();
		meinRahmen.setSize(250, 250);
		JPanel meinPanel = new JPanel();
		meinRahmen.setLocationRelativeTo(null);

		JComboBox combo2 = new JComboBox();

		if (�nderung == -99) {
			meinRahmen.setTitle("Mietvertrag ID");
			JLabel frage = new JLabel("Welcher Mietvertrag wird bearbeitet?");
			meinPanel.add(frage);
			for (Mietvertrag contract : contractList) {
				combo2.addItem(contract.getMietvertragID());
			}
		}

		if (�nderung == 2) {
			meinRahmen.setTitle("Wohngungs ID");
			JLabel frage = new JLabel("Welche Wohnung soll ausgew�hlt werden?");
			meinPanel.add(frage);

			for (Wohnung flat : flatList) {
				combo2.addItem(flat.getWohnungsID());
			}
		}

		if (�nderung == 3) {
			meinRahmen.setTitle("Mieter ID");
			JLabel frage = new JLabel("Welcher Mieter soll ausgew�hlt werden?");
			meinPanel.add(frage);
			for (Mieter owner : ownerList) {
				combo2.addItem(owner.getKundenID());
			}
		}

		if (�nderung == 4) {
			meinRahmen.setTitle("Mitarbeiter ID");
			JLabel frage = new JLabel("Welcher Mitarbeiter soll ausgew�hlt werden?");
			meinPanel.add(frage);
			for (Mitarbeiter worker : workerList) {
				combo2.addItem(worker.getMitarbeiterID());
			}
		}

		meinRahmen.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				window = true;
			}
		});

		ActionListener cbActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (�nderung == -99) {
					bearbeitungsAuswahl_MietvertragID = (String) combo2.getSelectedItem();
				}
				if (�nderung == 2) {
					JFrame_wohnungsnummer_auswahl = (int) combo2.getSelectedItem();
				}
				if (�nderung == 3) {
					JFRame_mieterID_auswahl = (int) combo2.getSelectedItem();
				}
				if (�nderung == 4) {
					JFrame_mitarbeiterID_auswahl = (int) combo2.getSelectedItem();
				}
			}
		};
		meinPanel.add(combo2);
		meinRahmen.add(meinPanel, BorderLayout.SOUTH);
		meinRahmen.pack();
		meinRahmen.setVisible(true);
		while (window == false) {
			combo2.addActionListener(cbActionListener);
		}

	}

	/**
	 * Methode zum Einlesen einer Zahl vom Nutzer
	 * 
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return die eingelesene Zahl
	 */
	private int einlesen_Zahl(String[] auswahl, int z�hler) {
		Scanner s = new Scanner(System.in);
		int zahl = -100;
		try {

			do {
				System.out.println("Geben Sie ein: " + auswahl[z�hler - 1]);
				zahl = s.nextInt();
				if (zahl < 0) {
					System.out.println(
							"\n------------------------------- Fehler! ------------------------------- \nNur positive Zahlen erlaubt!");
				}
			} while (zahl < 0);
		} catch (InputMismatchException e) {
			System.out.println(
					"\n------------------------------- Fehler! ------------------------------- \nSie haben einen Buchstaben eingegeben, wo eine Zahl erwartet wurde!\n");
		}
		return zahl;
	}

	/**
	 * Methode zum Einlesen eines Wortes oder Satzes vom Nutzer
	 * 
	 * @param auswahl
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Name des
	 *            Index des Arrays)
	 * @param z�hler
	 *            = welches "�nderungsfeld" der Nutzer betreten hat (Nummer des
	 *            Index des Arrays)
	 * @return das eingelesene Wort
	 */
	private String einlesen_Wort(String[] auswahl, int z�hler) {
		System.out.println("Erstellen: " + auswahl[z�hler - 1]);
		Scanner s = new Scanner(System.in);
		String wort = s.nextLine();
		return wort;
	}

	/**
	 * Methode zum Anpassen der L�nge des Datums bei der Ausgabe auf der
	 * Konsole.
	 * 
	 */
	private String l�nge_anpassen_Datum(Datum a_GD) {

		int abzug = 0;

		String leerzeichen = "";

		if (a_GD != null) {

			String jahr = "" + a_GD.getJahr();
			int l_J = jahr.length();

			String monat = "" + a_GD.getMonat();
			int l_M = monat.length();

			String tag = "" + a_GD.getTag();
			int l_T = tag.length();

			abzug = l_J + l_M + l_T + 2; // +2 f�r die Punkte zwischen den
											// Komponenten
		}
		abzug = 4;
		if (abzug < 50) {
			while (abzug < 50) {
				leerzeichen = leerzeichen + " ";
				abzug += 1;
			}
		}
		return leerzeichen;
	}

	/**
	 * Methode zum Anpassen der L�nge des Attributes (au�er Datum) bei der
	 * Ausgabe auf der Konsole.
	 * 
	 * @param wort
	 *            = mitgegebenes Attribut
	 * 
	 * @return das Attribut mit den anschlie�enden Leerzeichen
	 */
	private String l�nge_anpassen(String wort) {

		int abzug = wort.length();
		if (wort.length() < 50) {
			while (wort.length() < 50) {
				wort = wort + " ";
			}
		}
		return wort;
	}
}