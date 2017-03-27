package ru.tsystems.js20.myshkovetcv.services;


import ru.tsystems.js20.myshkovetcv.model.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getAllGoods();

    Goods findGoods(long id);

    void delete(long id);

    void update(Goods goods);

    void save(Goods goods);

    Goods findGoodsByName(String name);
}
