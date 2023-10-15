# python爬虫入门

## 1.网络请求

## 1.1茫茫人海君何在

- 域名解析：由DNS（域名解析服务器）完成，如果呗劫持则会找到错误的结果

- 请求发送：将信息直接传到目标服务器上，由服务器决定处理与返回的结果

- 相应处理：浏览器渲染结果并呈现给你，随后用户“为所欲为”，比如浏览器页面修改

## 1.2终极哲学三大问

（服务器视角下的网络请求）

- 你是谁：User-Agent|Cookies---一串数字

- 你从哪里来：IP

- 你来这里干什么：Method&Parameter   method：请求方法 （get）

​                                                               parameter:参数

在这一过程中可能面临一些攻击（爬虫可能无意间导致这样的问题）

-  DoS（Denial of Service）attack:拒绝服务攻击，在Dos攻击基础上改为多个客户端（用户）

同时对目标网站发起大量请求使服务器"忙不过来"完成

- DDos(Distributed Denial of Service) attack:分布式拒绝服务攻击，在DoS攻击基础上改为多个客户端（用户）同时对网站目标发起大量请求

**写爬虫时应当全力避免这种情况，不要把服务器爬崩掉！**

## 1.3网络抓包基本功（请求）

> 浏览器页面的本质时基于HTTP协议的一次或多次网络请求，这些请求用户是可以直接查看的，比如按下F12再康康”网络“

网络抓包通常有如下用处：

1. 查看真正的数据来源，真实的独立数据
2. 查看下载视频等数据
3. 模拟请求完成登录
4. 测试网站安全性

## 2.爬虫初步

## 2.1何为爬

> 网络爬虫，（又称为网页蜘蛛，网络机器人，在FOAF社区中间，更经常称为网页追逐者），是一种按照一定的规则，自动地抓起万维网信息的程序或脚本。
>
> ——百度百科《爬虫》

> A Web crawler, sometimes called a spider or spiderbot and often shortened to crawler,is an Internet bot that systematically browses the World Wide Web, typically for the purpose of Web indexing(web spidering)
>
> ——wikipedia: Web crawler

- 初衷：为搜索引擎服务
- 现状：自动化或批量的数据获取

## 2.2为何爬

解放生产力

## 2.3孰可爬

怕之前请务必关注robots.txt，这是网站与爬虫间的“君子协议”，此处规定了什么能爬，什么不能爬

request -rate：请求频率

## 2.4如何爬

![image-20211207194328366](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20211207194328366.png)



![image-20211207195520109](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20211207195520109.png)

## 3爬虫实战

## 3.1准备

> 1. Python 3:编程语言，推荐使用3.7或3，8（当前的稳定新版）
> 2. Pycharm:强大的Python IDE,或者使用其他替代品即可，但不建议Windows自带的idle
> 3. requests:一个用于发起请求的Python库
> 4. BeautifulSoup4:一个用于解析html的Python 库

## 3.2自学内容——爬虫加强

上面只说到了比较重要的一部分。下面还有一些可能会用到的自学内容

- Python、Pycharm下载与环境配置
- 娴熟的搜索引擎使用技巧
- 文件编码处理
- js2py:在Python 中执行Javascript脚本
- pyppeteer:通过headless的方法直接渲染网页
- scrapy:真正的高性能爬虫架构

## 3.3爬取演示

不失一般性，爬取下面几个省的卫建委新闻作为示范：







