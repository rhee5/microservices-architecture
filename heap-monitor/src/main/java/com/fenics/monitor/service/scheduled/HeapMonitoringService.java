package com.fenics.monitor.service.scheduled;

import com.fenics.monitor.model.AlertRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;


@Service
public class HeapMonitoringService {

    @Value("${heap-monitor.memory.threshold:50}")
    private double memoryUsageThreshold;

    @Autowired
    private AlertRunnable alertRunnable;

    @Scheduled(fixedRateString = "${heap-monitor.frequency:5000}") //36000}")
    public void alarmTask() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();

        double usedMemory = heapMemoryUsage.getUsed();
        double maxMemory = heapMemoryUsage.getMax();

        double usedMemoryPercentage = usedMemory / maxMemory;

        if (usedMemoryPercentage > memoryUsageThreshold/100) {
            alertRunnable.setParameters(usedMemoryPercentage);
            alertRunnable.run();
        }
    }
}