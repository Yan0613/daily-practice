# 1.what is Django

> **Django**是一个[开放源代码](https://zh.wikipedia.org/wiki/开放源代码)的[Web应用框架](https://zh.wikipedia.org/wiki/Web应用框架)，由[Python](https://zh.wikipedia.org/wiki/Python)写成。采用了MTV(model–template–views)的[软件设计模式](https://zh.wikipedia.org/wiki/软件设计模式)，即模型（Model），视图（View）和模板（Template）。它在开发初期用于管理[劳伦斯出版集团](https://zh.wikipedia.org/w/index.php?title=劳伦斯出版集团&action=edit&redlink=1)旗下的一些以新闻为主的网站。Django于2005年7月在[BSD许可证](https://zh.wikipedia.org/wiki/BSD许可证)下发布，它的名字来源于[比利时](https://zh.wikipedia.org/wiki/比利时)的[吉普赛](https://zh.wikipedia.org/wiki/吉普赛)[爵士](https://zh.wikipedia.org/wiki/爵士乐)吉他手[金格·莱恩哈特](https://zh.wikipedia.org/wiki/金格·萊恩哈特)。
>
> Django的主要目标是简化数据库驱动的网站的开发。Django注重组件的重用性和“可插拔性”，[敏捷开发](https://zh.wikipedia.org/wiki/敏捷开发)和[DRY法则](https://zh.wikipedia.org/wiki/一次且仅一次)（Don't Repeat Yourself）。在Django中普遍使用的语言是[Python](https://zh.wikipedia.org/wiki/Python)，甚至包括配置文件和数据模型。
>
> Django于2008年6月17日正式成立基金会。
>
> ​                                                                            ------wikipedia

# 2.start a project

### 2.1 open the terminal

```
django-admin startprojeect projectname
python3 manage.py runserver
```

> manage.py is essentially the same program with django-admin, but we use django-admin to create a django project , now we already have a project.

now if you open your web browser and enter localhost:8000,you can see this :

![image-20220224174125652](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20220224174125652.png)

it works, awesome!



 

# some questions:

1.what is the difference between package and module?

A package is a collection of Python modules: while a module is a single Python file, a package is a directory of Python modules containing an additional __init__.py file, to distinguish a package from a directory that just happens to contain a bunch of Python scripts.