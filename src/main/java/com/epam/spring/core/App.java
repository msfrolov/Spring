package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.loggers.EventLogger;

public class App {

    private Client client;
    private EventLogger eventLogger;

    public App() {
    }

    public App(Client client) {
        this.client = client;
    }

    public static void main(String[] args) {
        App app = new App();
        app.logEvent("some event for user 1");
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventLogger getEventLogger() {
        return eventLogger;
    }

    public void setEventLogger(EventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }
}
