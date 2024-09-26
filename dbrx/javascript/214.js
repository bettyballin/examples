// preload.js

const contextBridges = require('./path/to/contextBridges');

module.exports = () => {
  const { exposeInMainWorld } = contextBridges;

  // Expose the bridges to main world.
  Object.values(exposeInMainWorld).forEach((bridge) =>
    bridge()
  );
};

// Run the preload function
module.exports();