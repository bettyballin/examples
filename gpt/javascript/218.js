
   (function() {
     'use strict';
     var originalRandom = Math.random;
     Object.defineProperty(Math, 'random', {
       value: originalRandom,
       writable: false,
       configurable: false
     });
   })();
   
