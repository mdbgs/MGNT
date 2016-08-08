package ServletPackages.OutPut;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;

public class GeneratorStyle {
	public static CellStyle createCellStyle(Workbook workbook, String destination) {
		CellStyle cellStyle = workbook.createCellStyle();
		switch (destination) {
		case "titre1": {
			cellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		}
			break;
		case "titre2": {
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setVerticalAlignment((short) 12);

		}
			break;
		case "titre3": {
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setVerticalAlignment((short) 12);

		}
			break;
		case "titre4": {
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setVerticalAlignment((short) 12);

		}
			break;
		case "titre5": {
			cellStyle.setBorderBottom(CellStyle.SOLID_FOREGROUND);
			cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderRight(CellStyle.SOLID_FOREGROUND);
			cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setBorderTop(CellStyle.SOLID_FOREGROUND);
			cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
			cellStyle.setVerticalAlignment((short) 12);

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
			fontTitle.setFontHeight((short) 280);
			fontTitle.setUnderline(Font.U_SINGLE);
			fontTitle.setFontName("Candara");
		}
			break;
		case "titre2": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Candara");
		}
			break;
		case "titre3": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Calibri");
		}
			break;
		case "titre4": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Candara");
			fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
		}
			break;
		case "titre5": {
			fontTitle.setFontHeight((short) 220);
			fontTitle.setFontName("Candara");
			fontTitle.setColor(IndexedColors.BLUE.getIndex());
			fontTitle.setItalic(true);
		}
			break;

		}
		return fontTitle;

	}
}
