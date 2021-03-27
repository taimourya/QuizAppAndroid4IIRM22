package com.example.quizv1.Dao;


import java.util.List;

public interface IRepository<Type> {

    public List<Type> findAll();
    public Type findOneById(int id);
    public void add(Type t);
}
