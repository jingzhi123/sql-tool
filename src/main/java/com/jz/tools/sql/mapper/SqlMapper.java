package com.jz.tools.sql.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.util.PageData;

@Repository
public interface SqlMapper{
	List<PageData> queryAny(QueryEntity qn);
}
