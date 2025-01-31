package com.floresyeventos.v1.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.floresyeventos.v1.model.Flores;
@Repository
public interface florRepository extends JpaRepository<Flores,Long>{
    //Que va aqui adentro
 
}
