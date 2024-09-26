var modules = {
    'main.js': 'alert("Main module")',
    'another.js': 'alert("Another module")',
    'notUsed.js': 'alert("I am never used")',
};

for (var module in modules) {
    eval(modules[module]);
}