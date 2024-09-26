// Note: Native library loading is not directly possible in JavaScript.
// We'll assume you're using a library like node-ffi to interact with native code.

const ffi = require('ffi-napi');
const ref = require('ref-napi');

// Define the interface for the native library
const IHelper = ffi.Library('Helper', {
  'GetInfo': ['pointer', []]
});

class MyApplet {
  constructor() {
    this.pHelper = IHelper;
    this.pInfo = null;
  }

  init() {
    if (this.pHelper) {
      this.pInfo = this.pHelper.GetInfo();
    }
  }

  getInfoString() {
    if (this.pInfo) {
      // Convert the native wide char to a JavaScript string
      return ref.readCString(this.pInfo.MyInfoString, 0);
    }
    return null;
  }
}

// Usage
const applet = new MyApplet();
applet.init();
console.log(applet.getInfoString());