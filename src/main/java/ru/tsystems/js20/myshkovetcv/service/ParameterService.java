package ru.tsystems.js20.myshkovetcv.service;

import ru.tsystems.js20.myshkovetcv.model.Parameter;

import java.util.List;

public interface ParameterService {

    Parameter findById(Long id);

    Parameter findByName(String name);

    void saveParameter(Parameter parameter);

    void updateParameter(Parameter parameter);

    List<Parameter> findAllParameters();

}
