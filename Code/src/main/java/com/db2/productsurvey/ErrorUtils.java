package com.db2.productsurvey;

public class ErrorUtils {
    public static String getErrorPagePathFromContext(Error error) {
        return "/error.jsp?code="+error.name();
    }
}
