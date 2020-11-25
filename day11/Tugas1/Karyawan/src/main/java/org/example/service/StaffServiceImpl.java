package org.example.service;

import org.example.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("staffService")
public class StaffServiceImpl implements StaffService {


    //  Using two hashmaps in order to provide performance of O(1) while fetching products
    private static HashMap<Long, Staff> staffs = new HashMap<>();
    private static HashMap<String, Long> idNameHashMap = new HashMap<>();

    public Staff findById(Long id) {
        return staffs.get(id);
    }

    public Staff findByName(String name) {

        if (idNameHashMap.get(name) != null){
            return staffs.get(idNameHashMap.get(name));
        }

        return null;
    }

    public void saveStaff(Staff product) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(product.getIDKaryawan(), product);
            idNameHashMap.put(product.getNama(), product.getIDKaryawan());
        }
    }

    public void updateStaff(Staff product) {
        synchronized (this) {    //  Critical section synchronized
            staffs.put(product.getIDKaryawan(), product);
            idNameHashMap.put(product.getNama(), product.getIDKaryawan());
        }
    }

    public void deleteStaffById(Long id) {
        synchronized (this) {    //  Critical section synchronized
            idNameHashMap.remove(staffs.get(id).getNama());
            staffs.remove(id);
        }
    }

    @Override
    public List<Staff> findAllStaff() {
        return new ArrayList<>(staffs.values());
    }

    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }

    public void deleteAllStaff() {
        staffs.clear();
    }

}
