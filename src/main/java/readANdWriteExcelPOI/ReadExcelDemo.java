package readANdWriteExcelPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelDemo {
	
	

	private static final String STRING = null;

	public static void main(String[] args) throws IOException {

		String excelFilePath = "Books.xlsx";
		File file = new File(excelFilePath);
		FileInputStream fileinputstream = new FileInputStream(file);
		// FileInputStream fileinputstream = new FileInputStream(new
		// File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(fileinputstream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowitr = sheet.iterator();
		System.out.println( sheet.getLastRowNum() );
		
		while (rowitr.hasNext()) {
			Row nextrow = rowitr.next();
			Iterator<Cell> cellitr = nextrow.cellIterator();
			while (cellitr.hasNext()) {
				Cell cell = cellitr.next();
				System.out.println(cell);
				
				
				 switch(cell.getCellType()) {
		            case STRING:
		               System.out.println(cell.getStringCellValue()) ;
		                break;
		            case NUMERIC:
		            	  System.out.println(cell.getNumericCellValue());
		                break;
		            case BOOLEAN:
		            	  System.out.println(cell.getBooleanCellValue());
		                break;
		            }
				
				
			}
			
		}
		
		workbook.close();
		fileinputstream.close();
	}

}
