package com.epam.spring.core.loggers;

import com.epam.spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLoggerImpl extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache = new ArrayList<>();

    @Override public void logEvent(Event msg) {
        cache.add(msg);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        for (Event msg : cache) {
            super.logEvent(msg);
        }
        cache.clear();
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public void destroy() {
        writeEventsFromCache();
    }
}

