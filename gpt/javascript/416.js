
const { contextBridge, ipcRenderer } = require("electron");

contextBridge.exposeInMainWorld("electronAPI", {
    loadFile: () => ipcRenderer.invoke("channel-load-file")
});

