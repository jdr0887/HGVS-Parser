package org.renci.hgvs.model;

public class InsertionChangeAction implements ChangeAction {

    private String bases;

    public InsertionChangeAction() {
        super();
    }

    public InsertionChangeAction(String bases) {
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
        return String.format("InsertionChangeAction [bases=%s]", bases);
    }

}
