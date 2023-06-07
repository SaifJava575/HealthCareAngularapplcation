package in.nareshit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nareshit.raghu.dto.InsuranceDTO;

public interface InsuranceService {


	public InsuranceDTO save(InsuranceDTO insurance);
    public InsuranceDTO update(InsuranceDTO insurance,  long iNo) throws Exception;
	public InsuranceDTO getById(long iNo) throws Exception;
	public List<InsuranceDTO> getAll();
	public Map<String, Boolean> delete(long iNo) throws Exception;
}
