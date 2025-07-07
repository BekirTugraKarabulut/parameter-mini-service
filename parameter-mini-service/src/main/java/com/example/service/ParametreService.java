package com.example.service;

import com.example.dto.DtoParametre;
import com.example.dto.DtoParametreUI;

import java.util.List;

public interface ParametreService {

    public List<DtoParametre> allParameters();

    public DtoParametre findByParametre(Long code);

    public DtoParametre saveParametre(DtoParametreUI dtoParametreUI);

    public DtoParametre updateParametre(Long code , DtoParametreUI dtoParametreUI);

    public void deleteParametre(Long code);

}
