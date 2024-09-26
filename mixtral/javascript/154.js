const { spawn } = require('child_process');

var password = 'user-input';

// Create a child process to execute the cracklib-check
let checkPasswordProcess = spawn('cracklib-check', [password]);

// Listen for output
checkPasswordProcess.stdout.on('data', (data) => {
  console.log(`Output: ${data}`);
});

// Handle errors
checkPasswordProcess.stderr.on('data', (errData) => {
  console.error(`Error occurred: ${errData}`);
});