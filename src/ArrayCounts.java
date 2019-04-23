/**
 * Name: Phillip Araujo
 * Course: CSCI 145 - Computer Science I
 * Assignment: 7
 * 
 * Project/Class Description:
 * This program shows an array of a length 100.
 * 100 is then spilt into 10 rows by 10 columns filled with random integers ranging from
 * 1 through 99. It then shows the lowest and second lowest values of the array. Next it shows
 * how many numbers fall into different categories of 0's,10's,20's,30's,40's,50's,60's, 70's,80's, and 90's. 
 * It then shows the number of duplicates that are in the array, and finally reprints the array  without duplicate values.
 * 
 * Known bugs: None.
 */

public class ArrayCounts {

	public static void main (String [] args)
    {
        // Makes an array that holds 100 random positive 
        // integers from 1-99
        int [] num = new int [100];

        // A for loop to place random integers into array 
        for (int i = 0; i < num.length; i++){ 
            num[i] = (int)(Math.random() * 99 + 1);
        }
        System.out.println("Printing original array...");

        //Calls the printArray method to print the values in original array
        printArray(num);

        //Calls the findLowest method and prints the lowest number in the array 
        int lowest = findLowest(num);
        System.out.println("The lowest number in the array is " + lowest);

        //Calls the findSecondLowest method and prints the second lowest number in the array
        int secondLowest = findSecondLowest(num);
        System.out.println("The second lowest number in the array is " 
            + secondLowest);

        System.out.println();

        //Calls the buildDecileArray and displayDecile methods and prints the deciles
        int [] decile = buildDecileArray(num);
        System.out.println("Printing deciles ...");
        System.out.println("   1s  10s  20s  30s  40s  50s  60s  70s  80s  90s");
        System.out.println(" ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        displayDecileArray(decile);

        System.out.println();
        System.out.println();

        //Calls the eliminateDuplicates method, shows the number of nonduplicate 
        //values, and reprints the array without any duplicate values
        int [] uniqueValues = eliminateDuplicates(num);
        System.out.println("Now a new array from entries in the original, "
            + "without duplicates");
        System.out.println("This array has " 
            + uniqueValues.length + " unique entries");
        printArray(uniqueValues);     
    }

    public static void printArray (int []num)
    {
        //Nested for loops that calls the original array and places the array values
        //into rows and columns
        int rows = num.length/10;
        int colm = 10;
        for (int r = 0; r < rows + 1; r++){
            if (r == rows)
                colm = num.length % 10;
            for (int c = 0; c < colm; c++){ 
                System.out.printf("%5d",num[(r)*10 + c]);
            } 
            System.out.println();
        }
    }

    public static int findLowest (int []num)
    {
        //A for loop to find the lowest value in the array
        int lowest = num[0];
        for (int i = 0; i < num.length; i++){
            if(num[i]<lowest)
                lowest = num[i];
        }
        return lowest;
    }

    public static int findSecondLowest (int []num)
    {
        //A for loop to find 2nd lowest value in the array
        int lowest = findLowest(num);
        int secondLowest = num [0];  
        for (int i = 0; i < num.length; i++){
            if(num[i] > lowest && num[i]< secondLowest){
                secondLowest = num[i];
            }  
        }
        return secondLowest;
    } 

    public static int [] buildDecileArray(int []num)
    {
        //A for loop to build the decile array
        int [] decile = new int [10];
        for (int i = 0; i < num.length; i++){
            decile[num[i] / 10]++;
        }
        return decile;
    }

    public static int [] displayDecileArray(int []decile)
    {
        //A for loop to display the decile array 
        int [] dec = buildDecileArray(decile);
        for (int i = 0; i < decile.length; i++){
            System.out.printf("%5d",decile[i]);
        }
        return dec;
    }

    public static int [] eliminateDuplicates(int []num)
    {
        //This for loop calls the original array values
        int uniqueValues = num.length;
        int [] arr = new int [uniqueValues];
        for (int i = 0; i<uniqueValues; i++){
            arr[i] = num[i];
        }

        //This nested for loop replaces are duplicate values with zeros
        for (int i = 0; i<uniqueValues; i++){
            for (int j = i+1; j<uniqueValues; j++){
                if (arr [j] == arr[i])
                    arr [j] = 0;
            }
        }

        //This for loop counts the number of nonduplicate valuesin the array
        int count = 0;
        for (int k = 0; k<uniqueValues; k++){
            if (arr[k]== 0) 
                count++;
        }

        //This for loop creates an array with no duplicate values in it
        int [] answer = new int [uniqueValues - count];
        int index = 0;
        for ( int q = 0; q<uniqueValues; q++){
            if( arr[q] != 0){
                answer[index] = arr[q];
                index++;
            }
        }
        return answer;     
    }  

}
