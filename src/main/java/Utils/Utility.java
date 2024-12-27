package Utils;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
	import java.util.Random;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Utility { 
		private WebDriver driver;
		public static void captureScreenshot(WebDriver driver,String testID) throws IOException {			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
//			Date date=new Date();
//			String FileName = date.toString().replace(" ","_").replace(":", " ") ;
			String FileName = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss").format(new Date());	
			
			File dest= new File("test-output\\FailedScreeshots\\Test"+testID+" "+FileName+".jpg");
			FileHandler.copy(src,dest );			
		}
		
		
		public String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);

			sourceFile.renameTo(targetFile);

			return targetFilePath;

		}
		
		
		
		
		
//		public static String fetchDataFromExcelSheet(String sheet,int row, int column) throws EncryptedDocumentException, IOException {
//			String path= "src/main/resources/data/testdata.xlsx"; 
//			FileInputStream file= new FileInputStream(new File(path));
//			String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
//			return data;
//		}	
		
		
			

}

	