package es.nangel.bk8s.perfumeriasloli.search;

import es.nangel.bk8s.perfumeriasloli.inventory.InventoryItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchResults {
    private List<InventoryItem> results;
}
