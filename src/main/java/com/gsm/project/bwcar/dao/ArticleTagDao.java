package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ArticleTag;
import com.gsm.project.bwcar.pojo.ArticleTagExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ArticleTagDao {
    long countByExample(ArticleTagExample example);

    int deleteByExample(ArticleTagExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);

    List<ArticleTag> selectByExample(ArticleTagExample example);

    ArticleTag selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int updateByExample(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

    int updateByPrimaryKeySelective(ArticleTag record);

    int updateByPrimaryKey(ArticleTag record);
}