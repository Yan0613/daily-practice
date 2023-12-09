# HTML

**image** 

src:绝对路径和相对路径: 相对路径./ 当前目录，../上一级目录

width、height: 一般只用设定一个

**span**

span标签没有任何语义，一行可以定义多个

**CSS选择器**

![image-20231107233911071](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107233911071.png)

![image-20231107234006663](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107234006663.png)

**超链接<a>**

![image-20231107234118235](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107234118235.png)

**<vedio>、<audio>、<p>**

![image-20231107234313352](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107234313352.png)

```html
<vedio src = "..." controls = "controls"></vedio>
```



**盒子模型**

![image-20231107234924013](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107234924013.png)

布局标签：（顺时针）

![image-20231107234952392](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231107234952392.png)

**表单**

![image-20231108000813767](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108000813767.png)

```html
<label><input type = "radio" name = "gender">男</input></label>
```

加lable的作用就是不用点到小圆圈也可以选中

**JSON**

![image-20231108004200478](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108004200478.png)

# BOM

![image-20231108170426891](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108170426891.png)

定时器：

```javascript
//setInterval
var i = 0;
setInterval(function(){
	i++;
	console.log("定时器执行了"+ i +"次");
},2000);

//setTimeOut--延迟指定时间执行一次
setTimeOut(function(){
    alert("JS");
},3000);

```

![image-20231108171143719](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108171143719.png)

# DOM

![image-20231108171805718](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108171805718.png)

![image-20231108172418071](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108172418071.png)

# JS事件绑定

```js
onclick = ""
```

```javascript
document.getElementID("").onclick = function(){
...
}
```

```javascript
onfoucus()//聚焦
onblur()//离焦
```

# VUE快速入门

![image-20231108183301083](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108183301083.png)

![image-20231108185947207](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108185947207.png)

```vue
v-bind:"url" //v-bind后面不加空格
```

![image-20231108193318940](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231108193318940.png)

![image-20231113000359924](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113000359924.png)

![image-20231113000417215](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113000417215.png)

v-if 经过判定不会渲染组件，v-show如果条件不成立，浏览器还是会渲染，只是通过css的display来决定组件是不是渲染

![image-20231113003018322](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113003018322.png)

插值表达式：

在前端开发中，插值表达式通常指的是一种在模板或视图中嵌入变量值的语法。**这样的表达式允许动态地将数据绑定到用户界面中，实现视图和数据的关联。**在前端框架和库中，常见的插值表达式语法如下：

1. **Vue.js 插值表达式：**

在 Vue.js 中，插值表达式使用双大括号 `{{ ... }}` 包裹变量或表达式。例如：

```html
<div>{{ message }}</div>
```

上述代码中，`message` 是一个在 Vue 实例中定义的数据属性。当 `message` 的值发生变化时，对应的视图将自动更新。

2. **Angular 插值表达式：**

在 Angular 中，插值表达式同样使用双大括号 `{{ ... }}`，例如：

```html
<div>{{ title }}</div>
```

在这里，`title` 是 Angular 组件中定义的属性或变量。和 Vue 类似，Angular 的插值表达式也会在相关数据发生变化时更新对应的视图。

**3. React 插值表达式：**

在 React 中，通常使用花括号 `{}` 将 JavaScript 表达式嵌入到 JSX 中，而不是使用特定的插值表达式语法。例如：

```jsx
<div>{message}</div>
```

在这里，`message` 是一个 React 组件的状态或属性。React 通过在 `render` 函数中动态生成 JSX 来实现视图的更新。

总体而言，这些插值表达式都具有类似的目标，即将动态生成的数据绑定到用户界面，使得界面能够随着数据的变化而更新。每个前端框架或库都有其自己的插值表达式语法和机制，但它们的基本思想是相似的。

![image-20231113005643034](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113005643034.png)

# AJAX

![image-20231113123607803](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113123607803.png)



![image-20231113123543786](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113123543786.png)

![image-20231113123917210](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113123917210.png)

```js
readyState == 4 && xmlHttpRequest.status ==200 //前者：数据准备完成，后者：请求成功
```

# Axios

![image-20231113125039508](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113125039508.png)

成功回调函数：

```js
.then((result) => 
	console.log(result.data));
});
```

![image-20231113125949362](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231113125949362.png)

# Maven

![image-20231114191255475](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114191255475.png)

![image-20231114192529020](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114192529020.png)

# HTTP

![image-20231114203210491](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114203210491.png)



![image-20231114203633088](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114203633088.png)

![image-20231114204209467](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114204209467.png)

![image-20231114204424606](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114204424606.png)

必知状态码：200：成功

404：资源不存在

500：服务端发生错误

# SpringBoot

## 三层架构

![image-20231114225755826](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231114225755826.png)

![image-20231115005929418](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231115005929418.png)

## 分层解耦/IOC&DI

![image-20231115010512165](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231115010512165.png)

bean声明

![image-20231115011251825](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231115011251825.png)

**springboot 有扫描包的作用。默认扫描当前包和其子包**

![image-20231115012128199](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231115012128199.png)

## MyBatis

![image-20231118221132594](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231118221132594.png)

![image-20231120152224481](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120152224481.png)

JDBC：

```java
//1.注册驱动
//2.获取连接对象
//3.获取执行SQL的对象Statement,执行SQL，返回结果
//封装结果数据
```

 

**数据库链接池：**

![image-20231120152649748](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120152649748.png)

如何切换数据库连接池？

![image-20231120153124586](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120153124586.png)

 

lombook

 在实体类上面加上注解

![image-20231120154517749](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120154517749.png)

![image-20231120154535877](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120154535877.png)

举个例子：

```java
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@Data//相当于上面所有的注解
@NoArgsConstructor//无参构造
@AllAegsConstructor//全参构造
public class User{
    
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;
}
```

## Mybatis基本操作-CRUD

```java
@Mapper
public interface EmpMapper {
    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);
}
```

![image-20231120193157309](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231120193157309.png)

```java
    //新增员工
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)"+
            "values (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);
}
```

```java
//    //条件查询----拼接
    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
           "entrydate between #{begin} and #{end} order by update_time desc ")
   public List<Emp> list(String name, short gender , LocalDate begin, LocalDate end);
```

## 动态Mybatis

```xml
<!--    collection:遍历的集合-->
<!--    item:遍历出来的元素-->
<!--    seprator: 分隔符-->
<!--    open: 遍历开始前拼接的SQL片段-->
<!--    close: 遍历结束后拼接的SQL片段-->
    <delete id="deleteByIds">
        delete form emp where id in
        <foreach collection="ids" item="id" separator="," open="(" close=")">
            #{id}
        </foreach>
    </delete>
```

## 配置文件

![image-20231125192827848](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231125192827848.png)

![image-20231125211501970](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231125211501970.png)

## JWT令牌

```java
    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt(){
        Map<String, Object> claims  = new HashMap<>();
        claims.put("id",1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"itheima")//签名算法
                .setClaims(claims) //自定义内容（载荷）
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//设置有效期为1H
                .compact();
        System.out.println(jwt);
    }
```

[使用jwt0.11.1导致版本报错_虎落鹰背的博客-CSDN博客](https://blog.csdn.net/qq_60361946/article/details/128402295?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-128402295-blog-118401875.235^v38^pc_relevant_sort_base2&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-1-128402295-blog-118401875.235^v38^pc_relevant_sort_base2&utm_relevant_index=2)

报错

> [Unable to load class named [io.jsonwebtoken.impl.DefaultJwtBuilder] from the thread context, current, or system/application ClassLoaders. All heuristics have been exhausted. Class could not be found. Have you remembered to include the jjwt-impl.jar in your runtime classpath?]
> ————————————————
> 版权声明：本文为CSDN博主「虎落鹰背」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
> 原文链接：https://blog.csdn.net/qq_60361946/article/details/128402295

原因是包导少了

```xml
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-api</artifactId>
            <version>0.11.1</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-impl</artifactId>
            <version>0.11.2</version>
        </dependency>
        <dependency>
            <groupId>io.jsonwebtoken</groupId>
            <artifactId>jjwt-jackson</artifactId>
            <version>0.11.2</version>
        </dependency>

```

运行之后继续报错

![image-20231126145630521](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231126145630521.png)

解决：把JWT签名加长后成功运行

![image-20231126150103354](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231126150103354.png)

## Filter过滤器

过滤器链

![image-20231126174641831](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231126174641831.png)



ctrl+alt+t 快捷键：surrounded with

## Intercepter拦截器 

**Webconfig.java**

```java
package com.itheima.config;

import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**");
    }
}

```

**interceptor.LoginCheckInterceptor**

```java
package com.itheima.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源方法运行前运行，返回true,放行，返回false，不放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandle...");
        return true;
    }

    @Override//表资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("prehandle...");
    }

    @Override//试图渲染完毕之后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}

```

## 事务管理

1. 保障数据要求的**一致性**：transactional

```java
    @Transactional
    @Override
    public void delete(Integer id) {

        deptMapper.deleteById(id);//根据ID删除部门数据
        empMapper.deleteByDept(id);//根据部门ID删除该部门下的员工
    }

```

2. **默认情况下，只有出现RuntiemException才回滚异常。rollbackfor**属性用于控制出现何种异常类型，回滚事务。

```java
@Transactional(rollbackFor = Exception.class)
@Override
public void delete(Integer id) {

    deptMapper.deleteById(id);//根据ID删除部门数据
    empMapper.deleteByDept(id);//根据部门ID删除该部门下的员工
}
```

3. propogation。事务传播行为，指的就是当一个事务方法被另一个事务方法调用的时候，这个事务方法如何进行事务控制。

   ![image-20231126225140676](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231126225140676.png)

   

   **propogation = REQUIRES_NEW 表示，在出现异常的时候，还是需要一个新的事务，不会回滚（云里雾里，每天弄懂行不行？）**

   

![image-20231126225300768](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231126225300768.png)

# AOP基础

aop:面向切面变成，面向方法编程

# 项目实战

Nginx反向代理的好处：

1. 提高访问速度（可以在Nginx做缓存），如果请求同一个地址，可以把缓存数据相应给前端
2. 进行负载均衡，把大量请求按照指定的方式均衡分配给集群中的每台服务器
3. 保证后端服务安全，有的地方的是局域网，请求先发给内部的Nginx服务器，再请求到后端服务，而不是直接请求到后端服务。

反向代理的配置方式：

匹配到/api/  之后进行动态匹配

##  Swagger

![image-20231128215039698](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231128215039698.png)

项目约定

管理端发出的请求，统一使用/admin作为前缀

用户端发出的请求，统一使用/user作为前缀

> DTO VO Entity 的区别
>
> 具体的区别关系，我举个例子来说明。
> 需求：返回某个用户信息和其账号订单数量。
>
> 首先我们需要查询数据库获取用户信息和账号订单数量，但是无论是用户信息对应的Entity还是账号订单对应的Entity都不能满足我们的需要。
> 这时我们创建一个DTO继承用户信息Entity（正常来讲还是不要继承，重写一份），扩展订单数量属性。然后无论是连表还是单独查询，将查询到数据放到DTO中就好了。
> 处理完数据该返回了。但是页面中需要显示用户的性别，可是我们DTO中存的是数字0和1，这咋办，那我们就在创建一个VO，将DTO转换为VO（将其中的性别转换为男女汉字），用来返回页面数据。
> ————————————————
> 版权声明：本文为CSDN博主「世代农民」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
> 原文链接：https://blog.csdn.net/weixin_45056780/article/details/125293579

通过JWT令牌解析出员工ID

```javascript
        //TODO 后期改成当前登录用户id
        //设置当前记录创建人id和修改人id
        employee.setCreateUser(10L);
        employee.setUpdateUser(10L);
```

ThreadLocal

并不是线程，而是线程的局部变量，具有线程隔离的效果，只有在线程内才能获取到对应值，线程外则不能访问。

##  消息转换器

```java
    /**
     * 扩展SpringMVC框架的消息转化器
     * @param converters
     */
    protected void extendMessageConverts(List<HttpMessageConverter<?>> converters){
        log.info("扩展消息转换器");
        //创建一个消息转换器对象
       MappingJackson2CborHttpMessageConverter converter =  new MappingJackson2CborHttpMessageConverter();
       //需要为消息转换器设置一个对象转换器，对象转换器可以将Java对象序列化为Json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将自己的消息转换器加入容器中
        //容器中其实有很多消息转换器，但是我们希望优先使用我们的消息转换器
        converters.add(0,converter);
    }
```

路径参数

```java
    @PostMapping("/status/{status}")
    public Result startOrStop(@PathVariable Integer status, Long id){
        log.info("");
        return Result.success();
    }
```

cntl + alt + b实现类

## 自动字段填充

```java
package com.sky.aspect;

import com.sky.annotation.AutoFill;
import com.sky.constant.AutoFillConstant;
import com.sky.context.BaseContext;
import com.sky.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * 自定义切面，实现公共字段自动填充
 */
@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    /**
     * 切入点：对哪些类的哪些方法进行拦截
     */
    @Pointcut("execution(* com.sky.mapper.*.*(..)) && @annotation(com.sky.annotation.AutoFill)")//mapper包内所有的类所有的方法
    public void autoFillPointCut(){}

    /**
     * 前置通知，在通知中进行公共字段的赋值
     */
    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint){
        log.info("开始进行公共字段的自动填充");

        //获取到当前被拦截的方法上的数据库操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();//方法签名对象
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);//获得方法上的注解对象
        OperationType operationType = autoFill.value();//获得数据库操作类型

        //获取到当前被拦截方法的参数--实体对象
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length ==0){
            return;
        }

        Object entity = args[0];

        //为实体对象的公共属性赋值，准备赋值数据
        LocalDateTime now = LocalDateTime.now();
        Long currenId = BaseContext.getCurrentId();

        //根据当前不同的操作类型，为对应的属性反射
        if (operationType  == operationType.INSERT){
            //为四个公共字段赋值
            try {
                Method setcreateTime  = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME,LocalDateTime.class);
                Method setCreateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_USER, Long.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                //通过反射为对象属性赋值
                setcreateTime.invoke(entity,now);
                setCreateUser.invoke(entity,currenId);
                setUpdateTime.invoke(entity,now);
                setUpdateUser.invoke(entity,currenId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (operationType == operationType.UPDATE) {
            try {
                //为两个公共字段赋值
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                Method setUpdateUser = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_USER, Long.class);

                //通过反射为对象属性赋值
                setUpdateTime.invoke(entity,now);
                setUpdateUser.invoke(entity,currenId);

            } catch (Exception e){
                e.printStackTrace();
            }


        }
    }
}

```

## 新增菜品

```java
@Component
@ConfigurationProperties(prefix = "sky.alioss")
@Data
public class AliOssProperties {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

}
```

读取配置项，封装成Java对象

Transcactional保证原子操作

## Redis

![image-20231201184531653](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231201184531653.png)

![image-20231201184615073](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231201184615073.png)

第三个业务场景：验证码

![image-20231201201843100](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231201201843100.png)

![image-20231201202123100](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231201202123100.png)

![image-20231201202156551](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20231201202156551.png)

## 缓存数据

缓存操作比IO操作要快很多



开始-》后端服务-是否存在缓存数据？读取缓存：查询数据库并且载入缓存

## WebSocket

WebSocket是一种基于TCP的一种新的网络协议，它实现了浏览器与服务器的全双工通信——浏览器与服务器只需要完成一次握手，二者就可以建立长连接，并且进行双向的数据传输。

