作者：振动梦想的翅膀 起飞
链接：https://zhuanlan.zhihu.com/p/352203604
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



## **一、Cmake用途**

是一种常用的项目构建工具，组织和管理多文件的项目代码，其主要功能包括：多文件编译；管理外部依赖；代码模块化；编译结果安装等

## **二、Cmake安装**

在Ubuntu平台下，已包含Cmake的安装包，直接运行`sudo apt-get install cmake`即可，默认安装在 /usr/local/bin目录下

## **三、基本语法**

## **1 常用命令**

- **add_executable**

- - 原型: add_executable(<name> [WIN32](https://zhuanlan.zhihu.com/p/352203604/edit#) [EXCLUDE_FROM_ALL] source1 source2 … sourceN)
  - 作用: 用于指定从一组源文件 source1 source2 … sourceN 编译出一个可执行文件且命名为 name
  - 示例: add_executable(Main ${DIR_SRCS})



- **add_library**

- - 原型: add_library([STATIC | SHARED |MODULE] [EXCLUDE_FROM_ALL] source1 source2 … sourceN)
  - 作用: 用于指定从一组源文件 source1 source2 … sourceN 编译出一个库文件且命名为 name
  - 示例: add_library(Lib ${DIR_SRCS})



- **add_subdirectory**

- - 原型: add_subdirectory(source_dir[binary_dir] [EXCLUDE_FROM_ALL])
  - 作用: 用于添加一个需要进行构建的子目录
  - 示例: add_subdirectory(Lib)



- **aux_source_directory**

- - 原型: "aux_source_directory(<dir><variable>)
  - 作用: 用于将 dir 目录下的所有源文件的名字保存在变量variable中
  - 示例: aux_source_directory(. DIR_SRCS)



- **cmake_minimum_required**

- - 原型: cmake_minimum_required(VERSIONmajor[.minor[.patch[.tweak\]]](https://zhuanlan.zhihu.com/p/352203604/edit#))
  - 作用: 用于指定需要的Cmake的最低版本
  - 示例: cmake_minimum_required(VERSION 2.8)



- **find_library**

- - 原型: find_library (<VAR>name1 [path1 path2 …])
  - 作用: 用于查找库文件 name1 的路径，如果找到则将路径保存在 VAR中（此路径为一个绝对路径），如果没有找到则结果为<VAR>-NOTFOUND。
  - 示例: 



- **find_path**

- - 原型: find_path(<VAR>name1 [path1 path2 …])
  - 作用: 用于查找包含文件 name1 的路径，如果找到则将路径保存在 VAR中（此路径为一个绝对路径），如果没有找到则结果为<VAR>-NOTFOUND. 默认的情况下，VAR会被保存在 Cache中，这时候我们需要清除 VAR 才可以进行下一次查询(使用 unset命令)
  - 示例: find_path(LUA_INCLUDE_PATH lua.h ${LUA_INCLUDE_FIND_PATH})



- **find_package**

- - 原型: FIND_PACKAGE(<name> [major.minor] [QUIET] [NO_MODULE] [[REQUIRED|COMPONENTS] [componets …]])
  - 作用: 用来调用预定义在CMAKE_MODULE_PATH下的Find<name>.cmake模块,也可以自己定义Find<name>模块,通过SET(CMAKE_MODULE_PATH dir)将其放入工程的某个目录供工程使用



- **mark_as_advanced**

- - 原型: mark_as_advanced([CLEAR|FORCE] <var1> ...)
  - 作用: 标记已命名的缓冲变量为advanced,advanced变量不会在cmake图形界面中显示除非advanced选项开启



- **message**

- - 原型: message([STATUS | WARNING | AUTHOR_WARNING | FATAL_ERROR | SEND_ERROR]“message to display” …)
  - 作用: 用于输出信息
  - 示例: message(“Hello World”)



- **project**

- - 原型: project(<projectname>[languageName1 languageName2 … ] )
  - 作用: 用于指定项目的名称
  - 示例: project(Main)



- **set**

- - 原型: set(<variable><value> [[CACHE <type> <docstring> [FORCE]] |  PARENT_SCOPE])
  - 作用: 用于设定变量variable的值为value. 如果指定了CACHE变量将被放入Cache（缓存）中
  - 示例: set(ProjectName Main)



- **target_link_libraries**

- - 原型: target_link_libraries(<target>[item1 [item2 […]]] [[debug | optimized | general] ] …)
  - 作用: 用于指定target需要链接item1、item2. 这里 target必须已经被创建,链接的item可以是已经存在的target（依赖关系会自动添加）
  - 示例: target_link_libraries(Main Lib)



## **2 条件判断语句**

if的基本使用格式

```text
IF (expression)
    COMMAND1(ARGS ...)
    COMMAND2(ARGS ...)
    ...
ELSE (expression)
    COMMAND1(ARGS ...)
    COMMAND2(ARGS ...)
    ...
ENDIF (expression) # 一定要有ENDIF与IF对应
```

- IF (expression): expression为 空,0,N,NO,OFF,FALSE,NOTFOUND或<var>_NOTFOUND时为假
- IF (var1 AND var2): 逻辑与
- IF (var1 OR var2): 逻辑或
- IF (not expression): 逻辑非

## **四、使用示例**

在Linux平台下使用Cmake生成Makefile并编译的**基本流程**为

- 根据一定的语法规则编写CmakeLists.txt
- 执行命令 `cmake PATH`在目录PATH下生成Makefile
- 使用命令`make`进行编译

## **1 单文件项目**

安装好Cmake之后，从最简单的只含单个文件的项目开始学习Cmake 项目的整体目录结构为  

```text
    hello/
    |– CMakeLists.txt
    |– build/
     – main.cpp
```

- 建立一个项目目录hello
- 在该目录下建立一个main.cpp文件，这是此项目的源代码，代码如下

```cpp
#include <iostream> 
using namespace std;

int main()
{
    cout<<"hello world!"<<endl;
}
```

- 在该目录下新建CmakeList.txt文件，这是Cmake直接处理的对象，所有使用Cmake构建的项目中都需要名为CmakeList.txt的文件，Cmake的基本语法结构为：命令名称（参数），其代码如下

```text
 #cmake最低版本需求，不加入此行会受到警告信息
 CMAKE_MINIMUM_REQUIRED(VERSION 2.6)
 
 #项目名称
 PROJECT(HELLO)
 
 #把当前目录(.)下所有源代码文件和头文件加入变量SRC_LIST
 AUX_SOURCE_DIRECTORY(. SRC_LIST)
 
 #指示SRC_LIST中所有的源文件编译生成应用程序 hello (在windows下会自动生成hello.exe)
 ADD_EXECUTABLE(hello ${SRC_LIST})
```

- 编译项目 直接在hello目录下进行编译会使生成的中间文件和源代码混杂在一起，无法使用`make distclean`删除中间文件，因此采用外部编译，即

- - 新建一个build目录用于存放所有中间文件，进入build；
  - 执行`cmake ..`，在当前目录(..)下生成相应的MakeFile；
  - 执行`make`进行编译



## **2 多文件项目**

处理一个源文件分布在不同目录下的项目，其目录结构为

```text
    prj/
    |- main.cpp
    |- src/
     - test.cpp
     - test.h
```

此时src目录下的文件需要编译成一个链接库

- 创建CmakeLists.txt，代码如下

```text
PROJECT(main)
CMAKE_MINIMUM_REQUIRED(VERSION 2.6)

#指明本项目包含一个子目录src
ADD_SUBDIRECTORY( src )
AUX_SOURCE_DIRECTORY(. DIR_SRCS)
ADD_EXECUTABLE(main ${DIR_SRCS}  )

#指明可执行文件main需要连接链接库test
TARGET_LINK_LIBRARIES( main test )
```

- 在子目录src中创建CmakeList.txt，代码如下

```text
AUX_SOURCE_DIRECTORY(. DIR_TEST_SRCS)
#将src目录中的源文件编译为共享库test
ADD_LIBRARY ( test ${DIR_TEST_SRCS})
```

- 进行编译。回到prj目录，执行`cmake .`和`make`（未采用外部编译） 程序将首先解析目录prj下的CmakeList.txt，执行到`ADD_SUBDIRECTORY( src )`时解析目录src下的CmakeList.txt

## **3 查找和使用其他程序库的方法**

- 在项目根目录下创建目录cmake/modules，进入该目录，创建文件Findlibdb_cxx.cmake（命名规范为FindlibNAME.cmake，其中NAME 是函数库的名称），其代码如下

```text
#将参数的内容输出到终端
MESSAGE(STATUS "Using bundled Findlibdb.cmake...")

#指明头文件查找路径，在 /usr/include/ 和 /usr/local/include/ 中查找文件db_cxx.h，并将db_cxx.h 所在的路径保存在变量LIBDB_CXX_INCLUDE_DIR中
FIND_PATH(
LIBDB_CXX_INCLUDE_DIR
db_cxx.h
/usr/include/
/usr/local/include/
)

#在目录 /usr/lib/ 和 /usr/local/lib/ 中寻找名称为 db_cxx 的链接库,并将结果保存在变量LIBDB_CXX_LIBRARIES中
FIND_LIBRARY(
LIBDB_CXX_LIBRARIES NAMES  db_cxx
PATHS /usr/lib/ /usr/local/lib/
)
```

- 在项目根目录下创建CmakeList.txt，代码如下

```text
PROJECT(main)
CMAKE_MINIMUM_REQUIRED(VERSION 2.6)
SET(CMAKE_SOURCE_DIR .)

#在目录 ./cmake/modules 中查找 Findlibdb_cxx.cmake
SET(CMAKE_MODULE_PATH ${CMAKE_ROOT}/Modules ${CMAKE_SOURCE_DIR}/cmake/modules)
AUX_SOURCE_DIRECTORY(. DIR_SRCS)
ADD_EXECUTABLE(main ${DIR_SRCS})

#到变量CMAKE_MODULE_PATH指示的目录中查找文件 Findlibdb_cxx.cmake 并执行
FIND_PACKAGE( libdb_cxx REQUIRED)
MARK_AS_ADVANCED(
LIBDB_CXX_INCLUDE_DIR
LIBDB_CXX_LIBRARIES
)

#条件判断语句，如果 LIBDB_CXX_INCLUDE_DIR 和 LIBDB_CXX_LIBRARIES 都已经被赋值,则设置编译时到 LIBDB_CXX_INCLUDE_DIR 寻找头文件并且设置可执行文件 main 需要与链接库 LIBDB_CXX_LIBRARIES 进行连接
IF (LIBDB_CXX_INCLUDE_DIR AND LIBDB_CXX_LIBRARIES)
MESSAGE(STATUS "Found libdb libraries")
INCLUDE_DIRECTORIES(${LIBDB_CXX_INCLUDE_DIR})
MESSAGE( ${LIBDB_CXX_LIBRARIES} )
TARGET_LINK_LIBRARIES(main ${LIBDB_CXX_LIBRARIES} )
ENDIF (LIBDB_CXX_INCLUDE_DIR AND LIBDB_CXX_LIBRARIES)
```

- 进行编译。回到根目录，执行`cmake .`和`make`（未采用外部编译）