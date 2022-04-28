package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class MyController {

    @Get("/flat")
    @Produces(MediaType.APPLICATION_JSON)
    public Dto flat() {
        return new Dto(new Object[]{"Hello", "World"});
    }

    @Get("/nested")
    @Produces(MediaType.APPLICATION_JSON)
    public Dto nested() {
        return new Dto(new Object[]{"Hello", new Object[] { "World" }});
    }
}
