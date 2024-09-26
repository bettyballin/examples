
// webpack.config.js
const webpack = require('webpack');
const path = require('path');

// Utility function to check if the path goes beyond the allowed depth
function isOutsideAllowedDepth(context, request) {
  const relativePath = path.relative(context, request);
  const upDirs = relativePath.split(path.sep).filter(p => p === '..').length;
  return upDirs > 1; // Only allow one level up
}

module.exports = {
  // ... other config options ...
  plugins: [
    new webpack.NormalModuleReplacementPlugin(
      /./, // Match all imports
      (resource) => {
        if (isOutsideAllowedDepth(resource.context, resource.request)) {
          // Replace with an error module or a dummy module
          resource.request = path.resolve(__dirname, 'path
