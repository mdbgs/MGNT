package ServletPackages.OutPut;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class GeneratorStyle {
	public static CellStyle createCellStyle(Workbook workbook, String destination) {
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setWrapText(true);
		switch (destination) {
		case "yearReport1": {
			cellStyle.setFillForegroundColor((short) 49);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
			break;
		case "yearReport2": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "yearReport3": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "yearReport4": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "yearReport5": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "yearReport6": {
			cellStyle.setFillForegroundColor((short) 44);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport7": {
			cellStyle.setFillForegroundColor((short) 22);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport8": {
			cellStyle.setAlignment(CellStyle.ALIGN_GENERAL);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		}
			break;
		case "yearReport9": {
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport10": {
			cellStyle.setAlignment(CellStyle.ALIGN_GENERAL);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		}
			break;
		case "yearReport11": {
			cellStyle.setFillForegroundColor((short) 5);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport12": {
			cellStyle.setFillForegroundColor((short) 31);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport13": {
			cellStyle.setBorderRight(CellStyle.BORDER_DOUBLE);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "yearReport14": {
			cellStyle.setFillForegroundColor((short) 27);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_GENERAL);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		}
			break;
		case "navigation1": {
			cellStyle.setFillForegroundColor((short) 22);
			cellStyle.setTopBorderColor((short)16);
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor((short)16);
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor((short)16);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setLeftBorderColor((short)16);
			cellStyle.setBorderLeft(CellStyle.SOLID_FOREGROUND);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "navigation2": {
			cellStyle.setFillForegroundColor((short) 55);
			cellStyle.setTopBorderColor((short)16);
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor((short)16);
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor((short)16);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setLeftBorderColor((short)16);
			cellStyle.setBorderLeft(CellStyle.SOLID_FOREGROUND);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT);
		}
			break;
		case "navigation3": {
			cellStyle.setFillForegroundColor((short) 73);
			cellStyle.setTopBorderColor((short)16);
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor((short)16);
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor((short)16);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setLeftBorderColor((short)16);
			cellStyle.setBorderLeft(CellStyle.SOLID_FOREGROUND);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "navigation4": {
			cellStyle.setFillForegroundColor((short) 27);
			cellStyle.setTopBorderColor((short)16);
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor((short)16);
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor((short)16);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setLeftBorderColor((short)16);
			cellStyle.setBorderLeft(CellStyle.SOLID_FOREGROUND);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT);
		}
			break;
		case "navigation5": {
			cellStyle.setFillForegroundColor((short) 22);
			cellStyle.setTopBorderColor((short)16);
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor((short)16);
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor((short)16);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setLeftBorderColor((short)16);
			cellStyle.setBorderLeft(CellStyle.SOLID_FOREGROUND);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.ALIGN_LEFT);
		}break;
		}
		return cellStyle;

	}

	public static Font createFont(Workbook workbook, String destination) {
		Font fontTitle = workbook.createFont();
		//Year Report
		switch (destination) {
		case "yearReport1": {
			fontTitle.setColor(IndexedColors.WHITE.getIndex());
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontTitle.setUnderline(Font.U_SINGLE);
			fontTitle.setFontName("Candara");
			fontTitle.setFontHeight((short) 280);
		}
			break;
		case "yearReport2": {
			fontTitle.setFontName("Candara");
		}
			break;
		case "yearReport3": {
			fontTitle.setFontName("Calibri");
		}
			break;
		case "yearReport4": {
			fontTitle.setFontName("Candara");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "yearReport5": {
			fontTitle.setFontName("Candara");
			fontTitle.setColor(IndexedColors.BLUE.getIndex());
			fontTitle.setItalic(true);
		}
			break;
			case "yearReport6": {
			fontTitle.setFontName("Calibri");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "yearReport9": {
			fontTitle.setFontName("Calibri");
		}
			break;
		case "yearReport10": {
			fontTitle.setFontHeight((short) 240);
			fontTitle.setFontName("Calibri");
		}
			break;
		case "yearReport13": {
			fontTitle.setColor(IndexedColors.RED.getIndex());
			fontTitle.setFontHeight((short) 240);
			fontTitle.setFontName("Calibri");
		}
			break;
		case "navigation1": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Arial Black");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "navigation2": {
			fontTitle.setColor(IndexedColors.BLUE.getIndex());
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Arial Black");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontTitle.setUnderline(Font.U_SINGLE);
		}
			break;
		case "navigation3": {
			fontTitle.setFontHeight((short) 480);
			fontTitle.setFontName("Arial Black");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "navigation4": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Calibri");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		}
		
		return fontTitle;
	}

	public static void testColor(Row[] rows, Workbook workbook) {
		int number = rows.length;
		for (int i = 0; i < number - 1; i++) {
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setFillForegroundColor((short) i);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			System.out.println(i);
			Cell cell = rows[i].createCell(20);
			cell.setCellStyle(cellStyle);
			Cell cell1 = rows[i].createCell(21);
			cell1.setCellValue(i);
		}

	}
}
