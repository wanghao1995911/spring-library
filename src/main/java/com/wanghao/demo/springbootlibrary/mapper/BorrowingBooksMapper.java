package com.wanghao.demo.springbootlibrary.mapper;

import com.wanghao.demo.springbootlibrary.domain.BorrowingBooks;
import com.wanghao.demo.springbootlibrary.domain.BorrowingBooksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowingBooksMapper {
    long countByExample(BorrowingBooksExample example);

    int deleteByExample(BorrowingBooksExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BorrowingBooks record);

    int insertSelective(BorrowingBooks record);

    List<BorrowingBooks> selectByExample(BorrowingBooksExample example);

    BorrowingBooks selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByExample(@Param("record") BorrowingBooks record, @Param("example") BorrowingBooksExample example);

    int updateByPrimaryKeySelective(BorrowingBooks record);

    int updateByPrimaryKey(BorrowingBooks record); List<BorrowingBooks> selectByPageNumAndPageSize(@Param("currIndex")int currIndex,@Param("pageSize")int pageSize,@Param("userId")int userId);


    int selectAllRecordCount(@Param("userId") int userId);


    List<BorrowingBooks> selectAllByPage(@Param("currIndex")int currIndex,@Param("pageSize")int pageSize);

    int selectAll();
}