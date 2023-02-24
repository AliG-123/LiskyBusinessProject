package com.sparta.converter;

public class JsonConverterFactory extends ConverterFactory{
    @Override
    public Converter getConverter() {

        return new JsonConverter();
    }
}
