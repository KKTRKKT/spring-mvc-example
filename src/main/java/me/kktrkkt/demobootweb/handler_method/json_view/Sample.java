package me.kktrkkt.demobootweb.handler_method.json_view;

import com.fasterxml.jackson.annotation.JsonView;

public class Sample {

    @JsonView(SampleJson.List.class)
    private Long id;

    @JsonView(SampleJson.List.class)
    private String name;

    @JsonView(SampleJson.Details.class)
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
