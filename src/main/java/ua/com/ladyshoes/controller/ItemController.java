package ua.com.ladyshoes.controller;

import org.springframework.web.bind.annotation.*;
import ua.com.ladyshoes.dto.ItemDto;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.service.ItemService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/ishealthy")
    public String isHealthy() {
        return "healthy";
    }

    @GetMapping("/{id}")
    public ItemDto getById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    public List<ItemDto> getAllAvailable(){
        return itemService.getAllItemsAvailable();
    }
}
