// my-worker.js
self.addEventListener('message', function(e) {
  var data = e.data;
  switch (data.action) {
    case 'calculate':
      // Perform calculations here
      var result = calculate(data.payload);
      self.postMessage({ result: result });
      break;
  }
});

function calculate(payload) {
  // Your calculation logic here
  return payload;
}


html
<!-- index.html -->
<!DOCTYPE html>
<html>
<head>
  <title>Web Worker Example</title>
</head>
<body>
  <script>
    // Create a new worker
    const myWorker = new Worker('my-worker.js');

    // Post a message to the worker
    myWorker.postMessage({ action: 'calculate', payload: { /* your data */ } });

    // Listen for messages from the worker
    myWorker.addEventListener('message', function(e) {
      console.log('Result from worker:', e.data.result);
    });
  </script>
</body>
</html>