To make this code executable, we need to create an Electron application. Here is the complete code:

**index.html**
html
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Electron Test</title>
        <meta http-equiv="Content-Security-Policy" content="script-src 'self' 'unsafe-inline';"/>
    </head>

    <body>
        <div id="main-content"></div>

        <input type="button" id="button" value="Load File">
    </body>

    <script>
        document.getElementById('button').addEventListener('click', () => {
            window.electronAPI.loadFile()
                .then((data) => {
                    console.log(data); // Testing
                    document.getElementById("main-content").innerText = data.toString();
                });
        })
    </script>
</html>


**main.js**

const { app, BrowserWindow } = require('electron');
const path = require('path');

let mainWindow;

function createWindow() {
    mainWindow = new BrowserWindow({
        width: 800,
        height: 600,
        webPreferences: {
            nodeIntegration: true,
            contextIsolation: false,
            preload: path.join(__dirname, 'preload.js')
        }
    });

    mainWindow.loadFile('index.html');

    mainWindow.on('closed', () => {
        mainWindow = null;
    });
}

app.on('ready', createWindow);

app.on('window-all-closed', () => {
    if (process.platform !== 'darwin') {
        app.quit();
    }
});

app.on('activate', () => {
    if (mainWindow === null) {
        createWindow();
    }
});


**preload.js**

const { ipcRenderer } = require('electron');

window.electronAPI = {
    loadFile() {
        return ipcRenderer.invoke('load-file');
    }
};


**electron.js**

const { ipcMain } = require('electron');

ipcMain.handle('load-file', async () => {
    // Replace with your file loading logic
    return 'File contents!';
});


**package.json**
json
{
    "name": "electron-test",
    "version": "1.0.0",
    "main": "main.js",
    "scripts": {
        "start": "electron ."
    },
    "dependencies": {
        "electron": "^13.1.7"
    }
}


Run `npm start` to execute the application.