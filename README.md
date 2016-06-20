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

```
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {
    Component,
    StyleSheet,
    View,
    Text,
    Navigator,
    TextInput,
    Alert
} from 'react-native';

import Button from '../components/Button';

import Danmaku from 'react-native-danmaku';

export default class LiveStyle extends Component {
    constructor(props){
        super(props);

        this.state = {
            comment: '',
            comments: [],
            started: false
        }
    }

    addComment() {
        this.setState({started: false});
        this.setState({started: true});
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.text}>
                    LiveStyle
                </Text>

                <Danmaku style={styles.danmaku} started={this.state.started}></Danmaku>

                <TextInput
                    style={{height: 40, borderColor: 'gray', borderWidth: 1}}
                    onChangeText={(text) => this.setState({comment: text})}
                    value={this.state.text}
                />

                <Button
                    containerStyle={styles.round_button}
                    style={styles.round_button_text}
                    onPress={this.addComment.bind(this)}>
                    发送
                </Button>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'transparent',
        alignItems: 'center',
        justifyContent: 'center'
    },

    danmaku: {
        flex: 1,
        backgroundColor: 'transparent',
        width: 400,
        height: 800
    },

    text: {
        color: 'white'
    },
    round_button: {
        height: 32,
        marginTop: 26,
        marginLeft: 10,
        marginRight: 10,
        borderWidth: 1,
        borderColor: '#cfcfcf',
        backgroundColor: '#ffffff',
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius: 8
    },

    round_button_text: {
        color: '#333333',
        fontSize: 14
    }
});
```