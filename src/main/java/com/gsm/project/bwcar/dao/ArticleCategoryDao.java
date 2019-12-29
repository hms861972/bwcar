package com.gsm.project.bwcar.dao;

import com.gsm.project.bwcar.pojo.ArticleCategory;
import com.gsm.project.bwcar.pojo.ArticleCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleCategoryDao {
    long countByExample(ArticleCategoryExample example);

    int deleteByExample(ArticleCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    List<ArticleCategory> selectByExample(ArticleCategoryExample example);

    ArticleCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByExample(@Param("record") ArticleCategory record, @Param("example") ArticleCategoryExample example);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);
}