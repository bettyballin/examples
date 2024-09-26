const { BrowserWindow, app } = require('electron');

app.on('ready', () => {
  const mainWindow = new BrowserWindow({
    webSecurity: false
  });
});