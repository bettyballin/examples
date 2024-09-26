const child_process = require('child_process');

var password = 'some_password';
var checkPassword = child_process.spawn('cracklib-check', {stdio: ['pipe', 'pipe', 'ignore']});

checkPassword.stdin.write(`echo ${password}\n`);
checkPassword.stdin.end();

checkPassword.stdout.on('data', (data) => {
  console.log(`stdout: ${data}`);
});

checkPassword.stderr.on('data', (data) => {
  console.error(`stderr: ${data}`);
});

checkPassword.on('close', (code) => {
  console.log(`child process exited with code ${code}`);
});