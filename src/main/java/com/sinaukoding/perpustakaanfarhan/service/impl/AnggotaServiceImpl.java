package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Anggota;
import com.sinaukoding.perpustakaanfarhan.entity.User;
import com.sinaukoding.perpustakaanfarhan.entity.dto.AnggotaDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.AnggotaMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.UserMapping;
import com.sinaukoding.perpustakaanfarhan.repository.AnggotaRepository;
import com.sinaukoding.perpustakaanfarhan.repository.UserRepository;
import com.sinaukoding.perpustakaanfarhan.service.AnggotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnggotaServiceImpl implements AnggotaService {

    @Autowired
    private AnggotaRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public AnggotaDTO save(AnggotaDTO param) {
        User user = UserMapping.instance.toEntity(param.getUser());

        Anggota data = AnggotaMapping.instance.toEntity(param);

        if (param.getUser() != null) {
            user = userRepository.save(user);

            data.getUser().setId_user(user.getId_user());
        }

        data = repository.save(data);

        return AnggotaMapping.instance.toDto(data);
    }

    @Override
    public List<AnggotaDTO> findAllData()
    {
        return AnggotaMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public AnggotaDTO update(AnggotaDTO param, Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNama(param.getNama()== null ? data.getNama() : param.getNama());
            data.setJenisKelamin(param.getJenisKelamin() != null ? param.getJenisKelamin() : data.getJenisKelamin());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());

            return  AnggotaMapping.instance.toDto(repository.save(data));
        }
        return AnggotaMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Anggota data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public AnggotaDTO findById(Long id) {
        return AnggotaMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}