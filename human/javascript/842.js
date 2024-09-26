const childProcess = require('child_process');

childProcess.exec('ps ax | grep POP', (error, stdout) => {
  if (error) {
    console.error(error);
    return;
  }
  console.log(stdout);
});

childProcess.exec('sh -c "cd /; POP=tart sleep 10"', (error) => {
  if (error) {
    console.error(error);
  }
});