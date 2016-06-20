/**
 * Created by mygu on 16/6/19.
 */

import React, {
    requireNativeComponent,
    PropTypes,
    View,
    Component
} from 'react-native';

class Danmaku extends Component {

    constructor(props, context) {
        super(props, context);
    }

    render() {
        const nativeProps = Object.assign({}, this.props);
        Object.assign(nativeProps, {});
        return (
            <RCTDanmaku
                {...nativeProps}
            />
        )
    }
}

Danmaku.propTypes = {
    started: PropTypes.bool,
    ...View.propTypes
};

const RCTDanmaku = requireNativeComponent('RCTDanmaku', Danmaku);

module.exports = Danmaku;
