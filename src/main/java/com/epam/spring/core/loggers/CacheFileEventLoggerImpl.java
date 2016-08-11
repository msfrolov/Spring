package com.epam.spring.core.loggers;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLoggerImpl extends FileEventLogger {

    private int cacheSize;
    private List<String> cache = new ArrayList<>();

    @Override public void logEvent(String msg) {
        cache.add(msg);
        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (String msg : cache) {
            super.logEvent(msg);
        }
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }
}

