package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.ParameterDao;
import ru.tsystems.js20.myshkovetcv.dao.ParameterValueDao;
import ru.tsystems.js20.myshkovetcv.model.ParameterValue;

import java.util.List;

@Service("parameterValueService")
@Transactional
public class ParameterValueServiceImpl implements ParameterValueService {

    @Autowired
    private ParameterValueDao parameterValueDao;

    @Autowired
    private ParameterDao parameterDao;

    @Override
    public ParameterValue findById(Long id) {
        return parameterValueDao.findById(id);
    }

    @Override
    public ParameterValue findByValue(String value) {
        return parameterValueDao.findByValue(value);
    }

    @Override
    public void saveParameterValue(ParameterValue parameterValue) {
        parameterValue.setParameter(parameterDao.findById(parameterValue.getParameter().getId()));
        parameterValueDao.save(parameterValue);
    }

    @Override
    public void updateParameterValue(ParameterValue parameterValue) {
        ParameterValue parameterValueToBeMerged = parameterValueDao.findById(parameterValue.getId());
        if (parameterValueToBeMerged != null) {
            parameterValueDao.updateParameterValue(parameterValue);
        }
    }

    @Override
    public List<ParameterValue> findAllParameterValues() {
        return parameterValueDao.findAllParametersValue();
    }
}
