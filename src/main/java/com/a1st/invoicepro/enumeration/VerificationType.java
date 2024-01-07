package com.a1st.invoicepro.enumeration;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */
public enum VerificationType {
    ACCOUNT("ACCOUNT"),
    PASSWORD("PASSWORD");

    private final String type;

    VerificationType(String type) { this.type = type; }

    public String getType() {
        return this.type.toLowerCase();
    }
}
