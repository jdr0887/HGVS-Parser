package org.renci.hgvs;

public class HGVSParserException extends Exception {

    private static final long serialVersionUID = 8621819149431866109L;

    public HGVSParserException() {
        super();
    }

    public HGVSParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public HGVSParserException(String message) {
        super(message);
    }

    public HGVSParserException(Throwable cause) {
        super(cause);
    }

}
