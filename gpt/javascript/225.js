
const { execFile } = require('child_process');

// Assume `password` comes from user input
const password = 'userProvidedPassword';

execFile('echo', [password], (err, stdout, stderr) => {
  if (err) {
    // handle error
    console.error('Error:', err);
    return;
  }
  // Use the output from cracklib-check
  execFile('cracklib-check', { input: stdout }, (err, stdout, stderr) => {
    if (err) {
      // handle error
      console.error('Error:', err);
      return;
    }
    // Process the output
    console.log('Output:', stdout);
  });
});

