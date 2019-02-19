package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// changing file name
		response.addHeader("Content-Disposition", "attachmetn;filename=shipment.xlsx");
		
		// creating sheet with name
		Sheet sheet=workbook.createSheet();
		
		//create head
		setHead(sheet);
		
		//fetching data
		@SuppressWarnings("unchecked")
		List<ShipmentType> ls=(List<ShipmentType>)model.get("ls");
		
		//set bodt
		setBody(sheet, ls);
		
	}

	private void setBody(Sheet sheet, List<ShipmentType> ls) {
		
		int rowNum=1;
		for(ShipmentType s:ls) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getMode());
			row.createCell(2).setCellValue(s.getCode());
			row.createCell(3).setCellValue(s.getEnabled());
			row.createCell(4).setCellValue(s.getGrade());
			row.createCell(5).setCellValue(s.getDsc());
		}
		
		
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("SHIPMENT MODE");
		row.createCell(2).setCellValue("SHIPMENT CODE");
		row.createCell(3).setCellValue("SHIPMENT ENABLE");
		row.createCell(4).setCellValue("SHIPMENT GRADE");
		row.createCell(5).setCellValue("DISCRIPTION");
		
	}

}
