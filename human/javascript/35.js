const fs = require('fs');

// Create a test directory and set its stats
fs.mkdirSync('images');
fs.chmodSync('images', 0o755);
fs.chownSync('images', 1000, 1000); // assuming pax user id is 1000 and paxgrp group id is 1000

// Get stats of the directory
const stats = fs.statSync('images');

// Define a function to format date as in ls command output
function formatDate(date) {
  const monthNames = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
  return `${monthNames[date.getMonth()]} ${date.getDate()} ${date.getHours()}:${date.getMinutes()}`;
}

// Print directory information in ls command format
console.log(`drwxr-xr-x ${stats.nlink} pax paxgrp ${stats.size} ${formatDate(stats.mtime)} images`);