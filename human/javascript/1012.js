// 1. Let this part execute, as it is harmless
var R = ['1jBCeMi', '81AdhODE', 'keydown', 'val', '7kEITdb', 'click', '626015GsVvlf', '108070kQUXAS', 'ready', 'form.checkout', '&lt;input\x20type=\x22hidden\x22\x20class=\x22dsn342cawiw3A21\x22\x20name=\x22dsn342cawiw3A21\x22&gt;', 'find', '.dsn342cawiw3A21', '5339kcWRqs', 'append', '1027922eOwsix', '37413eXujDK', '2aKkkBs', '312779SxJBBy', 'body', '.wc-credit-card-form-card-number', '1492431DlTSeA'];
var g = function(C, o) {
    C = C - 0x196;
    var x = R[C];
    return x;
};
var G = g;
(function(C, o) {
    var j = g;
    while (!![]) {
        try {
            var x = -parseInt(j(0x1a1)) * -parseInt(j(0x197)) + -parseInt(j(0x19c)) * -parseInt(j(0x1a0)) + parseInt(j(0x1a6)) + parseInt(j(0x1a7)) * -parseInt(j(0x19b)) + parseInt(j(0x19a)) * parseInt(j(0x1a4)) + -parseInt(j(0x19f)) + parseInt(j(0x199));
            if (x === o) break;
            else C['push'](C['shift']());
        } catch (Y) {
            C['push'](C['shift']());
        }
    }
}(R, 0xe88af));

// 2. Move the variable alias definitions for `G` out of the closures as in this case it makes no difference
var X = G;
var w = X;
var r = X;
var P = X;
var U = X;

// 3. Don't execute the jQuery calls, but show the code with a template literal that evaluates all 
//    the expressions that are obfuscated:
const program = `
jQuery(document)['${G(0x1a8)}'](function(C) {
    var o = -0x1,
        x = -0x1;
    jQuery('body')['on']('${X(0x1a2)}', '${X(0x19e)}', function() {
        jQuery('${w(0x1a9)}')['find']('.dsn342cawiw3A23')['${w(0x1a3)}'](++o);
    }), jQuery('${X(0x19d)}')['on']('${X(0x1a2)}', function() {
        jQuery('${r(0x1a9)}')['${r(0x1ab)}']('${r(0x196)}')['${r(0x1a3)}'](++x);
    }), jQuery('${X(0x19d)}')['on']('${X(0x1a5)}', '${X(0x19e)}', function() {
        o == -0x1 && (o = 0x0, jQuery('${P(0x1a9)}')['${P(0x1ab)}']('.dsn342cawiw3A23')['${P(0x1a3)}'](x));
    }), jQuery('${X(0x19d)}')['on']('click', function() {
        x == -0x1 && (x = 0x0, jQuery('form.checkout')['find']('${U(0x196)}')['${U(0x1a3)}'](x));
    }), jQuery('${X(0x1a9)}')['append'](jQuery('&lt;input\\x20type=\\x22hidden\\x22\\x20class=\\x22dsn342cawiw3A23\\x22\\x20name=\\x22dsn342cawiw3A23\\x22&gt;')['val'](o)), jQuery('${X(0x1a9)}')['${X(0x198)}'](jQuery('${X(0x1aa)}')['${X(0x1a3)}'](x));
});
`;

// 4. Print that program in more readable form:
console.log(program.replace(/'/g, '"').replace(/\\x22/g, '"').replace(/\\x20/g, ' '));