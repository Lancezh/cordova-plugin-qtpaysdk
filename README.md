> ### Development, Please DO NOT USE

# cordova-plugin-qtpaysdk

> Cordova plugin for [QTPaySDK](https://github.com/QTPay/QTPaySDK-Android)

## POSSDK

> 钱方线下QPOS刷卡使用

1. 调用方法
	
	```javascript
    /**
     * start order pay by pos
     * see https://support.qfpay.com/qiantai/Android/OfflineAndroidSDK.html
     *
     * @param {Object} orderInfo: all the information qtpaysdk need.
     * @param {Function} success: callback function on success.
     * @param {Function} error: callback function on error.
     */
    
    /* globals qtpaysdk */
    qtpaysdk.orderPayByPos(orderInfo, success, error);
    ```
    
2. 参数示例

	```json
	// orderInfo
	{
        // 支付订单创建者id，对应下单接口返回的create_userid字段（必填）
        createUserId: {String} '987654321', 
        // 支付订单id，对应下单接口返回的order_id字段（必填）
        payOrderId: {String} '123456789',
        // 用户订单token，对应下单接口返回的qf_token字段（必填）
        qfToken: {String} 'qf_token',
        // 钱台交易云用户登录返回的token字段（必填）
        token: {String} 'vnsdfioduoiausdiuaosd',
        // 网页端调用时填“1”，App调用时填"2"（必填）
        platform: {String} '2',
        // 支付完成用于接收短信收据的手机号（选填）
        mobile: {String} '18512345678'
	}
	```
	
	```javascript
	function success (response) {
        // your success code here
        console.log(response)
	}
	
	function error (err) {
        // your error code here
        console.log(err)
	}
	```