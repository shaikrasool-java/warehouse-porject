package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		//download option, with file name
		response.addHeader("Content-Disposition", "attachment;filename=ordermethod.pdf");
		
		//create element
		Paragraph p=new Paragraph("Welcome OrderMethod");
		
		//add to pdf document
		
		document.add(p);
		
		//read data from map
		@SuppressWarnings({ "unchecked", "unused" })
		List<OrderMethod> lo=(List<OrderMethod>)model.get("lo");
		//create table
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("ORDER MODE");
		t.addCell("ORDER CODE");
		t.addCell("ORDER METHOD");
		t.addCell("ORDER ACCEPT");
		t.addCell("ORDER DESRIPTION");
		
		//ADD DB DATA TO TABLE
		
		for(OrderMethod o:lo) {
			t.addCell(String.valueOf(o.getId()));
			t.addCell(o.getMode());
			t.addCell(o.getCode());
			t.addCell(o.getMethod());
			t.addCell(o.getAccept().toString());
			t.addCell(o.getDsc());
		}
		//add to document
		document.add(t);
		//add data & time
		document.add(new Paragraph(new Date().toString()));
		
	}

}
