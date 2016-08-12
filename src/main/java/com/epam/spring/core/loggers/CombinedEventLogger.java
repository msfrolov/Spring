package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override public void logEvent(Event msg) {
        for (EventLogger logger : loggers) {
            logger.logEvent(msg);
        }
    }
}
