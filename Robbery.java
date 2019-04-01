public class Robbery {

	// Using DP: Get the maximum value with capacity C and n items
	public int Compare(int maximize1, int maximize2) {
		if (maximize1 > maximize2) return maximize1;
		else return maximize2;
	
	}
	public int maximizeRobWorthRecur(
		int capacity,
		int[] sizes,
		int[] worths,
		int n
	) {
		// fill in here, change the return
		if(n == 0 || capacity == 0) {
		return 0; 
	}
		if (capacity >= sizes[n-1]) {
			return Compare(worths[n-1]+maximizeRobWorthRecur(capacity-sizes[n-1],sizes,worths,n-1), maximizeRobWorthRecur(capacity,sizes,worths,n-1));
			}
			else return maximizeRobWorthRecur(capacity,sizes,worths,n-1);
		}
	

	public int maximizeRobWorthBottomUp(
		int capacity,
		int[] sizes,
		int[] worths
	) {
		// fill in here, change the return
	   int bottomCount, bottomCapacity;
       int l = sizes.length;
	   int Temp[][] = new int[l+1][capacity+1];
	   for (bottomCount = 0; bottomCount <= l; bottomCount++) {
		  for(bottomCapacity = 0; bottomCapacity <= capacity; bottomCapacity++) {
	   
			  if (bottomCount ==0 || bottomCapacity ==0)
	          Temp[bottomCount][bottomCapacity] = 0;
	          else if(sizes[bottomCount-1] > bottomCapacity)
	          Temp[bottomCount][bottomCapacity] = Temp[bottomCount-1][bottomCapacity];
	          else 
	          Temp[bottomCount][bottomCapacity] = Compare(worths[bottomCount-1]+ Temp[bottomCount-1][bottomCapacity - sizes[bottomCount-1]],Temp[bottomCount-1][bottomCapacity]);
		}
		  }
	    return Temp[l][capacity];
	}
	

/**
* Bonus: figure out which items exactly
* Takes in a DP DPTable
* Returns an int array of the individual worths of the items you took
*/
	public int[] takeRobInventory(int[][] DPTable) {
		// fill in here, change the return
		return new int[DPTable.length];
	}

	public static void main(String[] args) {
		Robbery r = new Robbery();
		int bagCapacity = 40;
		int[] itemSizes = {2, 25, 6, 13, 1, 15, 8, 5, 17, 4};
		int[] itemWorths = {35, 120, 900, 344, 29, 64, 67, 95, 33, 10};
		int arrayLength = itemSizes.length;

		int maxWorthRecur = r.maximizeRobWorthRecur(bagCapacity, itemSizes, itemWorths,arrayLength);
		System.out.println("Max worth of the bag: " + maxWorthRecur);
		int maxWorthBottomUp = r.maximizeRobWorthBottomUp(bagCapacity, itemSizes, itemWorths);
		System.out.println("Max worth of the bag: " + maxWorthBottomUp);

		// Bonus: Fill in the helper method takeRobInventory that could help you
		//figure out which items go into the bag that make it max worth. Feel free
		//to change up the parameters and returned types + values of the helper
		// methods above.
		// int[] itemsPicked = r.takeRobInventory();
		// System.out.println("The items we take are worth:")
		// for (int i = 0; i < results.length; i++) {
		// 	System.out.print(results[i] + " ");
	}
}
