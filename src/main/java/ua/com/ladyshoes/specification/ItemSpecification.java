package ua.com.ladyshoes.specification;

import org.springframework.data.jpa.domain.Specification;
import ua.com.ladyshoes.entity.Item;
import ua.com.ladyshoes.entity.Material;
import ua.com.ladyshoes.entity.Season;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ItemSpecification implements Specification<Item> {

    private Material material;
    private Season season;

    public ItemSpecification(Material material, Season season) {
        this.material = material;
        this.season = season;
    }

    @Override
    public Predicate toPredicate(Root<Item> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        Predicate availablePredicate = criteriaBuilder.isTrue(root.get("available"));
        predicateList.add(availablePredicate);
        if (season != null) {
            Predicate seasonPredicate = criteriaBuilder.equal(root.get("season"), season);
            Predicate seasonNullPredicate = criteriaBuilder.isNull(root.get("season"));
            predicateList.add(criteriaBuilder.or(seasonPredicate,seasonNullPredicate));
        }
        if (material != null) {
            Predicate materialPredicate = criteriaBuilder.equal(root.get("material"), material);
            predicateList.add(materialPredicate);
        }
        return criteriaBuilder.and(predicateList.toArray(Predicate[]::new));
    }

}
