package ServletPackages.OutPut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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
		CellStyle cellStyle = GeneratorStyle.createCellStyle(workbook, "titre1");
		cellStyle.setFont(GeneratorStyle.createFont(workbook, "titre1"));
		CellStyle style0 = GeneratorStyle.createCellStyle(workbook, "titre2");
		style0.setFont(GeneratorStyle.createFont(workbook, "titre2"));
		CellStyle style1 = GeneratorStyle.createCellStyle(workbook, "titre3");
		style1.setFont(GeneratorStyle.createFont(workbook, "titre3"));
		CellStyle style2 = GeneratorStyle.createCellStyle(workbook, "titre4");
		style2.setFont(GeneratorStyle.createFont(workbook, "titre4"));
		CellStyle style3 = GeneratorStyle.createCellStyle(workbook, "titre5");
		style3.setFont(GeneratorStyle.createFont(workbook, "titre5"));
		// row 4
		Cell[] cells1 = new Cell[12];
		Cell[] cells2 = new Cell[12];
		Cell[] cells3 = new Cell[12];
		Cell[] cells4 = new Cell[12];
		Cell[] cells5 = new Cell[12];
		Cell[] cells6 = new Cell[12];
		Cell[] cells7 = new Cell[12];
		Cell[] cells8 = new Cell[12];
		Cell[] cells9 = new Cell[12];
		Cell[] cells10 = new Cell[12];
		Cell[] cells11 = new Cell[12];

		sheet.setColumnWidth(0, 7500);
		sheet.setColumnWidth(1, 2500);
		sheet.setColumnWidth(2, 5000);
		sheet.setColumnWidth(3, 3000);
		sheet.setColumnWidth(4, 3000);
		sheet.setColumnWidth(5, 3000);
		sheet.setColumnWidth(6, 3000);
		sheet.setColumnWidth(7, 3000);
		sheet.setColumnWidth(8, 3000);
		sheet.setColumnWidth(9, 5000);
		sheet.setColumnWidth(10, 6000);
		sheet.setColumnWidth(11, 9000);

		Row[] rows = new Row[45];
		for (int i = 0; i < 44; i++) {
			rows[i] = sheet.createRow(i);
		}
		// Hauteur des lignes Height
		rows[1].setHeightInPoints(30);
		rows[2].setHeightInPoints(12);
		for (int i = 3; i < 9; i++) {
			rows[i].setHeightInPoints(30);
		}
		rows[9].setHeightInPoints(60);
		// Fusion des colonnes
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 11));
		sheet.addMergedRegion(new CellRangeAddress(10, 10, 0, 11));
		
		for (int i = 3; i < 10; i++) {
			sheet.addMergedRegion(new CellRangeAddress(i, i, 1, 8));
			sheet.addMergedRegion(new CellRangeAddress(i, i, 10, 11));
		}
		for(int i=0;i<6;i++){
			sheet.addMergedRegion(new CellRangeAddress(11,12 , i, i));
		}
		// row 2
		for (int i = 0; i < 12; i++) {
			cells1[i] = rows[1].createCell(i);
			cells1[i].setCellStyle(cellStyle);
			cells2[i] = rows[2].createCell(i);
			cells2[i].setCellStyle(cellStyle);
			cells11[i] = rows[10].createCell(i);
			cells11[i].setCellStyle(cellStyle);
		}

		for (int i = 0; i < 12; i++) {
			cells3[i] = rows[3].createCell(i);
			cells4[i] = rows[4].createCell(i);
			cells5[i] = rows[5].createCell(i);
			cells6[i] = rows[6].createCell(i);
			cells7[i] = rows[7].createCell(i);
			cells8[i] = rows[8].createCell(i);
			cells9[i] = rows[9].createCell(i);
			cells10[i] = rows[9].createCell(i);
			switch (i) {
			case 0: {
				cells3[i].setCellStyle(style0);
				cells4[i].setCellStyle(style0);
				cells5[i].setCellStyle(style0);
				cells6[i].setCellStyle(style0);
				cells7[i].setCellStyle(style0);
				cells8[i].setCellStyle(style0);
				cells9[i].setCellStyle(style0);
				cells10[i].setCellStyle(style0);
			}
				break;
			case 1:	case 2: case 3: case 4: case 5: case 6: case 7: case 8: 
			{
				cells3[i].setCellStyle(style1);
				cells4[i].setCellStyle(style1);
				cells5[i].setCellStyle(style1);
				cells6[i].setCellStyle(style1);
				cells7[i].setCellStyle(style1);
				cells8[i].setCellStyle(style1);
				cells9[i].setCellStyle(style1);
				cells10[i].setCellStyle(style1);
			}
				break;
			case 9: {
				cells3[i].setCellStyle(style2);
				cells4[i].setCellStyle(style2);
				cells5[i].setCellStyle(style2);
				cells6[i].setCellStyle(style2);
				cells7[i].setCellStyle(style2);
				cells8[i].setCellStyle(style2);
				cells9[i].setCellStyle(style2);
				cells10[i].setCellStyle(style2);
			}
				break;
			case 10: case 11: {
				cells3[i].setCellStyle(style3);
				cells4[i].setCellStyle(style3);
				cells5[i].setCellStyle(style3);
				cells6[i].setCellStyle(style3);
				cells7[i].setCellStyle(style3);
				cells8[i].setCellStyle(style3);
				cells9[i].setCellStyle(style3);
				cells10[i].setCellStyle(style3);
			}
				break;
			}
		}
		/** Add contained in the cell */
		cells1[0].setCellValue("ACE PROGRAMME - RESULTS FRAMEWORK");
		cells3[0].setCellValue("Project Title:");
		cells3[1].setCellValue(
				"Centre d’Excellence Africain en Mathematiques, Informatique et Technologies de l’Information et de la Communication (CEA-MITIC)");
		cells3[9].setCellValue("Total Grant (US$):");
		cells3[10].setCellValue("8.000.000 $US");
		
		cells4[0].setCellValue("Grant ID #:");
		cells4[1].setCellValue("036");
		cells4[9].setCellValue("Total Disbursement:");
		cells4[10].setCellValue("");

		cells5[0].setCellValue("Beneficiary Institution:");
		cells5[1].setCellValue("Université Gaston Berger de Saint-Louis");
		cells5[9].setCellValue("Total Period Expense:");
		cells5[10].setCellValue("");

		cells6[0].setCellValue("Project Start Date:");
		cells6[1].setCellValue("18 décembre 2014");
		cells6[9].setCellValue("Reporting Period:");
		cells6[10].setCellValue("Janv 2014 - 0ct 2015");

		cells7[0].setCellValue("Project End Date:");
		cells7[1].setCellValue("31 décembre 2018");
		cells7[9].setCellValue("Date of Submission:");
		cells7[10].setCellValue("20-nov-15");

		cells8[0].setCellValue("Project Coordinator:");
		cells8[1].setCellValue("Moussa Lo)");
		cells8[9].setCellValue("Reporting officer:");
		cells8[10].setCellValue("Responsable du Suivi Evaluation  CEA-MITIC, Université Gaston BERGER Saint-Louis");

		cells9[0].setCellValue("List of ACE courses:");
		cells9[1].setCellValue("Master Mathématiques Appliquées, Master Ingénierie Informatique et TIC, Master Développement de Systèmes d'Information, Master Réseaux et Télécommunications, Diplôme d'Ingénieur en Electronique et Télécommunications, Master Energies Renouvelables, Master MIAGE, Doctorat en Mathématiques Appliquées,  Doctorat en Informatique, Doctorat en Physique.");
		cells9[9].setCellValue("");
		cells9[10].setCellValue("");
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
