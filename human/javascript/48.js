var components = {
    component001 : 'testing111',
    component002 : 'testing222',
    component003 : 'testing333'
};

var APP = {};

APP.safeEval = function(nameOfComponent) {
    var result = components[nameOfComponent];
    if(result) {
        return result;
    } else {
        return 'ERROR';
    }
}

console.log(APP.safeEval('component001'));  // testing111
console.log(APP.safeEval('component002'));  // testing222
console.log(APP.safeEval('component003'));  // testing333
console.log(APP.safeEval('component004'));  // ERROR