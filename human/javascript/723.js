const fs = require('fs');
const path = require('path');

const PICTURES_DIR = '/path/to/pictures/';

function scandir(dir, sort) {
  fs.readdir(dir, (err, files) => {
    if (err) {
      console.error(err);
      return;
    }

    if (sort === 'SCANDIR_SORT_ASCENDING') {
      files.sort((a, b) => a.localeCompare(b));
    }

    console.log(files);
  });
}

scandir(PICTURES_DIR, 'SCANDIR_SORT_ASCENDING');