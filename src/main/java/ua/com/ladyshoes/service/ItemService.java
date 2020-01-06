package ua.com.ladyshoes.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.ladyshoes.dto.GetAllItemsResponse;
import ua.com.ladyshoes.dto.ItemDto;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.entity.Material;
import ua.com.ladyshoes.entity.Season;
import ua.com.ladyshoes.mapper.ItemDtoMapper;
import ua.com.ladyshoes.repository.ItemRepository;
import ua.com.ladyshoes.specification.ItemSpecification;

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

    public GetAllItemsResponse getAllItemsAvailable(int page, int size, Material material, Season season) {
        Page itemsPage = itemRepository.findAll(new ItemSpecification(material, season), PageRequest.of(page, size));
        return new GetAllItemsResponse(ItemDtoMapper.convertToDto(itemsPage.getContent()), itemsPage.getTotalElements());

    }

}
