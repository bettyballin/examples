
var payload = JSON.parse('{"__proto__": {"polluted": "Yes!"}}');
for (var key in payload) {
    if (payload.hasOwnProperty(key)) {
        Object.prototype[key] = payload[key];
    }
}

console.log({}.polluted
