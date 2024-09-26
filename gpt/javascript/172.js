
var crypto = require('crypto');
var fs = require('fs');

var file1 = process.argv[2];
var file2 = process.argv[3];

var sha1sum = function(filePath) {
  var data = fs.readFileSync(filePath); // Read the content of the file
  return crypto.createHash('sha1').update(data).digest('hex'); // Hash the content
};

var first = sha1sum(file1);
var second = sha1sum(file2);

console.log(first + '  ' + file1);
console.log(second + '  ' + file2);

if (first == second) {
  console.log("the two hashes are equal");
} else {
  console.log("the two hashes aren't equal");
}

