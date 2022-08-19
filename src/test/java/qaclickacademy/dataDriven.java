package qaclickacademy;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testcasename) throws Exception
	{
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("C:\\Users\\Zubair\\eclipse-workspace\\MavenJava\\src\\test\\java\\qaclickacademy\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
		int sheets=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			
			//identify Testcases column by scanning entire first row
			
			Iterator<Row> rows=sheet.iterator();//sheet is collection of rows
			Row firstrow=rows.next();
			Iterator<Cell> cell=firstrow.cellIterator();//row is collection of cells
			
			int k=0;
			int column = 0;
			while(cell.hasNext())
			{
				Cell value=cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("Testcases"))
				{
					column=k;
					
					//desired column
				}
				k++;
			}

			System.out.println(column);
			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
				{
					Iterator<Cell> itr=r.cellIterator();
					while(itr.hasNext())
					{
						Cell c=itr.next();
						if(c.getCellType()==CellType.STRING)
						{
							//System.out.println(itr.next().getStringCellValue());
						a.add(itr.next().getStringCellValue());
						}
						else if(c.getCellType()==CellType.NUMERIC)
						{
							//String intData=NumberToTextConverter.toText(itr.next().getNumericCellValue());
							a.add(NumberToTextConverter.toText(itr.next().getNumericCellValue()));
						}
					}
				}
				
			}
			
			}
		
		}
		return a;
	}


	
	//Identify testcases column by scanning entire first row
	//once column is identified then scan entire testcases column to identify purchase test case
	//after u grab purchase test case row grab the data
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.out.println("Hello");
//System.setProperty("Dlog4j2.loggerContextFactory", "org.apache.logging.log4j.simple.SimpleLoggerContextFactory");

		//File f=new File("/MavenJava/src/test/java/qaclickacademy/TestData.xlsx");

		}
}
