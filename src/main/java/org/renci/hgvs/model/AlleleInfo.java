package org.renci.hgvs.model;

public abstract class AlleleInfo {

    protected String location;

    public AlleleInfo() {
        super();
    }

    public AlleleInfo(String location) {
        super();
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
