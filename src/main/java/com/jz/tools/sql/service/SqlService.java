package com.jz.tools.sql.service;

import java.util.List;

import com.jz.tools.sql.entity.DeleteEntity;
import com.jz.tools.sql.entity.InsertEntity;
import com.jz.tools.sql.entity.QueryEntity;
import com.jz.tools.sql.entity.UpdateEntity;
import com.jz.tools.util.PageData;

public interface SqlService {
	List<PageData> querySql(String sql);
	List<PageData> queryAny(QueryEntity qn);
	int deleteAny(DeleteEntity dn);
	int insertAny(InsertEntity in);
	int updateAny(UpdateEntity un);
}
