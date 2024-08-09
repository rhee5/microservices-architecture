package com.fenics.monitor.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class AlertRunnable implements Runnable {

    private static Logger logger = LogManager.getLogger(AlertRunnable.class);

    @Value("${heap-monitor.memory.threshold:50}")
    protected double memoryUsageThreshold;

    protected double usedMemoryPercentage;

    public void setParameters(double usedMemoryPercentage){
        this.usedMemoryPercentage = usedMemoryPercentage;
    }

    @Override
    public void run() {
        System.out.println("ALERT: Java heap space usage exceeds " +memoryUsageThreshold+ "%. Current usage: "+usedMemoryPercentage*100+"%");
        logger.warn("ALERT: Java heap space usage exceeds {}%. Current usage: {}%", memoryUsageThreshold, usedMemoryPercentage * 100);
    }
}


