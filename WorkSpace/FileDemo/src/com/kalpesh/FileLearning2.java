package com.kalpesh;

import java.io.FileInputStream;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class FileLearning2 {
	public static final String path = "static/demo.docx";

	public static void main(String[] args) {
		XWPFWordExtractor ext;
		XWPFDocument doc;
		String poip = "";
		FileInputStream fs;
		try {
			fs = new FileInputStream(path);
			doc = new XWPFDocument(OPCPackage.open(fs));
			ext = new XWPFWordExtractor(doc);
			poip = ext.getText();
			System.out.println(poip);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
