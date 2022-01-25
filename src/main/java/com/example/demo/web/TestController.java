package com.example.demo.web;

import com.example.demo.model.DTO.EmployeeDTO;
import com.example.demo.model.binding.EmployeeBindingModel;
import com.example.demo.model.entity.EmployeeEntity;
import com.example.demo.model.sevice.EmployeeServiceModel;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.CreateXMLFile;
import com.example.demo.utils.impl.CreateXMLFileImpl;
import com.example.demo.utils.impl.ExelUtils;
import com.example.demo.utils.XmlParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Controller
public class TestController {
    private final EmployeeService employeeService;
    private final XmlParser xmlParser;
    private static final String PATH_OF_FILE = "C:\\Users\\ACER\\Desktop\\Java-Exel-Tool\\data\\";


    public TestController(EmployeeService employeeService, XmlParser xmlParser) {
        this.employeeService = employeeService;
        this.xmlParser = xmlParser;
    }

    @GetMapping("/input")
    public String testInputToDataBase() throws IOException {
        List<EmployeeBindingModel> employeeBindingModelsList = ExelUtils.readDataFromExelFile();
        List<EmployeeServiceModel> employeeServiceModelsList = employeeService.fromBindingModelToServiceModel(employeeBindingModelsList);
        List<EmployeeEntity> employeeEntitiesList = employeeService.fromEmployeeServiceModelToEmployeeEntity(employeeServiceModelsList);
        employeeService.saveEmployeesToDatabase(employeeEntitiesList);
        return "testInput";
    }
    @GetMapping("/output")
    public String testOutputFromDataBaseToXML() throws JAXBException, IOException {
        List<EmployeeDTO> employeeDTOS = employeeService.fromEntityToDTO();
        CreateXMLFile createXMLFile = new CreateXMLFileImpl();

        for (EmployeeDTO employeeDTO : employeeDTOS) {
            String fileName = createFileName(employeeDTO.getId(), employeeDTO.getfName(), employeeDTO.getlName());
            createXMLFile.createXML(String.format("%s%s.xml",PATH_OF_FILE,fileName));
            xmlParser.exportXml(employeeDTO,EmployeeDTO.class,PATH_OF_FILE+fileName+".xml");
        }

        return "testOutput";
    }



    private static String createFileName(Long id,String fName,String lName){
        String fileName ="";
        return fileName = String.format("%s%s%s",id,fName,lName);
    }

}
