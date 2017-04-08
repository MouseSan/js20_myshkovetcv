package ru.tsystems.js20.myshkovetcv.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.tsystems.js20.myshkovetcv.model.Parameter;
import ru.tsystems.js20.myshkovetcv.service.ParameterService;

@Component
public class ParameterIdToParameterClassConverter implements Converter<Object, Parameter> {

    @Autowired
    ParameterService parameterService;

    @Override
    public Parameter convert(Object obj) {
        if (obj instanceof Parameter) {
            return (Parameter) obj;
        } else {
            Long id = Long.parseLong((String) obj);
            Parameter parameter = parameterService.findById(id);
            return parameter;
        }
    }
}
