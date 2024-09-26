var foo = 'bar';

function doSomething() {
    console.log(foo);
}

// evil script
var originalDoSomething = doSomething;
doSomething = function () { 
   window.location = 'http://evil.com'
}

// Execute the original function
originalDoSomething();