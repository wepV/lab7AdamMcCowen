import java.util.Scanner;
import java.util.Formatter;
import java.io.File;
import java.io.PrintWriter;

public class lab7AdamMcCowen { 
    public static void main(String[] args){
        //in
        int arraySize = 0;
        try{
            File readFile = new File("orderdetails.txt");

            Scanner in = new Scanner(readFile);
            while (in.hasNext()){
                
                
                System.out.println(in.nextLine());


                arraySize += 1;
                

            }
            //System.out.println(arraySize); 
            in.close();
          
        }catch(Exception e){System.out.println(e.getMessage());}
    
        //grab data in arrays
        int[]    quantity    = new int   [arraySize]; 
        double[] unitPrice   = new double[arraySize]; 
        int[]    orderID     = new int   [arraySize];
        int[]    productID   = new int   [arraySize];
        double[] discount    = new double[arraySize];

        try{File arrayFile = new File("orderdetails.txt");
            Scanner in = new Scanner(arrayFile);
            
            System.out.println(Integer.parseInt(in.next()));

            int arrayer = 0;
            while(arrayer<=arraySize){
                quantity    [arrayer]  = in.nextInt();//????
                unitPrice   [arrayer]  = in.nextDouble();
                orderID     [arrayer]  = in.nextInt();
                productID   [arrayer]  = in.nextInt();
                discount    [arrayer]  = in.nextDouble();
            
                System.out.printf("%05.02f ", unitPrice[arrayer] 
                * quantity [arrayer] 
                - discount [arrayer] 
                * quantity [arrayer] 
                * unitPrice[arrayer]);
            }
            in.close();
                
        }catch(Exception e){System.out.println(e.getMessage());}

        

        //print data
        try{PrintWriter outputFile = new PrintWriter("outputAdamMcCowen.txt");
            int i = 0;
            while (i<=arraySize){ // OrderID total, the OrderID, a comma, and the total price for that ...
                outputFile.println(
                      quantity[i]   + ","
                    + unitPrice[i]  + ","
                    + orderID[i]    + ","
                    + productID[i]  + ","
                    + discount[i]   + ","
                );
                i++;
            }
            outputFile.close();
                
        }catch(Exception e){System.out.println(e.getMessage());}
    }
}