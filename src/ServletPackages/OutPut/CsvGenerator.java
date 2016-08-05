package ServletPackages.OutPut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;

import Enumeration.NumericConstant;

public class CsvGenerator implements NumericConstant {

	public void mergeInSheet(Sheet sheet, int firstRow, int secondRow, int firstColumn, int secondColumn) {
		sheet.addMergedRegion(new CellRangeAddress(firstRow, secondRow, firstColumn, secondColumn));
	}

	/** Create a report for year */
	public void yearReport(String year) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(WorkbookUtil.createSafeSheetName("YEAR " + year + " REPORT"));
 		CellStyle cellStyle = workbook.createCellStyle();
		sheet.setColumnWidth(0, 7000);
		sheet.setColumnWidth(1, 2000);
		sheet.setColumnWidth(2, 4500);
		sheet.setColumnWidth(3, 2500);
		sheet.setColumnWidth(4, 2500);
		sheet.setColumnWidth(5, 2500);
		sheet.setColumnWidth(6, 2500);
		sheet.setColumnWidth(7, 2500);
		sheet.setColumnWidth(8, 2500);
		sheet.setColumnWidth(9, 4500);
		sheet.setColumnWidth(10, 5500);
		sheet.setColumnWidth(11, 8500);
		Row[] rows = new Row[45];
		for (int i = 0; i < 44; i++) {
			rows[i] = sheet.createRow(i);
		}
		rows[1].setHeightInPoints(30);
		for(int i=3;i<9;i++){
			rows[i].setHeightInPoints(30);
		}
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,11));
		Cell cellRow1= rows[1].createCell(0); 
		/** Style for cells*/
		cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		
		cellRow1.setCellStyle(cellStyle);
		Cell[] cells=new Cell[12];
		for(int i=0;i<12;i++){
			cells[i]= rows[2].createCell(i);
			cells[i].setCellStyle(cellStyle);
		}
		
		try {
			FileOutputStream file = new FileOutputStream(urlOutPut + fileReportName + 4 + ".xls");
			workbook.write(file);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done!!!");
	}
}
