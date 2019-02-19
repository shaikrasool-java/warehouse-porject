package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		// for downloading and creating name for that
		
		response.addHeader("Content-Disposition", "attachment;filename=uom.pdf");
		
		//creating paragraph
		Paragraph p=new Paragraph("welcome to uom pdf view");
		
		//adding to document
		document.add(p);
		
		// list of data
		List<Uom> lu=(List<Uom>)model.get("lu");
		
		//creating pdf table
		
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("MODEL");
		t.addCell("DESCRIPTION");
		
		for(Uom u:lu) {
			t.addCell(u.getId().toString());
			t.addCell(u.getType());
			t.addCell(u.getModel());
			t.addCell(u.getDsc());
		}
		//adding table data to document
		document.add(t);
		
		//adding time and data
		document.add(new Paragraph(new Date().toString()));
		
		
	}

	
	
}
