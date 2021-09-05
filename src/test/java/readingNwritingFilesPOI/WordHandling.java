package readingNwritingFilesPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordHandling {

	public static void main(String[] args) throws IOException {

		String filePath = "E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\TestDataPOI\\readingDocfile.docx";

		/*
		 * File fileDemo = new File(filePath);
		 * 
		 * FileInputStream fis = new FileInputStream(fileDemo); XWPFDocument doc =new
		 * XWPFDocument(fis); System.out.println(doc.getParagraphs());
		 */
		loadFile(filePath);

	}

	public static void loadFile(String filePath) throws IOException {

		File file = new File(filePath);
		String fileExtension = FilenameUtils.getExtension(filePath);
		if (fileExtension.equalsIgnoreCase("docx")) {
			readDocxFile(file);
		} else {
			readDocFile(file);
		}
	}

	public static void readDocxFile(File file) throws IOException {

		FileInputStream fis = new FileInputStream(file);
		XWPFDocument docx = new XWPFDocument(fis);
		List<XWPFParagraph> getdocxparagraphs = docx.getParagraphs();
		int totalParagraphs = getdocxparagraphs.size();
		System.out.println("Total number of paragraphs : " + totalParagraphs);
		
		/*
		 * for (XWPFParagraph currentParagraph : getdocxparagraphs) {
		 * System.out.println(currentParagraph.getText().toString()); }
		 */
		
		Iterator<XWPFParagraph> para1 = docx.getParagraphsIterator();
		while (para1.hasNext()) {
			System.out.println(para1.next().getText());
		}

		docx.close();
	}



	public static void readDocFile(File file) throws IOException {
		
	}
}
