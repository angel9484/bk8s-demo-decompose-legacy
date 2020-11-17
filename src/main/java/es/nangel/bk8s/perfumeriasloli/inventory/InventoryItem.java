package es.nangel.bk8s.perfumeriasloli.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryItem {
    private float price;
    private String name;
}
