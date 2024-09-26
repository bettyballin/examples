// file: my-webpack-loader.js
const { getOptions } = require('loader-utils');
const validateOptions = require('schema-utils');
const path = require('path');

const schema = {
  type: 'object',
  properties: {
    test: {
      type: 'string'
    }
  }
};

function handler(source) {
  const options = getOptions(this);

  if(this.resourcePath.indexOf(path.resolve('./node_modules')) !== 0) {
    if(this.resourcePath.indexOf(path.resolve('./src')) !== 0) {
      throw `Resource loading restricted for ${this.resourcePath}`;
    }
  }

  validateOptions(schema, options, 'My Webpack Loader');

  return source;
}

module.exports = handler;