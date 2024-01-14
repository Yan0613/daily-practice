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

为什么hashmap线程不安全？

1,7

hashmap扩容时，对table扩容到newTable之后，需要将原来的数据转移到newtable中，在转移元素的过程中使用头插法，也就是链表的顺序会翻转。

1.8

这是jdk1.8中HashMap中put操作的主函数， 注意第6行代码，如果没有hash碰撞则会直接插入元素。如果线程A和线程B同时进行put操作，刚好这两条不同的数据hash值一样，并且该位置数据为null，所以这线程A、B都会进入第6行代码中。假设一种情况，线程A进入后还未进行数据插入时挂起，而线程B正常执行，从而正常插入数据，然后线程A获取CPU时间片，此时线程A不用再进行hash判断了，问题出现：线程A会把线程B插入的数据给**覆盖**，发生线程不安全。

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

### 创建线程的方式（三种）

1. 继承Thred
2. callable接口
3. runnable接口

2 和 3 有什么区别？



### volatile关键字

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

### CAS算法

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

### sychronized关键字

构造方法不能用suchronized修饰

`ynchronized` 同步语句块的实现使用的是 `monitorenter` 和 `monitorexit` 指令，其中 `monitorenter` 指令指向同步代码块的开始位置，`monitorexit` 指令则指明同步代码块的结束位置。

当执行monitorenter指令时，线程试图获取锁也就是获取对象监视器monitor的持有权。

![执行 monitorenter 获取锁](https://oss.javaguide.cn/github/javaguide/java/concurrent/synchronized-get-lock-code-block.png)

对象锁的的拥有者线程才可以执行 `monitorexit` 指令来释放锁。在执行 `monitorexit` 指令后，将锁计数器设为 0，表明锁被释放，其他线程可以尝试获取锁。

![执行 monitorexit 释放锁](https://oss.javaguide.cn/github/javaguide/java/concurrent/synchronized-release-lock-block.png)

### 锁升级

### Sychronied和volatile有什么区别

`synchronized` 关键字和 `volatile` 关键字是两个互补的存在，而不是对立的存在！

- `volatile` 关键字是线程同步的轻量级实现，所以 `volatile`性能肯定比`synchronized`关键字要好 。但是 `volatile` 关键字只能用于变量而 `synchronized` 关键字可以修饰方法以及代码块 。
- `volatile` 关键字能保证数据的可见性，但不能保证数据的原子性。`synchronized` 关键字两者都能保证。
- `volatile`关键字主要用于解决变量在多个线程之间的可见性，而 `synchronized` 关键字解决的是多个线程之间访问资源的同步性

### ReentrantLock

ReentrantLock 实现了 Lock 接口，是一个可重入且独占式的锁，和 synchronized 关键字类似。不过，ReentrantLock 更灵活、更强大，增加了轮询、超时、中断、公平锁和非公平锁等高级功能。

### AQS

抽象队列同步器

> AQS 核心思想是，如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，这个机制 AQS 是用 **CLH 队列锁** 实现的，即将暂时获取不到锁的线程加入到队列中。
>
> CLH(Craig,Landin,and Hagersten) 队列是一个虚拟的双向队列（虚拟的双向队列即不存在队列实例，仅存在结点之间的关联关系）。AQS 是将每条请求共享资源的线程封装成一个 CLH 锁队列的一个结点（Node）来实现锁的分配。在 CLH 同步队列中，一个节点表示一个线程，它保存着线程的引用（thread）、 当前节点在队列中的状态（waitStatus）、前驱节点（prev）、后继节点（next）
>
> CLH结构：
>
> ![img](https://oss.javaguide.cn/p3-juejin/40cb932a64694262993907ebda6a0bfe~tplv-k3u1fbpfcp-zoom-1.png)
>
> AQS核心原理图
>
> ![img](https://oss.javaguide.cn/github/javaguide/java/CLH.png)

### ThreadLocal

实现每一个线程都有自己的专属本地变量

ThreadLocal类主要解决的就是让每个线程绑定自己的值，可以将ThreadLocal类形象的比喻成存放数据的盒子，盒子中可以存储每个线程的私有数据。**如果你创建了一个ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的本地副本**，这也是ThreadLocal变量名的由来。他们可以使用 get() 和 set() 方法来获取默认值或将其值更改为当前线程所存的副本的值，从而避免了线程安全问题。

使用线程池的好处：

1. 降低资源消耗，通过重复利用已创建的线程降低线程创建和销毁过程中造成的消耗
2. 提高相应速度，当任务到达时，任务可以不需要等到线程创建就能执行
3. 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，会消耗系统资源，还会降低系统稳定性

线程池的核心参数：

**`ThreadPoolExecutor` 3 个最重要的参数：**

- **`corePoolSize` :** 任务队列未达到队列容量时，最大可以同时运行的线程数量。
- **`maximumPoolSize` :** 任务队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
- **`workQueue`:** 新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。

`ThreadPoolExecutor`其他常见参数 :

- **`keepAliveTime`**:线程池中的线程数量大于 `corePoolSize` 的时候，如果这时没有新的任务提交，多余的空闲线程不会立即销毁，而是会等待，直到等待的时间超过了 `keepAliveTime`才会被回收销毁，线程池回收线程时，会对核心线程和非核心线程一视同仁，直到线程池中线程的数量等于 `corePoolSize` ，回收过程才会停止。
- **`unit`** : `keepAliveTime` 参数的时间单位。
- **`threadFactory`** :executor 创建新线程的时候会用到。
- **`handler`** :饱和策略。关于饱和策略下面单独介绍一下。

![线程池各个参数的关系](https://javaguide.cn/assets/%E7%BA%BF%E7%A8%8B%E6%B1%A0%E5%90%84%E4%B8%AA%E5%8F%82%E6%95%B0%E4%B9%8B%E9%97%B4%E7%9A%84%E5%85%B3%E7%B3%BB-JlZBQPFq.png)

如何创建线程池？

ThreadPoolExecutor

### JMM(Java内存模型)

一般来说，编程语言可以直接复用操作系统层面的内存模型，但是不同操作系统的内存模型不同，但是Java语言是跨平台的，所以它提供一套自己的内存模型以屏蔽系统的差异。JMM可以看做是Java定义的并发编程相关的一组规范。

JMM如何抽象线程和主内存之间的关系？

线程可以把变量保存在本地内存中，而不是直接在主内存中进行读写。

**什么是主内存？什么是本地内存？**

- **主内存**：所有线程创建的实例对象都存放在主内存中，不管该实例对象是成员变量，还是局部变量，类信息、常量、静态变量都是放在主内存中。为了获取更好的运行速度，虚拟机及硬件系统可能会让工作内存优先存储于寄存器和高速缓存中。
- **本地内存**：每个线程都有一个私有的本地内存，本地内存存储了该线程以读 / 写共享变量的副本。每个线程只能操作自己本地内存中的变量，无法直接访问其他线程的本地内存。如果线程间需要通信，必须通过主内存来进行。本地内存是 JMM 抽象出来的一个概念，并不真实存在，它涵盖了缓存、写缓冲区、寄存器以及其他的硬件和编译器优化。

Java 内存模型的抽象示意图如下：

![JMM(Java 内存模型)](https://oss.javaguide.cn/github/javaguide/java/concurrent/jmm.png)

从上图来看，线程 1 与线程 2 之间如果要进行通信的话，必须要经历下面 2 个步骤：

1. 线程 1 把本地内存中修改过的共享变量副本的值同步到主内存中去。
2. 线程 2 到主存中读取对应的共享变量的值。

也就是说，JMM 为共享变量提供了可见性的保障。

### CopyOnWriteArrayList

`CopyOnWriteArrayList` 线程安全的核心在于其采用了 **写时复制（Copy-On-Write）** 的策略，从 `CopyOnWriteArrayList` 的名字就能看出了。

当需要修改（ `add`，`set`、`remove` 等操作） `CopyOnWriteArrayList` 的内容时，不会直接修改原数组，而是会先创建底层数组的副本，对副本数组进行修改，修改完之后再将修改后的数组赋值回去，这样就可以保证写操作不会影响读操作了。

## IO

### NIO

NIO 主要包括以下三个核心组件：

- **Buffer（缓冲区）**：NIO 读写数据都是通过缓冲区进行操作的。读操作的时候将 Channel 中的数据填充到 Buffer 中，而写操作时将 Buffer 中的数据写入到 Channel 中。
- **Channel（通道）**：Channel 是一个双向的、可读可写的数据传输通道，NIO 通过 Channel 来实现数据的输入输出。通道是一个抽象的概念，它可以代表文件、套接字或者其他数据源之间的连接。
- **Selector（选择器）**：允许一个线程处理多个 Channel，基于事件驱动的 I/O 多路复用模型。所有的 Channel 都可以注册到 Selector 上，由 Selector 来分配线程来处理事件。
- ![Buffer、Channel和Selector三者之间的关系](https://oss.javaguide.cn/github/javaguide/java/nio/channel-buffer-selector.png)

![image-20240114143225008](C:\Users\10203\AppData\Roaming\Typora\typora-user-images\image-20240114143225008.png)



# MySql

### 如何定位慢查询

开启日志

slow query log = true

slow query time = 2

### 如何分析慢查询语句

EXPLAIN 分析

TYPE 字段看看是不是可以优化

KEY字段查看是不是命中了全部的索引

### 索引底层结构（B+）

B树有多个分叉，形状上面看是矮胖的

B+树只在叶子节点存储数据。

1） B+树非叶子节点上是不存储数据的，仅存储键值，这么做是因为在数据库中页的大小是固定的，innodb中页的默认大小是16KB。如果不存储数据，那么就会存储更多的键值，相应的树的阶数（节点的子节点树）就会更大，树就会更矮更胖，如此一来我们查找数据进行磁盘的IO次数有会再次减少。

2） B+树的阶数是等于键值的数量，如果我们的B+树一个节点可以存储1000个键值，那么3层B+树可以存储1000×1000×1000=10亿个数据。一般根节点是常驻内存的，所以一般我们查找10亿数据，只需要2次磁盘IO。

3）因为B+树索引的所有数据均存储在叶子节点，而且数据是按照顺序排列的。那么B+树使得范围查找，排序查找，分组查找以及去重查找变得非常简单。

4） B+树中各个页之间是通过双向链表连接的，叶子节点中的数据是通过单向链表连接的

> （3）执行select * from user where name = ‘jim’ 的执行过程
>
> 根节点是常驻内存的，也就是说页1已经在内存中了，从内存中读取到页1，根据指针P1定位到页2
> 根据页2中的P2指针定位到页6
> 比较找到索引对应的值为jim，同时获取到主键为20
> 在根据20这个主键到主键索引中获取到这个叶子节点中存储的行数据。
> ————————————————
> 版权声明：本文为CSDN博主「Perley620」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
> 原文链接：https://blog.csdn.net/Pireley/article/details/133931413

### 簇集索引和非簇集索引

簇集索引：将数据存储与索引放在一块，索引结构的叶子节点保存了行数据。

二级索引：将数据与索引分开存储，索引结构的叶子节点关联的是对应的主键

回表：通过二级索引查找到对应的主键值，然后通过主键值找到聚集索引中所对应的整行数据，这个过程就是回表。

### 覆盖索引

指的是查询引用了索引，并且需要返回的列能在该索引中全部找到。

应用：MySql超大分页处理

先分页查询数据的ID字段，然后确定了id之后通过子查询过滤，只要查询这个id列表中的数据就可以了，因为查询id的时候，走的是覆盖索引，所以效率会提升很多。

```mysql
select *
from tb_sku t,
	(select id from tb_sku order_by id limit 9000000,10) a
where t.id = a.id;
```

**对比**

```mysql
select * from tb_sku limit 9000000,10;
```

### 什么情况下索引会失效

1. 违反最左前缀法则

   查询要从索引的最左前列开始，并且不跳过索引中的列。

2. 范围查询右边的列不能使用索引

```mysql
select * from tb_seller where name = '小米科技' and status = '1' and address  = '北京市';
```

↑走索引

```mysql
select * from tb_seller where name = '小米科技' and status > '1' and address = '北京市';
```

↑最后一个不走索引

3. 索引上进行了运算操作
4. 字符串不加单引号，因为MySql的查询优化器会自动进行类型转换。
5. 以%开头的模糊查询

### MVCC

隔离级别：

读未提交 读已提交 可重复读 串行化

为什么可重复读没有完全解决幻读？

可重复读没有完美的解决幻读，对于select（快照读）不会产生幻读，但对于update（当前读）会产生幻读

> **幻读是指在一个事务中，由于其他事务插入了新的数据行，导致该事务在两次读取之间看到了不同数量的数据行。可重复读可以通过锁定读取的数据行来避免同一事务中的幻读，但无法防止其他事务插入新的数据行，从而引发幻读问题**

MySql中事务的隔离性是如何保证的？

1. 锁：排它锁。 一个事物获取了一个数据行的排他锁，其他的事务就不能再获取该行的排它锁
2. MVCC多并发版本控制

它的实现主要以来数据库中记录的隐式字段、undo log , redaView

在mysql中给每个表都设定了隐藏字段，有一个是trx_id事务id，记录每次操作的事务的id，是自增的，另一个是roll_pointer 回滚指针，指向上一个版本的事务版本记录地址

undo_log主要的作用是记录回滚日志，存储老版本数据，在内部会形成一个版本链，在多个事务并行操作某一行记录，记录不同事务修改数据的版本，通过roll_pointer指针形成一个链表。

readView解决的事一个事物查询版本的问题，在内部定义了一些匹配规则和当前的一些事务id判断该访问哪个版本的数据。不同隔离级别的快照读不同，最终访问结构也不同，如果是rc隔离级别，每一次执行快照读生成readView，如果是RR隔离级别只在事务中第一次执行快照读时生成readView，后续复用

### SQL优化

1. UNION ALL 代替 UNION

2. SQL避免索引失效

3. 避免在Where字段对表达式进行操作

4. Select语句指明字段名称

5. Join优化， 能用INNNER JOIN 就不用 left join 和 right join
6. 设置合适的数值
7. 设置合适的字符串类型，char定长效率高， varchar可变长度效率更低

# Redis

### 常见数据结构：

1. **字符串（String）：** 用于存储文本、数字等简单数据。常见的用途包括缓存、计数器等。
2. **哈希表（Hash）：** 适用于存储对象的多个字段和值，常用于表示对象或配置信息。
3. **列表（List）：** 有序的字符串元素集合，支持在两端进行添加或删除元素，常用于实现队列、栈等数据结构。
4. **集合（Set）：** 无序的字符串元素集合，不允许重复的成员存在，常用于存储唯一值，如用户标签。
5. **有序集合（Sorted Set）：** 类似于集合，但每个成员都关联一个分数，用于排序元素。常用于排行榜等场景。

### 穿透、击穿、雪崩

穿透：查询一个不存在的数据，在缓存中查询不到的时候就会直接访问数据库

解决方案：布隆过滤器、不存在的话就把value设置为Null 不好

击穿：对于设置了过期时间的key， 缓存在某个时间点过期的时候恰好有大量对这个key的请求发了过来。

解决方案：互斥锁，失效的时候先用setnx去设置一个互斥锁，当操作成功返回的死后再load db，否则重试get缓存的方法。

设置当前key的过期逻辑

# 设计模式

## 工厂、简单工厂

## 适配器模式

## 注册器模式

## 观察者模式



# 框架类

## SpringMVC 



## Bean的生命周期

## 三级缓存

# 其他面试中出现的问题

## 幂等性

的通俗概念： 调用方，对一个系统进行重复调用（参数全部相同），不论重复调用多少次，这些调用对系统的影响都是相同的效果。

## Mysql死锁

表级锁和全局锁会出现死锁

死锁归根结底是由于并发请求造成的，解决死锁可以从两方面入手

1. 缓存去重，可以在Service层加一层缓存，把重复的请求给过滤掉，确保只放入一个请求进入。
2. 异常捕获。Mysql有自己的死锁检测和恢复机制。够把死锁异常catch。

## 如何设计一个秒杀系统？

