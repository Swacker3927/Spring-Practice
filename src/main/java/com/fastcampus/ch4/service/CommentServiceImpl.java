package com.fastcampus.ch4.service;

import com.fastcampus.ch4.dao.BoardDao;
import com.fastcampus.ch4.dao.CommentDao;
import com.fastcampus.ch4.domain.CommentDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    BoardDao boardDao;
    CommentDao commentDao;

    public CommentServiceImpl(CommentDao commentDao, BoardDao boardDao) {
        this.commentDao = commentDao;
        this.boardDao = boardDao;
    }

    @Override
    public int getCount(Integer bno) throws SQLException {
        return commentDao.count(bno);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int remove(Integer cno, Integer bno, String commentor) throws SQLException {
        int rowCnt = boardDao.updateCommentCnt(bno, -1);
        System.out.println("updateCommentCnt - rowCnt = " + rowCnt);
        rowCnt = commentDao.delete(cno, commentor);
        System.out.println("rowCnt = " + rowCnt);
        return rowCnt;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public int write(CommentDto commentDto) throws SQLException {
        boardDao.updateCommentCnt(commentDto.getBno(), 1);
        return commentDao.insert(commentDto);
    }

    @Override
    public List<CommentDto> getList(Integer bno) throws SQLException {
        return commentDao.selectAll(bno);
    }

    @Override
    public CommentDto read(Integer cno) throws SQLException {
        return commentDao.select(cno);
    }

    @Override
    public int modify(CommentDto commentDto) throws SQLException {
        return commentDao.update(commentDto);
    }
}
