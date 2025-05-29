/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;


public interface CrudDAO<T, ID> {

    T create(T entity);// tao moi

    void update(T entity);// cap nhat

    void deleteById(ID id);// xoa

    List<T> findAll();// getall = lay toan bo du lieu tu sql

    T findById(ID id);// tim theo khoa chinh
}
