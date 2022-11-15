package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.domain.BoardDto;
import com.fastcampus.ch4.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;

    @Override
    public int getCount() throws SQLException {
        return boardDao.count();
    }

    @Override
    public List<BoardDto> getList() throws SQLException {
        return boardDao.selectAll();
    }

    @Override
    public BoardDto read(Integer bno) throws SQLException {
        BoardDto boardDto = boardDao.select(bno);
        boardDao.increaseViewCnt(bno);

        return boardDto;
    }

    @Override
    public int write(BoardDto boardDto) throws SQLException {
        return boardDao.insert(boardDto);
    }

    @Override
    public int modify(BoardDto boardDto) throws SQLException {
        return boardDao.update(boardDto);
    }

    @Override
    public int remove(Integer bno, String writer) throws SQLException {
        return boardDao.delete(bno, writer);
    }

    @Override
    public List<BoardDto> getPage(Map map) throws SQLException {
        return boardDao.selectPage(map);
    }

    @Override
    public List<BoardDto> getSearchResultPage(SearchCondition sc) throws SQLException {
        return boardDao.searchSelectPage(sc);
    }

    @Override
    public int getSearchResultCnt(SearchCondition sc) throws SQLException {
        return boardDao.searchResultCnt(sc);
    }
}
