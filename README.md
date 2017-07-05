# Android 样式开发2

* [drawable](#drawable)
    * [普通图片](#普通图片)
    * [bitmap](#bitmap)
    * [点9图片](#点9图片)
    * [color](#color)
    * [inset](#inset)
    * [clip](#clip)
    * [scale](#scale)
    * [level-list](#level-list)
    * [transition](#transition)
    * [rotate](#rotate)
    * [animation-list](#animation-list)
    * [animated-rotate](#animated-rotate)
* [ViewAnimation](#viewanimation)
    * [alpha](#alpha)
    * [scale](#scale)
    * [translate](#translate)
    * [rotate](#rotate)
    * [set](#set)
    * [通用属性](#通用属性)
    * [interpolator](#interpolator)
* [PropertyAnimation](#propertyanimation)
    * [animator](#animator)
    * [objectAnimator](#objectanimator)
    * [set](#set)
* [style](#style)
* [参考网址](#参考网址)


## drawable

### 普通图片
图片是最常用的drawable资源，格式包括：png(推荐)、jpg(可接受)、gif(不建议)


### bitmap
可以通过bitmap标签对图片做一些设置，如平铺、拉伸或保持图片原始大小，也可以指定对齐方式

bitmap标签有：
* android:src 必填项，指定图片资源，只能是图片，不能是xml定义的drawable资源
* android:gravity 设置图片的对齐方式，比如在layer-list中，默认会尽量填满整个视图，导致图片可能会被拉伸，为了避免被拉伸，就可以设置对齐方式，可取值为下面的值，多个取值可以用 | 分隔：
    * top 图片放于容器顶部，不改变图片大小
    * bottom 图片放于容器底部，不改变图片大小
    * left 图片放于容器左边，不改变图片大小
    * right 图片放于容器右边，不改变图片大小
    * center 图片放于容器中心位置，包括水平和垂直方向，不改变图片大小
    * fill 拉伸整张图片以填满容器的整个高度和宽度，默认值
    * center_vertical 图片放于容器垂直方向的中心位置，不改变图片大小
    * center_horizontal 图片放于容器水平方向的中心位置，不改变图片大小
    * fill_vertical 在垂直方向上拉伸图片以填满容器的整个高度
    * fill_horizontal 在水平方向上拉伸图片以填满容器的整个宽度
    * clip_vertical 附加选项，裁剪基于垂直方向的gravity设置，设置top时会裁剪底部，设置bottom时会裁剪顶部，其他情况会同时裁剪顶部和底部
    * clip_horizontal 附加选项，裁剪基于水平方向的gravity设置，设置left时会裁剪右侧，设置right时会裁剪左侧，其他情况会同时裁剪左右两侧
* android:antialias 设置是否开启抗锯齿
* android:dither 设置是否抖动，图片与屏幕的像素配置不同时会用到，比如图片是ARGB 8888的，而屏幕是RGB565
* android:filter 设置是否允许对图片进行滤波，对图片进行收缩或者延展使用滤波可以获得平滑的外观效果
* android:tint 给图片着色，比如图片本来是黑色的，着色后可以变成白色
* android:tileMode 设置图片平铺的方式，取值为下面四种之一：
    * disable 不做任何平铺，默认设置
    * repeat 图片重复铺满
    * mirror 使用交替镜像的方式重复图片的绘制
    * clamp 复制图片边缘的颜色来填充容器剩下的空白部分，比如引入的图片如果是白色的边缘，那么图片所在的容器里除了图片，剩下的空间都会被填充成白色
* android:alpha 设置图片的透明度，取值范围为0.0~1.0之间，0.0为全透明，1.0为全不透明，API Level最低要求是11，即Android 3.0
* android:mipMap 设置是否可以使用mipmap，但API Level最低要求是17，即Android 4.2
* android:autoMirrored 设置图片是否需要镜像反转，当布局方向是RTL，即从右到左布局时才有用，API Level 19(Android 4.4)才添加的属性
* android:tileModeX 和tileMode一样设置图片的平铺方式，只是这个属性只设置水平方向的平铺方式，这是API Level 21(Android 5.0)才添加的属性
* android:tileModeY 和tileMode一样设置图片的平铺方式，只是这个属性只设置垂直方向的平铺方式，这是API Level 21(Android 5.0)才添加的属性
* android:tintMode 着色模式，也是API Level 21(Android 5.0)才添加的属性

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<bitmap xmlns:android="http://schemas.android.com/apk/res/android"
    android:src="@drawable/img_arrow_down"
    android:tint="#000">
</bitmap>
```

### 点9图片
点九图片文件扩展名为：.9.png，通过点九图片可以做局部拉伸

nine-patch标签的属性：
* android:src 必填项，必须指定点九类型的图片
* android:dither 设置是否抖动，图片与屏幕的像素配置不同时会用到，比如图片是ARGB 8888的，而屏幕是RGB565
* android:tint 给图片着色，比如图片本来是黑色的，着色后可以变成白色
* android:tintMode 着色模式，API Level 21(Android 5.0)才添加的属性
* android:alpha 设置图片的透明度，取值范围为0.0~1.0之间，0.0为全透明，1.0为全不透明，API Level最低要求是11
* android:autoMirrored 设置图片是否需要镜像反转，当布局方向是RTL，即从右到左布局时才有用，API Level 19(Android 4.4)才添加的属性


### color
color标签是drawable里最简单的标签了，只有一个属性：android:color，指定颜色值
这个标签一般很少用
颜色值一般都在colors.xml文件中定义


### inset
使用inset标签可以对drawable设置边距，其用法和View的padding类似，只不过padding是设置内容与边界的距离，而inset则可以设置背景drawable与View边界的距离。inset标签的可设置属性如下：

* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:visible 设置初始的可见性状态，默认为false
* android:insetLeft 左边距
* android:insetRight 右边距
* android:insetTop 顶部边距
* android:insetBottom 底部边距
* android:inset 设置统一边距，会覆盖上面四个属性，但API Level要求为21，即Android 5.0


### clip
使用clip标签可以对drawable进行裁剪，在做进度条时很有用。通过设置level值控制裁剪多少，level取值范围为0~10000，默认为0，表示完全裁剪，图片将不可见；10000则完全不裁剪，可见完整图片。看看clip标签可以设置的属性：

* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:clipOrientation 设置裁剪的方向，取值为以下两个值之一：
    * horizontal 在水平方向上进行裁剪，条状的进度条就是水平方向的裁剪
    * vertical 在垂直方向上进行裁剪
* android:gravity 设置裁剪的位置，可取值如下，多个取值用 | 分隔：
    * top 图片放于容器顶部，不改变图片大小。当裁剪方向为vertical时，会裁掉图片底部
    * bottom 图片放于容器底部，不改变图片大小。当裁剪方向为vertical时，会裁掉图片顶部
    * left 图片放于容器左边，不改变图片大小，默认值。当裁剪方向为horizontal，会裁掉图片右边部分
    * right 图片放于容器右边，不改变图片大小。当裁剪方向为horizontal，会裁掉图片左边部分
    * center 图片放于容器中心位置，包括水平和垂直方向，不改变图片大小。当裁剪方向为horizontal时，会裁掉图片左右部分；当裁剪方向为vertical时，会裁掉图片上下部分
    * fill 拉伸整张图片以填满容器的整个高度和宽度。这时候图片不会被裁剪，除非level设为了0，此时图片不可见
    * center_vertical 图片放于容器垂直方向的中心位置，不改变图片大小。裁剪和center时一样
    * center_horizontal 图片放于容器水平方向的中心位置，不改变图片大小。裁剪和center时一样
    * fill_vertical 在垂直方向上拉伸图片以填满容器的整个高度。当裁剪方向为vertical时，图片不会被裁剪，除非level设为了0，此时图片不可见
    * fill_horizontal 在水平方向上拉伸图片以填满容器的整个宽度。当裁剪方向为horizontal时，图片不会被裁剪，除非level设为了0，此时图片不可见
    * clip_vertical 附加选项，裁剪基于垂直方向的gravity设置，设置top时会裁剪底部，设置bottom时会裁剪顶部，其他情况会同时裁剪顶部和底部
    * clip_horizontal 附加选项，裁剪基于水平方向的gravity设置，设置left时会裁剪右侧，设置right时会裁剪左侧，其他情况会同时裁剪左右两侧
    


### scale
使用scale标签可以对drawable进行缩放操作，和clip一样是通过设置level来控制缩放的比例。scale标签可以设置的属性如下：

* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:scaleHeight 设置可缩放的高度，用百分比表示，格式为XX%，0%表示不做任何缩放，50%表示只能缩放一半
* android:scaleWidth 设置可缩放的宽度，用百分比表示，格式为XX%，0%表示不做任何缩放，50%表示只能缩放一半
* android:scaleGravity 设置drawable缩放后的位置，取值和bitmap标签的一样，就不一一列举说明了，不过默认值是left
* android:useIntrinsicSizeAsMinimum 设置drawable原有尺寸作为最小尺寸，设为true时，缩放基本无效，API Level最低要求为11


### level-list
当需要在一个View中显示不同图片的时候，比如手机剩余电量不同时显示的图片不同，level-list就可以派上用场了。level-list可以管理一组drawable，每个drawable设置一组level范围，最终会根据level值选取对应的drawable绘制出来。level-list通过添加item子标签来添加相应的drawable，其下的item只有三个属性：

* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:minLevel 该item的最小level值
* android:maxLevel 该item的最大level值

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<level-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/wifi01"
        android:maxLevel="25"/>
    <item
        android:drawable="@drawable/wifi02"
        android:maxLevel="50"/>
    <item
        android:drawable="@drawable/wifi03"
        android:maxLevel="75"/>
    <item
        android:drawable="@drawable/wifi04"
        android:maxLevel="100"/>
</level-list>
```
```
final ImageView ivLevelListWifi = (ImageView)findViewById(R.id.iv_level_list_wifi);
        ivLevelListWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                levelListNum += 25;
                if(levelListNum > 100)
                    levelListNum = 25;
                ivLevelListWifi.getDrawable().setLevel(levelListNum);
            }
        });
```
level包括最大maxLevel


### transition
transition其实是继承自layer-list的，只是，transition只能管理两层drawable，另外提供了两层drawable之间切换的方法，切换时还会有淡入淡出的动画效果。

transition标签生成的Drawable对应的类为TransitionDrawable，要切换时，需要主动调用TransitionDrawable的startTransition()方法，参数为动画的毫秒数，也可以调用reverseTransition()方法逆向切换。

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<transition xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/toggle_off"/>
    <item android:drawable="@drawable/toggle_on"/>
</transition>
```
```
final ImageView ivTransitionToggle = (ImageView)findViewById(R.id.iv_transition_toggle);
final TransitionDrawable transitionDrawable = (TransitionDrawable) ivTransitionToggle.getDrawable();
ivTransitionToggle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(isTransitionToggle){
            transitionDrawable.startTransition(500);
        }else{
            transitionDrawable.reverseTransition(500);
        }
        isTransitionToggle = !isTransitionToggle;
    }
});
```


### rotate
使用rotate标签可以对一个drawable进行旋转操作，在shape篇讲环形时最后举了个进度条时就用到了rotate标签。另外，比如你有一张箭头向上的图片，但你还需要一个箭头向下的图片，这时就可以使用rotate将向上的箭头旋转变成一张箭头向下的drawable。
rotate标签：
* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:fromDegrees 起始的角度度数
* android:toDegrees 结束的角度度数，正数表示顺时针，负数表示逆时针
* android:pivotX 旋转中心的X坐标，浮点数或是百分比。浮点数表示相对于drawable的左边缘距离单位为px，如5; 百分比表示相对于drawable的左边缘距离按百分比计算，如5%; 另一种百分比表示相对于父容器的左边缘，如5%p; 一般设置为50%表示在drawable中心
* android:pivotY 旋转中心的Y坐标
* android:visible 设置初始的可见性状态，默认为false

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<rotate xmlns:android="http://schemas.android.com/apk/res/android"
    android:drawable="@drawable/img_arrow_down"
    android:pivotX="50%"
    android:pivotY="50%"
    android:fromDegrees="180">

</rotate>
```


### animation-list
通过animation-list可以将一系列drawable构建成帧动画，就是将一个个drawable，一帧一帧的播放。通过添加item子标签设置每一帧使用的drawable资源，以及每一帧持续的时间。

animation-list标签有：
* android:oneshot属性设置是否循环播放，设为true时，只播放一轮就结束，设为false时，则会轮询播放
* android:duration属性设置该帧持续的时间，以毫秒数为单位。

animation-list对应的Drawable类为AnimationDrawable，要让动画运行起来，需要主动调用AnimationDrawable的start()方法。另外，如果在Activity的onCreate()方法里直接调用start()方法会没有效果，因为view还没有初始化完成是播放不了动画的。

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"
    android:oneshot="false">
    <item
        android:drawable="@drawable/wifi01"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/wifi02"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/wifi03"
        android:duration="1000"/>
    <item
        android:drawable="@drawable/wifi04"
        android:duration="1000"/>
</animation-list>
```
```
ImageView ivAnimationListWifi = (ImageView) findViewById(R.id.iv_animation_list_wifi);
final AnimationDrawable animationDrawable = (AnimationDrawable) ivAnimationListWifi.getDrawable();
ivAnimationListWifi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(!isAnimationListWifi){
            animationDrawable.start();
        }else{
            animationDrawable.stop();
        }
        isAnimationListWifi = !isAnimationListWifi;
    }
});
```


### animated-rotate
rotate标签只是将原有的drawable转个角度变成另一个drawable，它是静态的。而animated-rotate则会让drawable不停地做旋转动画。
animated-rotate标签属性有：
* android:drawable 指定drawable资源，如果不设置该属性，也可以定义drawable类型的子标签
* android:pivotX 旋转中心的X坐标
* android:pivotY 旋转中心的Y坐标
* android:visible 设置初始的可见性状态，默认为false

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<animated-rotate xmlns:android="http://schemas.android.com/apk/res/android"
    android:drawable="@drawable/img_arrow_down"
    android:pivotX="50%"
    android:pivotY="50%"
    android:visible="false">

</animated-rotate>
```



## ViewAnimation
视图动画，只能应用于各种View，可以做一些位置、大小、旋转和透明度的简单转变
视图动画可以通过xml文件定义，xml文件放于res/anim/目录下，根元素可以为：<alpha>, <scale>, <translate>, <rotate>, 或者<set>。
其中，<set>标签定义的是动画集，它可以包含多个其他标签，也可以嵌套<set>标签。
默认情况下，所有动画会同时播放；如果想按顺序播放，则需要指定startOffset属性；另外，还可以通过设置interpolator改变动画变化的速率，比如匀速、加速。


### alpha
alpha可以实现透明度渐变的动画效果，也就是淡入淡出的效果
* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:fromAlpha 动画开始时的透明度，0.0为全透明，1.0为不透明，默认为1.0
* android:toAlpha 动画结束时的透明度，0.0为全透明，1.0为不透明，默认为1.0

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<alpha xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromAlpha="0.0"
    android:toAlpha="1.0"
    android:duration="1000">

</alpha>
```
```
ivAlphaArrow.startAnimation(AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.alpha_arrow));
```


### scale
scale可以实现缩放的动画效果
* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:fromXScale 动画开始时X坐标上的缩放尺寸
* android:toXScale 动画结束时X坐标上的缩放尺寸
* android:fromYScale 动画开始时Y坐标上的缩放尺寸
* android:toYScale 动画结束时Y坐标上的缩放尺寸

以上四个属性，0.0表示缩放到没有，1.0表示正常无缩放，小于1.0表示收缩，大于1.0表示放大

* android:pivotX 缩放时的固定不变的X坐标，一般用百分比表示，0%表示左边缘，100%表示右边缘
* android:pivotY 缩放时的固定不变的Y坐标，一般用百分比表示，0%表示顶部边缘，100%表示底部边缘

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<scale xmlns:android="http://schemas.android.com/apk/res/android"
    android:fromXScale="1.0"
    android:fromYScale="1.0"
    android:toXScale="0.0"
    android:toYScale="0.0"
    android:duration="1000"
    android:pivotX="50%"
    android:pivotY="50%">

</scale>
```
```
ivScaleArrow.startAnimation(AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.scale_arrow));
```


### translate
translate可以实现位置移动的动画效果，可以是垂直方向的移动，也可以是水平方向的移动。
坐标的值可以有三种格式：
1. 从-100到100，以"%"结束，表示相对于View本身的百分比位置；
2. 如果以"%p"结束，表示相对于View的父View的百分比位置；
3. 如果没有任何后缀，表示相对于View本身具体的像素值。

属性有：
* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:fromXDelta 起始位置的X坐标的偏移量
* android:toXDelta 结束位置的X坐标的偏移量
* android:fromYDelta 起始位置的Y坐标的偏移量
* android:toYDelta 结束位置的Y坐标的偏移量

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<translate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000"
    android:fromXDelta="0"
    android:fromYDelta="0"
    android:toXDelta="100%"
    android:toYDelta="100%">

</translate>
```
```
ivTranslateArrow.startAnimation(AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.translate_arrow));
```


### rotate
rotate可以实现旋转的动画效果

* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:fromDegrees 旋转开始的角度
* android:toDegrees 旋转结束的角度
* android:pivotX 旋转中心点的X坐标，纯数字表示相对于View本身左边缘的像素偏移量；带"%"后缀时表示相对于View本身左边缘的百分比偏移量；带"%p"后缀时表示相对于父View左边缘的百分比偏移量
* android:pivotY 旋转中心点的Y坐标，纯数字表示相对于View本身顶部边缘的像素偏移量；带"%"后缀时表示相对于View本身顶部边缘的百分比偏移量；带"%p"后缀时表示相对于父View顶部边缘的百分比偏移量

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<rotate xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000"
    android:fromDegrees="0"
    android:toDegrees="360"
    android:pivotX="50%"
    android:pivotY="50%">

</rotate>
```
```
ivRotateArrow.startAnimation(AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.rotate_arrow));
```


### set
set标签可以将多个动画组合起来，变成一个动画集

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000">
    <alpha
        android:fromAlpha="1.0"
        android:toAlpha="0.0"/>
    <rotate
        android:fromDegrees="0"
        android:toDegrees="360"
        android:pivotX="50%"
        android:pivotY="50%"/>
    <scale
        android:fromXScale="1.0"
        android:fromYScale="1.0"
        android:toXScale="0"
        android:toYScale="0"
        android:pivotX="50%"
        android:pivotY="50%"/>
</set>
```
```
ivSetArrow.startAnimation(AnimationUtils.loadAnimation(AnimationActivity.this, R.anim.set_arrow));
```


### 通用属性
* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:detachWallpaper 设置是否在壁纸上运行，只对设置了壁纸背景的窗口动画(window animation)有效。设为true，则动画只在窗口运行，壁纸背景保持不变
* android:fillAfter 设置为true时，动画执行完后，View会停留在动画的最后一帧；默认为false；如果是动画集，需在<set>标签中设置该属性才有效
* android:fillBefore 设置为true时，动画执行完后，View回到动画执行前的状态，默认即为true
* android:fillEnabled 设置为true时，android:fillBefore的值才有效，否则android:fillBefore会被忽略
* android:repeatCount 设置动画重复执行的次数，默认为0，即不重复；可设为-1或infinite，表示无限重复
* android:repeatMode 设置动画重复执行的模式
    * restart 动画重复执行时从起点开始，默认为该值
    * reverse 动画会反方向执行
* android:startOffset 设置动画执行之前的等待时长，毫秒为单位；重复执行时，每次执行前同样也会等待一段时间
* android:zAdjustment 表示被设置动画的内容在动画运行时在Z轴上的位置
    * normal 默认值，保持内容在Z轴上的位置不变
    * top 保持在Z周最上层
    * bottom 保持在Z轴最下层
* android:interpolator 设置动画速率的变化，比如加速、减速、匀速等，需要指定Interpolator资源


### interpolator
通过interpolator可以定义动画速率变化的方式，比如加速、减速、匀速等
每种interpolator都是 Interpolator 类的子类，Android系统已经实现了多种interpolator，对应也提供了公共的资源ID
* AccelerateDecelerateInterpolator @android:anim/accelerate_decelerate_interpolator 在动画开始与结束时速率改变比较慢，在中间的时候加速
* AccelerateInterpolator @android:anim/accelerate_interpolator 在动画开始时速率改变比较慢，然后开始加速
* AnticipateInterpolator @android:anim/anticipate_interpolator 动画开始的时候向后然后往前抛
* AnticipateOvershootInterpolator @android:anim/anticipate_overshoot_interpolator 动画开始的时候向后然后向前抛，会抛超过目标值后再返回到最后的值
* BounceInterpolator @android:anim/bounce_interpolator 动画结束的时候会弹跳
* CycleInterpolator @android:anim/bounce_interpolator 动画循环做周期运动，速率改变沿着正弦曲线
* DecelerateInterpolator 	@android:anim/decelerate_interpolator 在动画开始时速率改变比较快，然后开始减速
* LinearInterpolator @android:anim/decelerate_interpolator 动画匀速播放
* OvershootInterpolator @android:anim/overshoot_interpolator 动画向前抛，会抛超过最后值，然后再返回

也可以自定义，自定义方法有两种：
1. 通过继承 Interpolator 父类或其子类；
2. 通过自定义的xml文件，可以更改上表中Interpolator的属性

自定义的xml文件需存放于res/anim/目录下,根标签与上表相应的有九种如下：
* <accelerateDecelerateInterpolator> 在动画开始与结束时速率改变比较慢，在中间的时候加速。没有可更改设置的属性，所以设置的效果和系统提供的一样
* <accelerateInterpolator> 在动画开始时速率改变比较慢，然后开始加速。有一个属性可以设置加速的速率

    * android:factor 浮点值，加速的速率，默认为1
* <anticipateInterpolator> 动画开始的时候向后然后往前抛。有一个属性设置向后拉的值

    * android:tension 浮点值，向后的拉力，默认为2，当设为0时，则不会有向后的动画了
* <anticipateOvershootInterpolator> 动画开始的时候向后然后向前抛，会抛超过目标值后再返回到最后的值。可设置两个属性

    * android:tension 浮点值，向后的拉力，默认为2，当设为0时，则不会有向后的动画了
    * android:extraTension 浮点值，拉力的倍数，默认为1.5(2*1.5)，当设为0时，则不会有拉力了
* <bounceInterpolator> 动画结束的时候会弹跳。没有可更改设置的属性
* <cycleInterpolator> 动画循环做周期运动，速率改变沿着正弦曲线。有一个属性设置循环次数

    * android:cycles 整数值，循环的次数，默认为1
* <decelerateInterpolator> 在动画开始时速率改变比较快，然后开始减速。有一个属性设置减速的速率
    
    * android:factor 浮点值，减速的速率，默认为1
* <linearInterpolator> 动画匀速播放。没有可更改设置的属性
* <overshootInterpolator> 动画向前抛，会抛超过最后值，然后再返回。有一个属性

    * android:tension 浮点值，超出终点后的拉力，默认为2
    

## PropertyAnimation
属性动画其实就是在一定时间内，按照一定规律来改变对象的属性，从而使对象展现出动画效果。
属性动画的xml文件则放于res/animator/目录下,在Java代码里引用属性动画的xml文件时，则用R.animator.filename
属性动画主要有三个元素：<animator>、<objectAnimator>、<set>
相对应的有三个类：ValueAnimator、ObjectAnimator、AnimatorSet
ValueAnimator是基本的动画类，处理值动画，通过监听某一值的变化，进行相应的操作。
ObjectAnimator是ValueAnimator的子类，处理对象动画。
AnimatorSet则为动画集，可以组合另外两种动画或动画集。


### animator
animator标签与对应的ValueAnimator类提供了属性动画的核心功能，包括计算动画值、动画时间细节、是否重复等。
执行属性动画分两个步骤：
1. 计算动画值
2. 将动画值应用到对象和属性上

ValueAnimator只完成第一步，即只计算值，要实现第二步则需要在值变化的监听器里自行更新对象属性。
animator标签包括：
* android:duration 动画从开始到结束持续的时长，单位为毫秒
* android:startOffset 设置动画执行之前的等待时长，单位为毫秒
* android:repeatCount 设置动画重复执行的次数，默认为0，即不重复；可设为-1或infinite，表示无限重复
* android:repeatMode 设置动画重复执行的模式
    * restart 动画重复执行时从起点开始，默认为该值
    * reverse 动画会反方向执行
* android:valueFrom 动画开始的值，可以为int值、float值或color值
* android:valueTo 动画结束的值，可以为int值、float值或color值
* android:valueType 动画值类型，若为color值，则无需设置该属性
    * intType 指定动画值，即以上两个value属性的值为整型
    * floatType 指定动画值，即以上两个value属性的值为浮点型，默认值
* android:interpolator 设置动画速率的变化，比如加速、减速、匀速等，需要指定Interpolator资源。

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<animator xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000"
    android:valueFrom="100"
    android:valueTo="20"
    android:valueType="intType">

</animator>
```
```
// 获取屏幕宽度
final int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this, R.animator.value_animator);
valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animator) {
        // 当前动画值，即为当前宽度比例值
        int currentValue = (Integer) animator.getAnimatedValue();
        // 根据比例更改目标view的宽度
        view.getLayoutParams().width = maxWidth * currentValue / 100;
        view.requestLayout();
    }
});
valueAnimator.start();
```
需要注意：
属性动画则是通过AnimatorInflater类的loadAnimation()方法获取相应的Animator类实例。
ValueAnimator通过添加AnimatorUpdateListener监听器监听值的变化，从而再手动更新目标对象的属性。
最后，通过调用valueAnimator.start()方法启动动画。



### objectAnimator
objectAnimator 标签对应的类为ObjectAnimator，为ValueAnimator的子类。
objectAnimator可以直接指定动画的目标对象的属性

比animator多了个属性：
* android:propertyName 目标对象的属性名，要求目标对象必须提供该属性的setter方法，如果动画的时候没有初始值，还需要提供getter方法

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<objectAnimator xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="1000"
    android:valueType="intType"
    android:valueFrom="100"
    android:valueTo="20"
    android:propertyName="width">

</objectAnimator>
```
```
private static class ViewWrapper {
        private View target; //目标对象
        private int maxWidth; //最长宽度值

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            //widthValue的值从100到20变化
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }
    }
```
```
// 获取屏幕宽度
int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
// 将目标view进行包装
ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
// 将xml转化为ObjectAnimator对象
ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.object_animator);
// 设置动画的目标对象为包装后的view
objectAnimator.setTarget(wrapper);
// 启动动画
objectAnimator.start();
```

ObjectAnimator提供了属性的设置，但相应的需要有该属性的setter和getter方法。
而ValueAnimator则只是定义了值的变化，并不指定目标属性，所以也不需要提供setter和getter方法，但只能在AnimatorUpdateListener监听器里手动更新属性。

为了对View更方便的设置属性动画，Android系统也提供了View的一些属性和相应的setter和getter方法：
* alpha：透明度，默认为1，表示不透明，0表示完全透明
* pivotX 和 pivotY：旋转的轴点和缩放的基准点，默认是View的中心点
* scaleX 和 scaleY：基于pivotX和pivotY的缩放，1表示无缩放，小于1表示收缩，大于1则放大
* rotation、rotationX 和 rotationY：基于轴点(pivotX和pivotY)的旋转，rotation为平面的旋转，rotationX和rotationY为立体的旋转
* translationX 和 translationY：View的屏幕位置坐标变化量，以layout容器的左上角为坐标原点
* x 和 y：View在父容器内的最终位置，是左上角坐标和偏移量（translationX，translationY）的和


### set
set标签对应于AnimatorSet类，可以将多个动画组合成一个动画集，如上面提到的在缩放宽度的同时做垂直移动，可以将一个缩放宽度的动画和一个垂直移动的动画组合在一起。

* android:ordering 设置动画的时序关系
    * together 动画同时执行，默认值
    * sequentially 动画按顺序执行

例如：
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:ordering="together">
    <objectAnimator
        android:duration="3000"
        android:propertyName="width"
        android:valueFrom="100"
        android:valueTo="20"
        android:valueType="intType" />
    <objectAnimator
        android:duration="3000"
        android:propertyName="marginTop"
        android:valueFrom="0"
        android:valueTo="100"
        android:valueType="intType" />
</set>
```
```
private static class ViewWrapper {
        private View target;
        private int maxWidth;

        public ViewWrapper(View target, int maxWidth) {
            this.target = target;
            this.maxWidth = maxWidth;
        }

        public int getWidth() {
            return target.getLayoutParams().width;
        }

        public void setWidth(int widthValue) {
            target.getLayoutParams().width = maxWidth * widthValue / 100;
            target.requestLayout();
        }

        public void setMarginTop(int margin) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) target.getLayoutParams();
            layoutParams.setMargins(0, margin, 0, 0);
            target.setLayoutParams(layoutParams);
        }
    }
```
```
public void onScaleWidth(View view) {
    // 获取屏幕宽度
    int maxWidth = getWindowManager().getDefaultDisplay().getWidth();
    // 将目标view进行包装
    ViewWrapper wrapper = new ViewWrapper(view, maxWidth);
    // 将xml转化为ObjectAnimator对象
    AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.set_animator);
    // 设置动画的目标对象为包装后的view
    animatorSet.setTarget(wrapper);
    // 启动动画
    animatorSet.start();
}
```


## style
Android的样式一般定义在res/values/styles.xml文件中，其中有一个根元素<resource>，而具体的每种样式定义则是通过<resource>下的子标签<style>来完成，<style>通过添加多个<item>来设置样式不同的属性。

另外，样式是可以继承的，可通过<style>标签的parent属性声明要继承的样式，也可通过点前缀 (.) 继承，点前面为父样式名称，后面为子样式名称。点前缀方式只适用于自定义的样式，若要继承Android内置的样式，则只能通过parent属性声明。

定义的样式太多，如果都放在styles.xml文件里，那这文件也太臃肿了。因此，可以将样式分类拆分成多个文件。

例如：
```
<style name="AutoButton">
    <item name="android:textSize">16sp</item>
    <item name="android:textColor">#ffffff</item>
    <item name="android:layout_margin">10dp</item>
    <item name="android:padding">10dp</item>
</style>

<style name="BlueButton" parent="AutoButton">
    <item name="android:background">#00aaff</item>
</style>

<style name="RedButton" parent="AutoButton">
    <item name="android:background">#ff0000</item>
</style>
```
同理，可以再values文件夹下创建style_yellow.xml样式。


## 参考网址
[http://keeganlee.me/post/android/20150830](http://keeganlee.me/post/android/20150830 "参考地址")

[https://github.com/keeganlee/kstyle](https://github.com/keeganlee/kstyle "参考地址")
