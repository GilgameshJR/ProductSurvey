package com.db2.productsurvey;

public enum Sex {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    public final String label;

    private Sex(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
