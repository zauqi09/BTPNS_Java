package org.example.restapi.controller;

import com.google.gson.Gson;
import org.example.database.model.Mahasiswa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.example.restapi.rabbitmq.*;
import org.example.database.model.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    public final Logger logger = LoggerFactory.getLogger(RestApiController.class);


    // -------------------Create a Mahasiswa-------------------------------------------

    @RequestMapping(value = "/mhs/", method = RequestMethod.POST)
    public ResponseEntity<?> createMhs(@RequestBody Mahasiswa mhs) {
        try {
            RestApiSend.addMhs(new Gson().toJson(mhs));
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Insert Siswa Berhasil", HttpStatus.OK);
    }

    // ------------------- Update a Mahasiswa ------------------------------------------------

    @RequestMapping(value = "/mhs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMhsApi(@PathVariable("id") Long id, @RequestBody Mahasiswa mhs) {
        mhs.setId(id);
        try {
            RestApiSend.updateMhs(new Gson().toJson(mhs));
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Update Mahasiswa Berhasil", HttpStatus.OK);
    }

    // ------------------- Tambah Absen ------------------------------------------------
    @RequestMapping(value = "/mhs/{id}/tambahabsen", method = RequestMethod.PUT)
    public ResponseEntity<?> tambahabsenMhs(@PathVariable("id") Long id) {
        try {
            RestApiSend.absensiMhs(Long.toString(id));
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Tambah Absen Mahasiswa Berhasil", HttpStatus.OK);
    }

    

}