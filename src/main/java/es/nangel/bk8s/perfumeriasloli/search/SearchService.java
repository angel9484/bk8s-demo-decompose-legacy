package es.nangel.bk8s.perfumeriasloli.search;

import es.nangel.bk8s.perfumeriasloli.inventory.InventoryCache;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnBean(InventoryCache.class)
public class SearchService {
    private final InventoryCache inventoryCache;

    public SearchService(InventoryCache inventoryCache) {
        this.inventoryCache = inventoryCache;
    }

    public SearchResults getAllProducts() {
        return SearchResults.builder().results(inventoryCache.getSomeElements()).build();
    }
}
