var C_lib = C_lib || {};
var Base = function() {};

/**
 * An array of 32-bit words.
 *
 * @property {Array} words The array of 32-bit words.
 * @property {number} sigBytes The number of significant bytes in this word array.
 */
var WordArray = C_lib.WordArray = Base.extend({
  init: function(words, sigBytes) {
    this.words = words || [];
    this.sigBytes = sigBytes || 0;
  }
});

// Example usage:
var wordArray = new WordArray();
console.log(wordArray);

var wordArray2 = new WordArray([1, 2, 3], 8);
console.log(wordArray2);