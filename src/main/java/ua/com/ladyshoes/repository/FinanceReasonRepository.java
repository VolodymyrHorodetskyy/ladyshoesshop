package ua.com.ladyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ladyshoes.entity.FinanceReason;
import ua.com.ladyshoes.entity.InputFinanceType;

import java.util.List;

@Repository
public interface FinanceReasonRepository extends JpaRepository<FinanceReason, Long> {

    List<FinanceReason> findByType(InputFinanceType type);

}
