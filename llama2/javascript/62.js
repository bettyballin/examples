var getRand;
(function(){
  'use strict';
  getRand = function(){
    return Math.random();
  }
})();

console.log(getRand()); //gives a nice random number

// Seal the function to prevent it from being overridden
Object.defineProperty(window, 'getRand', {
  configurable: false,
  writable: false
});

Math.random = function (){ return 0 };

console.log(getRand()); //still gives a random number because getRand is sealed and can't be overridden