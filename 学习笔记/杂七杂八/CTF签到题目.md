

# 1.源码签到题目

### 1.1 右键查看源码，查找注释得到flag值

### 1.2 难度提升

#### 1.2.1通过js设置无法通过鼠标右键查看源码

 解决办法：使用view-source:url来查看源码

# 2.数据包签到题目

> flag值在http相应头中、cookie或自定义中

### 2.1 flag头暴露在HTTP协议中

右键-检查元素-查看相应头，flag在相应头中

### 2.2 请求修改，符合条件暴露flag

消息头-修改和重发-修改user-agent , 改为haha,点击重发

# 3.隐藏文件签到题目

> 在题目直接给的URL地址中，无法找到flag值，但是却存在另外的URL，其中包含flag

### 3.1 直接给出flag.php文件，查看源代码或数据包

也可以隐藏在外部引用的css或者js文件中，也可能隐藏在注释当中

### 3.2 没有直接给出提示或者没有提示

查看robots.txt,查看网页中对应的提示信息，再根据提示解答

# 4.html文件隐藏签到题目

> 在html文件中隐藏信息，此类题目比较隐蔽，不容易被发现

题目制作：

1.制作helloworld.html

2.利用snow.exe隐藏flag值到helloworld.html

​    html注释中添加密文，就是密码

​    打开SNOW.EXE -C -m "flag{ flag值}" -p"密码" helloworld.html helloworld_enc.html

题目解答：

1.去md5在线解密，得到密码

2.下载网页右键另存页面

3.使用snow对网页进行解密

SNOW.EXE  -C -P ”密码“ helloworld_enc.html 

# 5.html代码限制签到题目

在html中的输入标签中，可以设置长度，是否可用等限制，（maxlength,disabled）

右键-查看元素-修改maxlength

# 6.cookie验证签到题目

cookie是保存在浏览器用户端上的用于状态保存的变量

将cookie进行修改