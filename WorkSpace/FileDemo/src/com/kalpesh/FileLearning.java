package com.kalpesh;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class FileLearning {
	public static final String path = "static/myFile.doc";

	public static void main(String[] args) {
		WordExtractor ext;
		HWPFDocument doc;
		String poip = "";
		FileInputStream fs;
		try {
			fs = new FileInputStream(path);
			doc = new HWPFDocument(fs);
			ext = new WordExtractor(doc);
			poip = ext.getText();
			System.out.println(poip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
