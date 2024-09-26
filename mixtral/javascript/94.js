const fs = require('fs');
const crypto = require('crypto');

function sha1sum(filePath){
    const buffer = fs.readFileSync(filePath);
    return crypto.createHash('sha1').update(buffer).digest("hex");
}

// Example usage:
console.log(sha1sum('path/to/your/file.txt'));