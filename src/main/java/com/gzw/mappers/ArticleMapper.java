package com.gzw.mappers;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.gzw.domain.Article;
import com.gzw.domain.ArticleClass;
import com.gzw.domain.ArticlePigeonhole;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gujian on 2017/6/25.
 */
public interface ArticleMapper extends BaseMapper<Article>{

    List<Article> findByAuthor(String author);

    List<Article> findByTitle(String title);

    List<Article> findByTag(String tag);

    int getArticleCount(String username);

    int getTagCount(String username);

    List<ArticleClass> getArticleClassList(String username);

    List<ArticlePigeonhole> getArticlePigeonhle(String username);

}
