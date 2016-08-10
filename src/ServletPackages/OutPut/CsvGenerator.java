package ServletPackages.OutPut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.WorkbookUtil;

import Enumeration.NumericConstant;

public class CsvGenerator implements NumericConstant {

	public void mergeInSheet(Sheet sheet, int firstRow, int secondRow, int firstColumn, int secondColumn) {
		sheet.addMergedRegion(new CellRangeAddress(firstRow, secondRow, firstColumn, secondColumn));
	}

	/** Create a report for year */
	public void yearReport(String year) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		Sheet sheet0 = workbook.createSheet(WorkbookUtil.createSafeSheetName("NAVIGATION PAGE"));
		Sheet sheet1 = workbook.createSheet(WorkbookUtil.createSafeSheetName("YEAR " + year + " REPORT"));
		Sheet sheet2 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 1"));
		Sheet sheet3 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 2"));
		Sheet sheet4 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 3"));
		Sheet sheet5 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 5"));
		Sheet sheet6 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 6"));
		Sheet sheet7 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 7"));
		Sheet sheet8 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 9"));
		Sheet sheet9 = workbook.createSheet(WorkbookUtil.createSafeSheetName("INDICATOR 10"));
		Sheet sheet10 = workbook.createSheet(WorkbookUtil.createSafeSheetName("COMMENTAIRES AUA"));
		CellStyle cellStyle = GeneratorStyle.createCellStyle(workbook, "titre1");
		cellStyle.setFont(GeneratorStyle.createFont(workbook, "titre1"));
		CellStyle style2 = GeneratorStyle.createCellStyle(workbook, "titre2");
		style2.setFont(GeneratorStyle.createFont(workbook, "titre2"));
		CellStyle style3 = GeneratorStyle.createCellStyle(workbook, "titre3");
		style3.setFont(GeneratorStyle.createFont(workbook, "titre3"));
		CellStyle style4 = GeneratorStyle.createCellStyle(workbook, "titre4");
		style4.setFont(GeneratorStyle.createFont(workbook, "titre4"));
		CellStyle style5 = GeneratorStyle.createCellStyle(workbook, "titre5");
		style5.setFont(GeneratorStyle.createFont(workbook, "titre5"));
		CellStyle style6 = GeneratorStyle.createCellStyle(workbook, "titre6");
		style6.setFont(GeneratorStyle.createFont(workbook, "titre6"));
		CellStyle style7 = GeneratorStyle.createCellStyle(workbook, "titre7");
		style7.setFont(GeneratorStyle.createFont(workbook, "titre6"));
		CellStyle style8 = GeneratorStyle.createCellStyle(workbook, "titre8");
		style8.setFont(GeneratorStyle.createFont(workbook, "titre6"));
		CellStyle style9 = GeneratorStyle.createCellStyle(workbook, "titre9");
		style9.setFont(GeneratorStyle.createFont(workbook, "titre9"));
		CellStyle style10 = GeneratorStyle.createCellStyle(workbook, "titre10");
		style10.setFont(GeneratorStyle.createFont(workbook, "titre10"));
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
		Cell[] cells12 = new Cell[12];
		Cell[] cells13 = new Cell[12];
		Cell[] cells14 = new Cell[12];
		Cell[] cells15 = new Cell[12];
		Cell[] cells16 = new Cell[12];
		Cell[] cells17 = new Cell[12];
		Cell[] cells18 = new Cell[12];
		Cell[] cells19 = new Cell[12];
		Cell[] cells20 = new Cell[12];
		Cell[] cells21 = new Cell[12];
		Cell[] cells22 = new Cell[12];
		Cell[] cells23 = new Cell[12];
		Cell[] cells24 = new Cell[12];
		Cell[] cells25 = new Cell[12];
		Cell[] cells26 = new Cell[12];
		Cell[] cells27 = new Cell[12];
		Cell[] cells28 = new Cell[12];
		Cell[] cells29 = new Cell[12];
		Cell[] cells30 = new Cell[12];
		Cell[] cells31 = new Cell[12];
		Cell[] cells32 = new Cell[12];
		Cell[] cells33 = new Cell[12];
		Cell[] cells34 = new Cell[12];
		Cell[] cells35 = new Cell[12];
		Cell[] cells36 = new Cell[12];
		Cell[] cells37 = new Cell[12];
		Cell[] cells38 = new Cell[12];
		Cell[] cells39 = new Cell[12];
		Cell[] cells40 = new Cell[12];
		Cell[] cells41 = new Cell[12];
		Cell[] cells42 = new Cell[12];
		Cell[] cells43 = new Cell[12];
		Cell[] cells44 = new Cell[12];

		sheet1.setColumnWidth(0, 7500);
		sheet1.setColumnWidth(1, 2500);
		sheet1.setColumnWidth(2, 5000);
		sheet1.setColumnWidth(3, 3000);
		sheet1.setColumnWidth(4, 3000);
		sheet1.setColumnWidth(5, 3000);
		sheet1.setColumnWidth(6, 3000);
		sheet1.setColumnWidth(7, 3000);
		sheet1.setColumnWidth(8, 3000);
		sheet1.setColumnWidth(9, 5000);
		sheet1.setColumnWidth(10, 6000);
		sheet1.setColumnWidth(11, 9000);

		Row[] rows = new Row[100];
		rows[0]= sheet0.createRow(0);
		Cell test= rows[0].createCell(0);
		test.setCellValue("test link");
		org.apache.poi.ss.usermodel.Hyperlink link = workbook.getCreationHelper().createHyperlink(Hyperlink.LINK_DOCUMENT);
		link.setAddress("INDICATOR 1");
		test.setHyperlink(link);
		for (int i = 0; i < 99; i++) {
			rows[i] = sheet1.createRow(i);
		}
		/**TEST COULEUR*/
		GeneratorStyle.testColor(rows, workbook);
		/**TEST COULEUR*/
		
		/** Hauteur des lignes Height */
		rows[1].setHeightInPoints(25);
		rows[2].setHeightInPoints(12);
		for (int i = 3; i < 9; i++) {
			rows[i].setHeightInPoints(25);
		}
		rows[9].setHeightInPoints(55);
		rows[11].setHeightInPoints(25);
		rows[12].setHeightInPoints(30);
		rows[13].setHeightInPoints(45);
		rows[14].setHeightInPoints(25);
		rows[15].setHeightInPoints(25);
		rows[16].setHeightInPoints(45);
		rows[17].setHeightInPoints(25);
		rows[18].setHeightInPoints(60);
		rows[19].setHeightInPoints(25);
		rows[20].setHeightInPoints(25);
		rows[21].setHeightInPoints(25);
		
		rows[22].setHeightInPoints(65);
		rows[23].setHeightInPoints(65);
		rows[24].setHeightInPoints(30);
		rows[25].setHeightInPoints(30);
		rows[26].setHeightInPoints(90);
		
		rows[29].setHeightInPoints(70);
		for (int i = 30; i <=33; i++) {
			rows[i].setHeightInPoints(30);
		}
		rows[34].setHeightInPoints(50);
		rows[35].setHeightInPoints(110);
		rows[36].setHeightInPoints(70);
		for (int i = 37; i <=40; i++) {
			rows[i].setHeightInPoints(30);
		}
		for (int i = 41; i < 44; i++) {
			rows[i].setHeightInPoints(65);
		}
		/** Fusion des colonnes*/
		sheet1.addMergedRegion(new CellRangeAddress(1, 1, 0, 11));
		sheet1.addMergedRegion(new CellRangeAddress(10, 10, 0, 11));
		
		for (int i = 3; i < 10; i++) {
			sheet1.addMergedRegion(new CellRangeAddress(i, i, 1, 8));
			sheet1.addMergedRegion(new CellRangeAddress(i, i, 10, 11));
		}
		for(int i=0;i<5;i++){
			sheet1.addMergedRegion(new CellRangeAddress(11,12 , i, i));
		}
		sheet1.addMergedRegion(new CellRangeAddress(11,11 , 5, 8));
		for(int i=9;i<12;i++){
			sheet1.addMergedRegion(new CellRangeAddress(11,12 , i, i));
		}
		for(int i=0;i<3;i++){
			sheet1.addMergedRegion(new CellRangeAddress(13,17 , i, i));
			sheet1.addMergedRegion(new CellRangeAddress(18,21 , i, i));
			sheet1.addMergedRegion(new CellRangeAddress(23,25 , i, i));
			sheet1.addMergedRegion(new CellRangeAddress(29,33 , i, i));
			sheet1.addMergedRegion(new CellRangeAddress(36,40 , i, i));
		}
		sheet1.addMergedRegion(new CellRangeAddress(13,17 , 11, 11));
		sheet1.addMergedRegion(new CellRangeAddress(18,21 , 11, 11));
		sheet1.addMergedRegion(new CellRangeAddress(23,25 , 11, 11));
		sheet1.addMergedRegion(new CellRangeAddress(28,28 , 0, 2));
		sheet1.addMergedRegion(new CellRangeAddress(29,33 , 11, 11));
		sheet1.addMergedRegion(new CellRangeAddress(36,40 , 11, 11));
		
		
		/** Creation de cellule */
		for (int i = 0; i < 12; i++) {
			cells1[i] = rows[1].createCell(i);
			cells2[i] = rows[2].createCell(i);
			cells3[i] = rows[3].createCell(i);
			cells4[i] = rows[4].createCell(i);
			cells5[i] = rows[5].createCell(i);
			cells6[i] = rows[6].createCell(i);
			cells7[i] = rows[7].createCell(i);
			cells8[i] = rows[8].createCell(i);
			cells9[i] = rows[9].createCell(i);
			cells10[i] = rows[9].createCell(i);
			cells11[i] = rows[10].createCell(i);
			cells12[i] = rows[11].createCell(i);
			cells13[i] = rows[12].createCell(i);
			cells14[i] = rows[13].createCell(i);
			cells15[i] = rows[14].createCell(i);
			cells16[i] = rows[15].createCell(i);
			cells17[i] = rows[16].createCell(i);
			cells18[i] = rows[17].createCell(i);
			cells19[i] = rows[18].createCell(i);
			cells20[i] = rows[19].createCell(i);
			cells21[i] = rows[20].createCell(i);
			cells22[i] = rows[21].createCell(i);
			cells23[i] = rows[22].createCell(i);
			cells24[i] = rows[23].createCell(i);
			cells25[i] = rows[24].createCell(i);
			cells26[i] = rows[25].createCell(i);
			cells27[i] = rows[26].createCell(i);
			cells28[i] = rows[27].createCell(i);
			cells29[i] = rows[28].createCell(i);
			cells30[i] = rows[29].createCell(i);
			cells31[i] = rows[30].createCell(i);
			cells32[i] = rows[31].createCell(i);
			cells33[i] = rows[32].createCell(i);
			cells34[i] = rows[33].createCell(i);
			cells35[i] = rows[34].createCell(i);
			cells36[i] = rows[35].createCell(i);
			cells37[i] = rows[36].createCell(i);
			cells38[i] = rows[37].createCell(i);
			cells39[i] = rows[38].createCell(i);
			cells40[i] = rows[39].createCell(i);
			cells41[i] = rows[40].createCell(i);
			cells42[i] = rows[41].createCell(i);
			cells43[i] = rows[42].createCell(i);
			cells44[i] = rows[43].createCell(i);
			/** Add style*/
			cells2[i].setCellStyle(cellStyle);
			cells1[i].setCellStyle(cellStyle);
			cells11[i].setCellStyle(cellStyle);
			cells12[i].setCellStyle(style6);
			if(i==10){
				for(int j=13; j<44;j++){
					rows[j].getCell(i).setCellStyle(style6);
				}
			}
			if(i>8 || i<5){
				cells13[i].setCellStyle(style6);
			}else{
				cells13[i].setCellStyle(style7);
			}
			switch (i) {
			case 0: {
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
			case 1:	case 2: case 3: case 4: case 5: case 6: case 7: case 8: 
			{
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
			case 9: {
				cells3[i].setCellStyle(style4);
				cells4[i].setCellStyle(style4);
				cells5[i].setCellStyle(style4);
				cells6[i].setCellStyle(style4);
				cells7[i].setCellStyle(style4);
				cells8[i].setCellStyle(style4);
				cells9[i].setCellStyle(style4);
				cells10[i].setCellStyle(style4);
			}
				break;
			case 10: case 11: {
				cells3[i].setCellStyle(style5);
				cells4[i].setCellStyle(style5);
				cells5[i].setCellStyle(style5);
				cells6[i].setCellStyle(style5);
				cells7[i].setCellStyle(style5);
				cells8[i].setCellStyle(style5);
				cells9[i].setCellStyle(style5);
				cells10[i].setCellStyle(style5);
			}
				break;
			}
		}
		CellStyle colorStyle=workbook.createCellStyle();
		colorStyle.setFillForegroundColor((short)34);
		for(int i=4;i<9;i++){
			rows[13].getCell(i).setCellStyle(colorStyle);
		}
		for(int i=13;i<44;i++){
			rows[i].getCell(0).setCellStyle(style8);
			for(int j=1;j<10;j++){
				rows[i].getCell(j).setCellStyle(style9);
			}
			rows[i].getCell(11).setCellStyle(style10);
		}
		
		/** Add contained in the cell */
		cells1[0].setCellValue("ACE PROGRAMME - RESULTS FRAMEWORK");
		cells3[0].setCellValue("Project Title:");
		cells3[1].setCellValue(
				"Centre d’Excellence Africain en Mathematiques, Informatique et Technologies de l’Information et de la Communication (CEA-MITIC)");
		cells3[9].setCellValue("Total Grant (US$):");
		cells3[10].setCellValue("8.000.000 $US");
		
		cells4[0].setCellValue("Grant ID #:");
		cells4[1].setCellValue(036);
		cells4[9].setCellValue("Total Disbursement:");

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

		cells12[0].setCellValue("ACE Level Results Indicators");
		cells12[1].setCellValue("Core");
		cells12[2].setCellValue("Unit of Measure");
		cells12[3].setCellValue("Specifics");
		cells12[4].setCellValue("Baseline \n (Nov.2013)");
		cells12[5].setCellValue("Cummulative target Values");
		cells12[9].setCellValue("Status as of 30 October \n 2015");
		cells12[10].setCellValue("Variance");
		cells12[11].setCellValue("Comments");
		
		cells13[5].setCellValue("Year 1 \n (Jun. 2015)");
		cells13[6].setCellValue("Year 2 \n (Jun. 2016)");
		cells13[7].setCellValue("Year 3 \n (Jun. 2017)");
		cells13[8].setCellValue("Year 4 \n (Jun. 2018)");
		
		cells14[0].setCellValue("Indicator 1: No of regional and national students (disaggregated) enrolled in  specialized short-term courses, Master, PhD, programs [No of which are females] (→ Regionality)");
		cells14[2].setCellValue("Number/ % \n (Indicator Definition: Count of non –national students in new ACE courses)");
		cells14[3].setCellValue("Total number of enrolled students");
		cells14[4].setCellValue(300);
		cells14[5].setCellFormula("F15+F17");
		cells14[6].setCellFormula("G15+G17");
		cells14[7].setCellFormula("H15+H17");
		cells14[8].setCellFormula("I15+I17");
		cells14[9].setCellValue(342);
		cells14[10].setCellFormula("J14-F14");
		cells14[11].setCellValue("les cibles des indicateurs globaux ne sont pas encore atteintes du fait du retard de démarrage du projet. Toutefois les cibles des indicateurs intermédiaires de 2015 de la régionalité et du genre sont atteintes avec des écarts positifs. C'est la cible des étudiants nationaux qui n'est pas encore atteinte.");
		
		cells15[4].setCellValue(40);
		cells15[5].setCellValue(60);
		cells15[6].setCellValue(90);
		cells15[7].setCellValue(125);
		cells15[8].setCellValue(165);
		cells15[9].setCellValue(80);
		cells15[10].setCellFormula("J15-F15");

		cells16[4].setCellValue(10);
		cells16[5].setCellValue(15);
		cells16[6].setCellValue(20);
		cells16[7].setCellValue(30);
		cells16[8].setCellValue(40);
		cells16[9].setCellValue(16);
		cells16[10].setCellFormula("J16-F16");

		cells17[4].setCellValue(311);
		cells17[5].setCellValue(340);
		cells17[6].setCellValue(360);
		cells17[7].setCellValue(375);
		cells17[8].setCellValue(385);
		cells17[9].setCellValue(262);
		cells17[10].setCellFormula("J17-F17");

		cells18[4].setCellValue(40);
		cells18[5].setCellValue(45);
		cells18[6].setCellValue(50);
		cells18[7].setCellValue(60);
		cells18[8].setCellValue(70);
		cells18[9].setCellValue(53);
		cells18[10].setCellFormula("J18-F18");
		
		cells19[0].setCellValue("Indicator 1b: No. of regional students enrolled in  specific specialised/ new ACE courses  (→ Regionality)");
		cells19[2].setCellValue("Number \n (Indicator Definition: Count of regional students in specific ACE courses)");
		cells19[3].setCellValue("Total regional students enrolled");
		cells19[4].setCellValue(40);
		cells19[5].setCellValue(60);
		cells19[6].setCellValue(90);
		cells19[7].setCellValue(125);
		cells19[8].setCellValue(165);
		cells19[9].setCellValue(80);
		cells19[10].setCellValue(20);

		cells20[3].setCellValue("PhD");
		cells20[4].setCellValue(3);
		cells20[5].setCellValue(12);
		cells20[6].setCellValue(15);
		cells20[7].setCellValue(20);
		cells20[8].setCellValue(25);
		cells20[9].setCellValue(5);
		cells20[10].setCellValue(2);

		cells21[3].setCellValue("Masters");
		cells21[4].setCellValue(37);
		cells21[5].setCellValue(40);
		cells21[6].setCellValue(55);
		cells21[7].setCellValue(70);
		cells21[8].setCellValue(90);
		cells21[9].setCellValue(62);
		cells21[10].setCellValue(25);

		cells22[3].setCellValue("Short Courses");
		cells22[4].setCellValue(0);
		cells22[5].setCellValue(8);
		cells22[6].setCellValue(20);
		cells22[7].setCellValue(35);
		cells22[8].setCellValue(50);
		cells22[9].setCellValue(13);
		cells22[10].setCellValue(5);
		
		cells23[0].setCellValue("Indicator 1b: No. of regional students enrolled in  specific specialised/ new ACE courses  (→ Regionality)");
		cells23[2].setCellValue("Number \n (Indicator Definition: Count of regional students in specific ACE courses)");
		cells23[3].setCellValue("");
		cells23[4].setCellValue(5);
		cells23[5].setCellFormula("E23+3");
		cells23[6].setCellFormula("F23+3");
		cells23[7].setCellFormula("G23");
		cells23[8].setCellFormula("H23+3");
		cells23[9].setCellValue(5);
		cells23[10].setCellFormula("J23-F23");
		cells23[11].setCellValue("Activité non exécutée du fait du retard accusé dans le démarrage du projet");

		cells24[0].setCellValue("Indicator 3: No. of Students /faculty with at least 1 month internship in a company or a local institution relevant to their field/ sector (→ Outreach)");
		cells24[2].setCellValue("Number  (Indicator Definition: Count of students or faculty with at least 1 month internship in ACE related private company or institution)");
		cells24[3].setCellValue("Total number of students and faculty trained");
		cells24[4].setCellValue(25);
		cells24[5].setCellValue(75);
		cells24[6].setCellValue(100);
		cells24[7].setCellValue(125);
		cells24[8].setCellValue(150);
		cells24[9].setCellValue(45);
		cells24[10].setCellFormula("J24-F24");
		cells24[11].setCellValue("Erreur baseline : les étiudiants du CEA vont en stage à partir du Master 2. L'effectif des étudiants du M2 est la cible des étudiants à envoyer en stage. Alors que la valeur reportée pour le baseline est l'ensemble des étudiants inscrits au CEA. ");
		
		cells25[3].setCellValue("Students");
		cells25[4].setCellValue(24);
		cells25[5].setCellValue(72);
		cells25[6].setCellValue(97);
		cells25[7].setCellValue(122);
		cells25[8].setCellValue(147);
		cells25[9].setCellValue(44);
		cells25[10].setCellFormula("J25-F25");

		cells26[3].setCellValue("Faculty");
		cells26[4].setCellValue(1);
		cells26[5].setCellValue(3);
		cells26[6].setCellValue(3);
		cells26[7].setCellValue(3);
		cells26[8].setCellValue(3);
		cells26[9].setCellValue(0);
		cells26[10].setCellFormula("J26-F26");

		cells27[0].setCellValue("Indicator 4:  Amount of externally generated revenue by the ACEs  as paid into the designated ACE-Programme account  (→ Training & Research Quality)");
		cells27[2].setCellValue("US Dollars (Indicator Definition: Amount of US Dollars  generated from outside ACE as percentage of total US Dollars generated by ACE)");
		cells27[3].setCellValue("");
		cells27[4].setCellValue(243000);
		cells27[5].setCellValue(267500);
		cells27[6].setCellValue(292500);
		cells27[7].setCellValue(317500);
		cells27[8].setCellValue(342500);
		cells27[9].setCellValue(24300);
		cells27[10].setCellFormula("J27-F27");
		cells27[11].setCellValue("les activités de génération de ressources n'ont pas encore débutées du fait du retard accusé dans le démarrage du projet");

		cells28[0].setCellValue("INTERMEDIATE RESULTS");
		cells29[0].setCellValue("Intermediate Result: Component 1");

		cells30[0].setCellValue("Indicator 5. No of regional and national faculty trained by the ACEs(→ Training Quality");
		cells30[2].setCellValue("Number (Indicator Definition: Count of faculty trained in relevant area )");
		cells30[3].setCellValue("Total number of regional and national faculty trained ");
		cells30[4].setCellValue(0);
		cells30[5].setCellValue(40);
		cells30[6].setCellValue(50);
		cells30[7].setCellValue(60);
		cells30[8].setCellValue(90);
		cells30[9].setCellValue(0);
		cells30[10].setCellFormula("J30-F30");
		cells30[11].setCellValue("Activité non exécutée du fait du retard accusé dans le démarrage du projet");

		cells31[3].setCellValue("Regional \n (Total)");
		cells31[4].setCellValue(0);
		cells31[5].setCellValue(10);
		cells31[6].setCellValue(10);
		cells31[7].setCellValue(15);
		cells31[8].setCellValue(25);
		cells31[9].setCellValue(0);
		cells31[10].setCellFormula("J31-F31");

		cells32[3].setCellValue("Regional (Female)");
		cells32[4].setCellValue(0);
		cells32[5].setCellValue(5);
		cells32[6].setCellValue(7);
		cells32[7].setCellValue(9);
		cells32[8].setCellValue(10);
		cells32[9].setCellValue(0);
		cells32[10].setCellFormula("J32-F32");

		cells33[3].setCellValue("National (Total)");
		cells33[4].setCellValue(0);
		cells33[5].setCellValue(30);
		cells33[6].setCellValue(40);
		cells33[7].setCellValue(45);
		cells33[8].setCellValue(65);
		cells33[9].setCellValue(0);
		cells33[10].setCellFormula("J33-F33");

		cells34[3].setCellValue("National (Female)");
		cells34[4].setCellValue(0);
		cells34[5].setCellValue(5);
		cells34[6].setCellValue(7);
		cells34[7].setCellValue(9);
		cells34[8].setCellValue(10);
		cells34[9].setCellValue(0);
		cells34[10].setCellFormula("J34-F34");

		cells35[0].setCellValue("Indicator 6. No of newly established or substantially revised curricula (→ Training Quality)");
		cells35[2].setCellValue("Number (Indicator Definition: Count of new/revised curricula)");
		cells35[3].setCellValue("NA");
		cells35[4].setCellValue(2);
		cells35[5].setCellValue(5);
		cells35[6].setCellValue(9);
		cells35[7].setCellValue(9);
		cells35[8].setCellValue(9);
		cells35[9].setCellValue(6);
		cells35[10].setCellFormula("J35-F35");
		cells35[11].setCellValue("");

		cells36[0].setCellValue("Indicator 7. Increase of internationally recognized research publications by the ACEs(→ Research Quantity and Quality)");
		cells36[2].setCellValue("Percentage(Indicator Definition: # of Internationally recognized ACE publications as % of total number of publications produced by ACE)");
		cells36[3].setCellValue("NA");
		cells36[4].setCellValue(14);
		cells36[5].setCellValue(18);
		cells36[6].setCellValue(20);
		cells36[7].setCellValue(25);
		cells36[8].setCellValue(30);
		cells36[9].setCellValue(79);
		cells36[10].setCellFormula("J36-F36");
		cells36[11].setCellValue("");

		cells37[0].setCellValue("Indicator 8. % (number) of regional students studying for a longer-term (at least 1 semester/ academic term) in ACEs, in a discipline supported through the ACE-Programme  (→Regionality)");
		cells37[2].setCellValue("Percentage (number) (Indicator Definition: Count of non-national students studying for at least 1 semester at ACE on programme supported course as % of total # of Students studying for at laest one year)");
		cells37[3].setCellValue("Total number of students studying for a longer-term in ACEs");
		cells37[4].setCellValue(2);
		cells37[5].setCellValue(50);
		cells37[6].setCellValue(60);
		cells37[7].setCellValue(80);
		cells37[8].setCellValue(100);
		cells37[9].setCellValue(2);
		cells37[10].setCellFormula("J37-F37");
		cells37[11].setCellValue("Activité non exécutée du fait du retard accusé dans le démarrage du projet");
		
		cells38[3].setCellValue("Regional (Total)");
		cells38[4].setCellValue(0);
		cells38[5].setCellValue(10);
		cells38[6].setCellValue(15);
		cells38[7].setCellValue(20);
		cells38[8].setCellValue(30);
		cells38[9].setCellValue(0);
		cells38[10].setCellFormula("J38-F38");
		
		cells39[3].setCellValue("Regional (Female)");
		cells39[4].setCellValue(0);
		cells39[5].setCellValue(20);
		cells39[6].setCellValue(30);
		cells39[7].setCellValue(40);
		cells39[8].setCellValue(50);
		cells39[9].setCellValue(0);
		cells39[10].setCellFormula("J39-F39");
		
		cells40[3].setCellValue("National (Total)");
		cells40[4].setCellValue(0);
		cells40[5].setCellValue(90);
		cells40[6].setCellValue(85);
		cells40[7].setCellValue(80);
		cells40[8].setCellValue(70);
		cells40[9].setCellValue(0);
		cells40[10].setCellFormula("J40-F40");

		cells41[3].setCellValue("National (Female");
		cells41[4].setCellValue(0);
		cells41[5].setCellValue(20);
		cells41[6].setCellValue(30);
		cells41[7].setCellValue(40);
		cells41[8].setCellValue(50);
		cells41[9].setCellValue(0);
		cells41[10].setCellFormula("J41-F41");

		cells42[0].setCellValue("Indicator 9. No of partnership agreements between ACEs and engaged Partner Institutions (→ Outreach/ Regionality)");
		cells42[2].setCellValue("Number (Indicator Definition: Count of partnership agreements )");
		cells42[3].setCellValue("NA");
		cells42[4].setCellValue(0);
		cells42[5].setCellValue(10);
		cells42[6].setCellValue(15);
		cells42[7].setCellValue(16);
		cells42[8].setCellValue(16);
		cells42[9].setCellValue(13);
		cells42[10].setCellFormula("J42-F42");

		cells43[0].setCellValue("Indicator 10. ACE-Programme Implementation team meetings with openly disclosed minutes (→ Admin./Governance Quality)");
		cells43[2].setCellValue("Number (Indicator Definition: Count of ACE Implementation team meetings)");
		cells43[3].setCellValue("NA");
		cells43[4].setCellValue(0);
		cells43[5].setCellValue(4);
		cells43[6].setCellValue(4);
		cells43[7].setCellValue(4);
		cells43[8].setCellValue(4);
		cells43[9].setCellValue(5);
		cells43[10].setCellFormula("J43-F43");

		cells44[0].setCellValue("Indicator 11. Annual disclosed unqualified external financial audit, with ACE annual budget                                                             (→ Admin./Governance Quality)");
		cells44[2].setCellValue("Non-applicable ");
		cells44[3].setCellValue("");
		cells44[4].setCellValue("Done");
		cells44[5].setCellValue("Done");
		cells44[6].setCellValue("Done");
		cells44[7].setCellValue("Done");
		cells44[8].setCellValue("Done");
		cells44[9].setCellValue("Done");
		cells44[10].setCellValue("Done");
		
		
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
