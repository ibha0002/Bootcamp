import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class determines the pair of numbers in a user defined list whos sum is equal to the first number (Target).
 * Call the appRun method to begin the application.
 *
 * @author Ibrahim Bhabay
 * @version 30/12/2018
 */

public class Numbers
{
    private int firstNumber;  // Target Number
    private ArrayList<Integer> numberList;  // ArrayList of integers to hold list of numbers.

    /**
     *  Default Constructor for objects of class Numbers
     */
    public Numbers()
    {
        // initialise instance variables
        firstNumber = 5;   // Defaul initial value
        numberList = new ArrayList<Integer>();  //Initialising ArrayList object
    }
    
    /**
     * This method begins the application.
     */    
    public void appRun()
    {
        getInput(); // Method to get input from user.
        findPairs(); // Method to find successfull pairs.
        clearList(); // Calling method to clear the ArrayList of integers.
    }
    
    /**
     * This method removes all the objects from the ArrayList making it reusable in the code.
     * Hence we will not have to create a different object each time we run the application.
     */
    public void clearList()
    {   
        for(int i = 0; i < numberList.size(); i++)
            numberList.remove(i);
    }
    
    /**
     * This method display the list of successful pairs in human readable format.
     *
     * @param  pairList  list of successful non-duplicate pairs.
     */
    public void displayPairs(ArrayList<Integer> pairList)
    {   
        System.out.println("");
        System.out.println("The pairs of numbers are: " );
        for (int i = 0; i <= pairList.size()-2; i += 2 )
        {
            System.out.print("[" + pairList.get(i) + "," + pairList.get(i+1) + "] "  );
        }
    }
    
    /**
     * This method determines the pairs of numbers whose sum is equal to first number. Two numbers in a pair must not be same.
     * This method does not takes care of duplicate pairs.
     */
    public void findPairs()
    {
        ArrayList<Integer> pairs = new ArrayList<>();      // ArrayList to hold successful pairs.  
        for (int i = 0; i <= numberList.size()-1; i ++ )
        {
            System.out.print(numberList.get(i) + ", ");
            
        }
        
        for(int i = 0; i <= (numberList.size() - 2); i++)  // Loop until ssecond last index.
        {
            for(int j = i+1; j <= (numberList.size() - 1); j++)  // Loop until last index.
            {
                int num1 = numberList.get(i);
                int num2 = numberList.get(j); 
                if(num1 != num2)
                {
                    if (firstNumber == num1 + num2) // Sum of number should be equal to target
                    {
                        pairs.add(num1);    // Add number to list
                        pairs.add(num2);

                    }
                }
            }
        }
        removeDuplicatePairs(pairs); // Calling method to remove possible duplicate pairs. we pass the list that contains the successful pairs.
    }
    
    /**
     * Accessor for fistNumber instance variable.
     *
     * @return   fisrtNumber instance variable
     */
    public int getfirstNumber()
    {
        return firstNumber;
    }
    
    /**
     * Accesssor for list of numbers
     *
     * @return    the ArrayList of numbers
     */
    public ArrayList<Integer> getnumberList()
    {
        return numberList;
    }
    
    /**
     * Method to accept the input from the user. It accepts the first number and list of numbers from the user until user decides to end the list.
     */
    public void getInput()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the initial Number.");
        // Accepting input as integer just for simplicity. 
        // Best practice is to accept as string and then parse it to integer value to avoid scanner object malfunction.
        int init = console.nextInt();  // First number(Targer Number)
        setfirstNumber(init); // Setting the fist number.
        int inputNumber = 0; // initialising the input number for the list to zero      
        while( inputNumber != -1) // Accept the number until user enters -1.
        {
            System.out.println("Enter a list of numbers greater than 0. Enter -1 to finish the list.");
            inputNumber = console.nextInt();
            if(inputNumber != -1)
            {
                setNumberList(inputNumber); // Calling mutator for list of numbers.
            }
        }
        System.out.println("Finished entering the list of numbers");
    }
    
    /**
     * This method removes the possible duplicate pairs from the list.
     *
     * @param  list  list cotaining successful pairs.
     */
    public void removeDuplicatePairs(ArrayList<Integer> list)
    {
        for(int k = 0; k<= list.size()-4; k += 2 )
        {
            int num1 = list.get(k); //Getting first pair. All other pairs will be checked aginst this pair. and then move to next pair.
            int num2 = list.get(k+1);
            for (int l = k+2; l <= list.size()-2; l += 2)
            {
                int num3 = list.get(l); // Pair to be compared.
                int num4 = list.get(l+1);
                if((num1 == num3 && num2 == num4) || (num1 == num4 && num2 == num3) ) // Check for duplicates.
                {
                    list.remove(l);  // Remove duplicates
                    list.remove(l);
                    l -= 2;  // Adjusting index after removal of a pair.
                }
            }  
        }
        displayPairs(list); // Calling method to display list of pairs.
    }
    
    /**
     * Mutator for firstNumber
     *
     * @param  newNumber is the integer value to set as the first number
     */
    public void setfirstNumber(int newNumber)
    {
        if (newNumber > 1)          // Guardian code. Assuming that the target number should be greater than 1 since no number in the list is less than 1.
            firstNumber = newNumber;
        else
            System.out.println("Invalid number");
    }
    
    /**
     * Mutator for the list of numbers. Accepts a integer value and add it to list of its greater than 0.
     *
     * @param  newElement  integer value to be added to list
     */
    public void setNumberList(int newElement)
    {
        if(newElement > 0)
            numberList.add(newElement);
        else
            System.out.println("The number entered must be greater than zero");
    }
}
