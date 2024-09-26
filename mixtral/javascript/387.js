const { contextBridge, ipcRenderer } = require("electron");

contextBridge.exposeInMainWorld("electronAPI", {
  loadFile: () =>
    new Promise((resolve) => {
      ipcRenderer.invoke("channel-load-file").then((result) => resolve(result));
    }),
});