package com.krishnan.android.ragaidentifier;

/**
 * Created by anand on 11/20/18.
 */

public class Ragam {

    private String Avarohanam;
    private String Arohanam;
    private String Ragam;

    public Ragam (String Ragam, String arohanam, String avarohanam) {
        this.Avarohanam = avarohanam;
        this.Arohanam = arohanam;
        this.Ragam = Ragam;
    }

    public String getAvarohanam() {
        return Avarohanam;
    }

    public String getArohanam() {
        return Arohanam;
    }

    public String getRagam() {
        return Ragam;
    }

}
