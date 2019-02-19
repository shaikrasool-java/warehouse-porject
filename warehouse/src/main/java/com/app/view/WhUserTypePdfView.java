package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		//downloading and creating a name for pdf document
		response.addHeader("Content-Disposition", "attachment;filename=whusertype.pdf");
		
		//creating a paragraph
		Paragraph p=new Paragraph("welcome to WhUserType PdF view");
		
		//adding paragraph to document
		document.add(p);
		
		//fetching data
		List<WhUserType> lw=(List<WhUserType>)model.get("lw");
		
		//creating table
		PdfPTable t=new PdfPTable(9);
		
		t.addCell("ID");
		t.addCell("USER TYPE");
		t.addCell("USER CODE");
		t.addCell("USER FOR");
		t.addCell("USER MAIL");
		t.addCell("USER CONTACT");
		t.addCell("USER ID TYPE");
		t.addCell("IF OTHER");
		t.addCell("ID NUMBER");
		
		for(WhUserType w:lw) {
			t.addCell(w.getId().toString());
			t.addCell(w.getType());
			t.addCell(w.getCode());
			t.addCell(w.getForType());
			t.addCell(w.getEmail());
			t.addCell(w.getContact());
			t.addCell(w.getIdType());
			t.addCell(w.getIfOther());
			t.addCell(w.getIdNum());
		}

		//adding table to document
		document.add(t);
		//adding time and date
		
		document.add(new Paragraph(new Date().toString()));
	}

}
