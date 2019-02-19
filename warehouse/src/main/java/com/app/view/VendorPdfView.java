package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		//for downloading as well as re-naming the file name
		
		response.addHeader("Content-Disposition","attachment;filename=vendor.pdf");
		
		//cretae paragraph
		Paragraph p=new Paragraph("Welcome to vendor pdf");
		
		//adding to document
		document.add(p);
		
		//fetching data
		
		List<Vendor> lv=(List<Vendor>)model.get("lv");
		
		//creating a table
		
		PdfPTable t=new PdfPTable(5);
		
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("CODE");
		t.addCell("DESG");
		t.addCell("PRESERVE");
		
		for(Vendor v:lv) {
			
			t.addCell(v.getId().toString());
			t.addCell(v.getVenName());
			t.addCell(v.getVenCode());
			t.addCell(v.getVenDesg());
			t.addCell(v.getVenPreserve().toString());
		}
		// above data adding to the document
		document.add(t);
		
		//adding to time and date
		
		document.add(new Paragraph(new Date().toString()));
		
	}

}
