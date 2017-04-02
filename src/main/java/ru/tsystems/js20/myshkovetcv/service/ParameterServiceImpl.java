package ru.tsystems.js20.myshkovetcv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsystems.js20.myshkovetcv.dao.ParameterDao;
import ru.tsystems.js20.myshkovetcv.model.Parameter;

import java.util.List;

@Service("parameterService")
@Transactional
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterDao parameterDao;

    @Override
    public Parameter findById(Long id) {
        return parameterDao.findById(id);
    }

    @Override
    public Parameter findByName(String name) {
        return parameterDao.findByName(name);
    }

    @Override
    public void saveParameter(Parameter parameter) {
        parameterDao.save(parameter);
    }

    @Override
    public void updateParameter(Parameter parameter) {
        Parameter entity = parameterDao.findById(parameter.getId());
        if (entity != null) {
            parameterDao.updateParameter(parameter);
        }
    }

    @Override
    public List<Parameter> findAllParameters() {
        return parameterDao.findAllParameters();
    }
}
