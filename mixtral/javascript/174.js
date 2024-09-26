let algo = {
  name: "ECDSA",
  namedCurve: "P-256"
};

// Generate some entropy
window.crypto.getRandomValues(new Uint8Array(1)).then((random) => {

  // Add the random value to your algorithm parameters
  algo['salt'] = new TextEncoder().encode('' + random);

  window.crypto.subtle.generateKey(
    algo,
    true,
    ["sign", "verify"]
  )
  .then(key => console.log(key))
  .catch((err) => {
    console.error("Error generating key: ", err);
  });

}).catch((err) => {
  console.error("Error generating entropy: ", err);
});