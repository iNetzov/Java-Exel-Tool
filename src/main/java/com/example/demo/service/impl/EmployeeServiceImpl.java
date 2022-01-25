package com.example.demo.service.impl;

import com.example.demo.model.binding.EmployeeBindingModel;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.sevice.EmployeeServiceModel;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeRepository employeeRepository) {
        this.modelMapper = modelMapper;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeServiceModel> fromBindingModelToServiceModel(List<EmployeeBindingModel> list) {
        List<EmployeeServiceModel>outputList = new ArrayList<>();
        for (EmployeeBindingModel employeeBindingModel : list) {
            EmployeeServiceModel map = modelMapper.map(employeeBindingModel, EmployeeServiceModel.class);
            outputList.add(map);
        }
        return outputList;
    }

    @Override
    public List<EmployeeEntity> fromEmployeeServiceModelToEmployeeEntity(List<EmployeeServiceModel> list) {
        List<EmployeeEntity>outputList = new ArrayList<>();
        for (EmployeeServiceModel employeeServiceModel : list) {
            EmployeeEntity map = modelMapper.map(employeeServiceModel, EmployeeEntity.class);
            outputList.add(map);
        }
        return outputList;
    }

    @Override
    public void saveEmployeesToDatabase(List<EmployeeEntity> list) {
            employeeRepository.deleteAll();
            employeeRepository.saveAll(list);
    }
}
