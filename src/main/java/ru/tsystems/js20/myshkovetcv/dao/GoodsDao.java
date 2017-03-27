package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> getAllGoodsAbovePrice(int price);
    List<Goods> getAllGoods();
    Goods findGoods(Long id);

    void addGoods(Goods goods);

    void deleteGoods(Goods goods);

    void updateGoods(Goods goods);

    Goods findGoodsByName(String name);
}
