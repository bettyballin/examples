
var crypto = require("crypto");
var fs = require("fs");

var data = fs.readFileSync("./hello.txt");
var pubkey = fs.readFileSync("./mykey.pem", "utf8"); //
