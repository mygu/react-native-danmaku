/**
 * Created by buhe on 16/4/29.
 */

import React , {
    requireNativeComponent,
    PropTypes,
    View,
    Component
} from 'react-native';

class Streaming extends Component {

  constructor(props, context) {
    super(props, context);
    this._onReady = this._onReady.bind(this);
    this._onConnecting = this._onConnecting.bind(this);
    this._onStreaming = this._onStreaming.bind(this);
    this._onShutdown = this._onShutdown.bind(this);
    this._onIOError = this._onIOError.bind(this);
    this._onDisconnected = this._onDisconnected.bind(this);
  }

  _onReady(event) {
    this.props.onReady && this.props.onReady(event.nativeEvent);
  }

  _onConnecting(event) {
    this.props.onConnecting && this.props.onConnecting(event.nativeEvent);
  }

  _onStreaming(event) {
    this.props.onStreaming && this.props.onStreaming(event.nativeEvent);
  }

  _onShutdown(event) {
    this.props.onShutdown && this.props.onShutdown(event.nativeEvent);
  }

  _onIOError(event) {
    this.props.onIOError && this.props.onIOError(event.nativeEvent);
  }

  _onDisconnected(event) {
    this.props.onDisconnected && this.props.onDisconnected(event.nativeEvent);
  }

  render() {
    const nativeProps = Object.assign({}, this.props);
    Object.assign(nativeProps, {
      onReady: this._onReady,
      onConnecting: this._onConnecting,
      onStreaming: this._onStreaming,
      onShutdown: this._onShutdown,
      onIOError: this._onIOError,
      onDisconnected: this._onDisconnected,
    });
    return (
        <RCTStreaming
            {...nativeProps}
            />
    )
  }
}

Streaming.propTypes = {
  stream: PropTypes.object,
  muted: PropTypes.bool,
  zoom: PropTypes.number,
  focus: PropTypes.bool,
  profile: PropTypes.shape({                          // 是否符合指定格式的物件
    video: PropTypes.shape({
      fps: PropTypes.number.isRequired,
      bps: PropTypes.number.isRequired,
      maxFrameInterval: PropTypes.number.isRequired
    }).isRequired,
    audio: PropTypes.shape({
      rate: PropTypes.number.isRequired,
      bitrate: PropTypes.number.isRequired,
    }).isRequired
  }).isRequired,
  started: PropTypes.bool,
  settings: PropTypes.object,

  onReady: PropTypes.func,
  onConnecting: PropTypes.func,
  onStreaming: PropTypes.func,
  onShutdown: PropTypes.func,
  onIOError: PropTypes.func,
  onDisconnected: PropTypes.func,
  ...View.propTypes,
}

const RCTStreaming = requireNativeComponent('RCTStreaming', Streaming);

module.exports = Streaming;