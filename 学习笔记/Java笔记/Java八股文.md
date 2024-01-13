# Java

## Java基础概念

### **JavaSE与JavaEE：**

JavaSE: Java平台标准版，可以构建桌面应用程序或简单的服务器应用程序，包括了Java核心类库和虚拟机等核心组件。

JavaEE: Java平台企业版，可以构建分布式、可移植、健壮、可伸缩和安全的服务端Java应用程序。

### **JDK与JRE与JVM**

JRE包括JVM，JDK包括JRE

![JDK 包含 JRE](https://oss.javaguide.cn/github/javaguide/java/basis/jdk-include-jre.png)

### **字节码：**

JVM可以理解的代码就叫做字节码，拓展名为.class。Java通过字节码的形式，及解决了传统解释性语言效率低的问题，又保留了解释性语言效率低的问题。

![Java程序转变为机器代码的过程](https://oss.javaguide.cn/github/javaguide/java/basis/java-code-to-machine-code.png)

在.class文件到机器可理解代码这一过程中，解释器解释辉导致效率较低，执行速度较慢，而且有的代码是会被重复调用的，也就是热点代码，所以后面引进了JIT运行时编译器，当JIT完成了第一次编译后，就会将字节码对应的机器码保存下来，下次可以直接使用。

问题：那什么时候删除这些机器码？有什么删除策略？

### **Java和C++的区别：**

Java不支持多重继承，CPP支持多重继承

Java有自带的垃圾回收机制，GC，不需要程序员手动释放内存。

C++支持方法和操作符重载，但是Java只支持方法重载

### **自动装箱和拆箱：**

装箱：将基本数据类型用他们的引用类型包装起来

拆箱：将包装类型转化为基本数据类型

### **浮点数运算精度丢失**

计算机二进制表示，遇见无限循环小数会截断，造成精度的丢失。

如何解决：运用BigDecimal

### **重载和重写的区别**

> 重载就是同样的一个方法能够根据输入数据的不同，做出不同的处理
>
> 重写就是当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法

构造方法不能被重写但是可以重载。

### **面向对象三大特征**

封装：将对象的状态信息隐藏在内部，不允许外部对象直接访问对象的内部信息比如属性

继承：子类可以继承父类的方法，子类可以拥有父类的方法，子类可以拓展自己的方法，子类可以重写父类的方法

多态：一个对象具有多种状态。

### **String, StringBuffer, StringBuilder**

string长度不可变，后面两个长度是可变的。

`StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。`StringBuilder` 并没有对方法进行加同步锁，所以是非线程安全的。

### **try-catch-finally**

finally代码不一定会执行，比如，如果finally之前虚拟机被终止运行，finally的代码就不会被执行。

## Java集合

### **ArrayList和LinkList的区别**

线程安全：ArrayList和LinkedList都是不同步的，也就是不保证线程安全。

底层数据结构：ArrayList采用的是Objeect[]数组，是一个动态数组；LinkedList底层是一个双向链表。在中间插入元素时间复杂度是O（n）

插入和删除数据的时间复杂度：ArrayList增加元素的时间复杂度是O（1），因为是在尾部加入。而LinkedList在头部和尾部插入和删除节点的时间复杂度都是O(1)【add, addFirst, addLat, removeFirst, removeLast】，但是在中间插入元素的时间复杂度也是O（n）因为要找到插入的位置。

是否支持快速随机访问：LinkedList不支持高效的随机元素访问，而ArrayList继承了RanDomAccess接口，可以支持高效随机访问。

### **LinkedList源码**

为什么不能使用randomaccess接口？

答：LinkedList是基于双向链表的存储，存储内存地址并不连续，只能通过指针定位，不能快速访问接口。

### **HashMap源码**

主要用来存放键值对，它是基于哈希表的Map接口实现

Put方法（HashMap插入元素）：

> 如果定位到的数组位置没有元素 就直接插入。
>
> 如果定位到的数组位置有元素就和要插入的 key 比较，如果 key 相同就直接覆盖，如果 key 不相同，就判断 p 是否是一个树节点，如果是就调用`e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value)`将元素添加进入。如果不是就遍历链表插入(插入的是链表尾部)。
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/collection/hashmap-source-code.html

![ ](https://oss.javaguide.cn/github/javaguide/database/sql/put.png)

#### 面试八股

> 面试题：HashMap如何get一个元素?
> 题目分析
> 这一题问的是如何获取HashMap内保存的元素，考察的是HashMap底层原理的掌握。首先要知道，HashMap是如何保存元素的，之后才能够知道如何获取一个元素。
>
> 回答
> 想要在HashMap中获取Get一个元素，需要传入一个Key。
> HashMap会计算这个key的哈希值，并对HashMap的容量进行求余，得到以数组的方式保存的数据中，key所对应的位置。
> 获取到HashMap中key所对应的位置之后，判断那个位置保存的的键的哈希值和键是否等于传入的Key，若相等即找到了想要的元素。
> 若不相等，表示发生了哈希冲突。需要进一步判断对应位置的对象类型是否为TreeNode，若不是，则表示当前位置保存的是链表，否则，表示当前位置保存的是红黑树。
> 若保存的是链表，则从链头开始遍历，直到发现链表中的一个的节点上保存的key等于传入的Key。
> 若保存的是红黑树，则从树中查找节点的key等于传入的key。若查找成功，返回节点保存到值，即为查找结果。
> 若查找失败，返回null。
> ————————————————
> 版权声明：本文为CSDN博主「堂子哥冲鸭」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
> 原文链接：https://blog.csdn.net/wang465745776/article/details/112007184



### **ConcurrentHashMap**

**1.7**

![Java 7 ConcurrentHashMap 存储结构](https://oss.javaguide.cn/github/javaguide/java/collection/java7_concurrenthashmap.png)

线程安全的HashMap，如何实现线程安全？

1.7之前，concurrenthashmap是由16个segment组成的，也就是说，它并发的最大线程数是16个。一个segment之中是hashmap这样的结构。

put过程：

> 由于 `Segment` 继承了 `ReentrantLock`，所以 `Segment` 内部可以很方便的获取锁，put 流程就用到了这个功能。
>
> 1. `tryLock()` 获取锁，获取不到使用 **`scanAndLockForPut`** 方法继续获取。
>
> 2. 计算 put 的数据要放入的 index 位置，然后获取这个位置上的 `HashEntry` 。
>
> 3. 遍历 put 新元素，为什么要遍历？因为这里获取的 `HashEntry` 可能是一个空元素，也可能是链表已存在，所以要区别对待。
>
>    如果这个位置上的 **`HashEntry` 不存在**：
>
>    1. 如果当前容量大于扩容阀值，小于最大容量，**进行扩容**。
>    2. 直接头插法插入。
>
>    如果这个位置上的 **`HashEntry` 存在**：
>
>    1. 判断链表当前元素 key 和 hash 值是否和要 put 的 key 和 hash 值一致。一致则替换值
>    2. 不一致，获取链表下一个节点，直到发现相同进行值替换，或者链表表里完毕没有相同的。 
>       1. 如果当前容量大于扩容阀值，小于最大容量，**进行扩容**。
>       2. 直接链表头插法插入。
>
> 4. 如果要插入的位置之前已经存在，替换后返回旧值，否则返回 null.
>
> 这里面的第一步中的 `scanAndLockForPut` 操作这里没有介绍，这个方法做的操作就是不断的自旋 `tryLock()` 获取锁。当自旋次数大于指定次数时，使用 `lock()` 阻塞获取锁。在自旋时顺表获取下 hash 位置的 `HashEntry`。
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/collection/concurrent-hash-map-source-code.html

get:

> 1. 计算得到 key 的存放位置。
> 2. 遍历指定位置查找相同 key 的 value 值。

**1.8**

![Java8 ConcurrentHashMap 存储结构（图片来自 javadoop）](https://oss.javaguide.cn/github/javaguide/java/collection/java8_concurrenthashmap.png)

put：

> 根据 key 计算出 hashcode 。
>
> 判断是否需要进行初始化。
>
> 即为当前 key 定位出的 Node，如果为空表示当前位置可以写入数据，利用 CAS 尝试写入，失败则自旋保证成功。
>
> 如果当前位置的 `hashcode == MOVED == -1`,则需要进行扩容。
>
> 如果都不满足，则利用 synchronized 锁写入数据。
>
> 如果数量大于 `TREEIFY_THRESHOLD` 则要执行树化方法，在 `treeifyBin` 中会首先判断当前数组长度 ≥64 时才会将链表转换为红黑树。
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/collection/concurrent-hash-map-source-code.html

get:

> 1. 根据 hash 值计算位置。
> 2. 查找到指定位置，如果头节点就是要找的，直接返回它的 value.
> 3. 如果头节点 hash 值小于 0 ，说明正在扩容或者是红黑树，查找之。(find方法查找)
> 4. 如果是链表，遍历查找之。

## 并发编程

### 进程和线程

进程是程序的一次执行过程，是系统运行程序的基本单位

线程与进程相似，但线程是一个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。

**多个线程可以共享进程的堆和方法区资源，但是每个线程都有自己的程序计数器、虚拟机栈和本地方法栈**

![Java 运行时数据区域（JDK1.8 之后）](https://oss.javaguide.cn/github/javaguide/java/jvm/java-runtime-data-areas-jdk1.8.png)



1. 堆和方法区是所有线程共享的资源，其中堆是进程中最大的一块内存，主要用于存放新创建的对象 (几乎所有对象都在这里分配内存)，方法区主要用于存放已被加载的类信息、常量、静态变量、即时编译器编译后的代码等数据。

2. 程序计数器为什么是私有的？

   程序计数器主要是记录上次指令执行到哪里了，如果发生了线程上下文的切换，线程要保证恢复到正确的执行为止。

3. 虚拟机栈和本地方法栈为什么是私有的？

   为了保证线程中的局部变量不被别的线程访问。

4. 堆和方法区

   堆和方法区都是线程锁共享的资源，其中堆事进程中最大的一块内存，主要用于创建新的对象。方法区主要是存放一杯加载的类信息、常量、静态变量、即使编译器编译后的代码等数据

   

可以直接调用Thread类的run方法吗？

> 这是另一个非常经典的 Java 多线程面试问题，而且在面试中会经常被问到。很简单，但是很多人都会答不上来！
>
> new 一个 `Thread`，线程进入了新建状态。调用 `start()`方法，会启动一个线程并使线程进入了就绪状态，当分配到时间片后就可以开始运行了。 `start()` 会执行线程的相应准备工作，然后自动执行 `run()` 方法的内容，这是真正的多线程工作。 但是，直接执行 `run()` 方法，会把 `run()` 方法当成一个 main 线程下的普通方法去执行，并不会在某个线程中执行它，所以这并不是多线程工作。
>
> **总结：调用 `start()` 方法方可启动线程并使线程进入就绪状态，直接执行 `run()` 方法的话不会以多线程的方式执行**
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-01.html

volatile关键字

作用：

1. 保证线程之间变量的可见性
2. 防止指令重排
3. 不能保证原子性，可以用sychornized关键字修饰

> `volatile` 关键字其实并非是 Java 语言特有的，在 C 语言里也有，它最原始的意义就是禁用 CPU 缓存。如果我们将一个变量使用 `volatile` 修饰，这就指示 编译器，这个变量是共享且不稳定的，每次使用它都到主存中进行读取
>
> 禁止指令重排序：
>
> 通过特定的内存屏障实现

双重校验锁实现对象单列：

```java
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public  static Singleton getUniqueInstance() {
       //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
```

CAS算法

> CAS 的全称是 **Compare And Swap（比较与交换）** ，用于实现乐观锁，被广泛应用于各大框架中。CAS 的思想很简单，就是用一个预期值和要更新的变量值进行比较，两值相等才会进行更新。
>
> CAS 是一个原子操作，底层依赖于一条 CPU 的原子指令。
>
> > **原子操作** 即最小不可拆分的操作，也就是说操作一旦开始，就不能被打断，直到操作完成。
>
> CAS 涉及到三个操作数：
>
> - **V**：要更新的变量值(Var)
> - **E**：预期值(Expected)
> - **N**：拟写入的新值(New)
>
> 当且仅当 V 的值等于 E 时，CAS 通过原子方式用新值 N 来更新 V 的值。如果不等，说明已经有其它线程更新了 V，则当前线程放弃更新。
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-02.html

CAS会引起ABA问题

> 如果一个变量 V 初次读取的时候是 A 值，并且在准备赋值的时候检查到它仍然是 A 值，那我们就能说明它的值没有被其他线程修改过了吗？很明显是不能的，因为在这段时间它的值可能被改为其他值，然后又改回 A，那 CAS 操作就会误认为它从来没有被修改过。这个问题被称为 CAS 操作的 **"ABA"问题。**
>
> ABA 问题的解决思路是在变量前面追加上**版本号或者时间戳**。
>
> ------
>
> 著作权归JavaGuide(javaguide.cn)所有 基于MIT协议 原文链接：https://javaguide.cn/java/concurrent/java-concurrent-questions-02.html

sychronized关键字



# 其他面试中出现的问题

幂等性的通俗概念： 调用方，对一个系统进行重复调用（参数全部相同），不论重复调用多少次，这些调用对系统的影响都是相同的效果。

