package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.ParameterValue;

import java.util.List;

public interface ParameterValueService {

    ParameterValue findById(Long id);

    ParameterValue findByValue(String value);

    void saveParameterValue(ParameterValue parameterValue);

    void updateParameterValue(ParameterValue parameterValue);

    List<ParameterValue> findAllParameterValues();

}
