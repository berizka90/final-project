package model.dao;

import java.sql.SQLException;

/**
 * Functional interface used in DAO implementations for mapping data from
 * ResultSet to Entity and from Entity to ResultSet
 * @param <S> - source object for mapping (ResultSet or entity)
 * @param <D> - mapping destination object (ResultSet or entity)
 */

public interface Mapper <S, D> {
    void map(S source, D destination) throws SQLException;
}