package com.example.demo.model.DTO;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeDTO {
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "firstName")
    private String fName;
    @XmlElement(name = "lastName")
    private String lName;
    @XmlElement(name = "age")
    private Integer age;
    @XmlElement(name = "company")
    private String company;
    @XmlElement(name = "jobTitle")
    private String jobTitle;
    @XmlElement(name = "salary")
    private BigDecimal salary;

    public EmployeeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
