package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItemsAvailable() {
        return itemRepository.findAll();
    }


}
