const _ = require('underscore');

_.templateSettings = {
  interpolate : /{{(.+?)}}/g
};
var compiled = _.template("Hello {{ name }}!");
console.log(compiled({ 'name': 'fred' }));