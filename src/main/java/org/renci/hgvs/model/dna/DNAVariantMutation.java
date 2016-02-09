package org.renci.hgvs.model.dna;

import java.io.Serializable;

import org.apache.commons.lang3.Range;
import org.renci.hgvs.model.AlleleInfo;
import org.renci.hgvs.model.VariantMutationType;

public class DNAVariantMutation implements Serializable {

    private static final long serialVersionUID = 6711463880295930784L;

    private String accession;

    private VariantMutationType sequenceType;

    private DNAChangeType changeType;

    private AlleleInfo alleleInfo;

    public DNAVariantMutation() {
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

    public DNAChangeType getChangeType() {
        return changeType;
    }

    public void setChangeType(DNAChangeType changeType) {
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
        return String.format("VariantMutation [accession=%s, sequenceType=%s, changeType=%s, alleleInfo=%s]", accession, sequenceType,
                changeType, alleleInfo);
    }

}
