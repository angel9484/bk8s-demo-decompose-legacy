package es.nangel.bk8s.perfumeriasloli.scancontents;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "scan", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableScheduling
public class ScanContentsSchedulerService {
    private final ScanContentsController scanContentsController;

    public ScanContentsSchedulerService(ScanContentsController scanContentsController) {
        this.scanContentsController = scanContentsController;
    }

    @Scheduled(fixedRateString = "3000")
    public void scanAHeavyProcess() {
        scanContentsController.scan();
    }
}
