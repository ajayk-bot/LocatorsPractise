package pavanOnlineTrainingApachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UsingHashMapOFMap {

	public static String excelPath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\main\\resources\\excelFilesList\\DataHashMap.xlsx";

	static FileInputStream fis;
	static Workbook workbook;
	static XSSFSheet sheet;
	static XSSFRow rows;
	static XSSFCell cells;

	public static void loadexcel() throws IOException {
		System.out.println("loading the excel file...");
		File file = new File(excelPath);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = (XSSFSheet) workbook.getSheet("ObjectRepo");
		fis.close();
	}

	public static Map<String, Map<String, String>> getDataMap() throws IOException {

		if (sheet == null) {
			loadexcel();
		}

		Map<String, Map<String, String>> superMap = new HashedMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashedMap<String, String>();
		// we need to loop through the sheet.

		for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
			rows = sheet.getRow(i);
			String keyCell = rows.getCell(0).getStringCellValue();

			for (int j = 1; j < rows.getLastCellNum(); j++) {
				String keyValue = rows.getCell(j).getStringCellValue();
				myMap.put(keyCell, keyValue);
			}

			superMap.put("MASTERKEY", myMap);
		}

		return superMap;

	}

	public static String getValue(String key) throws IOException {
		Map<String, String> myVal = getDataMap().get("MASTERKEY");
		String returnVal = myVal.get(key);
		return returnVal;

	}

	public static void main(String[] args) throws IOException {

		System.out.println(getValue("BaseUrl"));
		System.out.println(getValue("Username"));
		System.out.println(getValue("password"));
		System.out.println(getValue("firstname"));
		System.out.println(getValue("lastname"));
		System.out.println(getValue("middleName"));

	}

}
