package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.dto.ItemDto;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.mapper.ItemDtoMapper;
import ua.com.ladyshoes.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDto getItemById(Long id) {
        return ItemDtoMapper.convertToDto(itemRepository.findById(id).orElse(null));
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<ItemDto> getAllItemsAvailable() {
        return ItemDtoMapper.convertToDto(itemRepository.findAll());
    }


}
