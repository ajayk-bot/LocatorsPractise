package pavanOnlineTrainingApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		String excelPath = ".\\src\\main\\resources\\excelFilesList\\ReadDataExcel.xlsx";
		// File file = new File(excelPath);
		FileInputStream inputStream = new FileInputStream(new File(excelPath));
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		// using for loop
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		System.out.println("Number of rows in sheet :" + rows);
		System.out.println("Number of column in sheet : " + cols);

		System.out.println("------ USING for loop to read excel ----------");
		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.getCell(c);
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println(" ");
		}
		
		//using iterator
		
		System.out.println("------ USING iterator ----------");
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			Iterator<Cell> cellItr = row.cellIterator();
			
			while (cellItr.hasNext()) {
				Cell cell = cellItr.next();
				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print(" | ");
			}
			System.out.println(" ");
			
		}

	}

}
