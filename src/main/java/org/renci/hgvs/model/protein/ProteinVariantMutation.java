package org.renci.hgvs.model.protein;

import java.io.Serializable;

import org.renci.hgvs.model.AlleleInfo;
import org.renci.hgvs.model.VariantMutationType;

public class ProteinVariantMutation implements Serializable {

    private static final long serialVersionUID = 6711463880295930784L;

    private String accession;

    private VariantMutationType sequenceType;

    private ProteinChangeType changeType;

    private AlleleInfo alleleInfo;

    public ProteinVariantMutation() {
        super();
    }

    public String getAccession() {
        return accession;
    }

    public void setAccession(String accession) {
        this.accession = accession;
    }

    public VariantMutationType getSequenceType() {
        return sequenceType;
    }

    public void setSequenceType(VariantMutationType sequenceType) {
        this.sequenceType = sequenceType;
    }

    public ProteinChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(ProteinChangeType changeType) {
        this.changeType = changeType;
    }

    public AlleleInfo getAlleleInfo() {
        return alleleInfo;
    }

    public void setAlleleInfo(AlleleInfo alleleInfo) {
        this.alleleInfo = alleleInfo;
    }

    @Override
    public String toString() {
        return String.format("ProteinVariantMutation [accession=%s, sequenceType=%s, changeType=%s, alleleInfo=%s]", accession,
                sequenceType, changeType, alleleInfo);
    }

}
