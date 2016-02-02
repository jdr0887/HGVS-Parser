package org.renci.hgvs.model;

import java.util.Arrays;
import java.util.List;

/**
 * http://www.hgvs.org/mutnomen/examplesDNA.html
 * 
 * @author jdr0887
 */
public enum ChangeType {

    SUBSTITUTION(Arrays.asList("(-?\\d+|-?\\d+_-?\\d+|\\d+\\+?\\d+|\\d+-?\\d+)(.)>(.)")),

    DELETION(Arrays.asList("(-?\\d+|-?\\d+_-?\\d+)del(.+)?")),

    DUPLICATION(Arrays.asList("(-?\\d+|-?\\d+_-?\\d+)dup(.+)?")),

    INSERTION(Arrays.asList("(-?\\d+|-?\\d+_-?\\d+)ins(.+)")),

    INVERSION(Arrays.asList("(-?\\d+_-?\\d+)inv(.+)?")),

    COMPLEX(Arrays.asList("(-?\\d+_-?\\d+)del(.+)?ins(.+)"));

    private List<String> regexes;

    private ChangeType(List<String> regexes) {
        this.regexes = regexes;
    }

    public List<String> getRegexes() {
        return regexes;
    }

    public void setRegexes(List<String> regexes) {
        this.regexes = regexes;
    }

}
