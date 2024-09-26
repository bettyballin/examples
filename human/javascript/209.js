const fs = require('fs');

if (fs.existsSync("counter.txt")) {
  fs.truncateSync("counter.txt", 0);
  fs.writeFileSync("counter.txt", content);
} else {
  fs.writeFileSync("counter.txt", content);
}