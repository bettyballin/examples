(async () => {

  var uncomressedKeyB64 = 'BAmL07vrRR5lfkWuH1RAFJufx0B4J+BdOqIYZCH+fJc8c+5sFch8aXEJ6qVgTnnYjKwrQ1BO3Tg28/F1h/FjMVQ='; 
  var comressedKeyB64 = 'AgmL07vrRR5lfkWuH1RAFJufx0B4J+BdOqIYZCH+fJc8';

  const b64ToBin = (b64) => {
      const binaryString = atob(b64);
      const length = binaryString.length;
      const bytes = new Uint8Array(length);
      for (let i = 0; i < length; i++) {
          bytes[i] = binaryString.charCodeAt(i);
      }
      return bytes.buffer;
  };

  const importB64Key = async (base64key) => {
      const bin = b64ToBin(base64key);
      console.log('bin ', bin);
      const key = await crypto.subtle.importKey(
          'raw',
          bin,
          {
              name: 'ECDH',
              namedCurve: 'P-256',
          },
          true,
          [] 
      );
      return key;
  };

  console.log(await importB64Key(uncomressedKeyB64));
  console.log(await importB64Key(comressedKeyB64));

})();