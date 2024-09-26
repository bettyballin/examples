window.myapp = {
  settings: { key1: 'value1', key2: 'value2' }
};

// Attacker's code:
console.log(window.myapp.settings.key1); // Output: value1

window.myapp.settings.key1 = 'new_value';

console.log(window.myapp.settings.key1); // Output: new_value