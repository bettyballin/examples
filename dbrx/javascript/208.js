const fs = require('fs');
const path = require('path');

const assetsPath = './assets'; // replace with your assets path
const isValidFilename = (filename) => /^[a-zA-Z0-9._-]+$/.test(filename); // basic filename validation

function deleteFile(file) {
  if (isValidFilename(file)) {
    fs.unlink(path.join(assetsPath, file), (err) => {
      if (err) {
        console.error(`Error deleting file: ${err}`);
      } else {
        console.log(`File deleted successfully: ${file}`);
      }
    });
  } else {
    console.error(`Invalid filename provided: ${file}`);
  }
}

// Test the function
deleteFile('test.txt');