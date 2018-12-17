package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.ProjRole;

@Repository
public interface ProjRoleRepository extends JpaRepository<ProjRole, Long> {
}
