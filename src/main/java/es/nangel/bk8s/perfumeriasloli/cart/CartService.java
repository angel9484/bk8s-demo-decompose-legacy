package es.nangel.bk8s.perfumeriasloli.cart;

import es.nangel.bk8s.perfumeriasloli.inventory.InventoryItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
@ConditionalOnProperty(prefix = "cart", name = "enabled", havingValue = "true", matchIfMissing = true)
public class CartService {
    private Map<InventoryItem, Integer> cart;

    @PostConstruct
    public void init() {
        cart = new HashMap<>();
    }

    public Map<InventoryItem, Integer> addToCart(InventoryItem inventoryItem) {
        cart.compute(inventoryItem, (inventoryItem1, integer) -> {
            if (integer == null) {
                return 1;
            }
            return integer + 1;
        });
        return cart;
    }
}
