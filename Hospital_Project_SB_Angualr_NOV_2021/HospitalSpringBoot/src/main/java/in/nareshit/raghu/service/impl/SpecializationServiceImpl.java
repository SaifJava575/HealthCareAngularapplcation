package in.nareshit.raghu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.dto.SpecializationDTO;
import in.nareshit.raghu.model.Specialization;
import in.nareshit.raghu.repository.SpecializationRepository;
import in.nareshit.raghu.service.SpecializationService;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService {

	@Autowired
	private SpecializationRepository sRepo;

	private Specialization convertDTOtoModel(SpecializationDTO specializationDTO) {

		Specialization specialization = new Specialization();

		specialization.setSpecId(specializationDTO.getSpecId());
		specialization.setSpeciality(specializationDTO.getSpeciality());

		return specialization;
	}

	private SpecializationDTO convertModelToDTO(Specialization specialization) {
		return new SpecializationDTO(specialization);
	}

	@Override
	public SpecializationDTO save(SpecializationDTO specializationDTO) {
		Specialization specialization = convertDTOtoModel(specializationDTO); 
		sRepo.save(specialization);
		return convertModelToDTO(specialization); // return DTO
	}

	@Override
	public SpecializationDTO update(SpecializationDTO specialization, long specId) throws Exception {
		// TODO Auto-generated method stub
		SpecializationDTO cpySpec = getById(specId);
		cpySpec.setSpeciality(specialization.getSpeciality());
		Specialization spec = convertDTOtoModel(cpySpec);
		sRepo.save(spec);
		return convertModelToDTO(spec);
	}

	@Override
	public SpecializationDTO getById(long specId) throws Exception {
		Specialization specialization = sRepo.findById(specId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + specId));
		 return convertModelToDTO(specialization);
	}

	@Override
	public List<SpecializationDTO> getAll() {
		List<Specialization> specializationList = sRepo.findAll();
		List<SpecializationDTO> specializationDTOList = new ArrayList<>();
		
		for(Specialization specialization : specializationList) {
			specializationDTOList.add(convertModelToDTO(specialization));
		}
		
		return specializationDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long specId) throws Exception {
		Specialization specialization = convertDTOtoModel(getById(specId));
		sRepo.delete(specialization);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

}
