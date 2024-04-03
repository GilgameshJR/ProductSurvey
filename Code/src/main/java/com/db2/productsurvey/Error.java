package com.db2.productsurvey;

public enum Error {
    MISSINGPARAMETER("A parameter in the request is missing."),
    ILLEGALPARAMETER("Parameter type wrong, check your inputs"),
    WRONGCREDENTIALS("Wrong credentials, try again"),
    GENERICERROR("Generic error occurred"),
    NOQUESTIONNAIRE("No questionnaire found"),
    MEMBER_QUESTIONNAIREALREADYSUMBITTED("You already submitted the questionnaire, try tomorrow"),
    MEMBER_OFFENSIVEWORD("Offensive words. You have been blocked forever"),
    MEMBER_BLOCKED("You have been blocked forever"),
    ADMIN_CREATIONONPASTDATE("Cannot create a questionnaire for a past date, only for present or future"),
    ADMIN_QUESTIONNAIREALREADYEXIST("A questionnaire already exists for the selected date");

    public final String description;

    Error(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}