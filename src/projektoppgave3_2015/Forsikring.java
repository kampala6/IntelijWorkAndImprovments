/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektoppgave3_2015;

import java.io.Serializable;

public abstract class Forsikring implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int BIL = 1;
    public static final int HUS_INNBO = 2;
    public static final int REISE = 3;
    public static final int BAAT = 4;
    public static final int FRITIDSBO = 5;

    private int forsikringId;
    private int totalKunderabatt = 3;
    private int fType = 0;

    protected Forsikring(int forsikringId) {
        this.forsikringId = forsikringId;
    }

    public int getForsikringId() {
        return forsikringId;
    }

    public void setForsikringId(int forsikringId) {
        this.forsikringId = forsikringId;
    }// backward compatibility for old code
    public int getForsikiringID() {
        return getForsikringId();
    }

    public void setForsikiringID(int forsikringId) {
        setForsikringId(forsikringId);
    }

    public int getTOTALKUNDERABATT() {
        return totalKunderabatt;
    }

    public void setTOTALKUNDERABATT(int totalKunderabatt) {
        this.totalKunderabatt = totalKunderabatt;
    }

    public int getF_type() {
        return fType;
    }

    public void setF_type(int fType) {
        this.fType = fType;
    }

    public abstract double premie();

    @Override
    public abstract String toString();

    public abstract int age();

    public abstract int getForsikringsType();
}
