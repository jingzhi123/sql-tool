package com.jz.tools.sql.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jz.tools.sql.entity.DeleteEntity;
import com.jz.tools.sql.entity.InsertEntity;
import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.sql.entity.UpdateEntity;
import com.jz.tools.util.PageData;

@Repository
public interface SqlMapper{
	List<PageData> querySql(String sql);
	List<PageData> queryAny(QueryEntity qn);
	int deleteAny(DeleteEntity dn);
	int insertAny(InsertEntity in);
	int updateAny(UpdateEntity un);
}
