if (window && window.console) {
  console.clear();

  // Display a warning message
  console.warn("Warning! Do not paste anything here.");

  // Override the log method to display another custom message
  const originalLog = console.log;

  console.log = function() {
    if (arguments[0] && arguments[0].startsWith('%c')) {
      return;
    }

    originalLog.apply(console, ['Warning! Do not paste anything here.']);
  };
}

// Test the code
console.log('Test');
console.log('%ctest', 'color: red');