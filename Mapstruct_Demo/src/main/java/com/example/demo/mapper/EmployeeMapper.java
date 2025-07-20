package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;

@Mapper
public interface EmployeeMapper {

	EmployeeMapper EMP_MAPPER = Mappers.getMapper(EmployeeMapper.class);
	
	@Mapping(target = "id" , ignore = true)
	Employee populateEmployee(EmployeeDTO empDTO);
	
	EmployeeDTO populateEmployeeDTO(Employee emp);
	
}
