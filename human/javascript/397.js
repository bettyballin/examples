const json = '{"key":"value"}';

console.log(JSON.parse(json));

const flags = JSON_HEX_QUOT | JSON_HEX_TAG | JSON_HEX_AMP | JSON_HEX_APOS;
console.log(JSON.stringify(json, null, flags));