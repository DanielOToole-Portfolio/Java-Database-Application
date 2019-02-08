
package algoca2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import java.util.Scanner;


public class Demo {

    public static void main(String[] args)  {
       
        
         Scanner keyboard = new Scanner(System.in);
        Model model = Model.getInstance();
        int opt;

        do {
            System.out.println("1. Read File");
            System.out.println("2. Output File From Array List");
            System.out.println("3. View all Branch Staff");
            System.out.println("4. View all Branch Manager");
            System.out.println("5. View all PaySlips");
            System.out.println("0. Exit");
            System.out.println();

            System.out.print("Enter option: ");
            String line = keyboard.nextLine();
            opt = Integer.parseInt(line);

            System.out.println("You chose option " + opt);
            switch (opt) {
                case 1: {
                    System.out.println("Read File into Array List");
                    readStaffFile(keyboard, model);
                    break;
                }
                case 2: {
                    System.out.println("Output File From Array List");
                    outputStaffFile(keyboard, model);
                    break;
                }
                case 3: {
                    System.out.println("Displaying all Branch Staff");
                    viewBranchStaff(model);
                    break;
                }
              case 4: {
                    System.out.println("Displaying all Branch Managers");
                    viewBranchManager(model);
                    break;
                }
              case 5: {
                    System.out.println("Displaying all PaySlips");
                    printPayslip(model);
                    break;
                }
              
              
              
            }
        }
        while (opt != 0);
    
    }

    public static void readStaffFile(Scanner kb, Model m) {
      
     
      System.out.println("Enter file name :");
      String inputFileName = kb.nextLine();
      File inputFile = new File(inputFileName);
      try{
        Scanner in = new Scanner(inputFile);
        while (in.hasNextLine())
        {
            String line = in.nextLine();
            if(line.equalsIgnoreCase("P"))
            {
                createBranchStaff(in, m);
            }
        else if(line.equalsIgnoreCase("mgr"))
            {
                createBranchManager(in, m);
            }
        }
          in.close();
    

       
      }
      catch (FileNotFoundException ex)
      {
          System.out.println("No such file exists");
          
      }
      
     
    
        
    }
    public static void createBranchStaff(Scanner in, Model model){
        
       
        String n = in.nextLine();
        
         int mN = in.nextInt();
        String x = in.nextLine();
        
        String e = in.nextLine();
        
        int sID = in.nextInt();
        x = in.nextLine();
        
        double s = in.nextDouble();
        x = in.nextLine();
        
        int mID = in.nextInt();
       
       
        BranchStaff p = new BranchStaff(sID, n, mN, e, s, mID);
        model.addBranchStaff(p);
        
    }
    
    public static void readBranchStaff(Scanner in, Model m){
    }   
    
    private static void viewBranchStaff(Model mdl) {
        List<BranchStaff> BranchStaff = mdl.getBranchStaff();
        System.out.println();
        if (BranchStaff.isEmpty()) {
            System.out.println("There are no BranchStaff in the database.");
        }
        else {
            System.out.printf("%5s %20s %20s %20s %8s %7s\n",
                    "Staff ID", "Name", "Mobile", "Email","Salary", "Manager ID");
            for (BranchStaff pr : BranchStaff) {
                System.out.printf("%5d %20s %20s %15s %.2f %7s\n",
                        pr.getStaffID(),
                        pr.getName(),
                        pr.getMobileNumber(),
                        pr.getEmail(),
                        pr.getSalary(),
                        pr.getManagerID());
            }
        }
        System.out.println();
    }
    
    
    
    
    
    private static void viewBranchManager(Model mdl) {
        List<BranchManager> BranchManager = mdl.getBranchManager();
        System.out.println();
        if (BranchManager.isEmpty()) {
            System.out.println("There are no managers in the database.");
        }
        else {
            System.out.printf("%5s %20s %20s %15s %10s\n",
                    "Staff ID", "Name", "MobileNumber", "Email", "Address");
            for (BranchManager mgr : BranchManager) {
                System.out.printf("%5d %20s %20s %15s %10s\n",
                        mgr.getStaffID(),
                        mgr.getName(),
                        mgr.getMobileNumber(),
                        mgr.getEmail(),            
                        mgr.getAddress());
            }
        }
        System.out.println();
    }
    
     public static void createBranchManager(Scanner in, Model model){
        
       String n = in.nextLine();
       
        int mN = in.nextInt();
        String x = in.nextLine();
        
        String e = in.nextLine();
        
        int sID = in.nextInt();
        x = in.nextLine();
        
        String a = in.nextLine();
              
        BranchManager mgr = new BranchManager(sID, n, mN, e, a);       
        model.addBranchManager(mgr);
        
    }
    
    public static void readBranchManager(Scanner in, Model m){
    }   
    
    
    public static void outputStaffFile(Scanner in, Model m){
     
        
        System.out.println("Enter file name: ");
        String outputFileName = in.nextLine();
        try{
            //code for output
            PrintWriter out = new PrintWriter(outputFileName);
            List<BranchManager> BranchManager = m.getBranchManager();
            for (BranchManager pt : BranchManager) 
            {
                out.println("Name: " + pt.getName() +"" + pt.getName());
                out.println("Staff ID: " + pt.getStaffID());      
            }
            //end of output
            out.close();
        }
        catch(FileNotFoundException e){
            System.err.println("File not found");
        }       
    
    }
    
    
    private static void printPayslip(Model m)
    {
        Staff s = null;
        File inputFile = new File("payfile.txt");
        try{
            Scanner in = new Scanner(inputFile);
            while (in.hasNextLine())
            {
                String line = in.nextLine();
                String id = in.nextLine();
                int StaffID = parseInt(id.trim());
                System.out.println("Name " + line);
                System.out.println("Staff ID " + StaffID);
                if(line.equalsIgnoreCase("P"))
                {                        
                    s = m.findBranchStaffByStaffID(StaffID);
                }
               else if(line.equalsIgnoreCase("M"))
                {
                    s = m.findBranchManagerByStaffID(StaffID);
                }
                
                if (s != null)
                    s.printPayslip();
                else 
                    System.out.println("Staff Nummber : " + StaffID + " not found in database");
            }
        
        }
        catch (FileNotFoundException ex)
        {
          System.out.println("No such file exists - check the spelling of your text file");
        }
    }
    
  
    
    
}
