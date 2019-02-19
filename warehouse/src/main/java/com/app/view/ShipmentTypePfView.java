package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		//for downloading and giving name for that
		
		response.addHeader("Content-Disposition", "attachment;filename=shipment.pdf");

		//create paragraph
		Paragraph p=new Paragraph("Welcome to ShipmentType pdf");
		
		// add to document
		document.add(p);
		
		//read data form map
		List<ShipmentType> ls=(List<ShipmentType>)model.get("ls");
		
		//creating table
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");
		t.addCell("SHIPMENT MODE");
		t.addCell("SHIPMENT CODE");
		t.addCell("SHIPMENT ENABLE");
		t.addCell("SHIPMENT GRADE");
		t.addCell("DESCRIPTION");

		//fetching data to table
		for(ShipmentType s:ls) {
			t.addCell(s.getId().toString());
			t.addCell(s.getMode());
			t.addCell(s.getCode());
			t.addCell(s.getEnabled());
			t.addCell(s.getGrade());
			t.addCell(s.getDsc());
		}
		
		//add to document
		document.add(t);
		//add date and time
		document.add(new Paragraph(new Date().toString()));
	}
	


	
}
