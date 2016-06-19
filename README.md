#Danmaku React Native SDK
##Installation
```
Run npm install react-native-danmaku --save
```

###Android

**android/settings.gradle**
```
include ':react-native-danmaku'
project(':react-native-danmaku').projectDir = new File(settingsDir, '../node_modules/react-native-danmaku/android')
```
**android/app/build.gradle**
```
dependencies {
    ...
    compile project(':react-native-danmaku')
}
```
**MainActivity.java**

On top, where imports are:
```java
import com.danmaku.rndanmaku.DanmakuPackage;
```

Modify getPackages method
```java
 @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new DanmakuPackage()
        );
    }
```


##Usage