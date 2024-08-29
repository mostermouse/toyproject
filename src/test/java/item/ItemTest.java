package item;

import com.toyproject.toyproject.item.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {
    @Test
    void ItemTest1(){
        Item item = Item.builder().size(10).build();
    }
}
