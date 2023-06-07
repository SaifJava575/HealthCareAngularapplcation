package in.nareshit.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nareshit.raghu.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {


}
