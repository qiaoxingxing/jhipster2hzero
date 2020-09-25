[TOC]

# 生成jhipster项目
注意: 服务类型选微服务、认证方式选择jwt;

![](index_files/20a3cfde-2964-4cf9-a665-479e6d27d507.jpg)


# 迁移说明
jhipster(v6.10.3)生成的项目迁移到hzero, 需要改动的内容: 
- 注册到nacos
	- 添加依赖包
	- 修改bootstrap.yml
- 注册到hzero-admin
	- 添加`hzero-boot-admin`依赖包
	- 添加路由配置: `RouteExtraDataManager.java`
	- 禁用jhipster swagger: 修改`application.yml`等文件
	- 修改actuator配置: `application.yml`的`management`节点
- 认证
	- 添加`@EnableChoerodonResourceServer`注解
	- 注释`SecurityConfiguration.java`文件, 把它的三个注解移动到其他文件;
- 验证迁移效果的测试controller: TestController

具体的改动内容可以用git对比代码; 
git里添加的tag: 
```
0.1 jhipster初始化项目;
0.2 初步完成迁移;
```
操作步骤可以参考后面的"idea对比代码示例"

# 验证迁移是否成功
打开hzero的swagger文档: `http://<gateway>/swagger/swagger-ui.html#/`, 显示测试系统的文档且能够调用成功;


# idea对比代码示例
可以按照以下步骤对比tag 0.1和0.2的代码: 
## 1. 找到tag是0.2的commit
![](index_files/b0f81b7c-a1aa-4712-89df-d1f3e472c8ab.png)
## 2. 切换到tag 0.2
![](index_files/47c1cb6c-2b5f-4842-a60b-ae0852ea606c.png)
## 3. 找到tag是0.1的commit
![](index_files/470a7266-f679-4762-8279-9a12a010ddec.png)
## 4. 对比
![](index_files/96db86d9-f22b-43d2-97ed-78458be74cef.png)


改动的文件列表:   
![](index_files/dfdd6e1a-148e-451a-a42f-bab8b78e1580.png)


双击对比某个文件:  
![](index_files/6ed893fb-0603-476c-a469-b261e6421d7f.png)


