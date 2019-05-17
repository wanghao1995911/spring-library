package com.wanghao.demo.springbootlibrary.mapper;

import com.wanghao.demo.springbootlibrary.domain.BookCategory;
import com.wanghao.demo.springbootlibrary.domain.BookCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookCategoryMapper {
    long countByExample(BookCategoryExample example);

    int deleteByExample(BookCategoryExample example);

    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    List<BookCategory> selectByExample(BookCategoryExample example);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByExampleSelective(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByExample(@Param("record") BookCategory record, @Param("example") BookCategoryExample example);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
    List<BookCategory> selectByPageNum(@Param("currIndex") int currIndex,@Param("pageSize")int pageSize);

    int selectAllCount();

}