package ua.com.ladyshoes.controller;

import org.springframework.web.bind.annotation.*;
import ua.com.ladyshoes.dto.GetAllItemsResponse;
import ua.com.ladyshoes.dto.ItemDto;
import ua.com.ladyshoes.service.ItemService;

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

    @GetMapping(params = {"page", "size"})
    public GetAllItemsResponse getAllAvailable(@RequestParam("page") int page, @RequestParam("size") int size) {
        return itemService.getAllItemsAvailable(page, size);
    }
}
