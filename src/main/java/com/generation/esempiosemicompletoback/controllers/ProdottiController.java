package com.generation.esempiosemicompletoback.controllers;

import com.generation.esempiosemicompletoback.model.dtos.ProductGetDto;
import com.generation.esempiosemicompletoback.model.entities.Prodotto;
import com.generation.esempiosemicompletoback.model.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProdottiController
{
    @Autowired
    ProdottoRepository repo;

    //http://localhost:8080/api/products?cat=i&v=3&sgn=true
    @GetMapping
    public List<ProductGetDto> leggiTutti
    (
            @RequestParam(required = false) String cat,
            @RequestParam(required = false) Double v,
            @RequestParam(required = false) Boolean sgn
    )
    {
        List<Prodotto> l = repo.findAll();
        if(cat!=null)
            l = l.stream().filter(p->p.getCategoria().toLowerCase().contains(cat.toLowerCase())).toList();
        if(v!=null && sgn!=null)
            l = l.stream()
                    .filter
                    (
                            p->
                            {
                              if(sgn)
                                  return p.getPrezzo()>=v;
                              else
                                  return p.getPrezzo()<=v;
                            }
                    ).toList();

        return l.stream().map(p-> new ProductGetDto(p)).toList();
//       List<ProductGetDto> listaDto = new ArrayList<>();
//
//       for(Prodotto p : l)
//       {
//           ProductGetDto convertito = new ProductGetDto(p);
//           listaDto.add(convertito);
//       }
//       return listaDto;
//       return repo.findAll().stream().map(p-> new ProductGetDto(p)).toList();
    }

//    @GetMapping
//    public List<Prodotto> leggiTutti()
//    {
//        return repo.findAll();
//
//    }
}
