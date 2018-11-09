package com.nhnent.edu.dispatcher.helper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.StringUtils;

// TODO: 7. enum converter 작성
// TODO: 7. enum converter作成
public class LowerCaseStringToEnumConverterFactory implements ConverterFactory<String, Enum> {
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        Class<?> enumType = targetType;
        while (enumType != null && !enumType.isEnum()) {
            enumType = enumType.getSuperclass();
        }

        if (enumType == null) {
            throw new IllegalArgumentException("The target type " + targetType.getName() + " does not refer to an enum");
        }

        return new LowerCaseStringToEnum(enumType);
    }


    private class LowerCaseStringToEnum<T extends Enum> implements Converter<String, T> {
        private final Class<T> enumType;


        public LowerCaseStringToEnum(Class<T> enumType) {
            this.enumType = enumType;
        }


        @Override
        public T convert(String source) {
            if (StringUtils.isEmpty(source)) {
                return null;
            }

            return (T) Enum.valueOf(this.enumType, source.trim().toUpperCase());
        }

    }

}
