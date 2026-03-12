package org.test_task.enums;

public enum Gender {

    MALE("//label[@for='gender-radio-1']"),
    FEMALE("//label[@for='gender-radio-2']"),
    OTHER("//label[@for='gender-radio-3']");

    private final String xpath;

    Gender(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}