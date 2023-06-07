package in.nareshit.raghu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.dto.BillDTO;
import in.nareshit.raghu.model.Bill;
import in.nareshit.raghu.repository.BillRepository;
import in.nareshit.raghu.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository repo;
	
	
	private Bill convertDTOtoModel(BillDTO billDTO) {
		
		Bill bill = new Bill();
		
		bill.setbId(billDTO.getbId());
		bill.setbAmt(billDTO.getbAmt());
		bill.setIsInsuared(billDTO.getIsInsuared());
		bill.setPatient(billDTO.getPatient());
		bill.setInsurance(billDTO.getInsurance());
		bill.setBillDate(billDTO.getBillDate());
		bill.setIsInsuared(billDTO.getIsInsuared());
		
		return bill;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private BillDTO convertModelToDTO(Bill bill) {
		return new BillDTO(bill);
	}
	
	@Override
	public BillDTO save(BillDTO billDTO) {
		Bill bill = convertDTOtoModel(billDTO); // convert dto to model for database interaction
		bill.setBillDate(new Date());
//		System.out.println( "::::::::::::::::::::" + bill.getInsurance().getiNo());
		return convertModelToDTO(repo.save(bill)); // return DTO 
	}

	@Override
	public BillDTO update(BillDTO billDTO, long bid) throws Exception {
		
		BillDTO copybill = getById(bid);
		
		copybill.setbId(bid);
		copybill.setbAmt(billDTO.getbAmt());
		copybill.setIsInsuared(true);
		copybill.setInsurance(billDTO.getInsurance());
		copybill.setPatient(billDTO.getPatient());
		copybill.setBillDate(new Date());
		
		// step 1 
		Bill bill = convertDTOtoModel(copybill);
		
		//step 2
		
		// step 3
		return convertModelToDTO(repo.save(bill));
	}

	@Override
	public BillDTO getById(long bid) throws Exception {
		Bill bill = repo.findById(bid)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + bid));
		return convertModelToDTO(bill);
	}

	@Override
	public List<BillDTO> getAll() {
		List<Bill> billList = repo.findAll();
		List<BillDTO> billDTOList = new ArrayList<>();
		
		for(Bill bill : billList) {
			billDTOList.add(convertModelToDTO(bill));
		}
		
		return billDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long bid) throws Exception {
		Bill bill = convertDTOtoModel(getById(bid));
		repo.delete(bill);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
		
	}

	

}