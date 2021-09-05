package pavanOnlineTrainingApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws IOException {


		// blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// create a sheet in the workbook
		XSSFSheet sheet = workbook.createSheet("Employee Data");

		Object[][] empData = { { "ID", "NAME", "LASTNAME" }, { 1, "Amit", "Shukla" }, { 2, "Lokesh", "Gupta" },
				{ 3, "John", "Adwards1" } };

		int rows = empData.length;
		int cols = empData[0].length;
		System.out.println("Rows:" + rows);
		System.out.println("Column:" + cols);

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for (int c = 0; c < cols; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = empData[r][c];
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}

		String filepath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\main\\resources\\excelFilesList\\WriteDataInExcel.xlsx";
		FileOutputStream outputStream = new FileOutputStream(filepath);
		workbook.write(outputStream);
		
		outputStream.close();
		System.out.println("EMployeed data got updated.");
	}

}
