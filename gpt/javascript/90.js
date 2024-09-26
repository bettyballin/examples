
// This is the script you want to execute inside the worker
var workerScript = `
self.onmessage = function(e) {
  // Worker code goes here
  console.log('Message received from main script');
  var workerResult =
