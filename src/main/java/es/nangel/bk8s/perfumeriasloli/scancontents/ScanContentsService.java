package es.nangel.bk8s.perfumeriasloli.scancontents;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "scan", name = "enabled", havingValue = "true", matchIfMissing = true)
public class ScanContentsService {

    public void scanAHeavyProcess() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
