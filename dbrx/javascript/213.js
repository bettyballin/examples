// contextBridges.js

const { contextBridge } = require('electron');

contextBridge.exposeInMainWorld(
  'bridge1', {
    // bridge methods and properties here...
  }
);

contextBridge.exposeInMainWorld(
  'bridge2', {
    // another set of bridged functionality
  }
);