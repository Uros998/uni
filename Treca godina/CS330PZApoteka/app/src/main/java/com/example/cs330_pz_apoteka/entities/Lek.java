package com.example.cs330_pz_apoteka.entities;

import java.util.Arrays;

public class Lek {
    private int id;
    private String ime;
    private String tip;
    private String opis;
    private int cena;
    private byte[] img;

    public Lek() {
    }

    public Lek(int id) {
        this.id = id;
    }

    public Lek(int id, String ime, String tip, String opis, int cena, byte[] img) {
        this.id = id;
        this.ime = ime;
        this.tip = tip;
        this.opis = opis;
        this.cena = cena;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Lek{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", tip='" + tip + '\'' +
                ", opis='" + opis + '\'' +
                ", cena=" + cena +
                ", img=" + Arrays.toString(img) +
                '}';
    }
}
