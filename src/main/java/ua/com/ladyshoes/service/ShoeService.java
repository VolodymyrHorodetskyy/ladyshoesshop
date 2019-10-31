package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.Shoe;
import ua.com.ladyshoes.repository.ShoeRepository;

import java.util.List;

@Service
public class ShoeService {

    private ShoeRepository shoeRepository;

    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public Shoe addShoe(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

    public List<Shoe> getAllShoes() {
        return shoeRepository.findAll();
    }

}
