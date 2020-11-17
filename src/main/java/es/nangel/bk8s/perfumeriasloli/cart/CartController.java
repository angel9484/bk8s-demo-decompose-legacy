package es.nangel.bk8s.perfumeriasloli.cart;

import es.nangel.bk8s.perfumeriasloli.inventory.InventoryItem;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/addToCart")
@ConditionalOnBean(CartService.class)
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = {""}, produces = {"application/json"}, headers = {"Accept=application/json"})
    public ResponseEntity<Map<InventoryItem, Integer>> findProducts(@RequestBody InventoryItem inventoryItem) {
        return ResponseEntity.ok(cartService.addToCart(inventoryItem));
    }
}
