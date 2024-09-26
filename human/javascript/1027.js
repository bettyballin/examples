const minimatch = require('minimatch');

const match = minimatch('react-scripts/react-dev-utils/recursive-readdir/minimatch', '^3.0.5');
console.log(match);