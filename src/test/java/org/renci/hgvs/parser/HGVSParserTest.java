package org.renci.hgvs.parser;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.renci.hgvs.HGVSParser;
import org.renci.hgvs.HGVSParserException;
import org.renci.hgvs.model.dna.ComplexAlleleInfo;
import org.renci.hgvs.model.dna.DNAChangeType;
import org.renci.hgvs.model.dna.DNAVariantMutation;
import org.renci.hgvs.model.dna.DeletionAlleleInfo;
import org.renci.hgvs.model.dna.DuplicationAlleleInfo;
import org.renci.hgvs.model.dna.SubstitutionAlleleInfo;

public class HGVSParserTest {

    @Test
    public void duplication() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_006642.3:c.1339dupG");
        assertTrue(a.getChangeType().equals(DNAChangeType.DUPLICATION));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getBases().equals("G"));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getLocation().equals("1339"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_015600.4:c.846_852dupTAAGAGC");
        assertTrue(a.getChangeType().equals(DNAChangeType.DUPLICATION));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getBases().equals("TAAGAGC"));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getLocation().equals("846_852"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_000828.4:c.-2dupG");
        assertTrue(a.getChangeType().equals(DNAChangeType.DUPLICATION));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getBases().equals("G"));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getLocation().equals("-2"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_014049.4:c.-44_-41dupTAAG");
        assertTrue(a.getChangeType().equals(DNAChangeType.DUPLICATION));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getBases().equals("TAAG"));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getLocation().equals("-44_-41"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001142620.1:c.*230dupG");
        assertTrue(a.getChangeType().equals(DNAChangeType.DUPLICATION));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getBases().equals("G"));
        assertTrue(((DuplicationAlleleInfo) a.getAlleleInfo()).getLocation().equals("*230"));
    }

    @Test
    public void deletion() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_152269.4:c.248delT");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases().equals("T"));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("248"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_002036.3:c.286_299delTGGCCTGTCCTGGC");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases().equals("TGGCCTGTCCTGGC"));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("286_299"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001171814.1:c.11-5_14del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("11-5_14"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001195302.1:c.629_639+1del12");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength().equals(12));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("629_639+1"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_173560.3:c.779_780+12del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("779_780+12"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_203447.3:c.1126-395_2971-2751del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("1126-395_2971-2751"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_000646.2:c.-174_-173delGA");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases().equals("GA"));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("-174_-173"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001193311.1:c.-709del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("-709"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001135024.1:c.115+256_115+259delGAAG");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases().equals("GAAG"));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("115+256_115+259"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001166158.1:c.342+12891del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("342+12891"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_003477.2:c.1183-3088_1247+760del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("1183-3088_1247+760"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_000158.3:c.993-?_1618+?del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("993-?_1618+?"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_000158.3:c.993-?_1618+?del");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("993-?_1618+?"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001142777.1:c.*285_*286delCT");
        assertTrue(a.getChangeType().equals(DNAChangeType.DELETION));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBases().equals("CT"));
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getBaseLength() == null);
        assertTrue(((DeletionAlleleInfo) a.getAlleleInfo()).getLocation().equals("*285_*286"));

    }

    @Test
    public void insertion() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:c.76_77insG");
        assertTrue(a.getChangeType().equals(DNAChangeType.INSERTION));
    }

    @Test
    public void inversion() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:g.1077_1080inv");
        assertTrue(a.getChangeType().equals(DNAChangeType.INVERSION));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:c.77_80invCTGA");
        assertTrue(a.getChangeType().equals(DNAChangeType.INVERSION));
    }

    @Test
    public void substitution() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:c.127C>T");
        assertTrue(a.getChangeType().equals(DNAChangeType.SUBSTITUTION));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getLocation().equals("127"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getWildtype().equals("C"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getMutation().equals("T"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:c.127-16C>T");
        assertTrue(a.getChangeType().equals(DNAChangeType.SUBSTITUTION));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getLocation().equals("127-16"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getWildtype().equals("C"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getMutation().equals("T"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001256819.1:c.*142T>G");
        assertTrue(a.getChangeType().equals(DNAChangeType.SUBSTITUTION));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getLocation().equals("*142"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getWildtype().equals("T"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getMutation().equals("G"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001040613.2:c.*7-2A>G");
        assertTrue(a.getChangeType().equals(DNAChangeType.SUBSTITUTION));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getLocation().equals("*7-2"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getWildtype().equals("A"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getMutation().equals("G"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001286044.1:c.-100+670A>C");
        assertTrue(a.getChangeType().equals(DNAChangeType.SUBSTITUTION));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getLocation().equals("-100+670"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getWildtype().equals("A"));
        assertTrue(((SubstitutionAlleleInfo) a.getAlleleInfo()).getMutation().equals("C"));

    }

    @Test
    public void complex() throws HGVSParserException {
        DNAVariantMutation a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:g.712_717delinsTG");
        assertTrue(a.getChangeType().equals(DNAChangeType.COMPLEX));
        assertTrue(((ComplexAlleleInfo) a.getAlleleInfo()).getInserts().equals("TG"));

        a = HGVSParser.getInstance().parseDNAMutation("NM_001017995.2:g.712_717delAGGGCAinsTG");
        assertTrue(a.getChangeType().equals(DNAChangeType.COMPLEX));
        assertTrue(((ComplexAlleleInfo) a.getAlleleInfo()).getInserts().equals("TG"));
    }

}
