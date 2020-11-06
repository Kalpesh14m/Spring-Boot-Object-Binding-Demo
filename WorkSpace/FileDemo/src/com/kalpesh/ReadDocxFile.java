
package com.kalpesh;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class ReadDocxFile {
	public static final String path = "static/myFile.doc";

	public static void main(String[] args) {
		try {
			FileInputStream fs = new FileInputStream(path);

			XWPFDocument doc = new XWPFDocument(fs);

			List<XWPFParagraph> paraList = doc.getParagraphs();

			for (XWPFParagraph para : paraList) {
				System.out.println(para.getText());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
