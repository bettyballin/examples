window.myapp = {
  settings: { key1: 'value1', key2: 'value2' }
};

console.log(Object.keys(window.myapp.settings)); 

delete window.myapp.settings[Object.keys(window.myapp.settings)[0]];

console.log(Object.keys(window.myapp.settings));