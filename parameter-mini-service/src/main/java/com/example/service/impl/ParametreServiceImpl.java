package com.example.service.impl;

import com.example.dto.DtoParametre;
import com.example.dto.DtoParametreUI;
import com.example.exception.BaseException;
import com.example.exception.ErrorMessage;
import com.example.exception.MessageType;
import com.example.model.Parametre;
import com.example.repository.ParametreRepository;
import com.example.service.ParametreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParametreServiceImpl implements ParametreService {

    @Autowired
    private ParametreRepository parametreRepository;

    @Override
    public List<DtoParametre> allParameters() {

        List<Parametre> parametreList = parametreRepository.findAll();

        if(parametreList.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.PARAMETRELER_YOK , parametreList.toString()));
        }

        List<DtoParametre> dtoParametreList = new ArrayList<>();

        for (Parametre parametre : parametreList) {
            DtoParametre dtoParametre = new DtoParametre();
            BeanUtils.copyProperties(parametre, dtoParametre);
            dtoParametreList.add(dtoParametre);
        }

        return dtoParametreList;
    }

    @Override
    public DtoParametre findByParametre(Long code) {

        Parametre parametre = parametreRepository.findByCode(code);

        if (parametre == null) {
            throw new BaseException(new ErrorMessage(MessageType.PARAMETRE_YOK , parametre.getCode().toString()));
        }

        DtoParametre dtoParametre = new DtoParametre();
        BeanUtils.copyProperties(parametre, dtoParametre);

        return dtoParametre;
    }

    @Override
    public DtoParametre saveParametre(DtoParametreUI dtoParametreUI) {

        Parametre parametre = new Parametre();

        parametre.setCode(dtoParametreUI.getCode());
        parametre.setParametreAd(dtoParametreUI.getParametreAd());

        if(parametre.getCode() < 0){
            throw new BaseException(new ErrorMessage(MessageType.CODE_DEGERİ_EKSİ_HATASI ,  parametre.getCode().toString()));
        }

        Parametre dbParametre = parametreRepository.save(parametre);
        DtoParametre dtoParametre = new DtoParametre();

        BeanUtils.copyProperties(dbParametre, dtoParametre);

        return dtoParametre;
    }

    @Override
    public DtoParametre updateParametre(Long code , DtoParametreUI dtoParametreUI) {

        Parametre parametre = parametreRepository.findByCode(code);

        if(parametre == null){
            throw new BaseException(new ErrorMessage(MessageType.PARAMETRE_YOK , parametre.getCode().toString()));
        }

        parametre.setCode(dtoParametreUI.getCode());
        parametre.setParametreAd(dtoParametreUI.getParametreAd());

        Parametre updateParametre = parametreRepository.save(parametre);
        DtoParametre dtoParametre = new DtoParametre();
        BeanUtils.copyProperties(updateParametre, dtoParametre);

        return dtoParametre;
    }

    @Override
    public void deleteParametre(Long code) {

        Optional<Parametre> parametre = parametreRepository.findById(code);

        if(parametre.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.PARAMETRE_YOK , parametre.get().toString()));
        }

        parametreRepository.delete(parametre.get());

    }
}
