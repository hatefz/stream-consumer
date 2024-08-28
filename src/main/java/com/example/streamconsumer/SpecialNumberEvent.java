package com.example.streamconsumer;

public class SpecialNumberEvent {
    private String specialNumber;
    private EventType eventType;

    public SpecialNumberEvent() {
    }

    public SpecialNumberEvent(String specialNumber, EventType eventType) {
        this.specialNumber = specialNumber;
        this.eventType = eventType;
    }

    public String getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(String specialNumber) {
        this.specialNumber = specialNumber;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }
}
