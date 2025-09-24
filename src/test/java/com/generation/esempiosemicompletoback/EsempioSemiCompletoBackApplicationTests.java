package com.generation.esempiosemicompletoback;

import com.generation.esempiosemicompletoback.model.entities.Prodotto;
import com.generation.esempiosemicompletoback.model.repository.ProdottoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EsempioSemiCompletoBackApplicationTests {

    @Autowired
    ProdottoRepository repo;

    @Test
    void contextLoads()
    {
        List<Prodotto> prodotti = new ArrayList<>();

        prodotti.add(new Prodotto(null, "Calzini", "Vestiti", "https://www.cappelleria.it/pic/32311a.jpg", 4.99));
        prodotti.add(new Prodotto(null, "Sandali", "Vestiti", "https://data.mecshopping.it/imgprodotto/sandali-uomo-con-cinturini-a-strappo_703493.jpg", 18.99));
        prodotti.add(new Prodotto(null, "Candele", "Accessori", "https://www.erboristeriavita.it/shop/24861-large_default/candela-da-tavolo-alta-qualita-20-x-2cm-arancione.jpg", 2.99));
        prodotti.add(new Prodotto(null, "Corda da arrampicata", "Hobby", "https://media.adeo.com/mkp/ed5267b9874848349c4b8190a0d6dc69/media.jpeg", 12.99));
        prodotti.add(new Prodotto(null, "Smalto per pareti", "DIY", "https://www.boerofaidate.it/wp-content/uploads/2024/01/7PB993---Smalto-per-muri-lucido---7-lt.png", 76.99));

        repo.saveAll(prodotti);
    }

}
