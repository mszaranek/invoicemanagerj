package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.Sprint;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
}
