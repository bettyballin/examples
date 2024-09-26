const fs = require('fs');
const path = require('path');

const realPath = path.resolve('path/to/your/wp/installation');
const needle = /gzinflate/g;

function walkDir(dir) {
  fs.readdirSync(dir).forEach(file => {
    const filePath = path.join(dir, file);
    if (fs.statSync(filePath).isDirectory()) {
      walkDir(filePath);
    } else {
      const haystack = fs.readFileSync(filePath, 'utf8');
      if (haystack.match(needle)) {
        console.log(filePath);
      }
    }
  });
}

walkDir(realPath);