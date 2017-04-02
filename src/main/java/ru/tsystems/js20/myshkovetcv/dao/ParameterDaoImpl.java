package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.Parameter;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("parameterDao")
public class ParameterDaoImpl extends AbstractDao<Long, Parameter> implements ParameterDao {

    @Override
    public Parameter findById(Long id) {
        return getByKey(id);
    }

    @Override
    public Parameter findByName(String name) {
        try {
            Parameter parameter = (Parameter) getEntityManager()
                    .createQuery("SELECT p FROM Parameter p WHERE p.name LIKE :name")
                    .setParameter("name", name)
                    .getSingleResult();
            return parameter;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(Parameter parameter) {
        persist(parameter);
    }

    @Override
    public void updateParameter(Parameter parameter) {
        update(parameter);
    }

    @Override
    public List<Parameter> findAllParameters() {
        List<Parameter> parameterList = getEntityManager()
                .createQuery("SELECT p FROM Parameter p ORDER BY p.name ASC")
                .getResultList();
        return parameterList;
    }
}
