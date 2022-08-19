package qaclickacademy;

import java.util.ArrayList;

public class testSample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		dataDriven obj=new dataDriven();
		
		ArrayList data=obj.getData("Add Profile");
		
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
//		for(String s:data)
//		{
//			System.out.println(s);
//		}
	}

}
