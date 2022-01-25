package com.example.demo.service;

import com.example.demo.model.DTO.EmployeeDTO;
import com.example.demo.model.binding.EmployeeBindingModel;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.sevice.EmployeeServiceModel;

import java.util.List;

public interface EmployeeService {
    List<EmployeeServiceModel> fromBindingModelToServiceModel(List<EmployeeBindingModel>list);
    List<EmployeeEntity> fromEmployeeServiceModelToEmployeeEntity(List<EmployeeServiceModel>list);
    List<EmployeeDTO>fromEntityToDTO();
    void saveEmployeesToDatabase(List<EmployeeEntity>list);
}
