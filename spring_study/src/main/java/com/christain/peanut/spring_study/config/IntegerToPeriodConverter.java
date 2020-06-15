package com.christain.peanut.spring_study.config;

import com.christain.peanut.common.domain.Period;
import org.springframework.core.convert.converter.Converter;

public class IntegerToPeriodConverter implements Converter<Integer,Period> {
    @Override
    public Period convert(Integer source) {
        Period period = new Period();
        period.setAge(source);
        return period;
    }
}
