const fs = require('fs');
const { ipcMain } = require('electron');

function openFile() {
    return new Promise((resolve, reject) => {
        fs.readFile("logs.txt", "utf-8", (error, data) => {
            if (error) {
                console.log('reject: ' + error); // Testing
                reject(error);
            } else {
                console.log('resolve: ' + data); // Testing
                resolve(data)
            }
        });
    });
}

ipcMain.handle('channel-load-file', async (event, message) => {
    return await openFile()
        .then((data) => {
            console.log('handle: ' + data); // Testing
            return data;
        })
        .catch((error) => {
            console.log('handle error: ' + error); // Testing
            return 'Error Loading Log File';
        })
});