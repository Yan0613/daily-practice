# 1.ROS是什么

![image-20220206231108493](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220206231108493.png)

> ROS（Robot Operating System，下文简称“ROS”）是一个适用于机器人的开源的元操作系统。它提供了操作系统应有的服务，包括硬件抽象，底层设备控制，常用函数的实现，进程间消息传递，以及包管理。它也提供用于获取、编译、编写、和跨计算机运行代码所需的工具和库函数。
>
> ROS 的主要目标是为机器人研究和开发提供代码复用的支持。ROS是一个分布式的进程（也就是“节点”）框架，这些进程被封装在易于被分享和发布的程序包和功能包中。ROS也支持一种类似于代码储存库的联合系统，这个系统也可以实现工程的协作及发布。这个设计可以使一个工程的开发和实现从文件系统到用户接口完全独立决策（不受ROS限制）。同时，所有的工程都可以被ROS的基础工具整合在一起。
>
> ​                                                                                                            -------------------------ROS wiki

# 2.ROS核心概念

### 2.1 节点与节点管理器

![image-20220207143204351](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207143204351.png)

#### 节点

1.节点：具体的执行单元

2.小组中的不同人可以负责不同的部分的编程

3.避免重名，造成混乱

#### 节点管理器

节点之间不知道彼此的存在，都是ROS master帮助它们在彼此之间建立链接

### 2.2 话题通信

![image-20220207144753300](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207144753300.png)

#### 话题

单向数据传播，发布者---->订阅者，传输的数据通道叫做话题。 

#### 消息

数据通道中传输的数据内容教消息

### 2.3服务通信

![image-20220207145815154](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207145815154.png)

服务是双向的

### 2.4 话题与服务对比

![image-20220207145924238](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207145924238.png)

适用场景：

话题：摄像头驱动之后发给摄像头处理节点

服务：用在逻辑处理

### 2.5 全局共享字典

![image-20220207150355637](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207150355637.png)

### 2.6 文件系统

![image-20220207161041088](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207161041088.png)

# 3.ROS命令行工具的使用

![image-20220207163550677](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207163550677.png)

### 3.1 打开小海龟

1.打开ROS master

```bash
roscore
```

2.运行turtlesim功能包

```bash
rosrun turtlesim turtlesim_node
```

3.运行键盘控制

```bash
rosrun turtlesim turtle_teleop_key
```

**注意：分别在三个命令行窗口中打开**

### 3.2 rqt_graph

一系列基于rqt的可视化工具

可以看见系统的全貌

![image-20220207172159609](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207172159609.png)

> 打开后看见的窗口

### 3.3 rosnode

> rosnode用于显示系统当中所有节点相关信息的指令

rosnode list 列出系统中所有节点

rosnode info 查看某一节点具体的信息

### 3.4 rostopic

rostopic list打印当前系统所有话题列表

```bash
rostopic pub  /turtle1/cmd_vel 
//按tab自动补全
```

![image-20220207173358011](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207173358011.png)

> /turtlr/cmd_vel ..为话题名
>
> 后面的Twist为发布指令的一个数据的内内容，双引号为消息数据结构里面具体的数据
>
> linear:线速度，angular角速度

pub后面加 -r 多少频率去发布消息数据的内容，实现循环

消息相关：

```
rosmsg show  
```

服务相关：

```
rosservice
rosservice call /spawn tab tab 生成第二个海龟
```

**summary:**

![image-20220207175737996](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220207175737996.png)

### 3.5话题记录和话题复现

```bash
记录和复现话题

　　话题记录：rosbag reccord-a-O cmd_record

　　话题复现：rosbag play cmd_record.bag    -a:all -O 后面是压缩的名字
```

ctrl+c话题保存在ubuntu主目录下

# 4.创建工作空间与功能包

### 4.1工作空间

工作空间是一个存放工程开发相关文件的文件夹。

![image-20220209145440949](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220209145440949.png)

编译文件:编译过程中产生的文件

开发空间:编译生成的可执行文件，脚本、库等等

**创作工作空间：**

```
mkdir -p ~/catkin_ws/src
cd ~/catkin_ws/src
catkin_init_workspace
```

**编译工作空间：**

```
cd ~/catkin_ws/
catkin_make
```

**设置环境变量：**

```
source devel/setup.bash
```

**检查环境变量：**

```
echo $ROS_PACKAGE_PATRH
```

### 4.2 功能包

在src中创建：

```
 cd ~/catkin_ws/src/
```

功能包格式：

```
catkin_create_pkg   package_name   depend1 depend2 depend2
package_name：功能表名称
```

depend1、2、3：依赖项

创建功能包：

```
catkin_create_pkg learning_communication std_msgs rospy roscpp
```

std_msgs：包含常见消息类型

roscpp：使用C++实现ROS各种功能

rospy：使用python实现ROS各种功能

5.编译功能包

```
cd ~/catkin_ws
catkin_make
source ~/catkin_ws/devel/setup.bash
```

显示如下说明编译成功：

![image-20220209151016942](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220209151016942.png)

# 5. 创建publisher

**1.在src目录下创建一个learning_topic功能包：**

```
catkin_create_pkg learning_topic roscpp rospy std_msgs turtlesim
```

**2.在learning_topic–>src 中新建velocity_publisher.cpp**
在velocity_publisher.cpp中添加如下代码

```C++
/**
*该例程将发布turtle1/cmd_vel话题,消息类型geometry_msgs::Twist
*/ 

#include <ros/ros.h>
#include <geometry_msgs/Twist.h>

int main(int argc, char **argv)
{
	// ROS节点初始化  
    //告诉ROS master我来了
	ros::init(argc, argv, "velocity_publisher");

	// 创建节点句柄
    //节点句柄用来管理ROS相关的API的一些资源
	ros::NodeHandle n;

	// 创建一个Publisher，发布名为/turtle1/cmd_vel的topic，消息类型为geometry_msgs::Twist，队列长度10
	ros::Publisher turtle_vel_pub = n.advertise<geometry_msgs::Twist>("/turtle1/cmd_vel", 10);

	// 设置循环的频率
	ros::Rate loop_rate(10);

	int count = 0;
	while (ros::ok())
	{
	    // 初始化geometry_msgs::Twist类型的消息
		geometry_msgs::Twist vel_msg;
		vel_msg.linear.x = 0.5;
		vel_msg.angular.z = 0.2;

	    // 发布消息
		turtle_vel_pub.publish(vel_msg);
		ROS_INFO("Publsh turtle velocity command[%0.2f m/s, %0.2f rad/s]", 
				vel_msg.linear.x, vel_msg.angular.z);

	    // 按照循环频率延时
	    loop_rate.sleep();
	}

	return 0;
}

```

**3.配置CMakeLists,txt中的编译规则**
（需要配置的文件位置catkin_ws/src/learning_topic）

- 设置需要编译的代码和生成的可执行文件
- 设置链接库
  在

```
###########
## Build ##
###########
```

目录下添加如下代码：

```
add_executable(velocity_publisher src/velocity_publisher.cpp)  描述把哪一个可执行文件编译成可执行文件
target_link_libraries(velocity_publisher ${catkin_LIBRARIES})帮助把可执行文件跟ROS相关的库做链接
```

**4.编译工程**:

```
catkin_make
source devel/setup.bash
```

**5.运行如下指令：**

```
reocore
rosrun turtlesim turtlesim_node 
rosrun learning_topic velocity_publisher 
```

> 如何实现一个发布者：
>
> 1.初始化ROS节点
>
> 2.向ROS Master注册节点信息，包括发布的话题名和话题中的消息类型
>
> 3.创造消息数据
>
> 4.按照一定的频率循环发布消息

# 6.创建subscriber

### 6.1 话题模型

![image-20220209162258920](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220209162258920.png)

### 6.2 实现

1、

在创建的learning_topic文件下的src文件下创建一个pose_subscriber.cpp文件

![img](https://img-blog.csdnimg.cn/20200427201515511.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjI2OTgxNw==,size_16,color_FFFFFF,t_70)

```cpp
/**
 * 该历程将订阅/turtle1/pose话题,消息类型turtlesim::Pose
 */
 
#include <ros/ros.h>
#include <turtlesim/Pose.h>
 
// 接收到订阅消息后，会进入消息回调函数
void poseCallback(const turtlesim::Pose::ConstPtr& msg)
{
	// 将接收到的消息打印出来
	ROS_INFO("Turtle pose: x:%0.6f,y:%0.6f",msg->x,msg->y);
}
 
int main(int argc,char **argv)
{
	//初始化ROS节点
	ros::init(argc,argv,"pose_subscriber");
 
	//创建节点语柄
	ros::NodeHandle n;
	
	// 创建一个Subscriber，订阅名为/turtle/pose的topic,注册回调函数poseCallback
	ros::Subscriber pose_sub=n.subscribe("/turtle1/pose",10,poseCallback);
 
	// 循环等待回调函数
	ros::spin();
 
	return 0;
}
```

**综上，如何创建一个订阅者**

- 初始化ROS节点；
- 订阅需要的话题；
- 循环等待话题消息，接收到消息后进入回调函数；
- 在回调函数中完成消息处理。

2、编辑CMakeLists.txt

加上

```
add_executable(pose_subscriber src/pose_subscriber.cpp)
target_link_libraries(pose_subscriber ${catkin_LIBRARIES})
```

![img](https://img-blog.csdnimg.cn/20200427201700388.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjI2OTgxNw==,size_16,color_FFFFFF,t_70)

3.编译并运行发布者

```
cd /catkin_ws
catkin_make 
```

4.验证

```
roscore
rosrun turtlesim turtlesim_node
rosrun be+tab po+tab
回车
```

**python写的可以不用编译！！python写的可以不用编译！！python写的可以不用编译！！**

# 7.话题消息的订阅与使用

### 7.1话题消息模型

publisher:发布这个人的信息

subscriber:接收这个人的信息

![image-20220209183401432](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220209183401432.png)

### 7.2自定义话题消息

话题消息person.msg的内容

```
string name
uint8 sex
uint8 age

uint8 unknow = 0
uint8 male = 1
uint8 female = 2

```

- 将上面内容放在Person.msg中。

- 在package.xml中添加功能包依赖

  动态生成程序的功能包的依赖

```
<build_depend>message_generation</build_depend>  编译依赖
<exec_depend>message_runtime</exec_depend>  运行依赖  
```

- 在CMakeLists.txt添加编译选型

```
find_package( …… message_generation)  添加功能包
add_message_files(FILES Person.msg)  把person.msg作为定义的接口
generate_messages(DEPENDENCIES std_msgs) 编译.msg文件中要依赖哪些ROS已有的库或者包
catkin_package(…… message_runtime)

```

- 编译生成语言相关文件

### 7.3 话题消息具体步骤

1.打开功能包下面并创建文件夹

```
ubuntu@ubuntu:~/catkin_ws$ cd ~/catkin_ws/src/learning_topic/
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ mkdir msg
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ ls
CMakeLists.txt  include  msg  package.xml  scripts  src
```



2.创建文件并输入内容

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ cd msg/
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/msg$ touch Person.msg
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/msg$ gedit Person.msg 

```

- 打开后输入下面内容：

```
string name
uint8 sex
uint8 age

uint8 unknow = 0
uint8 male = 1
uint8 female = 2

```

- 保存之后退出

3.修改配置文件package.xml

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/msg$ cd ../
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ ls
CMakeLists.txt  include  msg  package.xml  scripts  src
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ gedit package.xml 
```

- 打开文件后进行编辑增加下面两句

```
<build_depend>message_generation</build_depend>
<exec_depend>message_runtime</exec_depend>

```

- <build_depend>xxx</build_depend>是编译依赖，依赖于xxx包
- <exec_depend>xxx</exec_depend>是执行依赖，依赖于运行的xxx包
- 上面两个依赖是进行创建话题消息的固定的依赖包。
- 添加之后保存退出

4.修改配置文件CMakeLists.txt

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ ls
CMakeLists.txt  include  msg  package.xml  scripts  src
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ gedit CMakeLists.txt 

```

- 打开后再合适的地方添加，根据关键词查位置：find_package、add_message_files、generate_messages、catkin_package

```
# 一般在开头
find_package(
xxx #之前的依赖包
message_generation
)


## Declare ROS messages, services and actions ##
add_message_files(
   FILES 
   Person.msg
)
generate_messages(
   DEPENDENCIES 
   std_msgs
)


## catkin specific configuration ##

catkin_package(
  xxx #之前的依赖包
  CATKIN_DEPENDS geometry_msgs roscpp rospy std_msgs turtlesim
  message_runtime
)

```

- 添加完成后保存退出

5.回到根目录下做编译

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ cd ~/catkin_ws/
ubuntu@ubuntu:~/catkin_ws$ catkin_make

```

- ROS会根据编写的固定格式转换成C++的数据类型定义，进行使用，转换完成的内容在/catkin_ws/devel/include/learning_topic中

### 7.4发布者和订阅者的编写

1、打开功能包及SRC路径新建文件。

```
ubuntu@ubuntu:~/catkin_ws/devel/include/learning_topic$ roscd learning_topic/
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ ls
CMakeLists.txt  include  msg  package.xml  scripts  src
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ cd src/
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/src$ touch person_publisher.cpp

ubuntu@ubuntu:~/catkin_ws/src/learning_topic/src$ touch person_subscriber.cpp
```

2、编写发布者。

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/src$ gedit person_publisher.cpp 
```


打开输入一下内容：

    #include <ros/ros.h>
    #include "learning_topic/Person.h"
    
    int main(int argc, char **argv)
    {
        // ROS节点初始化
        ros::init(argc, argv, "person_publisher");
    // 创建节点句柄
    ros::NodeHandle n;
    
    // 创建一个Publisher，发布名为/person_info的topic，消息类型为learning_topic::Person，队列长度10
    ros::Publisher person_info_pub = n.advertise<learning_topic::Person>("/person_info", 10);
    
    // 设置循环的频率
    ros::Rate loop_rate(1);
    
    int count = 0;
    while (ros::ok())
    {
        // 初始化learning_topic::Person类型的消息
    	learning_topic::Person person_msg;
    	person_msg.name = "Tom";
    	person_msg.age  = 18;
    	person_msg.sex  = learning_topic::Person::male;
    
        // 发布消息
    	person_info_pub.publish(person_msg);
    
       	ROS_INFO("Publish Person Info: name:%s  age:%d  sex:%d", 
    			  person_msg.name.c_str(), person_msg.age, person_msg.sex);
    
        // 按照循环频率延时
        loop_rate.sleep();
    }
    
    return 0;
    }
3.编写订阅者

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic/src$ gedit person_subscriber.cp
```

打开输入以下内容：

```
#include <ros/ros.h>
#include "learning_topic/Person.h"

// 接收到订阅的消息后，会进入消息回调函数
void personInfoCallback(const learning_topic::Person::ConstPtr& msg)
{
    // 将接收到的消息打印出来
    ROS_INFO("Subcribe Person Info: name:%s  age:%d  sex:%d", 
			 msg->name.c_str(), msg->age, msg->sex);
}

int main(int argc, char **argv)
{
    // 初始化ROS节点
    ros::init(argc, argv, "person_subscriber");

    // 创建节点句柄
    ros::NodeHandle n;

    // 创建一个Subscriber，订阅名为/person_info的topic，注册回调函数personInfoCallback
    ros::Subscriber person_info_sub = n.subscribe("/person_info", 10, personInfoCallback);

    // 循环等待回调函数
    ros::spin();

    return 0;
}


```

4、回到工作空间进行编译

```
ubuntu@ubuntu:~/catkin_ws/src/learning_topic$ cd ~/catkin_ws/
ubuntu@ubuntu:~/catkin_ws$ catkin_make
```

- 将以下代码加入到learning_topic下的CMakeLists文件下
  最后一句使与头文件Person.h产生连接

```
add_executable(person_publisher src/person_publisher.cpp) 
target_link_libraries(person_publisher ${catkin_LIBRARIES})
add_dependencies(person_publisher ${PROJECT_NAME}_generate_messages_cpp)

add_executable(person_subscriber src/person_subscriber.cpp)
target_link_libraries(person_subscriber ${catkin_LIBRARIES})
add_dependencies(person_subscriber ${PROJECT_NAME}_generate_messages_cpp)

```



### 7.5编写运行的程序

1.运行roscore

```
ubuntu@ubuntu:~/catkin_ws$ roscore

```

2.运行发布者

```
ubuntu@ubuntu:~/catkin_ws$ rosrun learning_topic person_publisher 

```

3.运行订阅者

```
ubuntu@ubuntu:~/catkin_ws$ rosrun learning_topic person_subscriber 

```

4.结果说明：

- 发布者根据发布者程序中的代码发送固定的信息

```
ubuntu@ubuntu:~/catkin_ws$ rosrun learning_topic person_publisher 
[ INFO] [1636890566.998334986]: Publish Person Info: name:Tom  age:18  sex:1
[ INFO] [1636890567.999594084]: Publish Person Info: name:Tom  age:18  sex:1
```

- 订阅者通过订阅话题进行接收话题中消息进行打印

```
ubuntu@ubuntu:~/catkin_ws$ rosrun learning_topic person_subscriber 
[ INFO] [1636890591.999855074]: Subcribe Person Info: name:Tom  age:18  sex:1
[ INFO] [1636890592.999571488]: Subcribe Person Info: name:Tom  age:18  sex:1
```

**ROS Master 用来建立链接，建立了之后就不需要了**

# 8.客户端Client的编程实现

![image-20220212162338265](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220212162338265.png)



### 8.1创建功能包

 

```
cd /catkin_ws/src
catkin_create_pkg learning_service roscpp rospy std_msgs geometry_msgs turtlesim
```

 然后在你创建的learning_service文件下的src文件下创建一个turtle_spawn.cpp文件  

```
touch turtle_spawn.cpp
```

 

### 8.2创建C++文件

 在.cpp文件下输入  

```
/**
 * 该例程将请求/spawn服务，服务数据类型turtlesim::Spawn
 */

#include <ros/ros.h>
#include <turtlesim/Spawn.h>

int main(int argc, char** argv)
{
    // 初始化ROS节点
	ros::init(argc, argv, "turtle_spawn");节点名

    // 创建节点句柄
	ros::NodeHandle node;

    // 发现/spawn服务后，创建一个服务客户端，连接名为/spawn的service
	ros::service::waitForService("/spawn");查询系统种是不是有spawn服务，阻塞型的程序
	ros::ServiceClient add_turtle = node.serviceClient<turtlesim::Spawn>("/spawn");

    // 初始化turtlesim::Spawn的请求数据
	turtlesim::Spawn srv;
	srv.request.x = 2.0;
	srv.request.y = 2.0;
	srv.request.name = "turtle2";

    // 请求服务调用
	ROS_INFO("Call service to spwan turtle[x:%0.6f, y:%0.6f, name:%s]", 
			 srv.request.x, srv.request.y, srv.request.name.c_str());

	add_turtle.call(srv); call:把request发出去，然后等待服务器给我一个反馈

	// 显示服务调用结果
	ROS_INFO("Spwan turtle successfully [name:%s]", srv.response.name.c_str());

	return 0;
};
```

python： 

```
#!/usr/bin/env python3
# -*- coding: utf-8 -*-

########################################################################
####          Copyright 2020 GuYueHome (www.guyuehome.com).          ###
########################################################################

# 该例程将请求/spawn服务，服务数据类型turtlesim::Spawn

import sys
import rospy
from turtlesim.srv import Spawn

def turtle_spawn():
	# ROS节点初始化
    rospy.init_node('turtle_spawn')

	# 发现/spawn服务后，创建一个服务客户端，连接名为/spawn的service
    rospy.wait_for_service('/spawn')
    try:
        add_turtle = rospy.ServiceProxy('/spawn', Spawn)

		# 请求服务调用，输入请求数据
        response = add_turtle(2.0, 2.0, 0.0, "turtle2")
        return response.name
    except rospy.ServiceException as e:
        print("Service call failed: %s" %e)

if __name__ == "__main__":
	#服务调用并显示调用结果
    print("Spwan turtle successfully [name:%s]" %(turtle_spawn()))
```

如何实现一个客户端

- 初始化ROS结点
- 创建一个Client实例；
- 发布服务请求数据；
- 等待Server处理之后的应答结果

 

### 8.3 编辑CMakeLists.txt

 加上这两句  

```
add_executable(turtle_spawn src/turtle_spawn.cpp) 编译成turtle_spawn的规则
target_link_libraries(turtle_spawn ${catkin_LIBRARIES}) 链接库
```

 [![微信图片_20210107163759](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210107163759.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210107163759.png) 



### 8.4 编译并运行

 

```
cd /catkin_ws
catkin_make
```

 

### 8.5 验证

 

```
roscore
rosrun turtlesim turtlesim_node
rosrun learning_service turtle_spawn
```

 当然，以上三个命令都是在不同终端下输入  

### 8.6 结果

 创建出一个新的小乌龟  [![微信图片_20210107163829](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210107163829.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210107163829.png)

### 

# 9.服务端server的编程实现

在海龟仿真器下输入按键，通过服务端接收数据，并把数据发送给海龟仿真器

### 9.1创建功能包

  然后在你创建的turtle_command_server文件下的src文件下创建一个pose_subscriber.cpp文件

### 9.2在.cpp文件中输入以下内容

 

```c
/**
 * 该例程将执行/turtle_command服务，服务数据类型std_srvs/Trigger
 */
 
#include <ros/ros.h>
#include <geometry_msgs/Twist.h>
#include <std_srvs/Trigger.h>n 服务数据类型头文件

ros::Publisher turtle_vel_pub;
bool pubCommand = false;

// service回调函数，输入参数req，输出参数res
bool commandCallback(std_srvs::Trigger::Request  &req,
         			std_srvs::Trigger::Response &res)
{
	pubCommand = !pubCommand;

    // 显示请求数据
    ROS_INFO("Publish turtle velocity command [%s]", pubCommand==true?"Yes":"No");

	// 设置反馈数据
	res.success = true;
	res.message = "Change turtle command state!";

    return true;
}

int main(int argc, char **argv)
{
    // ROS节点初始化
    ros::init(argc, argv, "turtle_command_server");

    // 创建节点句柄
    ros::NodeHandle n;

    // 创建一个名为/turtle_command的server，注册回调函数commandCallback
    ros::ServiceServer command_service = n.advertiseService("/turtle_command", commandCallback);

	// 创建一个Publisher，发布名为/turtle1/cmd_vel的topic，消息类型为geometry_msgs::Twist，队列长度10
	turtle_vel_pub = n.advertise<geometry_msgs::Twist>("/turtle1/cmd_vel", 10);

    // 循环等待回调函数
    ROS_INFO("Ready to receive turtle command.");

	// 设置循环的频率
	ros::Rate loop_rate(10);

	while(ros::ok())
	{
		// 查看一次回调函数队列。是不是有数据进来了
    	ros::spinOnce();
		
		// 如果标志为true，则发布速度指令
		if(pubCommand)
		{
			geometry_msgs::Twist vel_msg;
			vel_msg.linear.x = 0.5;
			vel_msg.angular.z = 0.2;
			turtle_vel_pub.publish(vel_msg);
		}

		//按照循环频率延时
	    loop_rate.sleep();
	}

    return 0;
}
```

 

综上，如何实现一个服务器

 

- 初始化ROS节点；
- 创建Server实例
- 循环等待服务请求，进入回调函数；
- 在回调函数中完成服务功能的处理，并反馈应答数据。

### 9.3编辑CMakeLists.txt

 加上这两句  

```c
add_executable(turtle_command_server src/turtle_command_server.cpp)
target_link_libraries(turtle_command_server ${catkin_LIBRARIES})
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200204225558210.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200204225558210.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)



### 9.4编译并运行发布者

```c
cd /catkin_ws
catkin_make
```

 

### 9.5验证

 

```c
roscore
rosrun turtlesim turtlesim_node
rosrun learning_service turtle_command_server 
rosservice call /turtle_command 双击tab补全"{}"  
    再发送停止运动，Client相当于海龟运动的一个开关
```

 当然，以上四个命令都是在不同终端下输入 第四个命令是Trigger的参数，输入为空



### 9.6结果

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200204230203422.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200204230203422.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)



# 10.服务数据的定义与使用

**创建一个request，里面包含学生的年龄性别姓名，发送给服务端，服务端再反馈response**

 ![image-20220212171643540](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220212171643540.png)



如何自定义服务数据 

- 定义srv文件
- 在package.xml中添加功能包依赖
- 在CMakeLists.txt添加编译选项
- 编译生成语言相关文件

 

### 10.1定义srv文件

 在learning_service下创建srv文件夹  [![微信图片_20210108150238](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150238.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150238.png) 在srv文件夹下创建Person.srv文件  

```
string name
uint8 age
uint8 sex

uint8 unknown=0
uint8 male=1
uint8 female=2
---
string result //server是不是已经显示成功了
```

 

### 10.2 在package.xml中添加功能包依赖

 

```
  <build_depend>message_generation</build_depend>
  <exec_depend>message_runtime</exec_depend>
```

 [![微信图片_20210108150313](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150313.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150313.png) 

### 10.3 在CMakeList.txt添加编译选项

```
add_executable(person_server src/person_server.cpp)
target_link_libraries(person_server ${catkin_LIBRARIES})
add_dependencies(person_server ${PROJECT_NAME}_gencpp)

add_executable(person_client src/person_client.cpp)
target_link_libraries(person_client ${catkin_LIBRARIES})
add_dependencies(person_client ${PROJECT_NAME}_gencpp)
```

 [![微信图片_20210108150337](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150337.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150337.png) [![微信图片_20210108150340](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150340.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150340.png) [![微信图片_20210108150342](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150342.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150342.png) [![微信图片_20210108150348](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150348.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150348.png) 

### 10.4 在learing_service创建person_client.cpp和person_server.cpp文件

 

```
touch person_client.cpp
```

 

```
/**
 * 该例程将请求/show_person服务，服务数据类型learning_service::Person
 */

#include <ros/ros.h>
#include "learning_service/Person.h"

int main(int argc, char** argv)
{
    // 初始化ROS节点
	ros::init(argc, argv, "person_client");

    // 创建节点句柄
	ros::NodeHandle node;

    // 发现/spawn服务后，创建一个服务客户端，连接名为/spawn的service
	ros::service::waitForService("/show_person");
	ros::ServiceClient person_client = node.serviceClient<learning_service::Person>("/show_person");

    // 初始化learning_service::Person的请求数据
	learning_service::Person srv;
	srv.request.name = "Tom";
	srv.request.age  = 20;
	srv.request.sex  = learning_service::Person::Request::male;

    // 请求服务调用
	ROS_INFO("Call service to show person[name:%s, age:%d, sex:%d]", 
			 srv.request.name.c_str(), srv.request.age, srv.request.sex);

	person_client.call(srv);

	// 显示服务调用结果
	ROS_INFO("Show person result : %s", srv.response.result.c_str());

	return 0;
};
```

 

```
touch person_server.cpp
```

 

```
/**
 * 该例程将执行/show_person服务，服务数据类型learning_service::Person
 */
 
#include <ros/ros.h>
#include "learning_service/Person.h"

// service回调函数，输入参数req，输出参数res
bool personCallback(learning_service::Person::Request  &req,
         			learning_service::Person::Response &res)
{
    // 显示请求数据
    ROS_INFO("Person: name:%s  age:%d  sex:%d", req.name.c_str(), req.age, req.sex);

	// 设置反馈数据
	res.result = "OK";

    return true;
}

int main(int argc, char **argv)
{
    // ROS节点初始化
    ros::init(argc, argv, "person_server");

    // 创建节点句柄
    ros::NodeHandle n;

    // 创建一个名为/show_person的server，注册回调函数personCallback
    ros::ServiceServer person_service = n.advertiseService("/show_person", personCallback);

    // 循环等待回调函数
    ROS_INFO("Ready to show person informtion.");
    ros::spin();

    return 0;
}
```

 

### 10.5编译

 在catkin_ws文件下打开终端 输入  

```
catkin_make
```

 编译  

### 10.6验证

 输入  

```
roscore
rosrun learning_service person_client
rosrun learning_service person_server
```

 当然，三个命令都是在不同终端下执行的。 每次发一次请求，客户端都会返回response，打印数据  

### 10.7结果

 [![微信图片_20210108150534](https://www.guyuehome.com/Uploads/wp/2021/01/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20210108150534.png)](https://www.guyuehome.com/Uploads/wp/2021/01/微信图片_20210108150534.png)

# 11.参数的使用与编程方法

### 11.1参数模型

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205113235451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205113235451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 

- Parameter Server下放的是全局参数，节点A，B,C,D均可访问

 

### 11.2创建参数

 

1.创建功能包

 

```
cd /catkin_ws/src
catkin_create_pkg learning_parameter roscpp rospy std_srvs
```

 后面三个是依赖选项

### 11.3参数命令行使用

 ![image-20220212175616066](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220212175616066.png)

**rosparam**

 

- 列出当前多有参数：rosparam list
- 显示某个参数值：rosparam get *param_key*
- 设置某个参数值：rosparam set *param_key* *param_value*
- 保存参数到文件：rosparam dump *file_name*
- 从文件读取参数：rosparam load *file_name*
- 删除参数：rosparam delete *param_key*

 **实例** 打开海龟仿真器  

```
roscore
```

 

```
rosrun turtlesim turtlesim_node
```

 

```
rosparam
```

 显示  [![在这里插入图片描述](https://img-blog.csdnimg.cn/202002051158451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/202002051158451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 列出了rosparam参数命令行的使用，和上面说的基本相同  接下来输入  

```
rosparam list
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205120033871.png)](https://img-blog.csdnimg.cn/20200205120033871.png) 列出了海龟仿真器下的参数 /background_b,/background_g,/background_r就是颜色rgb的三个参数，具体调节海龟仿真器下的背景颜色。/rosdistro为ros的版本，/rosversion为ros版本号， /roslaunch/uris/host_nidie__38157为主机的地址，/run_id为进程的id号 **rosparam get 使用** 

```
rosparam get /background_b
```

 获取 /background的参数值255  

```
rosparam get /rosdistro
```

 查看你安装的ros版本  

```
rosparam get /rosversion
```

 查看你安装的ros版本号 **rosparam set使用** 

```
rosparam set /background_b 100
```

 

```
rosservice call /clear "{}"
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205121113901.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205121113901.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 修改了rgb中b的值，背景颜色发生改变  **rosparam dump使用** 

```
rosparam dump param.yaml
```

 将参数以文件的形式保存  [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205122221783.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205122221783.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) **rosparam load使用** 

```
rosparam load param.yaml
```

 加载文件，替换参数  **rosparam delete使用**  删除某一个参数  

------

### 11.4命令行的程序如何用C++实现

 同样在learning_parameter文件下src文件中创建parameter_config.cpp文件  

```
touch parameter_config.cpp
```

 输入  

```
/**
 * 该例程设置/读取海龟例程中的参数
 */
#include <string>
#include <ros/ros.h>
#include <std_srvs/Empty.h>

int main(int argc, char **argv)
{
	int red, green, blue;

    // ROS节点初始化
    ros::init(argc, argv, "parameter_config");

    // 创建节点句柄
    ros::NodeHandle node;

    // 读取背景颜色参数
	ros::param::get("/background_r", red);
	ros::param::get("/background_g", green);
	ros::param::get("/background_b", blue);

	ROS_INFO("Get Backgroud Color[%d, %d, %d]", red, green, blue);

	// 设置背景颜色参数
	ros::param::set("/background_r", 255);
	ros::param::set("/background_g", 255);
	ros::param::set("/background_b", 255);

	ROS_INFO("Set Backgroud Color[255, 255, 255]");

    // 读取背景颜色参数
	ros::param::get("/background_r", red);
	ros::param::get("/background_g", green);
	ros::param::get("/background_b", blue);

	ROS_INFO("Re-get Backgroud Color[%d, %d, %d]", red, green, blue);

	// 调用服务，刷新背景颜色
	ros::service::waitForService("/clear");
	ros::ServiceClient clear_background = node.serviceClient<std_srvs::Empty>("/clear");
	std_srvs::Empty srv;
	clear_background.call(srv);
	
	sleep(1);

    return 0;
}
```

 

### 11.5编辑CMakeLists.txt

 加上这两句  

```
add_executable(parameter_config src/parameter_config.cpp)
target_link_libraries(parameter_config ${catkin_LIBRARIES})
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205130246837.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205130246837.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 

### 11.6编译并运行

 

```
cd /catkin_ws
catkin_make
```

 

### 11.7验证

 

```
roscore
```

 

```
rosrun turtlesim turtlesim_node
```

 

```
rosrun learning_parameter parameter_config
```

 

### 11.8结果

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205130635227.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205130635227.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)

# 12.ROS中的坐标管理系统

### 12.1机器人中的坐标变换

 

##### TF功能包：坐标变换

 

##### TF功能包能干什么

 

- 五秒钟之前，机器人头部坐标系相对于全局坐标系的关系是怎么样的？
- 机器人夹取的物体相对于机器人中心坐标系的位置在哪里？
- 机器人中心坐标系相对于全局坐标系的位置在哪里？

 

##### TF坐标变换如何实现？

 

- 广播TF变换
- 监听TF变换

 

### 12.2海龟案例

 通过坐标变换实现控制一个海龟移动，而另一个海龟紧紧跟随这只海龟的移动  1.安装必要包 

```
sudo apt-get install ros-noetic-turtle-tf
```

 2.启动launch文件 

```
roslaunch turtle_tf turtle_tf_demo.launch
```

 3.再在一个新的终端下打开海龟键盘控制器 

```
rosrun turtlesim turtle_teleop_key
```

 通过海龟控制器发现，当你移动一只海龟，另外一只海龟就会朝着这只海龟移动 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205174428868.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205174428868.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 红线代表海龟键盘控制器下海龟的移动路线，黑线代表跟随海龟

的移动路线  系统之间两只海龟的坐标关系查看s 

```
rosrun tf view_frame
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205175024398.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205175024398.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) 查看任意两个坐标系的位置关系（命令行工具） 

```
rosrun tf tf_echo turtle1 turtle2
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205175624413.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205175624413.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70) Translation：分别在xyz轴上的相对坐标 Rotation：坐标系通过什么样的旋转来变成一样的姿态  查看任意两个坐标系的位置关系（可视化工具） 

```
rosrun rviz rviz -d `rospack find turtle_tf`/rviz/turtle_rviz.rviz
```

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205180637316.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205180637316.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)

# 13.tf坐标系广播与监听的编程实现

### 13.1创建功能包

 

```
cd /catkin_ws/src
catkin_create_pkg learning_tf roscpp rospy tf turtlesim
```

 

### 13.2创建广播C++代码

 当然还是在learning_tf/src下创建c++代码  

```
touch turtle_tf_broadcaster.cpp
```

 输入  

```
/**
 * 该例程产生tf数据，并计算、发布turtle2的速度指令
 */

#include <ros/ros.h>
#include <tf/transform_broadcaster.h>
#include <turtlesim/Pose.h>

std::string turtle_name;

void poseCallback(const turtlesim::PoseConstPtr& msg)
{
	// 创建tf的广播器
	static tf::TransformBroadcaster br;

	// 初始化tf数据
	tf::Transform transform;
	transform.setOrigin( tf::Vector3(msg->x, msg->y, 0.0) );
	tf::Quaternion q;
	q.setRPY(0, 0, msg->theta);
	transform.setRotation(q);

	// 广播world与海龟坐标系之间的tf数据
	br.sendTransform(tf::StampedTransform(transform, ros::Time::now(), "world", turtle_name));
}

int main(int argc, char** argv)
{
    // 初始化ROS节点
	ros::init(argc, argv, "my_tf_broadcaster");

	// 输入参数作为海龟的名字
	if (argc != 2)
	{
		ROS_ERROR("need turtle name as argument"); 
		return -1;
	}

	turtle_name = argv[1];

	// 订阅海龟的位姿话题
	ros::NodeHandle node;
	ros::Subscriber sub = node.subscribe(turtle_name+"/pose", 10, &poseCallback);

    // 循环等待回调函数
	ros::spin();

	return 0;
};
```

 

**如何创建一个tf广播器**

 

- 定义TF广播器（TransformBroadcater）
- 创建坐标变换值
- 发布坐标变换（sendTransform）

 

### 13.3创建监听C++代码

 当然还是在learning_tf/src下创建c++代码  

```
touch turtle_tf_listener.cpp
```

 输入  

```
/**
 * 该例程监听tf数据，并计算、发布turtle2的速度指令
 */

#include <ros/ros.h>
#include <tf/transform_listener.h>
#include <geometry_msgs/Twist.h>
#include <turtlesim/Spawn.h>

int main(int argc, char** argv)
{
	// 初始化ROS节点
	ros::init(argc, argv, "my_tf_listener");

    // 创建节点句柄
	ros::NodeHandle node;

	// 请求产生turtle2
	ros::service::waitForService("/spawn");
	ros::ServiceClient add_turtle = node.serviceClient<turtlesim::Spawn>("/spawn");
	turtlesim::Spawn srv;
	add_turtle.call(srv);

	// 创建发布turtle2速度控制指令的发布者
	ros::Publisher turtle_vel = node.advertise<geometry_msgs::Twist>("/turtle2/cmd_vel", 10);

	// 创建tf的监听器
	tf::TransformListener listener;

	ros::Rate rate(10.0);
	while (node.ok())
	{
		// 获取turtle1与turtle2坐标系之间的tf数据
		tf::StampedTransform transform;
		try
		{
			listener.waitForTransform("/turtle2", "/turtle1", ros::Time(0), ros::Duration(3.0));
			listener.lookupTransform("/turtle2", "/turtle1", ros::Time(0), transform);
		}
		catch (tf::TransformException &ex) 
		{
			ROS_ERROR("%s",ex.what());
			ros::Duration(1.0).sleep();
			continue;
		}

		// 根据turtle1与turtle2坐标系之间的位置关系，发布turtle2的速度控制指令
		geometry_msgs::Twist vel_msg;
		vel_msg.angular.z = 4.0 * atan2(transform.getOrigin().y(),
				                        transform.getOrigin().x());
		vel_msg.linear.x = 0.5 * sqrt(pow(transform.getOrigin().x(), 2) +
				                      pow(transform.getOrigin().y(), 2));
		turtle_vel.publish(vel_msg);

		rate.sleep();
	}
	return 0;
};
```

 

**如何实现一个TF监听器**

 

- 定义TF监听器；（TransformListener）
- 查找坐标变换；（waitForTransofrm、lookupTransform）

 

### 13.4编辑CMakeLists.txt

 加上这两句  

```
add_executable(turtle_tf_broadcaster src/turtle_tf_broadcaster.cpp)
target_link_libraries(turtle_tf_broadcaster ${catkin_LIBRARIES})

add_executable(turtle_tf_listener src/turtle_tf_listener.cpp)
target_link_libraries(turtle_tf_listener ${catkin_LIBRARIES})
```

 

### 13.5编译并运行

 

```
cd /catkin_ws
catkin_make
```

 

### 13.6验证

  

```c
roscore
```

 

```c
rosrun turtlesim turtlesim_node
```

 发布turtle1和world的关系

```c
rosrun learning_tf turtle_tf_broadcaster __name:=turtle1_tf_broadcaster /turtle1
```

 发布turtle2和world的关系

```c
rosrun learning_tf turtle_tf_broadcaster __name:=turtle2_tf_broadcaster /turtle2
```

 

```c
rosrun learning_tf turtle_tf_listener
```

 

```
rosrun turtlesim turtle_teleop_key 

```

当然也是在不同终端下执行  

### 13.7结果

 [![在这里插入图片描述](https://img-blog.csdnimg.cn/20200205192911408.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)](https://img-blog.csdnimg.cn/20200205192911408.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L25pZGllNTA4,size_16,color_FFFFFF,t_70)

# 14.launch启动文件的使用方法

### 14.1**Launch文件：**

**通过XML文件实现多节点的配置和启动（可自动启动ROS Master）**

 帮助快速启动指令和结点，避免重复打开终端输入命令

```
<launch>
	<node pkg="turtlesim" name="sim1" type="turtlesim_node"/>
	<node pkg="turtlesim" name="sim2" type="turtlesim_node"/>
</launch>	
```

 

- pkg为启动的包名
- name为设定节点名
- type为可执行文件名

 

**< launch >**

launch文件中的根元素采用< launch >标签定义  

**< node >**

启动节点  

```
<node pkg="package-name" type="executable-name" name="node-name" />
```

 

- pkg: rosrun命令后面紧跟着的功能包，节点所在的功能包名称
- type：节点可执行文件名称
- name:节点运行时的名称
- output、respawn、required、ns、args

 ![image-20220212204819690](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220212204819690.png)

![image-20220212205149358](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220212205149358.png)



### 14.2例子

 

```
<launch>
    <node pkg="learning_topic" type="person_subscriber" name="talker" output="screen" />
    <node pkg="learning_topic" type="person_publisher" name="listener" output="screen" /> 
</launch>
```

 第一行< launch >代表启动launch文件，第四行即为关闭launch文件。第二行代表启动功能包learning_topic 下person_subscriber可执行文件，第三行类似。  

```
 <launch>

    <!-- Turtlesim Node-->
    <node pkg="turtlesim" type="turtlesim_node" name="sim"/>
    <node pkg="turtlesim" type="turtle_teleop_key" name="teleop" output="screen"/>

    <node pkg="learning_tf" type="turtle_tf_broadcaster" args="/turtle1" name="turtle1_tf_broadcaster" />
    <node pkg="learning_tf" type="turtle_tf_broadcaster" args="/turtle2" name="turtle2_tf_broadcaster" />

    <node pkg="learning_tf" type="turtle_tf_listener" name="listener" />

  </launch>
```

 和例一讲解做对应即可。  

**launch的作用自我总结：就是运行launch文件，而launch文件中包含着你的可执行文件。总归是编译运行可执行文件，可是运行launch文件可以大大减少操作（打开终端的数量）**

### 14.3 launch示例

3.1 创建功能包

```
cd ~/catkin_ws/src
catkin_create_pkg learning_launch
mkdir launch
```

编译：

```
cd ~/catkin_ws
catkin_make
```

启动两个Node节点

```
simple.launch
<launch>
	<node pkg="learning_topic" type="person_subscriber" name="talker" output="screen" />
	<node pkg="learning_topic" type="person_publisher" name="listener" output="screen" />
</launch>
```



```
turtlesim_parameter_config.launch
<launch>
	<param name="/turtle_number" value="2" />
	<node pkg="turtlesim" type="turtlesim_node" name="turtlesim_node" >
		<param name="turtle_name1" value="Tom" />
		<param name="turtle_name2" value="Jerry" />
		<rosparam file="$(find learning_launch)/config/param.yaml" command="load" />
	</node>
	<node pkg="turtlesim" type="turtle_teleop_key" name="turtle_teleop_key" output="screen" />
</launch>
```


此时ROS中的参数列表为：

```
start_tf_demo_c++.launch
<launch>
	<node pkg="turtlesim" type="turtlesim_node" name="sim" />
	<node pkg="turtlesim" type="turtlesim_teleop_key" name="teleop" output="screen" />

<node pkg="learning_tf" type="turtle_tf_broadcaster" args="/turtle1" name="turtle1_tf_broadcaster" />
<node pkg="learning_tf" type="turtle_tf_broadcaster" args="/turtle2" name="turtle2_tf_broadcaster" />
<node pkg="learning_tf" type="turtle_tf_listener" name="listener" />

</launch>

```



```
turtlesim_remap.launch
<launch>
	<include file="$(find learning_launch)/launch/simple.launch" />

<node pkg="turtlesim" type="turtlesim_node" name="turtlesim_node">
	<remap from="/turtle1/cmd_vel" to="/cmd_vel" />
</node>

</launch>
```

查看当前ROS中的话题，并使用重映射后的话题发布速度指令：

