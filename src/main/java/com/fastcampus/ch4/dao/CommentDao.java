package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.CommentDto;

import java.sql.SQLException;
import java.util.List;

public interface CommentDao {
    int count(Integer bno) throws SQLException; // T selectOne(String statement)

    int deleteAll(Integer bno); // int delete(String statement)

    int delete(Integer cno, String commenter) throws SQLException; // int delete(String statement, Object parameter)

    int insert(CommentDto dto) throws SQLException; // int insert(String statement, Object parameter)

    List<CommentDto> selectAll(Integer bno) throws SQLException; // List<E> selectList(String statement)

    CommentDto select(Integer cno) throws SQLException; // T selectOne(String statement, Object parameter)

    int update(CommentDto dto) throws SQLException; // int update(String statement, Object parameter)
}
