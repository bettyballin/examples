//Will behave like function a( obj ) { return obj.something }
function makePropReader( propName ) {
    return new Function( "obj", "return obj." + propName );
}

// Test the function
let reader = makePropReader("something");
let obj = { something: "Hello, World!" };
console.log(reader(obj));