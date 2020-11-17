package es.nangel.bk8s.perfumeriasloli.scancontents;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scanContents")
@ConditionalOnBean(ScanContentsService.class)
public class ScanContentsController {
    private final ScanContentsService scanContentsService;

    public ScanContentsController(ScanContentsService scanContentsService) {
        this.scanContentsService = scanContentsService;
    }

    @PostMapping(value = {""}, produces = {"application/json"}, headers = {"Accept=application/json"})
    public void scan() {
        scanContentsService.scanAHeavyProcess();
    }
}
