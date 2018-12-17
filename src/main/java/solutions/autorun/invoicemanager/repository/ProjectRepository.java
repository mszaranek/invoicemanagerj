package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
