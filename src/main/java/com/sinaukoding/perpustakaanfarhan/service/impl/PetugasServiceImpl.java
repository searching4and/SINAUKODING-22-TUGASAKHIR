package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Petugas;
import com.sinaukoding.perpustakaanfarhan.entity.User;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PetugasDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PetugasMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.UserMapping;
import com.sinaukoding.perpustakaanfarhan.repository.PetugasRepository;
import com.sinaukoding.perpustakaanfarhan.repository.UserRepository;
import com.sinaukoding.perpustakaanfarhan.service.PetugasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetugasServiceImpl implements PetugasService {

    @Autowired
    private PetugasRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PetugasDTO save(PetugasDTO param) {
        User user = UserMapping.instance.toEntity(param.getUser());

        Petugas data = PetugasMapping.instance.toEntity(param);

        if (param.getUser() != null) {
            user = userRepository.save(user);

            data.getUser().setId_user(user.getId_user());
        }

        data = repository.save(data);

        return PetugasMapping.instance.toDto(data);
    }

    @Override
    public List<PetugasDTO> findAllData()
    {
        return PetugasMapping.instance.toListDto(repository.findAll());

    }
    @Override
    public PetugasDTO update(PetugasDTO param, Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            data.setNama(param.getNama()== null ? data.getNama() : param.getNama());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());

            return  PetugasMapping.instance.toDto(repository.save(data));
        }
        return PetugasMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Petugas data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PetugasDTO findById(Long id) {
        return PetugasMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}