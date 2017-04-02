package ru.tsystems.js20.myshkovetcv.dao;

import ru.tsystems.js20.myshkovetcv.model.Parameter;

import java.util.List;

public interface ParameterDao {

    Parameter findById(Long id);

    Parameter findByName(String name);

    void save(Parameter parameter);

    void updateParameter(Parameter parameter);

    List<Parameter> findAllParameters();

}
