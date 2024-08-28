package com.example.streamconsumer;

public class OperatorEvent {

    private String name;
    private Integer price;
    private EventType eventType;

    public OperatorEvent() {
    }

    public OperatorEvent(String name, Integer price, EventType eventType) {
        this.name = name;
        this.price = price;
        this.eventType = eventType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
