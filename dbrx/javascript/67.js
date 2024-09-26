const { v5: uuidv5 } = require('uuid');
const namespace = 'b9cfdb9d-f741-4e1f-89ae-1234567890ab'; // replaced <PASSWORD> with a random UUID
const name = "something";

// Generate a UUID from the given string and namespace.
const shaUuid = uuidv5(name, namespace); // added comma between name and namespace

console.log(shaUuid);