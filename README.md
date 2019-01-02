#### Lifecycle

###### 使用方式

> 注解方式使用

    详见：TestActivityLifeObserve

> 实现GenericLifecycleObserver接口，重写onStateChanged()方法

    详见：TestLifeObserve1

> 输出结果，Activity、Fragment生命周期函数的调用顺序

    onCreate()
    onStart()
    onResume()
    Activity的生命周期函数先于监听器执行

    onPause()
    onStop()
    onDestroy()
    Activity的生命周期函数后于监听器执行


// 这张图片很重要

![img](/lifecyle.png)

> 对此图片进行分析对应于LifecycleRegistry类中的getStateAfter()方法、downEvent()、upEvent()

###### 相关的类

    Lifecyle：定义了生命周期的中间状态(ing)和结束状态(ed)

    LifecycleObserver：观察者

    GenericLifecycleObserver：观察者，实现LifecycleObserver类，
    最终的事件会回调给onStateChanged()方法

    LifecycleOwner：代表要监听的Activity和Fragment，
    事件的分发者，负责发送事件给LifecycleRegistry

    LifecycleRegistry：控制中心，
    负责接送事件、控制事件的转换、分发事件

    Lifecycling：辅助LifecycleRegistry，
    通过反射的方式来获取对应GenericLifecycleObserver对象

    ReportFragment：添加的一个空的Fragment，
    负责Activity中各个生命周期的监听和分发

    SupportActivity：Activity中继承LifecycleOwner的位置，
    添加监听ReportFragment的位置，
    Activity实现LifecycleRegistry对象的最终位置，
    如果继承SupportActivity父类，而不是其子类，将获取不到对应的LifecycleOwner对象

    Fragment(v4包)：Fragment中继承LifecycleOwner的位置，
    添加监听的位置，在此Fragment中对应的生命周期中来分发事件，
    Fragment中实现LifecycleRegistry对象的最终位置，


###### 原理分析

    a、事件的分发
    1、入口
    需要监听的Activity中添加observer

    getLifecycle().addObserver(new TestActivityLifeObserve());

    从getLifecycle()来获取LifecycleRegistry对象，
    然后调用LifecycleRegistry.addObserver(observe)来绑定观察者，
    observe则是最终事件输出的地方，也是我们在对应的生命周期方法中做相应处理的地方

    addObserver(observe)方法：将观察者对象传入
    1、将LifecycleObserver包装成ObserverWithState对象
    在ObserverWithState对象中包含了LifecycleObserver对象和当前的状态

    2、通过Lifecycling.getCallback(observe)来获取对应GenericLifecycleObserver对象
    Lifecycling通过反射的方式来生成对应的GenericLifecycleObserver对象

    3、计算observe状态，然后通过ObserverWithState.dispatchEvent(LifecycleOwner, Event)来进行分发
    dispatchEvent()内部调用GenericLifecycleObserver.onStateChanged()方法来将状态返回
    这里的GenericLifecycleObserver实际是Lifecycling生成的observe对象
    在Lifecycling生成的observe中如：
    CompositeGeneratedAdaptersObserver
    SingleGeneratedAdapterObserver
    ……
    中的onStateChanged()方法中来调用对应生命周期方法
    onCreate()、onStart()……
    /**此处可以通过打断点来验证**/

    4、同步状态

    b、事件的起点
    1、在SupportActivity的onCreate()方法中
    ReportFragment.injectIfNeededIn(this);
    在SupportActivity中添加了ReportFragment，
    然后ReportFragment在Activity生命周期执行的时候会执行自己对应的方法

    2、ReportFragment中的生命周期方法中会调用
    dispatch(Lifecycle.Event.**);

    3、dispatch(Lifecycle.Event.***)：
    调用Fragment.getActivity()对象，获取当前的Activity，
    然后Activity.getLifecycle()获取LifecycleRegistry对象，
    然后调用LifecycleRegistry.handleLifecycleEvent(event);
    然后回到LifecycleRegistry类中进行生命周期事件的分发


    Activity会先创建ReportFragment，
    然后调用getLifecycle().addObserver(new TestActivityLifeObserve())中第一次事件分发
    INITIALIZED
    当Activity创建完成ReportFragment会回调onActivityCreated()方法进行第二次事件分发
    CREATED
    ……以此类推

    使用ReportFragment来分发生命周期消息的方式
    1、避免代码侵入性太强
    2、Fragment的生命周期创建的过程符合Activity中消息分发的过程
    Fragment的生命周期
        onCreate()
        onStart()
        onResume()
        Activity的生命周期函数先于Fragment对应的生命周期函数执行

        onPause()
        onStop()
        onDestroy()
        Activity的生命周期函数后于Fragment对应的生命周期函数执行




