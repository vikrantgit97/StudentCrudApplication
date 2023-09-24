package com.crudapp.utils;

import com.crudapp.entity.Course;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class ViewExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 1. define your own excel file name
		response.addHeader("Content-Disposition", "attachment;filename=SPECS.xlsx");

		// 2. read data given by Controller
		@SuppressWarnings("unchecked")
		List<Course> list = (List<Course>) model.get("list");

		// 3. create one sheet
		Sheet sheet = workbook.createSheet("COURSE");

		// 4. create row#0 as header
		setHead(sheet);

		// 5. create row#1 onwards from List<T>
		setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("NOTE");
	}

	private void setBody(Sheet sheet, List<Course> list) {
		int rowNum = 1;
		for (Course course : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(course.getId());
			row.createCell(1).setCellValue(course.getCourseCode());
			row.createCell(2).setCellValue(course.getCourseName());
			row.createCell(3).setCellValue(course.getCourseNote());
		}
	}

}
