package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

public class ConsoleEventLogger implements EventLogger {

    public ConsoleEventLogger() {
    }

    @Override
    public void logEvent(Event msg){
        System.out.println(msg);
    }
}
