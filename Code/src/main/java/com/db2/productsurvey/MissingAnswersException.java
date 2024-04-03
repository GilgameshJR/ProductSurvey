package com.db2.productsurvey;

public class MissingAnswersException extends Exception {
    public MissingAnswersException(String err) {
        super(err);
    }
}
