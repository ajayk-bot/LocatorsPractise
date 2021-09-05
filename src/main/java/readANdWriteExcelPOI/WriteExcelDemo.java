package readANdWriteExcelPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDemo {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub

		// blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// create a sheet in the workbook
		XSSFSheet sheet = workbook.createSheet("mapData");

		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "NAME", "LASTNAME" });
		data.put("2", new Object[] { 1, "Amit", "Shukla" });
		data.put("3", new Object[] { 2, "Lokesh", "Gupta" });
		data.put("4", new Object[] { 3, "John", "Adwards" });
		data.put("5", new Object[] { 4, "Brian", "Schultz" });

		// System.out.println(data);
		Set<String> key_set = data.keySet();
		System.out.println(key_set);
		//int rownum = sheet.getLastRowNum(); // return -1 no row is there in created sheet.
		int rownum = 0;
		
		for (String key : key_set) {
			XSSFRow row = sheet.createRow(rownum++);

			Object[] objArr = data.get(key_set);
			int cellnum = 0;
			
			for (Object obj : objArr) {
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
			}

		}

		String filePath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\main\\resources\\excelFilesList\\WriteData.xlsx";
		FileOutputStream outStream = new FileOutputStream(filePath);
		workbook.write(outStream);
		workbook.close();
		outStream.close();
		System.out.println("Writing on XLSX file Finished ...");
		
	}


}
