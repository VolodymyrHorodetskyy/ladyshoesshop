package ua.com.ladyshoes.db;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ua.com.ladyshoes.entity.*;
import ua.com.ladyshoes.service.FinanceReasonService;
import ua.com.ladyshoes.service.ImageService;
import ua.com.ladyshoes.service.ItemService;
import ua.com.ladyshoes.service.ShoeService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class FillDB {

    private ItemService itemService;
    private FinanceReasonService reasonService;
    private ShoeService shoeService;
    private ImageService imageService;

    public FillDB(ItemService itemService, FinanceReasonService reasonService, ShoeService shoeService, ImageService imageService) {
        this.itemService = itemService;
        this.reasonService = reasonService;
        this.shoeService = shoeService;
        this.imageService = imageService;
    }

    @PostConstruct
    public void init() {
        if (CollectionUtils.isEmpty(shoeService.getAllShoes())) {
            shoeService.addShoe(new Shoe("900", 700));
            List images = new ArrayList<Image>();


            Item item = new Item("Взуття кросівки", "шкіра", 1299d, 780d, images);
            itemService.createItem(item);
            images.add(new Image("test/Lakeland_3442-2-400x300.jpg", item, true));
            imageService.saveImage(images);

            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "передпалата", "олх"));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "повна оплата", "олх"));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "olx доставка", "олх"));

            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "реклама", ""));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "собівартість", ""));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "повернення", ""));
        }
    }

}
