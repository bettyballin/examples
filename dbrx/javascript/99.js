window.myapp = {
  settings: { key1: 'value1', key2: 'value2' }
};

// Attacker's code:
console.log(Object.keys(window.myapp.settings)); 

Object.defineProperty(window.myapp.settings, 'new_key', { value: 'new_value', enumerable: true });

console.log(Object.keys(window.myapp.settings));