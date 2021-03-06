package objekte;

import java.io.Serializable;

public class Suchanfrage implements Serializable {

    private static final long serialVersionUID = -3929758526444227802L;
    private int mitarbeiterID;
    private int kundenID;
    private double zimmeranzahl;
    private char relaZimmeranzahl;
    private double fläche;
    private char relaFläche;
    private double kosten;
    private char relaKosten;
    private double etage;
    private char relaEtage;
    private boolean balkon;
    private boolean fußbodenheizung;
    private String aussicht;

    public Suchanfrage(final int mitarbeiterID, final int kundenID, final char relaZimmeranzahl, final double such_zimmeranzahl, final char relaFläche, final double fläche, final char relaKosten, final double kosten, final char relaEtage, final double such_etage, final boolean balkon, final boolean fußbodenheizung, final String aussicht) {

        this.mitarbeiterID = mitarbeiterID;
        this.kundenID = kundenID;
        this.zimmeranzahl = such_zimmeranzahl;
        this.relaZimmeranzahl = relaZimmeranzahl;
        this.fläche = fläche;
        this.relaFläche = relaFläche;
        this.kosten = kosten;
        this.relaKosten = relaKosten;
        this.etage = such_etage;
        this.relaEtage = relaEtage;
        this.balkon = balkon;
        this.fußbodenheizung = fußbodenheizung;
        this.aussicht = aussicht;
    }

    public char getRelaZimmeranzahl() {
        return this.relaZimmeranzahl;
    }

    public void setRelaZimmeranzahl(final char relaZimmeranzahl) {
        this.relaZimmeranzahl = relaZimmeranzahl;
    }

    public char getRelaFläche() {
        return this.relaFläche;
    }

    public void setRelaFläche(final char relaFläche) {
        this.relaFläche = relaFläche;
    }

    public char getRelaKosten() {
        return this.relaKosten;
    }

    public void setRelaKosten(final char relaKosten) {
        this.relaKosten = relaKosten;
    }

    public char getRelaEtage() {
        return this.relaEtage;
    }

    public void setRelaEtage(final char relaEtage) {
        this.relaEtage = relaEtage;
    }

    public int getMitarbeiterID() {
        return this.mitarbeiterID;
    }

    public void setMitarbeiterID(final int mitarbeiterID) {
        this.mitarbeiterID = mitarbeiterID;
    }

    public int getKundenID() {
        return this.kundenID;
    }

    public void setKundenID(final int kundenID) {
        this.kundenID = kundenID;
    }

    public double getZimmeranzahl() {
        return this.zimmeranzahl;
    }

    public void setZimmeranzahl(final double zimmeranzahl) {
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

    public double getEtage() {
        return this.etage;
    }

    public void setEtage(final double etage) {
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
}
