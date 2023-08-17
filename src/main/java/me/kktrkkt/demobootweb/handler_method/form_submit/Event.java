package me.kktrkkt.demobootweb.handler_method.form_submit;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Event {

    interface NameValidation{};

    interface LimitValidation{};

    private Long id;

    @NotBlank(groups = NameValidation.class)
    private String name;

    @Min(value = 0, groups = LimitValidation.class)
    private int limit;

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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", limit=" + limit +
                '}';
    }
}
