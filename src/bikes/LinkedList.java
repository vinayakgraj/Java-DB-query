package bikes;

public class LinkedList {
	public Node head;
	public int listCount;

	public LinkedList(){
		//head = new Node();
		listCount = 0;
	}

	public void show(){
		Node current = head;
		while(current!=null){
			System.out.println(current.data);
			current = current.next;
		}
	}
	
	
	public void search2(BikeInfo dummy, String searchKey)
    {
		 Node current = head;
		 LinkedList unsortedList = new LinkedList();
		 //int flag = lastarg ;
		//System.out.println(lastarg);	
			

		 while(current != null) {
			 if( (dummy.type == null ||  current.data.type.equals(dummy.type)) &&
					 (dummy.color == null ||  current.data.color.equals(dummy.color)) &&
					 (dummy.material == null ||  current.data.material.equals(dummy.material)) &&
					 (dummy.wheelbase == -1 ||  current.data.wheelbase == dummy.wheelbase) &&
					 (dummy.height == -1 ||  current.data.height == dummy.height) &&
					 (dummy.gear == -1 ||  current.data.gear == dummy.gear))
			 {
	     				//System.out.println(current.data);
				 BikeInfo b2 = new BikeInfo(current.data.type , current.data.gear, current.data.wheelbase , current.data.height , current.data.color , current.data.material );
				 unsortedList.add(b2);
			 }
			 
			 //Add the cuurent into new list
			 // sort that list on the basis of flag
			 // show it 
			 current = current.next;
		 }
		unsortedList.sort(searchKey);
		unsortedList.show();
		 
	}
    							 
	
	public void sort(String searchKey) {
        
        	boolean wasChanged;
 
            do {
               // System.out.println(last_args);
            	Node current = head;
                Node previous = null;
                Node next = head.next;
                wasChanged = false;
                int param ;
                while ( next != null ) {
                	int compareSrc = 0;
                	int compareDst = 0;
                	if (searchKey.equals("-wheelbase") ){
                		compareSrc = current.data.wheelbase;
                		compareDst = next.data.wheelbase;
                	}else if(searchKey.equals("-height")) {
                		compareSrc = current.data.height;
                		compareDst = next.data.height;
                	}else if(searchKey.equals("-gear")) {
                		compareSrc = current.data.gear;
                		compareDst = next.data.gear;
                		
                	}
                	if ( compareSrc> compareDst) {
                        /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                        wasChanged = true;
 
                        if ( previous != null ) {
                        	Node sig = next.next;
 
                        	previous.next = next;
                        	next.next = current;
                        	current.next = sig;
                        } else {
                        	Node sig = next.next;
 
                        	head = next;
                        	next.next = current;
                        	current.next = sig;
                        }
 
                        previous = next;
                        next = current.next;
                    } else { 
						previous = current;
	                    current = next;
	                    next = next.next;
                    }
                	
                	
                	
                	}	
               
                
            } while( wasChanged );
        }
	
   
    

    public boolean add(BikeInfo d){
    	Node end = new Node(d);
    	
    	if(head == null) {
    		head = end;
    		return true;
    	}
    	Node current = head;
    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = end;
    	listCount++;
      //  System.out.println(d+" appended to tail!");
        return true;
    }

    public boolean add(BikeInfo d,int index){
    	Node end = new Node(d);
    	Node current = head;
    	int jump;

    	if(index>listCount || index<1){
    		System.out.println("Add Failed: index out of bounds of size of linked list!!");
    		return false;
    	}
    	else{
    		jump = 0;
    		while(jump<index-1){
    			current = current.next;
    			jump++;
    		}
    		end.next = current.next;
    		current.next = end;
    		listCount++;
    		//System.out.println("Success! "+d+" added at index "+index);
            return true;
    	}
    }

    public boolean deleteNodeWithData(BikeInfo d){
    	Node current = head;
        while(current.next!=null){
            if(current.next.data==d){
                current.next = current.next.next;
                listCount--;
                System.out.println("Success! Node with data "+d+" deleted.");
                return true;
            }
            current = current.next;
        }
        System.out.println("Delete Failed: No node found with given data!");
        return false;
    }

    public boolean deleteNodeAtIndex(int index){
    	Node current = head;
    	int jump;
    	if(index>listCount || index<1){
    		System.out.println("Delete Failed: index out of bounds of size of linked list!!");
    		return false;
    	}    	
    	else{
    		jump=0;
    		while(jump<index-1){
    			current = current.next;
    			jump++;
    		}
    		current.next = current.next.next;
    		System.out.println("Success! Node at index "+index+" deleted.");
    		listCount--;
    		return true;
    	}
    	
    }
    
}