// Request permission to access certificates
navigator.permissions.query("certificate")
  .then(permission => {
    if (permission.state === "granted") {
      // User has granted permission proceed with signing the form
      const text = "ask";
      const signature = window.crypto.subtle.sign(
        {
          name: "RSASSA-PKCS1-v1_5",
          hash: { name: "SHA-256" }
        },
        window.crypto.subtle.generateKey(
          {
            name: "RSASSA-PKCS1-v1_5",
            modulusLength: 2048,
            publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
            hash: { name: "SHA-256" }
          },
          true,
          ["sign", "verify"]
        ),
        new TextEncoder("utf-8").encode(text)
      );
      console.log(signature);
    } else {
      console.error("User denied permission to access certificates.");
    }
  })
  .catch(error => console.error("Error requesting permission:", error));