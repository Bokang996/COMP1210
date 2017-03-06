import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
*/
public class DodecahedronListMenuApp {
   /**
   */
   public static void main(String[] args) throws IOException {
      
      String listName = "*** no list name assigned ***";
      ArrayList<Dodecahedron> dodObj = new ArrayList<Dodecahedron>();
      DodecahedronList dodObjList = new DodecahedronList(listName, dodObj);
      String fileName = "no file Name";
      // create/declare ArrayList Dodecahedron Objects
      // create/declare ArrarList DodecahedronList Objects using list name and ArratList as params in the constructor
      
      String userInput = "";
      Scanner scanInput = new Scanner(System.in);
      
      System.out.println("Dodecahedron List System Menu\n"
                       + "R - Read File and Create Dodecahedron List\n"
                       + "P - Print Dodecahedron List\n" 
                       + "S - Print Summary\n"
                       + "A - Add Dodecahedron Object\n"   
                       + "D - Delete Triangle Object\n"   
                       + "F - Find Dodecahedron\n"
                       + "E - Edit Dodecahedron\n"
                       + "Q - Quit");
      
      do {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         
         String label = "";
         String color = "";
         double edge = 0;
         int index;
         
         userInput = scanInput.nextLine();
         if (userInput.length() == 0) {
            continue;
         }
         userInput = userInput.toUpperCase();
         char userChar = userInput.charAt(0);
         
         
         switch (userChar) {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scanInput.nextLine();
               
               dodObjList = dodObjList.readFile(fileName);
               System.out.println("\tFile read in and Dodecahedron List created\n");
               
               break;
               
            case 'P':
               System.out.println(dodObjList);
               break;
               
            case 'S':
               System.out.println("\n" + dodObjList.summaryInfo() + "\n");
               break;
               
            case 'A':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               dodObjList.addDodecahedron(label, color, edge);
               
               System.out.println("\t*** Dodecahedron added ***\n");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (dodObjList.deleteDodecahedron(label) != null) {
                  dodObjList.deleteDodecahedron(label);
                  System.out.println("\t\"" + label + "\" deleted\n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               
               if (dodObjList.findDodecahedron(label) != null) {
                  System.out.println(dodObjList.findDodecahedron(label).toString() + "/n");
               } else {
                  System.out.println("\t\"" + label + "\" not found\n");
               }
               break;
            
            case 'E':
               System.out.print("\tLabel: ");
               label = scanInput.nextLine();
               System.out.print("\tColor: ");
               color = scanInput.nextLine();
               System.out.print("\tEdge: ");
               edge = Double.parseDouble(scanInput.nextLine());
               
               if (dodObjList.findDodecahedron(label) != null) {
                  dodObjList.editDodecahedron(label, color, edge);
                  System.out.println("\"" + label + "\" successfully edited");
               } else {
                  System.out.println("\"" + label + "\" not found");
               }
               break;
               
            case 'Q': case 'q':
               break;
            
            default:
               // loop again;
         }
      } while (!userInput.equalsIgnoreCase("Q"));
   }
}