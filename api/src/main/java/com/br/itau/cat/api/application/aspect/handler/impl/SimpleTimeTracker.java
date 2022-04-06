package com.br.itau.cat.api.application.aspect.handler.impl;

import com.br.itau.cat.api.application.aspect.handler.TimeTracker;
import com.br.itau.cat.api.application.aspect.handler.Timer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleTimeTracker implements TimeTracker {
    private static final Logger logger = LoggerFactory.getLogger(SimpleTimeTracker.class);

    public SimpleTimeTracker() {
    }

    public Timer start(String tag) {
        return new SimpleTimer(tag, System.currentTimeMillis(), logger);
    }
}
