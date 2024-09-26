<!DOCTYPE html>
<html>
<head>
  <title>ECDSA Signing Example</title>
</head>
<body>
  <h1>ECDSA Signing Example</h1>
  <p id="pub"></p>
  <p id="sig"></p>

  <script>
    (async () => {
      // Generate key pair
      var keypair = await window.crypto.subtle.generateKey(
        {
          name: "ECDSA",
          namedCurve: "P-256", // secp256r1 
        },
        false,
        ["sign", "verify"] 
      );

      // Export public key in X.509/SPKI format, DER encoded
      var publicKey = await window.crypto.subtle.exportKey(
        "spki", 
        keypair.publicKey 
      );  
      document.getElementById("pub").innerHTML = "Public key: " + ab2b64(publicKey);

      // Sign data
      var data = {
        "data_1":"The quick brown fox",
        "data_2":"jumps over the lazy dog"
      }
      var dataStr = JSON.stringify(data) 
      var dataBuf = new TextEncoder().encode(dataStr).buffer
      var signature = await window.crypto.subtle.sign(
        {
          name: "ECDSA",
          hash: {name: "SHA-256"}, 
        },
        keypair.privateKey, 
        dataBuf 
      ); 
      document.getElementById("sig").innerHTML = "Signature: " + ab2b64(signature);
    })();

    // Helper
    function ab2b64(arrayBuffer) {
      return window.btoa(String.fromCharCode.apply(null, new Uint8Array(arrayBuffer)));
    }
  </script>
</body>
</html>