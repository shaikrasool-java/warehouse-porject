package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//xl file name changing
		response.addHeader("Content-Disposition", "attachment;filename=OrderMethod.Xlsx");
		
		//create sheet with name
		
		Sheet sheet=workbook.createSheet("oms");
		
		//create head
		
		setHead(sheet);
		
		//read data
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms=(List<OrderMethod>)model.get("oms");
		
		//set body
		setBody(sheet, oms);
		
		
	}

	private void setBody(Sheet sheet, List<OrderMethod> oms) {

		int rowNum=1;
		for(OrderMethod o:oms) {
			Row row=sheet.createRow(rowNum++);
			
			row.createCell(0).setCellValue(o.getId());
			row.createCell(1).setCellValue(o.getMode());
			row.createCell(2).setCellValue(o.getCode());
			row.createCell(3).setCellValue(o.getMethod());
			row.createCell(4).setCellValue(o.getAccept().toString());
			row.createCell(5).setCellValue(o.getDsc());
			
		}
		
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("ORDER MODE");
		row.createCell(2).setCellValue("ORDER CODE");
		row.createCell(3).setCellValue("ORDER METHOD");
		row.createCell(4).setCellValue("ORDER ACCEPT");
		row.createCell(5).setCellValue("ORDER DESCRIPTION");
		
	}

}
