package com.example.demo.utils.impl;

import com.example.demo.model.binding.EmployeeBindingModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExelUtils {
    public static final String EXEL_PATH = "./data/TestData.xlsx";

    private static Object getCellValues(Cell cell,Workbook workbook) {
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        if (cell.getCellType() == CellType.FORMULA){
            switch (evaluator.evaluateFormulaCell(cell)) {
                case BOOLEAN:
                    return cell.getBooleanCellValue();
                case NUMERIC:
                    return cell.getNumericCellValue();
                case STRING:
                    return cell.getStringCellValue();
            }
        }else{
            switch (cell.getCellType()) {
                case STRING -> {
                    return cell.getStringCellValue();
                }
                case NUMERIC -> {
                    return cell.getNumericCellValue();
                }
                case BOOLEAN -> {
                    return cell.getBooleanCellValue();
                }
                default -> {
                    return null;
                }
            }
        }
        return null;
    }

    public static List<EmployeeBindingModel> readDataFromExelFile() throws IOException {
        String exelFilePath = EXEL_PATH;
        List<EmployeeBindingModel> employeeList = new ArrayList<>();

        Workbook workbook = new XSSFWorkbook(EXEL_PATH);
        Sheet sheet = workbook.getSheet("Sheet1");

        Iterator<Row> iterator = sheet.iterator();
        iterator.next();

        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
            EmployeeBindingModel employee = new EmployeeBindingModel();

            while (cellIterator.hasNext()) {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex) {
                    case 0:
                        employee.setfName((String) getCellValues(nextCell,workbook)); break;
                    case 1:
                        employee.setlName((String) getCellValues(nextCell,workbook)); break;
                    case 2:
                        employee.setAge((Double) getCellValues(nextCell,workbook)); break;
                    case 3:
                        employee.setCompany((String) getCellValues(nextCell,workbook)); break;
                    case 4:
                        employee.setJobTitle((String) getCellValues(nextCell,workbook)); break;
                    case 5:
                        employee.setSalary((Double) getCellValues(nextCell,workbook)); break;
                }
            }
            employeeList.add(employee);
        }
//        workbook.close();
        return employeeList;
    }
}
