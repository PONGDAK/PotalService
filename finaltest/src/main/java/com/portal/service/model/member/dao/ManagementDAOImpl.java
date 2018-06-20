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

    @Override
    public void cancelMember(int id) {
        sqlSession.update("management.cancelMember", id);
    }

    @Override
    public void deleteNowMember(int id) {
        sqlSession.delete("management.deleteNowMember", id);
    }

}
