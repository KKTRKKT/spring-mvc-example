package me.kktrkkt.demobootweb.handler_method.form_submit;

public class Event {

    private Long id;

    private String name;

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
