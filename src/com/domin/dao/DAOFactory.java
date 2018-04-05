package com.domin.dao;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by asouqi on 4/5/18.
 */
public class DAOFactory {

    public static CRUDOperations getDAOObject(String name, HttpServletRequest request){
        switch (name){
            case "users":break;
        }
        return null;
    }
}
