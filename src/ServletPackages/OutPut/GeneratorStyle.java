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
		case "titre1": {
			cellStyle.setFillForegroundColor((short) 49);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
			break;
		case "titre2": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "titre3": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "titre4": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "titre5": {
			cellStyle.setVerticalAlignment((short) 12);
		}
			break;
		case "titre6": {
			cellStyle.setFillForegroundColor((short) 44);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre7": {
			cellStyle.setFillForegroundColor((short) 22);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre8": {
			cellStyle.setAlignment(CellStyle.ALIGN_GENERAL);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		}
			break;
		case "titre9": {
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre10": {
			cellStyle.setAlignment(CellStyle.ALIGN_GENERAL);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		}
			break;
		case "titre11": {
			cellStyle.setFillForegroundColor((short) 5);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre12": {
			cellStyle.setFillForegroundColor((short) 31);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre13": {
			cellStyle.setBorderRight(CellStyle.BORDER_DOUBLE);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		case "titre14": {
			cellStyle.setFillForegroundColor((short) 27);
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		}
			break;
		}
		return cellStyle;

	}

	public static Font createFont(Workbook workbook, String destination) {
		Font fontTitle = workbook.createFont();
		switch (destination) {
		case "titre1": {
			fontTitle.setColor(IndexedColors.WHITE.getIndex());
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
			fontTitle.setUnderline(Font.U_SINGLE);
			fontTitle.setFontName("Candara");
			fontTitle.setFontHeight((short) 280);
		}
			break;
		case "titre2": {
			fontTitle.setFontName("Candara");
		}
			break;
		case "titre3": {
			fontTitle.setFontName("Calibri");
		}
			break;
		case "titre4": {
			fontTitle.setFontName("Candara");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "titre5": {
			fontTitle.setFontName("Candara");
			fontTitle.setColor(IndexedColors.BLUE.getIndex());
			fontTitle.setItalic(true);
		}
			break;
		case "titre6": {
			fontTitle.setFontName("Calibri");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "titre9": {
			fontTitle.setFontName("Calibri");
		}
			break;
		case "titre10": {
			fontTitle.setFontHeight((short) 240);
			fontTitle.setFontName("Calibri");
		}
			break;
		case "titre13": {
			fontTitle.setColor(IndexedColors.RED.getIndex());
			fontTitle.setFontHeight((short) 240);
			fontTitle.setFontName("Calibri");
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
			Cell cell = rows[i].createCell(12);
			cell.setCellStyle(cellStyle);
			Cell cell1 = rows[i].createCell(13);
			cell1.setCellValue(i);
		}

	}
}
