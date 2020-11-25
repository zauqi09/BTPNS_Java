package org.example.service;
import org.example.model.Detail;
import org.example.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.stereotype.Service;



import java.util.List;


@Service("MahasiswaService")
public class MahasiswaServiceImpl implements MahasiswaService{
    @Autowired
    JdbcTemplate jdbc;
    @Qualifier("Mahasiswa")  // Test NamedParameterJdbcTemplate



    @Override
    public List<Mahasiswa> findAllMhs() {
        return jdbc.query(
                "select * from header",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public List<Mahasiswa> findMhsByName(String name) {
        return jdbc.query(
                "select * from header where fullname = '"+name+"'",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public List<Detail> findAllDetail() {
        return jdbc.query(
                "select * from detail",
                (rs, rowNum) ->
                        new Detail(
                                rs.getLong("iddetail"),
                                rs.getLong("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biologi")
                        )
        );
    }

    @Override
    public List<Detail> findByIdDetail(Long idmhs) {
        return jdbc.query(
                "select * from detail where idmhs = "+idmhs+"",
                (rs, rowNum) ->
                        new Detail(
                                rs.getLong("iddetail"),
                                rs.getLong("idmhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biologi")
                        )
        );
    }

    @Override
    public int saveMhs(Mahasiswa mhs) {
        return jdbc.update(
                "insert into header (idmhs, fullname, address, status, absensi) values(?,?,?,?,?)",
                null, mhs.getId(), mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi()
                );
    }

    @Override
    public int saveDetail(Detail detail,Long idmhs) {
        return jdbc.update(
                "insert into detail (iddetail, idmhs, physics, calculus, biologi) values(?,?,?,?,?)",
                null, idmhs, detail.getPhysics(), detail.getCalculus(), detail.getBiology());
    }


    @Override
    public int updateMhs(Mahasiswa mhs) {
        return jdbc.update(
                "update header set fullname=? ,status = ? where idmhs = ?",
                mhs.getFullname(), mhs.getStatus(), mhs.getId());
    }

    @Override
    public int updateDetail(Detail detail) {
        return jdbc.update(
                "update detail set physics=? ,calculus = ?,biologi = ? where idmhs = ?",
                detail.getPhysics(),detail.getCalculus(),detail.getBiology(),detail.getIdmhs());
    }

    @Override
    public int tambahAbsen(Long id) {
        return jdbc.update(
                "update header set absensi = absensi+1 where idmhs = ?",
                id);
//        return 0;
    }

    @Override
    public List<Mahasiswa> findById(Long id) {
        return jdbc.query(
                "select * from header where idmhs="+id+"",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getLong("idmhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    @Override
    public boolean isMhsExist(Mahasiswa mhs) {
        List<Mahasiswa> datMhs = jdbc.query(
                "Select * from detail where idmhs='"+mhs.getId()+"'",
                new BeanPropertyRowMapper(Mahasiswa.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (datMhs.size()!=0){
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean isDetailExist(Detail detail) {
        List<Detail> datMhs = jdbc.query(
                "Select * from detail where idmhs='"+detail.getIdmhs()+"'",
                new BeanPropertyRowMapper(Detail.class));

//        return customers;
        if (datMhs.size()!=0){
            return true;
        } else {
            return false;
        }
    }
}
