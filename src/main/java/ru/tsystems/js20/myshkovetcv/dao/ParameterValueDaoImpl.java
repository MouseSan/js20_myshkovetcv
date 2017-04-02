package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.ParameterValue;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("parameterValueDao")
public class ParameterValueDaoImpl extends AbstractDao<Long, ParameterValue> implements ParameterValueDao {

    @Override
    public ParameterValue findById(Long id) {
        return getByKey(id);
    }

    @Override
    public ParameterValue findByValue(String value) {
        try {
            ParameterValue parameterValue = (ParameterValue) getEntityManager()
                    .createQuery("SELECT p FROM ParameterValue p WHERE p.value LIKE :value")
                    .setParameter("value", value)
                    .getSingleResult();

            return parameterValue;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void save(ParameterValue parameterValue) {
        persist(parameterValue);
    }

    @Override
    public void updateParameterValue(ParameterValue parameterValue) {
        update(parameterValue);
    }

    @Override
    public List<ParameterValue> findAllParametersValue() {
        List<ParameterValue> parameterValueList = getEntityManager()
                .createQuery("SELECT p FROM ParameterValue p ORDER BY p.value ASC")
                .getResultList();
        return parameterValueList;
    }
}
