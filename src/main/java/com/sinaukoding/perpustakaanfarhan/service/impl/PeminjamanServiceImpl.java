package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Anggota;
import com.sinaukoding.perpustakaanfarhan.entity.Peminjaman;
import com.sinaukoding.perpustakaanfarhan.entity.Petugas;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.AnggotaMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PetugasMapping;
import com.sinaukoding.perpustakaanfarhan.repository.AnggotaRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PeminjamanRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PetugasRepository;
import com.sinaukoding.perpustakaanfarhan.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PeminjamanServiceImpl implements PeminjamanService {

    @Autowired
    private PeminjamanRepository repository;

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private PetugasRepository petugasRepository;


    @Transactional
    @Override
    public PeminjamanDTO save(PeminjamanDTO param) {
        Anggota anggota = AnggotaMapping.instance.toEntity(param.getAnggota());
        Petugas petugas = PetugasMapping.instance.toEntity(param.getPetugas());

        Peminjaman data = PeminjamanMapping.instance.toEntity(param);

        if (param.getAnggota() != null && param.getPetugas() != null) {
            anggota = anggotaRepository.save(anggota);
            petugas = petugasRepository.save(petugas);

            data.getAnggota().setId(anggota.getId());
            data.getPetugas().setId(petugas.getId());
        }

        data = repository.save(data);

        return PeminjamanMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PeminjamanDTO> findAllData()
    {
        return PeminjamanMapping.instance.toListDto(repository.findAll());

    }
    @Transactional
    @Override
    public PeminjamanDTO update(PeminjamanDTO param, Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPinjam(param.getTglPinjam()== null ? data.getTglPinjam() : param.getTglPinjam());
            data.setTglkembali(param.getTglkembali() != null ? param.getTglkembali() : data.getTglkembali());

            return  PeminjamanMapping.instance.toDto(repository.save(data));
        }
        return PeminjamanMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Peminjaman data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PeminjamanDTO findById(Long id) {
        return PeminjamanMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
