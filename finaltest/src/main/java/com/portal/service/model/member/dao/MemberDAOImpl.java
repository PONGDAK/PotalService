package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository // Spring에서 관리하는 dao bean으로 설정 
public class MemberDAOImpl implements MemberDAO {

    private final SqlSession sqlSession;

    @Inject
    public MemberDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public boolean loginCheck(MemberDTO dto) {
        String name = sqlSession.selectOne("member.loginCheck", dto);
        return name != null;
    }

    @Override
    public MemberDTO viewMember(String userid) {
        return sqlSession.selectOne("member.viewMember", userid);
    }

}




