const data = new Uint8Array([/* your data here */]);
const string = btoa(String.fromCharCode.apply(null, data));