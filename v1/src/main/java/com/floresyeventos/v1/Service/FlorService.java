package com.floresyeventos.v1.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.floresyeventos.v1.Repository.florRepository;
import com.floresyeventos.v1.model.Flores;

@Service
public class FlorService  {

    @Autowired
    private florRepository FlorRepository;

    
    public List<Flores> listarFlores() {
      
        return FlorRepository.findAll();
    }

    public Flores guardarFlor(Flores flores){
       return FlorRepository.save(flores);
    }

}