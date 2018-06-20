package com.portal.service.model.member.dao;

import com.portal.service.model.member.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ManagementDAOImpl implements ManagementDAO{

    private final SqlSession sqlSession;

    @Inject
    public ManagementDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<MemberDTO> memberList() {
        return sqlSession.selectList("management.memberList");
    }

    @Override
    public void insertMember(MemberDTO dto) {
        sqlSession.insert("management.insertMember", dto);
    }

    @Override
    public MemberDTO viewMember(int id) {
        return sqlSession.selectOne("management.viewMember", id);
    }

    @Override
    public void deleteMember(int id) {
        sqlSession.delete("management.deleteMember", id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        sqlSession.update("management.updateMember", dto);
    }

//    @Override
//    public boolean checkPw(int id, String passwd) {
//        boolean result =false;
//        Map<String, String> map  = new HashMap<>();
//        map.put("id", String.valueOf(id));
//        map.put("passwd", passwd);
//        int count=sqlSession.selectOne("management.checkPw", map);
//        if(count==1) result=true;
//        return result;
//    }
}
