package bikes;

public class BikeInfo {

	
	
	String type ;
	int gear;
	int wheelbase;
	int height;
	String color; 
	String material; 
	
public BikeInfo(String type , int gear,int wheelbase, int height, String color , String material) {
	
	this.type=type;
	this.gear=gear;
	this.wheelbase=wheelbase;
	this.height=height;
	this.material=material;
	this.color=color;
	
	
	
		 
	 }

 public String toString() {
	
return "Type: "+type+ ", Gear:"+gear+ ", Height:"
		+height+ ", Wheelbase: "+wheelbase + ", Material: "+material+", Color:"+ color + "\n";

}
	
}


