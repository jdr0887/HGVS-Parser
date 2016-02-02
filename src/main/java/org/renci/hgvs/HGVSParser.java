package org.renci.hgvs;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.Range;
import org.renci.hgvs.model.ChangeType;
import org.renci.hgvs.model.ComplexChangeAction;
import org.renci.hgvs.model.DeletionChangeAction;
import org.renci.hgvs.model.DuplicationChangeAction;
import org.renci.hgvs.model.InsertionChangeAction;
import org.renci.hgvs.model.InversionChangeAction;
import org.renci.hgvs.model.SequenceType;
import org.renci.hgvs.model.SubstitutionChangeAction;
import org.renci.hgvs.model.VariantMutation;

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

    public VariantMutation parse(String hgvs) {
        VariantMutation ret = new VariantMutation();
        if (hgvs.contains(":")) {
            ret.setAccession(hgvs.substring(0, hgvs.indexOf(":")));
            String letter = hgvs.substring(hgvs.indexOf(":") + 1, hgvs.indexOf(":") + 2);
            for (SequenceType sequenceType : SequenceType.values()) {
                if (sequenceType.getValue().equals(letter)) {
                    ret.setSequenceType(sequenceType);
                    break;
                }
            }

            Integer start = null;
            Integer end = null;

            String change = hgvs.substring(hgvs.indexOf(":") + 3, hgvs.length());
            for (ChangeType changeType : ChangeType.values()) {

                List<String> regexes = changeType.getRegexes();

                for (String regex : regexes) {
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(change);
                    if (m.matches()) {
                        ret.setChangeType(changeType);
                        String position = m.group(1);
                        if (position.contains("_")) {
                            start = Integer.valueOf(position.substring(0, position.indexOf("_")));
                            end = Integer.valueOf(position.substring(position.indexOf("_") + 1, position.length()));
                        } else {
                            start = Integer.valueOf(position);
                            end = start;
                        }
                        ret.setRange(Range.between(start, end));
                        switch (ret.getChangeType()) {
                            case DUPLICATION:
                                ret.setChangeAction(new DuplicationChangeAction(m.group(2)));
                                break;
                            case DELETION:
                                ret.setChangeAction(new DeletionChangeAction(m.group(2)));
                                break;
                            case INSERTION:
                                ret.setChangeAction(new InsertionChangeAction(m.group(2)));
                                break;
                            case SUBSTITUTION:
                                ret.setChangeAction(new SubstitutionChangeAction(m.group(2), m.group(3)));
                                break;
                            case INVERSION:
                                ret.setChangeAction(new InversionChangeAction(m.group(2)));
                                break;
                            case COMPLEX:
                                if (m.groupCount() > 2) {
                                    ret.setChangeAction(new ComplexChangeAction(m.group(3), m.group(2)));
                                } else {
                                    ret.setChangeAction(new ComplexChangeAction(m.group(2)));
                                }
                                break;
                        }

                        break;
                    }

                }

            }

        }

        return ret;
    }
}
