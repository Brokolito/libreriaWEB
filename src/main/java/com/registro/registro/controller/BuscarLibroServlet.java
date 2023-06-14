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

@WebServlet(name = "BuscarLibroServlet",value = ("/buscarLibro"))
public class BuscarLibroServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/buscarLibro.jsp");
        request.setAttribute("categorias",obtenerCategorias());
        requestDispatcher.forward(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String titulo=request.getParameter("titulo");
        String categoria=request.getParameter("categoria");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/buscarLibro.jsp");
        if(!titulo.isEmpty() || !categoria.isEmpty()){
            Libro libro=new Libro(0,titulo,categoria,"");
            ArrayList<Libro> libros=libro.buscarLibro();
            if(libros.size()!=0){
                request.setAttribute("libros",libros);
            }
        }
        System.out.println("Libros");
        request.setAttribute("categorias",obtenerCategorias());
        requestDispatcher.forward(request,response);
    }
    public ArrayList<Categoria> obtenerCategorias(){
        Connection connection= DBConnector.connection("libreria","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return CategoriaDAO.obtenerCategorias(query);
    }
}
