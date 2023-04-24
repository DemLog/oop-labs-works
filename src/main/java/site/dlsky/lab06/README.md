Дана программа, завершающаяся ошибкой:

```java
package com.example;

public class Main extends Thread {

    public int someMethod(String number) {
        return Integer.parseInt(number);
    }

    public void run() {
        try {
            System.out.println(someMethod("hello"));
        } catch (RuntimeException e) {
            throw new IllegalStateException("cannot perform operation", e);
        }
    }

    public static void execute() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        Main m = new Main();
        m.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Throwable mergedException = ExceptionUtil.merge(e, stackTrace);
                mergedException.printStackTrace();
            }
        });
        m.start();
    }

    public static void main(String[] args) throws Throwable {
        Main.class.getDeclaredMethod("execute").invoke(null);
    }
}
```

Реализовать класс ExceptionUtil, который обновляет stacktrace каждого исключения в цепочке, прибавляя к нему стек вызовов основного потока.

Результат выполнения программы должен выглядеть следующим образом: (обратите внимание на 3 строку, такой нет в стектрейсах, поэтому нужно добавлять ее специально)

```bash
java.lang.IllegalStateException: cannot perform operation
    at com.example.Main.run(Main.java:13)
    at <Thread.start>()
    at com.example.Main.execute(Main.java:18)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:564)
    at com.example.Main.main(Main.java:32)
Caused by: java.lang.NumberFormatException: For input string: "hello"
    at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:68)
    at java.base/java.lang.Integer.parseInt(Integer.java:652)
    at java.base/java.lang.Integer.parseInt(Integer.java:770)
    at com.example.Main.someMethod(Main.java:6)
    at com.example.Main.run(Main.java:11)
    ... 7 more
```