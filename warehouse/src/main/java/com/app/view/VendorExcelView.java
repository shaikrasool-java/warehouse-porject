package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		
		//excel pre-defined name to custom name
		response.addHeader("Content-Disposition", "attachment;filename=vendor.Xlsx");
		
		//creating sheet by using workbook
		
		Sheet sheet=workbook.createSheet("vendor");
		
		//create head
		setHead(sheet);
		
		//read data
		
		List<Vendor> lv=(List<Vendor>)model.get("lv");
		
		//set body
		setBody(sheet,lv);
	}

	@SuppressWarnings("unused")
	private void setBody(Sheet sheet, List<Vendor> lv) {

		int rowNum=1;
		for(Vendor v:lv) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(v.getId());
			row.createCell(1).setCellValue(v.getVenName());
			row.createCell(2).setCellValue(v.getVenCode());
			row.createCell(3).setCellValue(v.getVenDesg());
			row.createCell(4).setCellValue(v.getVenPreserve().toString());
		}
	}

	private void setHead(Sheet sheet) {
		
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("DESG");
		row.createCell(4).setCellValue("PRESERVE");
	}

}
