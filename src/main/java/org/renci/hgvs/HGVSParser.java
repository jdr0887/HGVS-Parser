package org.renci.hgvs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.renci.hgvs.model.VariantMutationType;
import org.renci.hgvs.model.dna.ComplexAlleleInfo;
import org.renci.hgvs.model.dna.DNAChangeType;
import org.renci.hgvs.model.dna.DNAVariantMutation;
import org.renci.hgvs.model.dna.DeletionAlleleInfo;
import org.renci.hgvs.model.dna.DuplicationAlleleInfo;
import org.renci.hgvs.model.dna.InsertionAlleleInfo;
import org.renci.hgvs.model.dna.InversionAlleleInfo;
import org.renci.hgvs.model.dna.SubstitutionAlleleInfo;
import org.renci.hgvs.model.protein.ProteinVariantMutation;

public class HGVSParser {

    private static HGVSParser instance;

    public static HGVSParser getInstance() {
        if (instance == null) {
            instance = new HGVSParser();
        }
        return instance;
    }

    private HGVSParser() {
        super();
    }

    public VariantMutationType determineType(String hgvs) throws HGVSParserException {
        VariantMutationType ret = null;
        if (!hgvs.contains(":")) {
            throw new HGVSParserException("Invalid Format: no ':' found");
        }
        String letter = hgvs.substring(hgvs.indexOf(":") + 1, hgvs.indexOf(":") + 2);
        for (VariantMutationType variantMutationType : VariantMutationType.values()) {
            if (variantMutationType.getValue().equals(letter)) {
                ret = variantMutationType;
                break;
            }
        }
        return ret;
    }

    public DNAVariantMutation parseDNAMutation(String hgvs) throws HGVSParserException {
        DNAVariantMutation ret = new DNAVariantMutation();
        try {

            ret.setSequenceType(determineType(hgvs));

            String change = hgvs.substring(hgvs.indexOf(":") + 3, hgvs.length());
            for (DNAChangeType changeType : DNAChangeType.values()) {
                String regex = changeType.getRegex();
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(change);
                if (m.matches()) {
                    ret.setChangeType(changeType);
                    switch (ret.getChangeType()) {
                        case DUPLICATION:
                            ret.setAlleleInfo(new DuplicationAlleleInfo(m.group(1), m.group(2)));
                            break;
                        case DELETION:
                            String numeric = m.group(2);
                            DeletionAlleleInfo deletionAlleleInfo = new DeletionAlleleInfo(m.group(1));
                            if (NumberUtils.isNumber(numeric)) {
                                deletionAlleleInfo.setBaseLength(Integer.valueOf(numeric));
                            } else {
                                deletionAlleleInfo.setBases(m.group(2));
                            }
                            ret.setAlleleInfo(deletionAlleleInfo);
                            break;
                        case INSERTION:
                            ret.setAlleleInfo(new InsertionAlleleInfo(m.group(1), m.group(2)));
                            break;
                        case SUBSTITUTION:
                            ret.setAlleleInfo(new SubstitutionAlleleInfo(m.group(1), m.group(2), m.group(3)));
                            break;
                        case INVERSION:
                            ret.setAlleleInfo(new InversionAlleleInfo(m.group(1), m.group(2)));
                            break;
                        case COMPLEX:
                            if (m.groupCount() > 2) {
                                ret.setAlleleInfo(new ComplexAlleleInfo(m.group(1), m.group(3), m.group(2)));
                            } else {
                                ret.setAlleleInfo(new ComplexAlleleInfo(m.group(1), m.group(2)));
                            }
                            break;
                    }

                    break;
                }

            }
        } catch (NumberFormatException e) {
            throw new HGVSParserException(e);
        }

        return ret;
    }

    public ProteinVariantMutation parseProteinMutation(String hgvs) throws HGVSParserException {
        throw new HGVSParserException("Not currently implemented");
    }

}
