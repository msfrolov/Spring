package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

import static com.epam.spring.core.EventType.ERROR;
import static com.epam.spring.core.EventType.INFO;

public class App {

    //    private Client client = context.getBean("client", Client.class);
    //    private EventLogger eventLogger = context.getBean("eventLogger", EventLogger.class);

    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggerMap;

    public App() {
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggerMap) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggerMap = loggerMap;
    }

    public static void main(String[] args) {
        ApplicationContext contextRoot = new ClassPathXmlApplicationContext("spring-root.xml");
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(new String[] {"spring-particular.xml"}, contextRoot);
        App app = context.getBean("app", App.class);

        Event event1 = context.getBean("event", Event.class);
        event1.setMsg("some event for user 1");
        app.logEvent(ERROR, event1);
        Event event2 = context.getBean("event", Event.class);
        event2.setMsg("some event for user 1");
        app.logEvent(INFO, event2);
        Event event3 = context.getBean("event", Event.class);
        event3.setMsg("some event for user 1");
        app.logEvent(event3);
        context.close();
    }

    private void logEvent(EventType type, Event msg) {
        EventLogger logger = loggerMap.get(type);
        if (logger == null) {
            logger = this.eventLogger;
        }
        String message = msg.getMsg();
        message.replaceAll(client.getId(), client.getFullName());
        msg.setMsg(message);
        logger.logEvent(msg);
    }

    private void logEvent(Event msg) {
        logEvent(null, msg);
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
