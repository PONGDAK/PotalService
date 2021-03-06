package com.portal.service.service.member;

import com.portal.service.model.member.dao.ManagementDAO;
import com.portal.service.model.member.dto.MemberDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {

    private final ManagementDAO managementDAO;

    @Inject
    public ManagementServiceImpl(ManagementDAO managementDAO) {
        this.managementDAO = managementDAO;
    }

    @Override
    public List<MemberDTO> memberList() {
        return managementDAO.memberList();
    }

    @Override
    public void insertMember(MemberDTO dto) {
        managementDAO.insertMember(dto);
    }

    @Override
    public MemberDTO viewMember(int id) {
        return managementDAO.viewMember(id);
    }

    @Override
    public void deleteMember(int id) {
        managementDAO.deleteMember(id);
    }

    @Override
    public void updateMember(MemberDTO dto) {
        managementDAO.updateMember(dto);
    }

    @Override
    public void cancelMember(int id) {
        managementDAO.cancelMember(id);
    }

    @Transactional
    @Override
    public void deleteNowMember(int id) {
        managementDAO.deleteNowMember(id);
    }
}
