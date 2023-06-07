package in.nareshit.raghu.service;

import java.util.List;
import java.util.Map;

import in.nareshit.raghu.dto.EmployeeDTO;

public interface EmployeeService {

	public EmployeeDTO save(EmployeeDTO employee);
    public EmployeeDTO update(EmployeeDTO employee, long empId) throws Exception;
	public EmployeeDTO getById(long empId) throws Exception;
	public List<EmployeeDTO> getAll();
	public Map<String, Boolean> delete(long empId) throws Exception;
	public boolean isExists(EmployeeDTO emp);

}
