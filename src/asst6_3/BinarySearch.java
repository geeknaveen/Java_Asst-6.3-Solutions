/* Write a program to search an element in a one-dimensional array using Binary 
Search Algorithm.   
Display a message stating whether element found in an array or not. Also, display the 
index position of the element if found.  */

package asst6_3;

/*Binary search is more efficient and merely used search algorithm in java programming. To implement Binary search we
must have an sorted array or collection. Binary Search searches element in middle of the Array. The array is than 
divided into sub-array in each iteration accordingly, if the element is greater than the middle element or smaller
than the middle element the respective sub-array is used for further searching
*/
import java.util.*; 

public class BinarySearch {

	public static void main(String[] args)     //main function declaration. and because it is static, program execution starts from main function.
	{
		int numberOfElements;        //initializing variable to store number of elements in the array.
		
		System.out.println("Please enter the size of array: ");        
		// asking value of numberOfElements from the user.
       	   	
		// For taking input from the user, we have to make the object of Scanner class.
      	Scanner sc=new Scanner(System.in);       //creating object of Scanner class.
		
		numberOfElements=sc.nextInt();    
			
		int[] binarySearchArray = new int[numberOfElements];      //Creating array of size equal to number input by user.
		
		System.out.println("Input the elements into the array: ");
		
		for(int i= 0 ; i < numberOfElements ; i++)        //for loop to read the values of elements from the user.
		{
			binarySearchArray[i] = sc.nextInt();   
			
		}
		
		//Basic condition to perform binary search on array is to sort the array.
		for(int i = 0 ; i < numberOfElements ; i++)              //Two for loops to implement insertion sort on the array.
			for(int j = i+1 ; j < numberOfElements ; j++)
			{
				if(binarySearchArray[i] > binarySearchArray[j])      //if left handside element is greater than right one.
				{
					int tempVariable = binarySearchArray[i];           //Swaping two elements of array using temporary variable.
					binarySearchArray[i] = binarySearchArray[j];
					binarySearchArray[j] = tempVariable;
				}
			}
		
		int elementToFind;          //int variable to find in array.
		
		System.out.println("\nEnter the element which you want to find??");        //Asking element.
		
		elementToFind = sc.nextInt();     
		
		//-------------Binary Search Algorithm-------------
		//Binary search is basically algorithm to reduce the array size by half every time.
		
		int lowIndex = 0 , highIndex = numberOfElements-1;        //Declaring two variables to locate high and low index values in array while binary searching.
		boolean isFound = false;     //boolean variable to check weather element is found or not.
		
		while(lowIndex <= highIndex)
		{
			int midIndex = (lowIndex + highIndex)/2;    //int variable to point mid index of array.
			
			if(binarySearchArray[midIndex] < elementToFind)
				lowIndex = midIndex + 1;        //Reducing the size of array, Now we will only look at the right of array.
			
			else if(binarySearchArray[midIndex] > elementToFind)
				highIndex = midIndex - 1;       //Reducing the size of array, Now we will only look at the left of array.
			
			else if(binarySearchArray[midIndex] == elementToFind)
			{
				//Element found
				System.out.println("Element is found in array and it's index is "+midIndex);    //Printing result.
				isFound = true;    //Changing boolean variable.
				break;        //No need to iterate now, because we found the position of the given element.
			}
					}
		
		//Element not found- It means given element is not there in the array.
		if(isFound == false)
			System.out.println("The element you have entered is not found in the array");
		
		sc.close();        
		
	}      

}    
