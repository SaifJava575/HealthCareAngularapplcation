package in.nareshit.raghu.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.dto.BillDTO;
import in.nareshit.raghu.service.BillService;

@RestController 
@RequestMapping(value = "/api") 
public class BillController {

	@Autowired 
	private BillService billService;
	
	@PostMapping(value="/bill",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<BillDTO> addBill(@RequestBody BillDTO billDTO) {
		BillDTO bill = billService.save(billDTO);
		return ResponseEntity.ok().body(bill);
	}
	
	@PutMapping(value="/bill/{id}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<BillDTO> updateBill(@RequestBody BillDTO billDTO,
								@PathVariable("id") long bid) throws Exception {
		
		BillDTO bill = billService.update(billDTO, bid);
		return ResponseEntity.ok().body(bill);
	}
	
	@DeleteMapping(value="/bill/{id}")
	public Map<String, Boolean> deleteBill(@PathVariable long id) throws Exception
	{
		return billService.delete(id);
	}

	@GetMapping(value="/bill/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<BillDTO> findById(@PathVariable long id) throws Exception {
		
		BillDTO bill =  billService.getById(id);
		return ResponseEntity.ok().body(bill);
	}
	
	@GetMapping(value="/bill")
	public ResponseEntity<List<BillDTO>> listAll()
	{
		List<BillDTO> billList = billService.getAll();
		return ResponseEntity.ok().body(billList);
	}
}
