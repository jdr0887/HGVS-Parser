package org.renci.hgvs.parser;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.renci.hgvs.HGVSParser;
import org.renci.hgvs.model.ChangeType;
import org.renci.hgvs.model.ComplexChangeAction;
import org.renci.hgvs.model.Variant;

public class HGVSParserTest {

    @Test
    public void duplication() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:c.147dupT");
        assertTrue(a.getChangeType().equals(ChangeType.DUPLICATION));

        a = HGVSParser.getInstance().parse("NM_001017995.2:g.147_148dup");
        assertTrue(a.getChangeType().equals(ChangeType.DUPLICATION));
    }

    @Test
    public void deletion() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:c.969delG");
        assertTrue(a.getChangeType().equals(ChangeType.DELETION));

        a = HGVSParser.getInstance().parse("NM_001017995.2:g.-11_-4del");
        assertTrue(a.getChangeType().equals(ChangeType.DELETION));
    }

    @Test
    public void insertion() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:c.76_77insG");
        assertTrue(a.getChangeType().equals(ChangeType.INSERTION));
    }

    @Test
    public void inversion() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:g.1077_1080inv");
        assertTrue(a.getChangeType().equals(ChangeType.INVERSION));

        a = HGVSParser.getInstance().parse("NM_001017995.2:c.77_80invCTGA");
        assertTrue(a.getChangeType().equals(ChangeType.INVERSION));
    }

    @Test
    public void substitution() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:c.127C>T");
        assertTrue(a.getChangeType().equals(ChangeType.SUBSTITUTION));
    }

    @Test
    public void complex() {
        Variant a = HGVSParser.getInstance().parse("NM_001017995.2:g.712_717delinsTG");
        assertTrue(a.getChangeType().equals(ChangeType.COMPLEX));
        assertTrue(((ComplexChangeAction) a.getChangeAction()).getInserts().equals("TG"));
        
        a = HGVSParser.getInstance().parse("NM_001017995.2:g.712_717delAGGGCAinsTG");
        assertTrue(a.getChangeType().equals(ChangeType.COMPLEX));
        assertTrue(((ComplexChangeAction) a.getChangeAction()).getInserts().equals("TG"));
    }

}
