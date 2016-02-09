package org.renci.hgvs.model.dna;

/**
 * http://www.hgvs.org/mutnomen/examplesDNA.html
 * 
 * @author jdr0887
 */
public enum DNAChangeType {

    SUBSTITUTION(String.format("(%s|%s)(.)>(.)", "\\*?-?\\d+", "\\*?-?\\d+_?\\+?\\*?-?\\d+")),

    DELETION(String.format("(%s|%s|%s|%s|%s|%s|%s|%s)del([A-Z]+|\\d+)?", "\\*?-?\\d+", "\\*?-?\\d+_?\\+?\\*?-?\\d+", "\\d+-\\d+_\\d+",
            "\\d+_\\d+\\+\\d+", "\\d+-\\d+_\\d+-\\d+", "\\d+\\+\\d+_\\d+\\+\\d+", "\\d+-\\d+_\\d+\\+\\d+", "\\d+-\\?_\\d+\\+\\?")),

    DUPLICATION(String.format("(%s|%s)dup(.+)?", "\\*?-?\\d+", "\\*?-?\\d+_?\\+?\\*?-?\\d+")),

    INSERTION(String.format("(%s|%s)ins(.+)", "\\*?-?\\d+", "\\*?-?\\d+_?\\+?\\*?-?\\d+")),

    INVERSION(String.format("(%s)inv(.+)?", "\\*?-?\\d+_?\\+?\\*?-?\\d+")),

    COMPLEX(String.format("(%s)del(.+)?ins(.+)", "\\*?-?\\d+_?\\+?\\*?-?\\d+"));

    private String regex;

    private DNAChangeType(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
