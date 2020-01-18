package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.MessageSendlog;
import com.gsm.project.bwcar.pojo.MessageSendlogExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MessageSendlogDao {
    long countByExample(MessageSendlogExample example);

    int deleteByExample(MessageSendlogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageSendlog record);

    int insertSelective(MessageSendlog record);

    List<MessageSendlog> selectByExample(MessageSendlogExample example);

    MessageSendlog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageSendlog record, @Param("example") MessageSendlogExample example);

    int updateByExample(@Param("record") MessageSendlog record, @Param("example") MessageSendlogExample example);

    int updateByPrimaryKeySelective(MessageSendlog record);

    int updateByPrimaryKey(MessageSendlog record);
}