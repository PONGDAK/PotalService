package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository //dao bean
public class AdminDAOImpl implements AdminDAO {

    private final SqlSession sqlSession;

    @Inject
    public AdminDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public String loginCheck(MemberDTO dto) {
        return sqlSession.selectOne("admin.login_check", dto);
    }

}





