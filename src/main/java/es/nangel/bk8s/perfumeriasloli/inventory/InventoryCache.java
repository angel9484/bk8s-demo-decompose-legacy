package es.nangel.bk8s.perfumeriasloli.inventory;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.javafaker.Faker;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
@ConditionalOnProperty(prefix = "cache.inventory", name = "enabled", havingValue = "true", matchIfMissing = true)
public class InventoryCache {
    private @NonNull Cache<String, InventoryItem> inventoryCache;

    @PostConstruct
    public void init() {
        Faker faker = new Faker();
        inventoryCache = Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES).build();
        for (int i = 0; i < 30000; ++i) {
            String name = faker.beer().name();
            inventoryCache.put(name, InventoryItem.builder().name(name).price((float) faker.random().nextDouble()).build());
        }
    }

    public List<InventoryItem> getSomeElements() {
        List<InventoryItem> items = new ArrayList<InventoryItem>();
        Random rnd = new Random();
        for (int i = 0; i < 30; ++i) {
            Collection<InventoryItem> values = inventoryCache.asMap().values();
            int sizeOfCache = values.size();
            int itemIndex = rnd.nextInt(sizeOfCache - 1);
            ArrayList<InventoryItem> inventoryItems = new ArrayList<InventoryItem>(values);
            items.add(inventoryItems.get(itemIndex));
        }
        return items;
    }
}
