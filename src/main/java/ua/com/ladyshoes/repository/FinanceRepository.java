package ua.com.ladyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ladyshoes.entity.InputFinanceRecord;

@Repository
public interface FinanceRepository extends JpaRepository<InputFinanceRecord, Long> {
}
