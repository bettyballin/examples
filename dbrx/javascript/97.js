const { spawn } = require('child_process');

function checkPassword(password) {
  const cracklibCheck = spawn('cracklib-check', [password]);

  cracklibCheck.stdout.on('data', (data) => {
    console.log(`stdout: ${data}`);
  });

  cracklibCheck.stderr.on('data', (data) => {
    console.error(`stderr: ${data}`);
  });

  cracklibCheck.on('close', (code) => {
    console.log(`child process exited with code ${code}`);
  });
}

checkPassword('your_password_here');