package ua.com.ladyshoes.mapper;

import ua.com.ladyshoes.dto.ItemDto;
import ua.com.ladyshoes.entity.Item;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ItemDtoMapper {

    public static ItemDto convertToDto(Item item) {
        ItemDto itemDto = null;
        if (item != null) {
            itemDto = new ItemDto();
            itemDto.setId(item.getId());
            itemDto.setName(item.getName());
            itemDto.setCost(item.getCost());
            itemDto.setDescription(item.getDescription());
            itemDto.setNewPrice(item.getNewPrice());
            itemDto.setPrice(item.getPrice());
            itemDto.setNewPriceTillDate(item.getNewPriceTillDate());
            itemDto.setMaterial(item.getMaterial());
            itemDto.setImages(item.getImages());
            if (item.getNewPrice() != null) {
                itemDto.setDiscountNumberOfDays(countNumberOfDays(item.getNewPriceTillDate()));
            }
        }
        return itemDto;
    }

    public static List<ItemDto> convertToDto(List<Item> items) {
        return items.stream().map(ItemDtoMapper::convertToDto).collect(toList());
    }

    private static long countNumberOfDays(LocalDate date) {
        if (!date.isAfter(LocalDate.now())) {
            return 0;
        }
        return Math.abs(ChronoUnit.DAYS.between(date, LocalDate.now()));
    }

}
