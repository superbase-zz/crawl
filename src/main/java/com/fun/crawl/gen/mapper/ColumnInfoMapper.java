package com.fun.crawl.gen.mapper;

import com.fun.crawl.gen.model.entity.ColumnInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ColumnInfoMapper {

    /**
     * 查询单个表的列详细信息
     * @param tableName
     * @return
     */
    List<ColumnInfo> listByTableName(@Param("tableName") String tableName);

}
