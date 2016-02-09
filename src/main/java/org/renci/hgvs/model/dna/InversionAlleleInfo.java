package org.renci.hgvs.model.dna;

import org.renci.hgvs.model.AlleleInfo;

public class InversionAlleleInfo extends AlleleInfo {

    private String bases;

    public InversionAlleleInfo() {
        super();
    }

    public InversionAlleleInfo(String location, String bases) {
        super(location);
        this.bases = bases;
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    @Override
    public String toString() {
        return String.format("InversionAlleleInfo [location=%s, bases=%s]", location, bases);
    }

}
