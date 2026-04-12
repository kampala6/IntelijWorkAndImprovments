//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package projektoppgave3_2015;

import java.io.Serializable;

public abstract class Forsikring implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int BIL = 1;
    public static final int HUS_INNBO = 2;
    public static final int REISE = 3;
    public static final int BAAT = 4;
    public static final int FRITIDSBO = 5;
    public static final int DEFAULT_TOTAL_KUNDERABATT = 3;
    public static final int DEFAULT_F_TYPE = 0;
    private int forsikringId;
    private int totalKunderabatt = 3;
    private int fType = 0;

    protected Forsikring(int var1) {
        this.forsikringId = var1;
    }

    public int getForsikringId() {
        return this.forsikringId;
    }

    public void setForsikringId(int var1) {
        this.forsikringId = var1;
    }

    /** @deprecated */
    @Deprecated
    public int getForsikiringID() {
        return this.getForsikringId();
    }

    /** @deprecated */
    @Deprecated
    public void setForsikiringID(int var1) {
        this.setForsikringId(var1);
    }

    public int getTotalKunderabatt() {
        return this.totalKunderabatt;
    }

    public void setTotalKunderabatt(int var1) {
        this.totalKunderabatt = var1;
    }

    /** @deprecated */
    @Deprecated
    public int getTOTALKUNDERABATT() {
        return this.getTotalKunderabatt();
    }

    /** @deprecated */
    @Deprecated
    public void setTOTALKUNDERABATT(int var1) {
        this.setTotalKunderabatt(var1);
    }

    public int getFType() {
        return this.fType;
    }

    public void setFType(int var1) {
        this.fType = var1;
    }

    /** @deprecated */
    @Deprecated
    public int getF_type() {
        return this.getFType();
    }

    /** @deprecated */
    @Deprecated
    public void setF_type(int var1) {
        this.setFType(var1);
    }

    public abstract double premie();

    public abstract String toString();

    public abstract int age();

    public abstract int getForsikringsType();
}
