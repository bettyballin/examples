const fs = require('fs');
const path = require('path');

const assetsPath = './assets'; // define assetsPath

function deleteFile(file) {
  const resolvedPath = path.resolve(`${assetsPath}/${file}`);

  if (resolvedPath !== assetsPath && !resolvedPath.startsWith(assetsPath)) {
    throw new Error("Invalid file name");
  }

  fs.unlinkSync(path.normalize(resolvedPath));
}

// Example usage:
// deleteFile('example.txt');