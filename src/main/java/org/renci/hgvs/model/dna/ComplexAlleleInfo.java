package org.renci.hgvs.model.dna;

import org.renci.hgvs.model.AlleleInfo;

public class ComplexAlleleInfo extends AlleleInfo {

    private String inserts;

    private String deletions;

    public ComplexAlleleInfo() {
        super();
    }

    public ComplexAlleleInfo(String location, String inserts) {
        super(location);
        this.inserts = inserts;
    }

    public ComplexAlleleInfo(String location, String inserts, String deletions) {
        super(location);
        this.inserts = inserts;
        this.deletions = deletions;
    }

    public String getInserts() {
        return inserts;
    }

    public void setInserts(String inserts) {
        this.inserts = inserts;
    }

    public String getDeletions() {
        return deletions;
    }

    public void setDeletions(String deletions) {
        this.deletions = deletions;
    }

    @Override
    public String toString() {
        return String.format("ComplexAlleleInfo [location=%s, inserts=%s, deletions=%s]", location, inserts, deletions);
    }

}
