package ru.tsystems.js20.myshkovetcv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.GoodsDao;
import ru.tsystems.js20.myshkovetcv.model.Goods;

import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao dao;

    @Override
    public List<Goods> getAllGoods() {
        return dao.getAllGoods();
    }

    @Override
    public Goods findGoods(long id) {
        return dao.findGoods(id);
    }

    @Override
    public void delete(long id) {
        dao.deleteGoods(findGoods(id));
    }

    @Override
    public void update(Goods goods) {
        dao.updateGoods(goods);
    }

    @Override
    public void save(Goods goods) {
        dao.addGoods(goods);
    }

    @Override
    public Goods findGoodsByName(String name) {
        return dao.findGoodsByName(name);
    }
}
