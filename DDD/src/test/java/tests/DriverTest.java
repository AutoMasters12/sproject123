package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DriverTest {

	@Test
	public void test() throws Exception {
		String path = "F:\\week2\\DDD\\src\\test\\resources\\testdata\\data_xls.xls";
		File f = new File(path);
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet("businessflow");
		int rows = s.getRows();
		int cols = s.getColumns();
		ArrayList<String> al;
		for (int i = 1; i < rows; i++) {
			System.out.println("testcase :" + i);
			al = new ArrayList<>();
			for (int j = 1; j < cols; j++) {
				String keyword = s.getCell(j, i).getContents();
				if (!keyword.equals("")) {
					al.add(keyword);
				}
			}
			for (String xlmethod : al) {
				File folder = new File("F:\\week2\\DDD\\src\\main\\java\\components");
				File files[] = folder.listFiles();
				for (File file : files) {
					String filename = file.getName().replace(".java", "");
					Class<?> c = Class.forName("components." + filename);
					//System.out.println(filename);
					Object obj = c.newInstance();
					Method methods[] = c.getDeclaredMethods();
					for (Method m : methods) {
						if(xlmethod.equals(m.getName())) {
							m.invoke(obj);
						}
						//System.out.println(m.getName());
					}
				}
			}
		}
		
	}

}
