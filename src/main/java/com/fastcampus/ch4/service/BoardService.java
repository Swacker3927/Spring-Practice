package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BoardService {
    int getCount() throws SQLException;

    List<BoardDto> getList() throws SQLException;

    BoardDto read(Integer bno) throws SQLException;

    int write(BoardDto boardDto) throws SQLException;

    int modify(BoardDto boardDto) throws SQLException;

    int remove(Integer bno, String writer) throws SQLException;

    List<BoardDto> getPage(Map map) throws SQLException;

    List<BoardDto> getSearchResultPage(SearchCondition sc) throws SQLException;

    int getSearchResultCnt(SearchCondition sc) throws SQLException;
}
