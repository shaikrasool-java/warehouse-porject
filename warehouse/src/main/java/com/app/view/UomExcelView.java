package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsView  {

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//xl file name change
		response.addHeader("Content-Disposition", "attachment;filename=Uom.xls");
		
		//create sheet
		Sheet sheet=workbook.createSheet("uom");
		
		// create head
		
		setHead(sheet);
		// read data
		List<Uom> lu=(List<Uom>)model.get("lu");
		//set body
		setBody(sheet, lu);
		
		
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
	}

	private void setBody(Sheet sheet, List<Uom> lu) {
		int rowNum=1;
		for(Uom u:lu) {
			Row row=sheet.createRow(rowNum++);
			 row.createCell(0).setCellValue(u.getId());
			 row.createCell(1).setCellValue(u.getType());
			 row.createCell(2).setCellValue(u.getModel());
			 row.createCell(3).setCellValue(u.getDsc());
			 
		}
	}



	}


