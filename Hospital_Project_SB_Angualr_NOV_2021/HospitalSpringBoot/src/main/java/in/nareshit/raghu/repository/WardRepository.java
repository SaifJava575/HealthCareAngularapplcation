package in.nareshit.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.model.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {


	@Query(value = "select * from #{#entityName} w where w.WARD_ID=?1", nativeQuery = true)
	public Ward getById(long wid);
}
