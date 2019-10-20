# 个人博客后台

#### 接口
###### 查询单个文章
url: localhost:8080/articles/1

method: GET

response: 

* 文章存在时:

httpCode=200
```
{
    "createDate": "2019-09-11T04:53:51.000+0000",
    "title": "测试",
    "originalContent": "c屙屎"
}
```
* 文章不存在时:
httpCode=404

响应体为空

###### 查询文章列表

url: localhost:8080/articles/list_title

method: GET

response: 

* 有文章列表存在时:

httpCode=200
```
[
    {
        "createDate": "2019-09-11T04:53:51.000+0000",
        "title": "测试"
    }
]
```
* 文章列表不存在时:
httpCode=404

响应体为空

###### 其他联系方式链接

url: localhost:8080/contacts

method: GET

response: 

* 有信息存在时:

httpCode=200
```
[
    {
        "iconUrl": "http://localhost1.com",
        "url": "http://localhost1.com"
    },
    {
        "iconUrl": "http://localhost2.com",
        "url": "http://localhost2.com"
    }
]
```
* 信息不存在时:
httpCode=404

响应体为空

#### 部署
需要有docker环境，直接执行主目录下的./start.sh,然后访问8080端口。如果要修改访问的端口，在下面的env.sh中进行修改
```
|────build.sh                   -------------------- 构建脚本
|────env.sh                     -------------------- 变量设置脚本         
|────start.sh                   -------------------- 服务启动脚本
```
* build.sh:编译jar包，拷贝到./docker/java目录中
* env.sh:设置变量，系统运行需要的变量都在这里进行设置
* start.sh: 启动脚本，变量设置好后，运行此脚本一键启动
