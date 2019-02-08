/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoca2;


public class Staff {
    
    private int staffID;
    private String Name;
    private int mobileNumber;
    private String email;
    
    public Staff(int sID, String n, int mN, String e){
        this.staffID = sID;
        this.Name = n;
        this.mobileNumber = mN;
        this.email = e;
    }
    
     public Staff(String n, int mN, String e) {
        this(-1, n,mN, e);
    }
    

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void display()
    {
       
        System.out.printf("%5d %20s %20s %15s",
            this.staffID,
            this.Name,
            this.mobileNumber,
            this.email);
    }
    
    public void printPayslip()
    {
        this.display();
        System.out.println("Weekly pay for hourly staff : Euro 500");
    }
    
    
    
   
    
    
}
