package com.example.demo.web;

import com.example.demo.model.binding.EmployeeBindingModel;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.sevice.EmployeeServiceModel;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.ExelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class TestController {
    private final EmployeeService employeeService;

    public TestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/test")
    public String test() throws IOException {
        List<EmployeeBindingModel> employeeBindingModelsList = ExelUtils.readDataFromExelFile();
        List<EmployeeServiceModel> employeeServiceModelsList = employeeService.fromBindingModelToServiceModel(employeeBindingModelsList);
        List<EmployeeEntity> employeeEntitiesList = employeeService.fromEmployeeServiceModelToEmployeeEntity(employeeServiceModelsList);
        employeeService.saveEmployeesToDatabase(employeeEntitiesList);
        return "test";
    }

}
