package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

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

    @Override
    public void insertMember(MemberDTO dto) {
        sqlSession.insert("member.insertMember", dto);
    }

    @Override
    public void deleteMember(int id) {
        sqlSession.delete("member.deleteMember", id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        sqlSession.update("member.updateMember", dto);
    }

    @Override
    public void cancelMember(int id) {
        sqlSession.update("member.cancelMember", id);
    }

    @Override
    public boolean checkPw(int id, String passwd) {
        boolean result =false;
        Map<String, String> map  = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("passwd", passwd);
        int count=sqlSession.selectOne("member.checkPw", map);
        if(count==1) result=true;
        return result;
    }
}




