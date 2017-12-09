package com.smallprintjobs.presentacion.json;


public interface IJsonTransformer {
    String toJson(Object data);
    Object fromJson(String json, Class clazz);
}


