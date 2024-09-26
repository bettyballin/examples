#!/usr/bin/env node

const fs = require('fs');
const crypto = require('crypto');

function sha1sum(filePath) {
  const fileContent = fs.readFileSync(filePath);
  return crypto.createHash('sha1').update(fileContent).digest('hex');
}

// Usage:
console.log(sha1sum(process.argv[2]));