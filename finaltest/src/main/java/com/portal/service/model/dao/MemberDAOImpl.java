package com.portal.service.model.dao;

import com.portal.service.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Inject
    SqlSession sqlSession;

    @Override
    public List<MemberDTO> memberList() {
        return sqlSession.selectList("member.memberList");
    }

    @Override
    public void insertMember(MemberDTO dto) {
        sqlSession.insert("member.insertMember", dto);
    }

    @Override
    public MemberDTO viewMember(Integer id) {
        return sqlSession.selectOne("member.viewMember", id);
    }

    @Override
    public void deleteMember(Integer id) {
        sqlSession.delete("member.deleteMember", id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        sqlSession.update("member.updateMember", dto);
    }

    @Override
    public boolean checkPw(Integer id, String passwd) {
        boolean result =false;
        Map<String, String> map  = new HashMap<>();
        map.put("id", String.valueOf(id));
        map.put("passwd", passwd);
        int count=sqlSession.selectOne("member.checkPw", map);
        if(count==1) result=true;
        return result;
    }
}
