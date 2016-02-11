package org.renci.hgvs.parser;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Scratch {

    @Test
    public void scratch() {
        Pattern p = Pattern.compile("\\[=/\\d+_\\d+del\\d+\\]");
        Matcher m = p.matcher("[=/3426_3452del27]");
        assertTrue(m.matches());
        System.out.println(m.group(0));
    }
}
