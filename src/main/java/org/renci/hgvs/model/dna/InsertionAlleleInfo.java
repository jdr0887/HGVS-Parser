package org.renci.hgvs.model.dna;

import org.renci.hgvs.model.AlleleInfo;

public class InsertionAlleleInfo extends AlleleInfo {

    private String bases;

    public InsertionAlleleInfo() {
        super();
    }

    public InsertionAlleleInfo(String location, String bases) {
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
        return String.format("InsertionAlleleInfo [location=%s, bases=%s]", location, bases);
    }

}
