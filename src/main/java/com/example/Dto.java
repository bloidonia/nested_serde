package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public class Dto {

    private final Object[] data;

    public Dto(Object[] data) {
        this.data = data;
    }

    public Object[] getData() {
        return data;
    }
}
