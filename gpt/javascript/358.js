
const fs = require('fs');
const path = require('path');

const assetsPath = path.join(__dirname, 'assets'); // Make sure to use an absolute path

function deleteFile(file) {
  if (!file) {
    console.error('No file specified');
    return;
  }

  // Extract the filename and normalize it
  const filename = path.basename(file);
  const filePath = path.normalize(path.join(assetsPath, filename));

  // Check that the filePath starts with assetsPath
  if (!filePath.startsWith(assetsPath)) {
    console.error('Invalid file
