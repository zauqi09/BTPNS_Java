package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.model.Mahasiswa;
import org.example.model.Detail;
public interface MahasiswaService {

    int saveMhs(Mahasiswa mahasiswa);
    int saveDetail(Detail detail, Long idmhs);
    int updateMhs(Mahasiswa mahasiswa);
    int updateDetail(Detail detail);
    int tambahAbsen(Long id);
    List<Mahasiswa> findById(Long id);
    List<Mahasiswa> findAllMhs();
    List<Mahasiswa> findMhsByName(String name);
    List<Detail> findAllDetail();
    List<Detail> findByIdDetail(Long idmhs);
    boolean isMhsExist(Mahasiswa mahasiswa);
    boolean isDetailExist(Detail detail);
}
