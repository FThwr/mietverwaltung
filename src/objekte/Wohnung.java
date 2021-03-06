package objekte;

import java.io.Serializable;

import hilfsklassen.Adresse;
import hilfsklassen.Datum;

public class Wohnung implements Serializable {

    private static final long serialVersionUID = -711561699997322789L;

    private int wohnungsID;
    private int zimmeranzahl;
    private double fläche;
    private double kosten;
    private int etage;
    private boolean balkon;
    private boolean fußbodenheizung;
    private String aussicht;
    private Adresse adresse;
    private String status;
    private Datum letztesRenovierungsdatum;
    private int renovierungsanzahl;
    private String letzeRenovierung_Details;
    private Handwerkerauftrag handwerkerauftrag;
    private Mitarbeiter zugeordneterMitarbeiter;

    public Wohnung(final int wohnungsID, final int zimmeranzahl, final double fläche, final double kosten, final int etage, final boolean balkon, final boolean fußbodenheizung, final String aussicht, final Adresse adresse, final String status, final Datum letztesRenovierungsdatum, final int renovierungsanzahl, final String letzeRenovierung_Details, final Handwerkerauftrag handwerkerauftrag,
            final Mitarbeiter zugeordneterMitarbeiter) {
        this.wohnungsID = wohnungsID;
        this.zimmeranzahl = zimmeranzahl;
        this.fläche = fläche;
        this.kosten = kosten;
        this.etage = etage;
        this.balkon = balkon;
        this.fußbodenheizung = fußbodenheizung;
        this.aussicht = aussicht;
        this.adresse = adresse;
        this.status = status;
        this.letztesRenovierungsdatum = letztesRenovierungsdatum;
        this.renovierungsanzahl = renovierungsanzahl;
        this.letzeRenovierung_Details = letzeRenovierung_Details;
        this.handwerkerauftrag = handwerkerauftrag;
        this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
    }

    public int getWohnungsID() {
        return this.wohnungsID;
    }

    public void setWohnungsID(final int wohnungsID) {
        this.wohnungsID = wohnungsID;
    }

    public int getZimmeranzahl() {
        return this.zimmeranzahl;
    }

    public void setZimmeranzahl(final int zimmeranzahl) {
        this.zimmeranzahl = zimmeranzahl;
    }

    public double getFläche() {
        return this.fläche;
    }

    public void setFläche(final double fläche) {
        this.fläche = fläche;
    }

    public double getKosten() {
        return this.kosten;
    }

    public void setKosten(final double kosten) {
        this.kosten = kosten;
    }

    public int getEtage() {
        return this.etage;
    }

    public void setEtage(final int etage) {
        this.etage = etage;
    }

    public boolean getBalkon() {
        return this.balkon;
    }

    public void setBalkon(final boolean balkon) {
        this.balkon = balkon;
    }

    public boolean getFußbodenheizung() {
        return this.fußbodenheizung;
    }

    public void setFußbodenheizung(final boolean fußbodenheizung) {
        this.fußbodenheizung = fußbodenheizung;
    }

    public String getAussicht() {
        return this.aussicht;
    }

    public void setAussicht(final String aussicht) {
        this.aussicht = aussicht;
    }

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(final Adresse adresse) {
        this.adresse = adresse;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Datum getLetztesRenovierungsdatum() {
        return this.letztesRenovierungsdatum;
    }

    public void setLetztesRenovierungsdatum(final Datum letztesRenovierungsdatum) {
        this.letztesRenovierungsdatum = letztesRenovierungsdatum;
    }

    public int getRenovierungsanzahl() {
        return this.renovierungsanzahl;
    }

    public void setRenovierungsanzahl(final int renovierungsanzahl) {
        this.renovierungsanzahl = renovierungsanzahl;
    }

    public String getLetzeRenovierung_Details() {
        return this.letzeRenovierung_Details;
    }

    public void setLetzeRenovierung_Details(final String letzeRenovierung_Details) {
        this.letzeRenovierung_Details = letzeRenovierung_Details;
    }

    public Mitarbeiter getZugeordneterMitarbeiter() {
        return this.zugeordneterMitarbeiter;
    }

    public void setZugeordneterMitarbeiter(final Mitarbeiter zugeordneterMitarbeiter) {
        this.zugeordneterMitarbeiter = zugeordneterMitarbeiter;
    }

    public Handwerkerauftrag getHandwerkerauftrag() {
        return this.handwerkerauftrag;
    }

    public void setHandwerkerauftrag(final Handwerkerauftrag handwerkerauftrag) {
        this.handwerkerauftrag = handwerkerauftrag;
    }

}