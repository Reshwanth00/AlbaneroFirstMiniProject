package com.example.AlbanerooFirst;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Serv {
    @Autowired
    Repo repo;

    public void addEmployee(Model model) {
        repo.save(model);
    }

    public void updateEmployee(Integer id, String name) {
        Model model = repo.findById(id).get();
        model.setName(name);
        repo.save(model);
    }

    public List<Model> allEmployee() {
        List<Model> list = repo.findAll();
        return list;
    }

    public Model removeId(Integer id) {
        Model model = repo.findById(id).get();
        repo.delete(model);
        return model;
    }
}
