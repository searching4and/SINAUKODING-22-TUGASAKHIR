package com.sinaukoding.perpustakaanfarhan.controller;

import com.sinaukoding.perpustakaanfarhan.common.Response;
import com.sinaukoding.perpustakaanfarhan.entity.dto.AnggotaDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDTO;
import com.sinaukoding.perpustakaanfarhan.service.impl.AnggotaServiceImpl;
import com.sinaukoding.perpustakaanfarhan.service.impl.PeminjamanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peminjam")
public class PeminjamanController {
    @Autowired
    private PeminjamanServiceImpl service;

    @GetMapping("/find-all")
    public Response findAllData(){
        List<PeminjamanDTO> data = service.findAllData();
        return new Response(data, "Get All Data Peminjaman", data.size(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public Response saveData(@RequestBody PeminjamanDTO param){
        if (service.save(param) == null){
            return new Response("Data Peminjaman tidak ditemukan", HttpStatus.BAD_REQUEST);
        }
        return new Response(service.save(param), "Data Berhasil di tambahkan", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateData(@PathVariable Long id,
                                        @RequestBody PeminjamanDTO param){
        PeminjamanDTO data = service.update(param, id);

        if (data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/find-by-id/{id}")
    public Response findById(@PathVariable Long id){
        return new Response(service.findById(id), "Berhasil Mengabil Data dari id " + id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteData(@PathVariable Long id){
        if (service.delete(id)){
            return new Response("Data Berhasil di Hapus",HttpStatus.OK);
        }else{
            return new Response("Data Gagal di Hapus",HttpStatus.BAD_REQUEST);
        }
    }
}
