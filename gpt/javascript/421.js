
   // In your main thread
   const sessionToken = getSessionTokenFromCookie(); // Implement this function securely
   const worker = new Worker('worker.js');
   worker.postMessage({ sessionToken });
   
