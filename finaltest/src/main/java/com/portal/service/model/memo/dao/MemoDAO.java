package com.portal.service.model.memo.dao;

import com.portal.service.model.memo.dto.MemoDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MemoDAO {
    @Select("select * from memo order by id desc")
    public List<MemoDTO> list();
    @Insert("insert into memo (writer, memo) values (#{writer}, #{memo})")
    public void insert(@Param("writer") String writer, @Param("memo") String memo);
    @Select("select * from memo where id=#{id}")
    public MemoDTO memo_view(@Param("id") int id);
    @Update("update memo set writer=#{writer}, memo=#{memo} where id=#{id}")
    public void update(MemoDTO dto);
    @Delete("delete from memo where id=#{id}")
    public void delete(@Param("id") int id);
}
