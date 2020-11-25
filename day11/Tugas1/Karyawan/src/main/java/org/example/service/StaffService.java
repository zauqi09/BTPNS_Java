package org.example.service;


import java.util.List;

import org.example.model.Staff;

public interface StaffService {

    Staff findById(Long id);

    Staff findByName(String name);

    void saveStaff(Staff product);

    void updateStaff(Staff product);

    void deleteStaffById(Long id);

    List<Staff> findAllStaff();

    void deleteAllStaff();

    boolean isStaffExist(Staff product);

}
