package ua.com.ladyshoes.dto;

import java.util.List;

public class GetAllItemsResponse {

    private List<ItemDto> items;
    private long itemsAmount;

    public GetAllItemsResponse() {
    }

    public GetAllItemsResponse(List<ItemDto> items, long itemsAmount) {
        this.items = items;
        this.itemsAmount = itemsAmount;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public long getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(long itemsAmount) {
        this.itemsAmount = itemsAmount;
    }
}
