package com.jz.tools.sql.service;

import java.util.List;

import com.jz.tools.util.PageData;

public interface SqlService {
	List<PageData> queryAny(String dbName, String tableName, String conditions, String order, String limit);
}
