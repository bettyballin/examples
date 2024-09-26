#!/usr/bin/env node

const spawn = require('child_process').spawn;

// Read password from argument to nodejs invocation
var password = process.argv[2];

if (!password) {
  console.error("Usage: node cracklib.js <password>");
  process.exit(1);
}

var cracklib_check = spawn('/usr/sbin/cracklib-check');

cracklib_check.stdin.setEncoding('utf-8');
cracklib_check.stdin.write(password);
cracklib_check.stdin.end();

// Process results of cracklib-check
cracklib_check.stdout.on('data', function (data) {
  console.log("[*] " + data.toString());
});

cracklib_check.stderr.on('data', function (data) {
  console.log("[-] " + data.toString());
});

cracklib_check.on('close', function (code) {
  process.exit(code);
});