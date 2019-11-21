package ua.com.ladyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ladyshoes.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
