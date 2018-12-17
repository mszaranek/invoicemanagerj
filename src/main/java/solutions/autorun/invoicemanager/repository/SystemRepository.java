package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.System;

@Repository
public interface SystemRepository extends JpaRepository<System, Long> {
}
