(function() { 
   var foo = 'bar';

   function doSomething() {
       console.log(foo);
   }
   doSomething();
})();

// evil script
doSomething = function () {  
   window.location = 'http://evil.com'
}