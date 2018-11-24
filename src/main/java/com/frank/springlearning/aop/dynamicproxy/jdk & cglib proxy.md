### Cglib代理 与 JDK代理区别

1. JDK只能针对有接口的类的接口方法进行动态代理

2. Cglib基于继承来实现代理，无法对static、final类进行代理

3. Cglib基于继承来实现代理，无法对private、static方法进行代理