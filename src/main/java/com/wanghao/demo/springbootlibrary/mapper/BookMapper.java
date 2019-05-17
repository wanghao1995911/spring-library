package com.wanghao.demo.springbootlibrary.mapper;

import com.wanghao.demo.springbootlibrary.domain.Book;
import com.wanghao.demo.springbootlibrary.domain.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookId);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    List<Book> selectByCategoryId(@Param("categoryId")int categoryId,@Param("currIndex") int currIndex,@Param("pageSize") int PageSize);

    //查找某一类别书籍的总数
    int selectBookCountByCategoryId(@Param("categoryId")int categoryId);
}