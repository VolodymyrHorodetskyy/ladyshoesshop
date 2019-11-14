package ua.com.ladyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.ladyshoes.entity.InputFinanceRecord;

import java.util.List;

@Repository
public interface FinanceRepository extends JpaRepository<InputFinanceRecord, Long> {

    List<InputFinanceRecord> findByRemovedFalse();

}
