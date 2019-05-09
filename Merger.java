/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {
	int iterate = start0;
	int iterateFirstList = start0;
	int iterateSecondList = start1;
	ArrayList<String> newList = new ArrayList<String>();
	while(newList.size() < nItems - start0) {
	    if ((usersData.get(start0).compareTo(usersData.get(start1))) > 0) {
		newList.add(usersData.get(start1));
		start1++;
		System.out.println(newList);
	    }
	    else {
		newList.add(usersData.get(start0));
		start0++;
		System.out.println(newList);
	    }
	}
	
	for(String item : newList){
	    usersData.set(iterate, item);
	    iterate++;
	}
	
	
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData; 
    }

    
    /** 
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0){
		return false;
		
	    }
        return true;
    }
}
