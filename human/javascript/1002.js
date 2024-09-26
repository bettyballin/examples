const fs = require('fs');
const { ipcMain } = require('electron');

function openFile() {
    return new Promise((resolve, reject) => {
        fs.readFile("logs.txt", "utf-8", (err, data) => {
            if (err) {
                console.error(err);
                resolve("Error Loading Log File");
            } else {
                console.log('openFile: ' + data); // Testing
                resolve(data);
            }
        });
    });
}

ipcMain.handle('channel-load-file', async () => {
    let result = await openFile();

    console.log('handle: ' + result); // Testing

    return result;
})