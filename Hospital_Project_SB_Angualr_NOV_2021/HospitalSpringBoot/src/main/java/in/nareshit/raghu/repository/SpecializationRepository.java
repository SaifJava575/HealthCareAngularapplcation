package in.nareshit.raghu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nareshit.raghu.model.Specialization;

public interface SpecializationRepository extends JpaRepository<Specialization, Long>{

	@Query(value = "select * from #{#entityName} s where s.SPEC_ID=?1", nativeQuery = true)
	public Specialization getById(long specId);
}
