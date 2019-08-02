# sql-tool
## MYSQL工具
一个可以动态调用的mysql小工具,方便常用的各种查询  
动态查询当前链接的任意一张表
### 用法
1. 将应用部署到服务器或机器  
2. 修改数据库链接  
3. 启动服务器  
4. 前端可直接通过调用接口,去操作当前链接下任意数据库 

### 动态查询
POST请求  
http://localhost:8888/sql
### 参数
**sql** 输入sql语句  
### 返回值
* **message** 提示消息
* **status** 状态(1成功,0失败)
* **data** 数据

### 示例
``` javascript
async querySql(sql) {
  
  let res = await this.axios.post(
    `${ctx}/localapi/sql`,
    qs.stringify({
      sql: sql,
      
    })
  );
  console.log(res.data);
  this.message = res.data.message;
  this.dataList = res.data.data;
}
```


### 查询  
### 接口地址
POST请求  
http://localhost:8888/sql/anyquery
### 参数
**dbName** 查询的数据库,不传为默认数据库  

**tableName** 表名  

**coditions** 传入一个或多个条件的数组  
* **column** 字段  
* **value** 值  
* **type** 类型  
  + **不传** 全等查询  
  + **like** 模糊查询  
  + **time** 时间查询 *(类型为time时必传 column:**startTime** 或 column:**startTime** 和 column:**endTime**)* 
  
**order** 传入排序条件  
* **column** 字段  
* **type** 升降序(asc/desc)
  
**limit** 传入limit限制条件  
* **from** 从第几行开始
* **length** 筛选几行

### 返回值
* **message** 提示消息
* **status** 状态(1成功,0失败)
* **data** 数据

### 示例
``` javascript
async query() {
  let conditions = [];
  conditions.push({ column: "name", value: "test", type: "like" },{ column: "score", value: "100"});
  let limit = {
    from: 0,
    length: 10
  };
  let order = {
    column: "score",
    type: "desc"
  };
  let res = await this.axios.post(
    `${ctx}/localapi/sql/anyquery`,
    qs.stringify({
      dbName: "test",
      tableName: "student",
      conditions: JSON.stringify(conditions),
      limit: JSON.stringify(limit),
      order: JSON.stringify(order)
    })
  );
  console.log(res.data);
  this.message = res.data.message;
  this.data = res.data.data;
}

```
**sql** select * from test.student where 1=1 and POSITION('test' in name) and score = '100' order by sign_time desc limit 0,10


### 新增  
### 接口地址
POST请求  
http://localhost:8888/sql/anyinsert
### 参数
**dbName** 查询的数据库,不传为默认数据库  

**tableName** 表名  

**datas** 传入一个或多个条件的数组  
* **column** 字段  
* **value** 值  
* **type** 字段类型  
  + **不传** 以字符串形式插入  
  + **int** 以数字形式插入  
  + **tinyint** 以数字形式插入 
  
### 返回值
* **message** 提示消息
* **status** 状态(1成功,0失败)
* **data** 成功的条数

### 示例
``` javascript
async insert() {
  let datas = [];
  datas.push({ column: "name", value: "test" },{ column: "score", value: "100" });

  let res = await this.axios.post(
    `${ctx}/localapi/sql/anyinsert`,
    qs.stringify({
      dbName: "test",
      tableName: "student",
      datas: JSON.stringify(datas),
    })
  );
  console.log(res.data);
  this.message = res.data.message;
  this.data = res.data.data;
}
```
**sql** insert into test.student ( name , score ) values ( 'test' , '100' ) 


### 修改  
### 接口地址
POST请求  
http://localhost:8888/sql/anyupdate
### 参数
**dbName** 查询的数据库,不传为默认数据库  

**tableName** 表名  

**datas** 传入一个或多个条件的数组  
* **column** 字段  
* **value** 值  
* **type** 字段类型  
  + **不传** 以字符串形式插入  
  + **int** 以数字形式插入  
  + **tinyint** 以数字形式插入 
  
**coditions** 传入一个或多个条件的数组  
* **column** 字段  
* **value** 值  
* **type** 类型  
  + **不传** 全等查询  
  + **like** 模糊查询  
  + **time** 时间查询 *(类型为time时必传 column:**startTime** 或 column:**startTime** 和 column:**endTime**)* 
  
### 返回值
* **message** 提示消息
* **status** 状态(1成功,0失败)
* **data** 成功的条数

### 示例
``` javascript
async update() {
  let datas = [];
  datas.push({ column: "name", value: "test2" },{ column: "score", value: "90" });
  let conditions = [];
  conditions.push({ column: "name", value: "test" },{ column: "score", value: "100" });

  let res = await this.axios.post(
    `${ctx}/localapi/sql/anyupdate`,
    qs.stringify({
      dbName: "test",
      tableName: "student",
      datas: JSON.stringify(datas),
      conditions: JSON.stringify(conditions),
    })
  );
  console.log(res.data);
  this.message = res.data.message;
  this.data = res.data.data;
}
```
**sql** update test.student SET name = 'test2' , score = '90' where 1=1 and name = 'test' and score = '100' 


### 删除  
### 接口地址
POST请求  
http://localhost:8888/sql/anydelete
### 参数
**dbName** 查询的数据库,不传为默认数据库  

**tableName** 表名  

**coditions** 传入一个或多个条件的数组  
* **column** 字段  
* **value** 值  
* **type** 类型  
  + **不传** 全等查询  
  + **like** 模糊查询  
  + **time** 时间查询 *(类型为time时必传 column:**startTime** 或 column:**startTime** 和 column:**endTime**)* 
  
### 返回值
* **message** 提示消息
* **status** 状态(1成功,0失败)
* **data** 成功的条数

### 示例
``` javascript
async delete() {
  let conditions = [];
  conditions.push({ column: "name", value: "test",type:'like' });

  let res = await this.axios.post(
    `${ctx}/localapi/sql/anydelete`,
    qs.stringify({
      dbName: "test",
      tableName: "student",
      conditions: JSON.stringify(conditions),
    })
  );
  console.log(res.data);
  this.message = res.data.message;
  this.data = res.data.data;
}
```
**sql** delete from test.student where 1=1 and POSITION('test' in name) 
