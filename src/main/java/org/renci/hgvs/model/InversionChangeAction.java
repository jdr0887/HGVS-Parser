package org.renci.hgvs.model;

public class InversionChangeAction implements ChangeAction {

    private String bases;

    public InversionChangeAction() {
        super();
    }

    public InversionChangeAction(String bases) {
        super();
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
        return String.format("InversionChangeAction [bases=%s]", bases);
    }

}
