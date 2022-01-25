package com.example.demo.config;

import com.example.demo.model.binding.EmployeeBindingModel;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.sevice.EmployeeServiceModel;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.ExelUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class AutoSaveScheduled {
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoSaveScheduled.class);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private final EmployeeService employeeService;

    public AutoSaveScheduled(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Scheduled(cron = "*/35 * * * * *")
    public void autoSave() throws IOException {
        List<EmployeeBindingModel> employeeBindingModelsList = ExelUtils.readDataFromExelFile();
        List<EmployeeServiceModel> employeeServiceModelsList = employeeService.fromBindingModelToServiceModel(employeeBindingModelsList);
        List<EmployeeEntity> employeeEntitiesList = employeeService.fromEmployeeServiceModelToEmployeeEntity(employeeServiceModelsList);
        employeeService.saveEmployeesToDatabase(employeeEntitiesList);

        LOGGER.info("Auto Save at: {}",formatter.format(LocalDateTime.now()));
    }
}
