package com.generation.esempiosemicompletoback.model.dtos;

import com.generation.esempiosemicompletoback.model.entities.Prodotto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductGetDto
{
    private Long id;
    private String name,category,imgUrl;
    private double price;

    public ProductGetDto(Prodotto p)
    {
        id=p.getId();
        name= p.getNome();
        category= p.getCategoria();
        imgUrl= p.getLinkImmagine();
        price= p.getPrezzo();
    }
}
