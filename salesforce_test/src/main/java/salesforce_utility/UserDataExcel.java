package salesforce_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class UserDataExcel {
	String celllaunch;
	String cellLogin;
	String cellUserName;
	String cellPassword;
	double wrongUser;
	double wrongPass;
	String celllastName;
	String cellemailId;
	String cellfullName;
	
	
	public UserDataExcel() throws Exception {
		String Excelpath = "C:\\Users\\pmuniraju\\Documents\\salesforce_data\\New_salesforce.xls";
		FileInputStream fi;
		try {
			fi = new FileInputStream(Excelpath);
		
		HSSFWorkbook myExcel = new HSSFWorkbook(fi);
		HSSFSheet mySheet = myExcel.getSheet("userdata");
		HSSFRow row0 = mySheet.getRow(0);
		HSSFRow row1 = mySheet.getRow(1);
		HSSFRow row2 = mySheet.getRow(2);
		HSSFRow row3 = mySheet.getRow(3);
		//this.celllaunch = celllaunch;
		this.celllaunch = row1.getCell(0).getStringCellValue();
		
		this.cellLogin = row2.getCell(0).getStringCellValue();
		this.cellUserName = row1.getCell(1).getStringCellValue();
		this.cellPassword = row1.getCell(2).getStringCellValue();
		//this.wrongUser = row1.getCell(3).getNumericCellValue();
		//this.wrongPass= row1.getCell(4).getNumericCellValue();
		this.celllastName = row1.getCell(3).getStringCellValue();
		this.cellemailId = row3.getCell(1).getStringCellValue();
		this.cellfullName = row2.getCell(3).getStringCellValue();
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/*public  void userValues() {
		String Excelpath = "C:\\Users\\pmuniraju\\Documents\\salesforce_data\\New_salesforce.xls";
		try {
			FileInputStream fi = new FileInputStream(Excelpath);
			HSSFWorkbook myExcel = new HSSFWorkbook(fi);
			HSSFSheet mySheet = myExcel.getSheet("userdata");
			HSSFRow row0 = mySheet.getRow(0);
			HSSFRow row1 = mySheet.getRow(1);
			HSSFRow row2 = mySheet.getRow(2);
			
			String celllaunch = row1.getCell(0).getStringCellValue();
			this.celllaunch = celllaunch;
			String cellLogin = row2.getCell(0).getStringCellValue();
			String cellUserName = row1.getCell(1).getStringCellValue();
			String cellPassword = row1.getCell(2).getStringCellValue();
			//System.out.println("cell1=" + row1.getCell(1).getStringCellValue());
			//String urlCell = "row0.getCell(0).getStringCellValue()";
			//System.out.println("cell0 =" + row0.getCell(0).getStringCellValue()); ;
			//System.out.println(celllaunch);
			System.out.println(cellLogin);
			System.out.println(cellUserName);
			System.out.println(cellPassword);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}*/
	
	public String getcelllaunch() {
		//this.celllaunch= celllaunch;
		return this.celllaunch;
	}
	
	public String getcelllogin() {
		return this.cellLogin;
	}
	public String getcellUser() {
		return this.cellUserName;
	}
	public String getcellPassword() {
		return this.cellPassword;
	}
	public double getwrongUser() {
		return this.wrongUser;
	}
	public double getwrongPass() {
		return this.wrongPass;
	}
	public String getcelllastName() {
		return this.celllastName;
	}
	public String getcellfullName() {
		return this.cellfullName;
	}
	public String getcellemailId() {
		return this.cellemailId;
	}
	
	
	
	/*public static void main(String []args) {
		UserDataExcel excel = new UserDataExcel();
		//excel.getcelllaunch();
		//System.out.println(excel.getcelllaunch());
		//System.out.println(excel.celllaunch);
	}*/

}
