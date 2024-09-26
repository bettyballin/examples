const path = require('path');

module.exports = {
  resolve: {
    modules: [
      path.resolve(__dirname, '..'), // Parent directory (one level above)
      'node_modules'                 // Default node_modules resolution
    ]
  }
};