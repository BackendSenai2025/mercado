package br.com.senai.backend.sistema_mercado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id; 
    
}
