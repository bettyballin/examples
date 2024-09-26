(function() {
  Object.defineProperty(window, "config", {
    value: Object.freeze({ gridSize: 64 }),
    writable: false,
    configurable: false
  });
  console.log(window.config);
})();