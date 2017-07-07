

/*package quadgraph
*
 *
 * @author jameson
 */

import java.util.Arrays;
import java.util.Scanner;

public class QuadGraph {

     static int dim = 21;
    static double yArr [] = new double[dim];
    static double a;
    static double b;
    static double c;
 
/*************************************************************************/

    public QuadGraph(double A, double B, double C){ //generate graph
        a = A;
        b = B;
        c = C;
    }
	
/************************************************************************/

    public static double [] yVal(){

        for(int j = 0; j<dim; j++){
            int x = j-10;
            yArr[j] = a*Math.pow(x, 2) + b*x + c;
        }
        return yArr;
    }

/************************************************************************/

    public void printGraph(){

        int p = 10;//actual y-value, counts from 10 to -10
        char [] g =
new char[dim]; //character array for open space/y-axis

        char [] h =
new char[dim]; //character array for x-axis

        char open = '
';

        char yAx =
'|';

        char xAx =
'-';

        char pt = '*';

        

        for(int i = 0;
i<dim; i++){ // i iterator prints each line

           
Arrays.fill(g, open);

                g[10]
= yAx;

               
Arrays.fill(h, xAx);

               
if(i==10){

                   
for(int m=0; m<dim; m++){

                       
if((int)Math.round(yArr[m]) == p){

                           
h[m] = pt;

                        } // end if 

                   
}//end m loop

 

                   
System.out.print(h);  // at i=10
(11th line) x axis is printed

                   
System.out.println(" x-axis");

 

                                                }
//end if i=10

 

               
if(i!=10){

                   
for(int k=0; k<dim; k++){

                       
if((int)Math.round(yArr[k]) == p){

                           
g[k] = pt;

                       
} //end if

                    }
//end k loop

 

                   
System.out.println(g);

                }

                                p--;         // decrement y value for next line

        }

                                System.out.println("
"); //print space after end of graph

    } //end printGraph

    

   
/*************************************************************************/

                public
Double [] quadSolve(){ //solve for x-intercepts

                                double
b2 = Math.pow(b, 2)-4*a*c;

 

                                if(b2
< 0){

                Double
bN = null;

                return
new Double [] {bN};

                                }

                                else
if(b2 == 0){

                Double
x0 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);

                return
new Double [] {x0};

                                }

                                else
{

                Double
x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);

                Double
x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4*a*c))/(2*a);

                return
new Double [] {x1, x2};

                                }

                } //
end quadSolve

 

   
/************************************************************************/  

    public static void
main(String[] args) {

 

        double []
coeffArr = new double[3];

        System.out.println("Enter
A, B, and C coefficients for the format \nAx^2 + Bx + C = y, one on each line
of input box");

        Scanner coIn =
new Scanner(System.in);

        for(int m = 0;
m < 3; m++) {

           
coeffArr[m] = coIn.nextDouble();

        } //end fill
coefficient array

        double coA =
coeffArr[0];

        double coB =
coeffArr[1];

        double coC =
coeffArr[2];

        

        QuadGraph
plot1 = new QuadGraph(coA, coB, coC);

       
QuadGraph.yVal();

       
plot1.printGraph();

        System.out.println("x-intercepts");

       
System.out.println(Arrays.toString(plot1.quadSolve()));

       
System.out.println("y-values from -10 to 10, increment by 1");

       
System.out.println(Arrays.toString(yArr));

    }

}


	
	
