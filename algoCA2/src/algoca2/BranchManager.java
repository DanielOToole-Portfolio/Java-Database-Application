
package algoca2;

import java.util.Calendar;
import java.util.Locale;


public class BranchManager extends Staff{

    
    
    private String Address;
    
    
    
    
    public BranchManager(int sID, String n, int mN, String e, String a){
        super(sID,n,mN,e);
        this.Address = a;
    }
    
        public BranchManager(String n, int mN, String e, String a){
            this(-1, n, mN, e, a);
            
        }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
     public void display()
    {
        // call the superclass display to deal with staff variables
        super.display();
        System.out.printf("%20s %8s %7s\n",
        this.Address);
    }
     
     public void printPayslip()
    {
       this.display();
       
      Calendar mCalendar = Calendar.getInstance();    
      String month = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
       
       System.out.println("MONTHLY PAY FOR : " + month + " 3000 Euro");
               
    }
    
}
