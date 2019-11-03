package com.febatis.memorystress.enumeration;

public enum BitmapSize {
    RESOLUTION_720P("720p"),
    RESOLUTION_1080P("1080p"),
    RESOLUTION_6000X3000("6000 X 3000");

    private String description;

    BitmapSize(String description) {
        this.description = description;
    }

    public static BitmapSize valueByDescription(String description) {

        for (BitmapSize value : values()) {
            if (value.description.equals(description)) {
                return value;
            }
        }

        return null;
    }

}
