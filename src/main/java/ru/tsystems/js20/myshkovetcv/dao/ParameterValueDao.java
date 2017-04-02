package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.ParameterValue;

import java.util.List;

public interface ParameterValueDao {

    ParameterValue findById(Long id);

    ParameterValue findByValue(String value);

    void save(ParameterValue parameterValue);

    void updateParameterValue(ParameterValue parameterValue);

    List<ParameterValue> findAllParametersValue();

}
