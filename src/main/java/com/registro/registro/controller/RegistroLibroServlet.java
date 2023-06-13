package com.registro.registro.controller;

import com.registro.registro.model.Categoria;
import com.registro.registro.model.Libro;
import com.registro.registro.model.data.DBConnector;
import com.registro.registro.model.data.dao.CategoriaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "RegistroLibroServlet", value = "/crearLibro")
public class RegistroLibroServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Libros");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/crearLibro.jsp");
        request.setAttribute("categorias",obtenerCategorias());
        requestDispatcher.forward(request,response);


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tituloLibro=request.getParameter("titulo");
        String categoria=request.getParameter("categoria");
        String fechaPublicacion=request.getParameter("fecha");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("crearLibro.jsp");
        if(!tituloLibro.isEmpty() && !categoria.isEmpty() && !fechaPublicacion.isEmpty() ){
            Libro libro=new Libro(0,tituloLibro,categoria,fechaPublicacion);
            if(libro.registrarLibro()){
                System.out.println("Funco");
            }else{
                System.out.println("No funco");
            }
        }
        requestDispatcher.forward(request,response);
    }
    public ArrayList<Categoria> obtenerCategorias(){
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        return CategoriaDAO.obtenerCategorias(query);
    }
}
