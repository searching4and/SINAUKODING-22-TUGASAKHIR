//package com.sinaukoding.perpustakaanfarhan.service.impl;
//
//import com.sinaukoding.perpustakaanfarhan.entity.Buku;
//import com.sinaukoding.perpustakaanfarhan.entity.PeminjamanDetail;
//import com.sinaukoding.perpustakaanfarhan.entity.Pengarang;
//import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
//import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDetailDTO;
//import com.sinaukoding.perpustakaanfarhan.entity.mapping.BukuMapping;
//import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanDetailMapping;
//import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengarangMapping;
//import com.sinaukoding.perpustakaanfarhan.repository.BukuRepository;
//import com.sinaukoding.perpustakaanfarhan.repository.PeminjamanDetailRepository;
//import com.sinaukoding.perpustakaanfarhan.repository.PenerbitRepository;
//import com.sinaukoding.perpustakaanfarhan.repository.PengarangRepository;
//import com.sinaukoding.perpustakaanfarhan.service.BukuService;
//import com.sinaukoding.perpustakaanfarhan.service.PeminjamanDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//public class PeminjamanDetailServiceImpl implements PeminjamanDetailService {
//
//    @Autowired
//    private PeminjamanDetailRepository repository;
//
//    @Autowired
//    private BukuRepository bukuRepository;
//
//    @Transactional
//    @Override
//    public PeminjamanDetailDTO save(PeminjamanDetailDTO param) {
//        Buku buku = BukuMapping.instance.toEntity(param.getBuku());
//
//        PeminjamanDetail data = PeminjamanDetailMapping.instance.toEntity(param);
//
//        if (param.getBuku().getId() == null) {
//            return null;
//        }
//        if (param.getBuku() != null) {
//            buku = bukuRepository.save(buku);
//
//            data.getBuku().setId(buku.getId());
//        }
//
//        data = repository.save(data);
//
//        return PeminjamanDetailMapping.instance.toDto(data);
//    }
//
//    @Transactional
//    @Override
//    public List<PeminjamanDetailDTO> findAllData()
//    {
//        return PeminjamanDetailMapping.instance.toListDto(repository.findAll());
//
//    }
//    @Transactional
//    @Override
//    public PeminjamanDetailDTO update(PeminjamanDetailDTO param, Long id) {
//        PeminjamanDetail data = repository.findById(id).orElse(null);
//
//        if (data != null){
//            data.setJudul(param.getJudul() == null ? data.getJudul() : param.getJudul());
//            data.setTahunTerbit(param.getTahunTerbit() != null ? param.getTahunTerbit() : data.getTahunTerbit());
//            data.setJumlah(param.getJumlah() != null ? param.getJumlah() : data.getJumlah());
//            data.setIsbn(param.getIsbn() != null ? param.getIsbn() : data.getIsbn());
//
//            return  PeminjamanDetailMapping.instance.toDto(repository.save(data));
//        }
//        return PeminjamanDetailMapping.instance.toDto(data);
//
//    }
//    @Override
//    public Boolean delete(Long id) {
//        PeminjamanDetail data = repository.findById(id).orElse(null);
//
//        if (data != null){
//            repository.delete(data);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public PeminjamanDetailDTO findById(Long id) {
//        return PeminjamanDetailMapping.instance.toDto(repository.findById(id).orElse(null));
//    }
//}
