package org.renci.hgvs.model.dna;

import org.renci.hgvs.model.AlleleInfo;

public class SubstitutionAlleleInfo extends AlleleInfo {

    private String wildtype;

    private String mutation;

    public SubstitutionAlleleInfo() {
        super();
    }

    public SubstitutionAlleleInfo(String location, String wildtype, String mutation) {
        super(location);
        this.wildtype = wildtype;
        this.mutation = mutation;
    }

    public String getWildtype() {
        return wildtype;
    }

    public void setWildtype(String wildtype) {
        this.wildtype = wildtype;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    @Override
    public String toString() {
        return String.format("SubstitutionAlleleInfo [location=%s, wildtype=%s, mutation=%s]", location, wildtype, mutation);
    }

}
