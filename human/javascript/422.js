function A(secret){ 
   return function(){
      var s=secret; 
      secret=null; 
      return s;
   };  
}

function B(fn){ 
    var v=fn(); 
    console.log(fn); 
    alert("In B(): " + v);  
}

var x=A(123); //give secret number to A, getting back a function
alert(x); // no secret here

B(x); // extract the secret by executing a one-time getter
alert(x);  // no secret here

alert(x()); // still no secret, it's used-up