package org.renci.hgvs.model;

/*
 * "c." for a coding DNA sequence (like  c.76A>T)
 * "g." for a genomic sequence (like g.476A>T)
 * "m." for a mitochondrial sequence (like m.8993T>C, see Reference Sequence)
 * "n" for a non-coding RNA reference sequence (gene producing an RNA transcript but not a protein, see Community consultation 002)
 * "r." for an RNA sequence (like r.76a>u)
 * "p." for a protein sequence (like  p.Lys76Asn)
*/
public enum VariantMutationType {

    CODING_DNA_SEQUENCE("c"),

    GENOMIC_SEQUENCE("g"),

    MITOCHONDRIAL_SEQUENCE("m"),

    RNA_SEQUENCE("r"),

    NON_CODING_RNA_SEQUENCE("n"),

    PROTEIN_SEQUENCE("p");

    private String value;

    private VariantMutationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
