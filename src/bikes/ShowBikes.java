package bikes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ShowBikes {

	public static void main(String[] args) {
		
		String bike_gear = new String();
		String bike_type = null ;
		String bike_wb ;
		String bike_height;
		String bike_color;
		String bike_material;
		int last_args = 0  ;
		// REading arguments	
		final String FILENAME = "/home/vin/IoT/unsorted.txt";
	
		BufferedReader br = null;
		FileReader fr = null;

		try {


			fr = new FileReader(FILENAME);
			
			br = new BufferedReader(fr);

			String sCurrentLine;
			LinkedList list = new LinkedList();
			while ((sCurrentLine = br.readLine()) != null) {
				String[] parts = sCurrentLine.split("-", 7);
				String type = parts[0];
				int gear =  Integer.parseInt(parts[1]);
				int height =  Integer.parseInt(parts[2]);
				int wheelbase =  Integer.parseInt(parts[3]);
				String color =  parts[4];
				String material =  parts[5];
				
				BikeInfo b1 = new BikeInfo(type , gear , height , wheelbase , color , material );
				list.add(b1);
			   
   		    
			}
			
			//list.show();
			String type = "dummy";
			BikeInfo dummyForSearch = new BikeInfo(null ,-1,-1,-1,null,null);
			String searchKey = args[args.length - 1 ];
			System.out.print(searchKey);
			
			for(int i =0; i<args.length-1; i=i+1) {

				if(args[i].equals("-type")){
					dummyForSearch.type = args[i+1];
				}
				else if (args[i].equals("-color")){
					dummyForSearch.color = args[i+1];
				}
				else if(args[i].equals("-material")){
					dummyForSearch.material = args[i+1];
				}
				else if(args[i].equals("-gear")){
					
						dummyForSearch.gear = Integer.parseInt(args[i+1]);
						
				}
				else if(args[i].equals("-wheelbase")){
						
						dummyForSearch.wheelbase = Integer.parseInt(args[i+1]);	
				
				}
				else if(args[i].equals("-height")){
						
						dummyForSearch.height = Integer.parseInt(args[i+1]);
						
				
						
				}
			}
		System.out.println(last_args);
		list.search2(dummyForSearch, searchKey);
		//list.sort(last_args);
		//list.show();
		
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

			
	}
}
