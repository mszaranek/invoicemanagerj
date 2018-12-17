package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.AppRole;

@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
}
