1. volatiled 
2. sychronized 同步

#### 问题描述
你需要保护某些数据不被多个线程访问。
#### 解决方案
在你需要保护的代码块上使用 synchronized 关键字。
#### 讨论
这个关键字使得在一个实例中，一次只允许一个线程运行被修饰的代码块。

3. java.util.concurrent.locks 锁机制简化同步
#### 问题描述
你希望用一种更容易的方式同步线程。
#### 解决方案
使用 java.util.concurrent.locks 中的锁机制



### Reference List
[1] JLS, https://docs.oracle.com/javase/specs/jls/se16/html/jls-17.html#jls-17.4