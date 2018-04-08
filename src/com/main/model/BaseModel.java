package com.main.model;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public abstract class BaseModel {
    protected static Integer id = 0;
    protected String name;
    protected ArrayList<Class<? extends BaseModel>> instances;

    public abstract void save();
    public abstract void update();
    public abstract void delete();

    public void increaseID(){
        id++;
    }

    public <T extends Class<? extends BaseModel>>T __getInstance(int id){
        T ins;
        ins = (id >= instances.size()) ? null : (T)instances.get(id);
        if (ins == null) {
            try {
                ins = (T) ((Class)((ParameterizedType)this
                        .getClass()
                        .getGenericSuperclass())
                        .getActualTypeArguments()[0])
                        .newInstance();
                return ins;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return ins;
    }

}
