package ua.com.ladyshoes.db;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ua.com.ladyshoes.entity.*;
import ua.com.ladyshoes.service.FinanceReasonService;
import ua.com.ladyshoes.service.ImageService;
import ua.com.ladyshoes.service.ItemService;
import ua.com.ladyshoes.service.ShoeService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
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


            Item item = new Item("Взуття Dr Martens на коричневій підошві", "шкіра", 1299d, 780d, images, Material.LEATHER);
            itemService.createItem(item);
            images.add(new Image("test/195/DSC00780.jpg", item, true));
            images.add(new Image("test/195/DSC00758.jpg", item, false));
            imageService.saveImage(images);

            Item item2 = new Item("Взуття Dr Martens на підошві з жовтою ниткою", "шкіра", 1599d, 780d, images, Material.LEATHER);
            item2.setNewPrice(1299d);
            item2.setNewPriceTillDate(LocalDate.now().plusDays(1));
            itemService.createItem(item2);
            List images2 = new ArrayList<Image>();
            images2.add(new Image("test/190ж/DSC00708.jpg", item2, true));
            images2.add(new Image("test/190ж/DSC00707.jpg", item2, false));
            images2.add(new Image("test/190ж/DSC00693.jpg", item2, false));
            imageService.saveImage(images2);

            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "передпалата", "олх"));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "повна оплата", "олх"));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.INCOME, "olx доставка", "олх"));

            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "реклама", ""));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "собівартість", ""));
            reasonService.addFinanceReason(new FinanceReason(InputFinanceType.EXPENSE, "повернення", ""));
        }
    }

}
