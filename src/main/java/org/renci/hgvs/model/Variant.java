package org.renci.hgvs.model;

import java.io.Serializable;

import org.apache.commons.lang3.Range;

public class Variant implements Serializable {

    private static final long serialVersionUID = 6711463880295930784L;

    private String accession;

    private Range<Integer> range;

    private SequenceType sequenceType;

    private ChangeType changeType;

    private ChangeAction changeAction;

    public Variant() {
        super();
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public SequenceType getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(SequenceType sequenceType) {
        this.sequenceType = sequenceType;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ChangeType changeType) {
        this.changeType = changeType;
    }

    public Range<Integer> getRange() {
        return range;
    }

    public void setRange(Range<Integer> range) {
        this.range = range;
    }

    public ChangeAction getChangeAction() {
        return changeAction;
    }

    public void setChangeAction(ChangeAction changeAction) {
        this.changeAction = changeAction;
    }

    @Override
    public String toString() {
        return String.format("Variant [accession=%s, range=%s, sequenceType=%s, changeType=%s, changeAction=%s]", accession, range,
                sequenceType, changeType, changeAction);
    }

}
