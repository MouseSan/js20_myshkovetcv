package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Goods;

import javax.persistence.*;
import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Goods> getAllGoodsAbovePrice(int price) {
        Query query = entityManager.createQuery("select g from Goods as g where g.price > :price");
        List<Goods> resultList = query.setParameter("price", price).setFirstResult(0).setMaxResults(10).getResultList();
        return resultList;
    }

    @Override
    @ManyToOne(cascade = CascadeType.ALL)
    public List<Goods> getAllGoods() {
        Query query = entityManager.createQuery("from Goods");
        List<Goods> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public Goods findGoods(Long id) {
        return entityManager.find(Goods.class, id);
    }

    @Override
    public void addGoods(Goods goods) {
        entityManager.persist(goods);
    }

    @Override
    public void deleteGoods(Goods goods) {
        entityManager.remove(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        entityManager.merge(goods);
    }

    @Override
    public Goods findGoodsByName(String name) {
//        System.out.println("name = " + name);
        List<Goods> goods = entityManager.createQuery("select g from Goods as g where g.name =:name").setParameter("name", name).getResultList();
        return !goods.isEmpty() ? goods.get(0) : null;
    }
}
