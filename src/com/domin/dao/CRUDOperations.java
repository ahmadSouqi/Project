package com.domin.dao;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by asouqi on 3/27/18.
 */
public interface CRUDOperations<T,I> {
    Collection<T> get() throws SQLException;

    void add(T object)throws SQLException;

    void edit(T object,I oldId)throws SQLException;

    void delete(I id)throws SQLException;
}
