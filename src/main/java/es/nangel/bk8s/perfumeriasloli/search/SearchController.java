package es.nangel.bk8s.perfumeriasloli.search;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findProducts")
@ConditionalOnBean(SearchService.class)
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = {""}, produces = {"application/json"}, headers = {"Accept=application/json"})
    public ResponseEntity<SearchResults> findProducts() {
        return ResponseEntity.ok(searchService.getAllProducts());
    }
}
