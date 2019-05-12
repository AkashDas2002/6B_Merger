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
	    if (iterateFirstList == start1){
		newList.add(usersData.get(iterateSecondList));
		iterateSecondList++;
	    }
	    else if (iterateSecondList == nItems) {
		newList.add(usersData.get(iterateFirstList));
		iterateFirstList++;
	    }
	    else if ((usersData.get(iterateFirstList).compareTo(usersData.get(iterateSecondList))) > 0) {
		newList.add(usersData.get(iterateSecondList));
		iterateSecondList++;
		//System.out.println(newList);
	    }
	    else {
		newList.add(usersData.get(iterateFirstList));
		iterateFirstList++;
		//System.out.println(newList);
	    }
	}
	
	for(String item : newList){
	    usersData.set(iterate, item);
	    iterate++;
	}
	
	
    }

    public void subSortThenMerge_Sorter(int start, int end) {
	if (end - start > 1) { //Boolean statement that determines wheter to use recursive case or base case
	    // The base case, although not explicitly written, is to do nothing (trivial)
	    
	    int mid = (start + end)/2;
	    subSortThenMerge_Sorter(start, mid); //recursive abstraction
	    subSortThenMerge_Sorter(mid,end); //recursive absstraction
	    // There is no leftover, but there are two recursive abstractions
	    merge(start, mid, end); //combiner
	    
	}

	else {}
    }

    public void subSortThenMerge_Sorter() {
	subSortThenMerge_Sorter(0,usersData.size());
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
