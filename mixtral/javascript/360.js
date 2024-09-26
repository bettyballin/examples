const { BrowserWindow } = require('electron');
const path = require('path');

new BrowserWindow({
  webPreferences: {
    preload: path.join(__dirname, 'preload.js'),
    sandbox: true,
    nodeIntegration: false,
    enableRemoteModule: false,
    contextIsolation: true
  }
});