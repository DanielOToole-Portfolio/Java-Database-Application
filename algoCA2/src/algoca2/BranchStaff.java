
package algoca2;

import java.util.Calendar;
import java.util.Locale;


public class BranchStaff extends Staff {
    
    private double Salary;
    private int managerID;
    
    public BranchStaff(int sID, String n, int mN, String e, double s, int mID){
        super(sID,n,mN,e);
        this.Salary = s;
        this.managerID = mID;
    }
    
    public BranchStaff(String n, int mN, String e, double s, int mID){
       this(-1, n, mN,e,s,mID);
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
    
    public void display()
    {
        // call the superclass display to deal with staff variables
        super.display();
        System.out.printf("%20s %8s\n",
        this.Salary,
        this.managerID);
    }
    
    public void printPayslip()
    {
       this.display();
       
      Calendar mCalendar = Calendar.getInstance();    
      String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
       
        System.out.println("MONTHLY PAY FOR : " + month + this.Salary/12);
               
    }
    
    
    
}
