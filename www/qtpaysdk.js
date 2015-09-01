var exec = require('cordova/exec');


/**
 * This class exposes the QTPaySDK Android SDK functionality to javascript.
 *
 * @constructor
 */
function QTPaySDK () {}

/**
 * start order pay by pos
 * see https://support.qfpay.com/qiantai/Android/OfflineAndroidSDK.html
 *
 * @param {Object} orderInfo: all the information qtpaysdk need.
 * @param {Function} success: callback function on success.
 * @param {Function} error: callback function on error.
 */
QTPaySDK.prototype.orderPayByPos = function(orderInfo, success, error) {
    exec(success, error, "qtpaysdk", "orderPayByPos", [orderInfo]);
};


/**
 * Plugin setup boilerplate.
 */
module.exports = new QTPaySDK();