package org.renci.hgvs.model;

public class DuplicationChangeAction implements ChangeAction {

    private String bases;

    public DuplicationChangeAction() {
        super();
    }

    public DuplicationChangeAction(String bases) {
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
        return String.format("DuplicationChangeAction [bases=%s]", bases);
    }

}
