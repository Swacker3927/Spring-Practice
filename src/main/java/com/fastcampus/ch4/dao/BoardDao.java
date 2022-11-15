package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BoardDao {
    BoardDto select(Integer bno) throws SQLException;
    int insert(BoardDto dto) throws SQLException;
    int update(BoardDto dto) throws SQLException;
    int delete(Integer bno, String writer) throws SQLException;
    int increaseViewCnt(Integer bno) throws SQLException;
    List<BoardDto> selectAll() throws SQLException;
    List<BoardDto> selectPage(Map map) throws SQLException;
    int count() throws SQLException;
    int deleteAll() throws SQLException;
    List<BoardDto> searchSelectPage(SearchCondition sc) throws SQLException;
    int searchResultCnt(SearchCondition sc) throws SQLException;
    int updateCommentCnt(Integer bno, Integer cnt) throws SQLException;
}
