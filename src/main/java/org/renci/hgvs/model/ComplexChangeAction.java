package org.renci.hgvs.model;

public class ComplexChangeAction implements ChangeAction {

    private String inserts;

    private String deletions;

    public ComplexChangeAction() {
        super();
    }

    public ComplexChangeAction(String inserts) {
        super();
        this.inserts = inserts;
    }

    public ComplexChangeAction(String inserts, String deletions) {
        super();
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
        return String.format("ComplexChangeAction [inserts=%s, deletions=%s]", inserts, deletions);
    }

}
