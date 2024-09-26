const path = require('path');
const fs = require('fs');
const assetsPath = '/assets';

function deleteFile(file) {
    let deletePath = path.join(assetsPath, file);
    if (deletePath.indexOf(assetsPath) === 0) {
        fs.unlink(deletePath, err => {
            if (err) {
                console.error(err);
            }
        });
    } else {
        console.error("Error: Attempt to delete file outside of assets directory.");
    }
}

// Example usage:
deleteFile("example.txt");