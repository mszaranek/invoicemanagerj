package solutions.autorun.invoicemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import solutions.autorun.invoicemanager.domain.Invoice;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
