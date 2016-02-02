package org.renci.hgvs.model;

public class DeletionChangeAction implements ChangeAction {

    private String bases;

    public DeletionChangeAction() {
        super();
    }

    public DeletionChangeAction(String bases) {
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
        return String.format("DeletionChangeAction [bases=%s]", bases);
    }

}
