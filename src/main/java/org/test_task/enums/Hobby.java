package org.test_task.enums;

public enum Hobby {

    SPORTS("//input[@id='hobbies-checkbox-1']"),
    READING("//input[@id='hobbies-checkbox-2']"),
    MUSIC("//input[@id='hobbies-checkbox-3']");

    private final String xpath;

    Hobby(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}