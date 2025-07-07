package com.example.controller.impl;

import com.example.controller.ParametreController;
import com.example.dto.DtoParametre;
import com.example.dto.DtoParametreUI;
import com.example.service.ParametreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api")
public class ParametreControllerImpl implements ParametreController {

    @Autowired
    private ParametreService parametreService;

    @Override
    @GetMapping("/all-parameter")
    public List<DtoParametre> allParameters() {
        return parametreService.allParameters();
    }

    @Override
    @GetMapping(path = "/parameter/{code}")
    public DtoParametre findByParametre(@PathVariable(name = "code" , required = true) Long code) {
        return parametreService.findByParametre(code);
    }

    @Override
    @PostMapping(path = "/parametre-ekle")
    public DtoParametre saveParametre(@RequestBody DtoParametreUI dtoParametreUI) {
        return parametreService.saveParametre(dtoParametreUI);
    }

    @Override
    @PutMapping(path = "/guncelle/{code}")
    public DtoParametre updateParametre(@PathVariable(name = "code" , required = true) Long code,@RequestBody DtoParametreUI dtoParametreUI) {
        return parametreService.updateParametre(code, dtoParametreUI);
    }

    @Override
    @DeleteMapping(path = "/delete/{code}")
    public void deleteParametre(@PathVariable(name = "code" , required = true) Long code) {
        parametreService.deleteParametre(code);
    }

}
