package com.crudapp.utils;

import com.crudapp.entity.Course;
import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ViewPDF extends AbstractPdfView {

	@Override
	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
		HeaderFooter header = new HeaderFooter(new Phrase("SPECIALIZATION PDF VIEW"), false);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setHeader(header);

		HeaderFooter footer = new HeaderFooter(new Phrase(new Date() + " (C) Nareshit, Page # "), true);
		footer.setAlignment(Element.ALIGN_RIGHT);
		document.setFooter(footer);
	}

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// download PDF with a given filename
		response.addHeader("Content-Disposition", "attachment;filename=SPEC.pdf");

		// read data from controller
		@SuppressWarnings("unchecked")
		List<Course> list = (List<Course>) model.get("list");

		// create element
		// Font (Family, Size, Style, Color)
		Font titleFont = new Font(Font.TIMES_ROMAN, 30, Font.BOLD, Color.RED);
		Paragraph title = new Paragraph("SPECIALIZATION DATA", titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(20.0f);
		title.setSpacingAfter(25.0f);
		// add to document
		document.add(title);

		Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.ORANGE);
		PdfPTable table = new PdfPTable(4);// no.of columns
		table.addCell(new Phrase("ID", tableHead));
		table.addCell(new Phrase("CODE", tableHead));
		table.addCell(new Phrase("NAME", tableHead));
		table.addCell(new Phrase("NOTE", tableHead));

		for (Course spec : list) {
			table.addCell(spec.getId().toString());
			table.addCell(spec.getCourseCode());
			table.addCell(spec.getCourseName());
			table.addCell(spec.getCourseNote());
		}
		// add to document
		document.add(table);
	}
}
