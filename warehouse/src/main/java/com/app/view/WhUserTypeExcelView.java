package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// creating a xl workbook name
		response.addHeader("Content-Disposition", "attachment;filename=whusertype.xlsx");
		
		//create sheet
		Sheet sheet=workbook.createSheet("whusretype");
		
		//set head
		setHead(sheet);
		//fetch records
		List<WhUserType>lw=(List<WhUserType>)model.get("lw");
		//set body
		setBody(sheet, lw);
		
		
	}

	private void setBody(Sheet sheet, List<WhUserType> lw) {
		
		int rowNum=1;
		for(WhUserType w:lw) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getType());
			row.createCell(2).setCellValue(w.getCode());
			row.createCell(3).setCellValue(w.getForType());
			row.createCell(4).setCellValue(w.getEmail());
			row.createCell(5).setCellValue(w.getContact());
			row.createCell(6).setCellValue(w.getIdType());
			row.createCell(7).setCellValue(w.getIfOther());
			row.createCell(8).setCellValue(w.getIdNum());
		}
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("USER TYPE");
		row.createCell(2).setCellValue("USER CODE");
		row.createCell(3).setCellValue("USER FOR");
		row.createCell(4).setCellValue("USER EMAIL");
		row.createCell(5).setCellValue("USER CONTACT");
		row.createCell(6).setCellValue("USER ID TYPE");
		row.createCell(7).setCellValue("IF OTHERS");
		row.createCell(8).setCellValue("ID NUMBER");
	}

}
