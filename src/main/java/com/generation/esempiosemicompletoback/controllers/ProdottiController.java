package com.generation.esempiosemicompletoback.controllers;

import com.generation.esempiosemicompletoback.model.dtos.ProductGetDto;
import com.generation.esempiosemicompletoback.model.entities.Prodotto;
import com.generation.esempiosemicompletoback.model.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProdottiController
{
    @Autowired
    ProdottoRepository repo;

    @GetMapping
    public List<ProductGetDto> leggiTutti()
    {
       List<Prodotto> l = repo.findAll();

       List<ProductGetDto> listaDto = new ArrayList<>();

       for(Prodotto p : l)
       {
           ProductGetDto convertito = new ProductGetDto(p);
           listaDto.add(convertito);
       }
       return listaDto;
//       return repo.findAll().stream().map(p-> new ProductGetDto(p)).toList();
    }

//    @GetMapping
//    public List<Prodotto> leggiTutti()
//    {
//        return repo.findAll();
//
//    }
}
