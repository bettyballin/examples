process.on('uncaughtException', function(err) {
  /* ignore error */
  console.log('Uncaught Exception:', err);
});

// Test the event handler
setTimeout(function() {
  throw new Error('Test error');
}, 1000);