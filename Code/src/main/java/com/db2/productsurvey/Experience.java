package com.db2.productsurvey;

public enum Experience {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High");

    public final String label;

    private Experience(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
