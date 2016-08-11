package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    //    private Client client = context.getBean("client", Client.class);
    //    private EventLogger eventLogger = context.getBean("eventLogger", EventLogger.class);

    private Client client;
    private EventLogger eventLogger;

    public App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-root.xml");
        App app = context.getBean("app", App.class);
        for (int i = 0; i < 6; i++) {
            Event event = context.getBean("event", Event.class);
            event.setMsg("some event for user 1");
            app.logEvent(event);
            sleep(1);

        }
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void logEvent(Event msg) {
        String message = msg.getMsg();
        message.replaceAll(client.getId(), client.getFullName());
        msg.setMsg(message);
        eventLogger.logEvent(msg);
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
