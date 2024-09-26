var modules = {
  'main.js': 'console.log("Main file loaded!");',
  'another.js': 'console.log("Another file loaded!");'
};

var requireFile = function(file) {
    if(modules[file])
        eval(modules[file]);
};

requireFile('main.js');
requireFile('another.js');