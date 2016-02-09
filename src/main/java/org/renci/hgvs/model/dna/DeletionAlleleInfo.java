package org.renci.hgvs.model.dna;

import org.renci.hgvs.model.AlleleInfo;

public class DeletionAlleleInfo extends AlleleInfo {

    private String bases;

    private Integer baseLength;

    public DeletionAlleleInfo() {
        super();
    }

    public DeletionAlleleInfo(String location) {
        super(location);
    }

    public String getBases() {
        return bases;
    }

    public void setBases(String bases) {
        this.bases = bases;
    }

    public Integer getBaseLength() {
        return baseLength;
    }

    public void setBaseLength(Integer baseLength) {
        this.baseLength = baseLength;
    }

    @Override
    public String toString() {
        return String.format("DeletionAlleleInfo [location=%s, bases=%s, baseLength=%s]", location, bases, baseLength);
    }

}
