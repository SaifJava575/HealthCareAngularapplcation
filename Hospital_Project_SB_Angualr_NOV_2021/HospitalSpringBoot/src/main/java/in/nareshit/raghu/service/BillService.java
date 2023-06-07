package in.nareshit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nareshit.raghu.dto.BillDTO;

public interface BillService {

	public BillDTO save(BillDTO bill);
    public BillDTO update(BillDTO bill, long bid) throws Exception;
	public BillDTO getById(long bid) throws Exception;
	public List<BillDTO> getAll();
	public Map<String, Boolean> delete(long bid) throws Exception;

	
}
