package com.floresyeventos.v1.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name ="tbl_flores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="arreglo", nullable =true, length = 50)
    String nombreArreglo;

    String color;
    float precio;

    
}
