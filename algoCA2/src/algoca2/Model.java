
package algoca2;

import java.util.ArrayList;
import java.util.List;


public class Model {

    
   private static Model instance = null;

    public static synchronized Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    private List<BranchStaff> BranchStaff;
    private List<BranchManager> BranchManager;

    private Model() {

        this.BranchStaff = new ArrayList<>();

        this.BranchStaff.add(
                new BranchStaff(1,
                         "John Smith",012,
                         "JohnSmith@gmail.com", 70000.00, 132));

        this.BranchStaff.add(
                new BranchStaff(2,
                        "Jane Smith",013,
                         "JaneSmith@gmail.com", 50000.00, 132));

        this.BranchStaff.add(
                new BranchStaff(3,
                        "Jim Smith",014,
                         "JimSmith@gmail.com", 80000.00, 132));

        this.BranchStaff.add(
                new BranchStaff(4,
                        "Janice Smith",015,
                         "JaniceSmith@gmail.com", 70000.00, 132));
        
        
        
        this.BranchManager = new ArrayList<>();

        this.BranchManager.add(
                new BranchManager(99,
                       "Sam Smith",015,
                         "SamSmith@gmail.com","Brooklyn"));
    }

    public List<BranchStaff> getBranchStaff() {
        return new ArrayList<>(this.BranchStaff);
    }

    public void addBranchStaff(BranchStaff p) {
        this.BranchStaff.add(p);
    }

    public BranchStaff findBranchStaffByStaffID(int staffID) {
        BranchStaff p = null;
        int i = 0;
        boolean found = false;
        while (i < this.BranchStaff.size() && !found) {
            p = this.BranchStaff.get(i);
            if (p.getStaffID() == staffID) {
                found = true;
            } else {
                i++;
            }
        }
        if (!found) {
            p = null;
        }
        return p;
    }
    
    
    public List<BranchManager> getBranchManager() {
        return new ArrayList<>(this.BranchManager);
    }

    public void addBranchManager(BranchManager m) {
        this.BranchManager.add(m);
    }

    Staff findBranchManagerByStaffID(int StaffID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}

    
