package com.registro.registro.model;

import com.registro.registro.model.data.DBConnector;
import com.registro.registro.model.data.dao.CategoriaDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Categoria {
    private int id;
    private String nombreCategoria;

    public Categoria(int id,String nombreCategoria) {
        this.id=id;
        this.nombreCategoria = nombreCategoria;
    }
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    public boolean registrarCategoria(){
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return new CategoriaDAO().registrarCategoria(query,this);
    }
}
