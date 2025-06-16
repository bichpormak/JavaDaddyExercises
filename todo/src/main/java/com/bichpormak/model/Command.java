package com.bichpormak.model;

public enum Command {

    ADD("add"),
    LIST("list"),
    EDIT("edit"),
    DELETE("delete"),
    FILTER("filter"),
    SORT("sort"),
    EXIT("exit");

    private String name;

    Command(String name) {
        this.name = name;
    }

}
