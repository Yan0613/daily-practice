# Python 函数模块导入

![image-20220106111112694](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220106111112694.png)

# 用as给函数指定别名

```python
from pizza import make_pizza as mp

mp(16,'peperonia')
```

# 用as给模块指定别名

```python
import pizza as p
```

# 导入模块中所有函数（最好别用）

```python
from pizza import * 
make_pizza(16, 'pepperoni') 
make_pizza(12, 'mushrooms', 'green peppers', 'extra cheese')
```

#### import语句中的星号让Python将模块pizza中的每个函数都复制到这个程序文件中。由于导入 了每个函数，可通过名称来调用每个函数，而无需使用句点表示法。然而，使用并非自己编写的 大型模块时，最好不要采用这种导入方法：如果模块中有函数的名称与你的项目中使用的名称相 同，可能导致意想不到的结果：Python可能遇到多个名称相同的函数或变量，进而覆盖函数，而不是分别导入所有的函数。

# 函数编写指南

1.给形参指定默认值时，等号两边不要有空格

```python
def function_name(parameter_0, parameter_1='default value')
```

2.对于函数调用中的关键字实参，也要遵循这种规定

```python
function_name(value_0, parameter_1='value')
```

3.形参列表的缩进

```python
def function_name( 
 parameter_0, parameter_1, parameter_2, 
 parameter_3, parameter_4, parameter_5): 
 function body..
```

