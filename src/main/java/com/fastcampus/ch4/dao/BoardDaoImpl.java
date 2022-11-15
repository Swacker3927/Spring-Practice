package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.fastcampus.ch4.dao.BoardMapper.";

    public int count() throws SQLException {
        return session.selectOne(namespace+"count");
    } // T selectOne(String statement)

    @Override
    public int deleteAll() {
        return session.delete(namespace+"deleteAll");
    } // int delete(String statement)

    @Override
    public int delete(Integer bno, String writer) throws SQLException {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace+"delete", map);
    } // int delete(String statement, Object parameter)

    public int insert(BoardDto dto) throws SQLException {
        return session.insert(namespace+"insert", dto);
    } // int insert(String statement, Object parameter)

    @Override
    public List<BoardDto> selectAll() throws SQLException {
        return session.selectList(namespace+"selectAll");
    } // List<E> selectList(String statement)

    public BoardDto select(Integer bno) throws SQLException {
        return session.selectOne(namespace + "select", bno);
    } // T selectOne(String statement, Object parameter)

    @Override
    public List<BoardDto> selectPage(Map map) throws SQLException {
        return session.selectList(namespace+"selectPage", map);
    } // List<E> selectList(String statement, Object parameter)

    @Override
    public int update(BoardDto dto) throws SQLException {
        return session.update(namespace+"update", dto);
    } // int update(String statement, Object parameter)

    @Override
    public int increaseViewCnt(Integer bno) throws SQLException {
        return session.update(namespace+"increaseViewCnt", bno);
    } // int update(String statement, Object parameter)

    @Override
    public List<BoardDto> searchSelectPage(SearchCondition sc) throws SQLException {
        return session.selectList(namespace+"searchSelectPage", sc);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws SQLException {
        return session.selectOne(namespace+"searchResultCnt", sc);
    }

    @Override
    public int updateCommentCnt(Integer bno, Integer cnt) throws SQLException {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("cnt", cnt);
        return session.update(namespace + "updateCommentCnt", map);
    }
}