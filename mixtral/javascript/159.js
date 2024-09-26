let alg_key = {
  name: "AES-GCM",
  length: 256
};

(async function() {
  let key = await window.crypto.subtle.generateKey(alg_key, false, ["encrypt", "decrypt"]);
  console.log(key);
})();