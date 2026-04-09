package projektoppgave3_2015;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Calendar;

public class Husoginnboforsikring extends Forsikring implements Serializable {

    private static final long serialVersionUID = 1L;

    private String boligensAdresse;
    private int byggeaar = -1;
    private String boligtype;
    private String byggemateriale;
    private String standard;
    private final int antallKvadratmeter;
    private int belopB = -1;
    private int belopI = -1;
    private double bonus = 0.0;
    private Calendar dato;
    private int kunde;

    public Husoginnboforsikring(int kunde,
                                String boligensAdresse,
                                String boligtype,
                                Calendar dato,
                                String byggemateriale,
                                int antallKvadratmeter,
                                int belopB,
                                int belopI,
                                int byggeaar,
                                String standard,
                                int forsikringId) {
        super(forsikringId);
        this.kunde = kunde;
        this.boligensAdresse = boligensAdresse;
        this.boligtype = boligtype;
        this.dato = dato;
        this.byggemateriale = byggemateriale;
        this.antallKvadratmeter = antallKvadratmeter;
        this.belopB = belopB;
        this.belopI = belopI;
        this.byggeaar = byggeaar;
        this.standard = standard;
    }

    public String getBoligensAdresse() {
        return boligensAdresse;
    }

    public void setBoligensAdresse(String boligensAdresse) {
        this.boligensAdresse = boligensAdresse;
    }

    public int getByggeaar() {
        return byggeaar;
    }

    public void setByggeaar(int byggeaar) {
        this.byggeaar = byggeaar;
    }

    public String getBoligtype() {
        return boligtype;
    }

    public void setBoligtype(String boligtype) {
        this.boligtype = boligtype;
    }

    public String getByggemateriale() {
        return byggemateriale;
    }

    public void setByggemateriale(String byggemateriale) {
        this.byggemateriale = byggemateriale;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getAntallKvadratmeter() {
        return antallKvadratmeter;
    }

    public int getBelopB() {
        return belopB;
    }

    public void setBelopB(int belopB) {
        this.belopB = belopB;
    }

    public int getBelopI() {
        return belopI;
    }

    public void setBelopI(int belopI) {
        this.belopI = belopI;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Calendar getDatoObjekt() {
        return dato;
    }

    public void setDato(Calendar dato) {
        this.dato = dato;
    }

    public int getKunde() {
        return kunde;
    }

    public void setKunde(int kunde) {
        this.kunde = kunde;
    }

    @Override
    public double premie() {
        return (antallKvadratmeter * belopB) * (1 - bonus / 100.0);
    }

    @Override
    public int getForsikringsType() {
        return HUS_INNBO;
    }

    @Override
    public int age() {
        if (dato == null) {
            return 0;
        }
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return Math.max(0, year - byggeaar);
    }

    @Override
    public String toString() {
        NumberFormat kr = NumberFormat.getCurrencyInstance();
        return "Husoginnboforsikring{" +
                "kunde=" + kunde +
                ", boligensAdresse='" + boligensAdresse + '\'' +
                ", byggeaar=" + byggeaar +
                ", boligtype='" + boligtype + '\'' +
                ", byggemateriale='" + byggemateriale + '\'' +
                ", standard='" + standard + '\'' +
                ", antallKvadratmeter=" + antallKvadratmeter +
                ", belopB=" + belopB +
                ", belopI=" + belopI +
                ", bonus=" + bonus +
                ", premie=" + kr.format(premie()) +
                '}';
    }
}