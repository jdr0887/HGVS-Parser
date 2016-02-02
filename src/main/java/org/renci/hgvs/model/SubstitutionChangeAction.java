package org.renci.hgvs.model;

public class SubstitutionChangeAction implements ChangeAction {

    private String from;

    private String to;

    public SubstitutionChangeAction() {
        super();
    }

    public SubstitutionChangeAction(String from, String to) {
        super();
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return String.format("SubstitutionChangeAction [from=%s, to=%s]", from, to);
    }

}
