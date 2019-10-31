package ua.com.ladyshoes.db;

import org.springframework.stereotype.Component;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceType;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.entity.Shoe;
import ua.com.ladyshoes.service.FinanceReasonService;
import ua.com.ladyshoes.service.ItemService;
import ua.com.ladyshoes.service.ShoeService;

import javax.annotation.PostConstruct;

@Component
public class FillDB {

    private ItemService itemService;
    private FinanceReasonService reasonService;
    private ShoeService shoeService;

    public FillDB(ItemService itemService, FinanceReasonService reasonService, ShoeService shoeService) {
        this.itemService = itemService;
        this.reasonService = reasonService;
        this.shoeService = shoeService;
    }

    @PostConstruct
    public void init() {
        shoeService.addShoe(new Shoe("900", 700));
        itemService.createItem(new Item("Взуття кросівки"));
        reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "передпалата", "олх"));
    }

}
