package ua.com.ladyshoes.service;

import org.springframework.stereotype.Service;
import ua.com.ladyshoes.entity.Shoe;
import ua.com.ladyshoes.repository.ShoeRepository;

@Service
public class ShoeService {

    private ShoeRepository shoeRepository;

    public Shoe addShoe(Shoe shoe) {
        return shoeRepository.save(shoe);
    }

}
