package common;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import tests.LoginPage;


public class Excel {

//	public static void main(String[] args) throws Exception {
//		Excel common = new Excel();
//		common.ExcelRead();
//	}
	
	public void ExcelRead() throws Exception {
		File src = new File("C:\\Users\\smishra7\\OneDrive - Capgemini\\Documents\\New.xls");
		FileInputStream fis = new FileInputStream(src);
		
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet ws = wb.getSheet("TestData"); 
		
		int rowCount = ws.getLastRowNum()+1;
		int colCount = ws.getRow(0).getLastCellNum();
		String [][] data =  new String[rowCount][colCount];
		
		for (int i = 0; i < rowCount; i++) {
			HSSFRow row = ws.getRow(i);
			for (int j = 0; j < colCount; j++) {
				HSSFCell cell = row.getCell(j);
//				String value = cellToString(cell);
//				String value = cell.toString();
				String val = cell.getStringCellValue();
				data[i][j]=val;
				System.out.println("value is "+val);			
			}			
		}
		wb.close();
	}	
}
