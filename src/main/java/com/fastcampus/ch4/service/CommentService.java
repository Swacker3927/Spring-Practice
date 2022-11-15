package com.fastcampus.ch4.service;

import com.fastcampus.ch4.domain.CommentDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface CommentService {
    int getCount(Integer bno) throws SQLException;

    @Transactional(rollbackFor = SQLException.class)
    int remove(Integer cno, Integer bno, String commentor) throws SQLException;

    @Transactional(rollbackFor = SQLException.class)
    int write(CommentDto commentDto) throws SQLException;

    List<CommentDto> getList(Integer bno) throws SQLException;

    CommentDto read(Integer cno) throws SQLException;

    int modify(CommentDto commentDto) throws SQLException;
}
