package com.main.model;

public class StudentModel extends BaseModel {

    public static Class<? extends BaseModel> instance;

    public StudentModel(){
        Instance(id);
        increaseID();
    }

    public static Class<? extends BaseModel> getInstanceOfStudent(int id){
        return instance;
    }

    private Class<? extends BaseModel> Instance(int id){
        instance = __getInstance(id);
        return instance;
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
