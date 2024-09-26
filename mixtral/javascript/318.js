Here is the executable JavaScript code:


const crypto = require('crypto');
const fsPromises = require('fs').promises;

function decrypt(text, secretKey) {
    const ivSize = 8;

    // Extract IV from the end of text
    let iv = Buffer.from(text.slice(-ivSize), 'hex');

    // Remove padding and extract cipherText
    let paddedCipherText = Buffer.allocUnsafe(0);

    if (Buffer.byteLength(text) > ivSize){
        paddedCipherText = text.substring(0, text.length - ivSize).toString('hex');

        // Create decipher
        const cipherKey = crypto.createHash("sha256").update(secretKey, 'utf-8').digest();

        let decipher = crypto.createDecipheriv('des-ede3', cipherKey, iv);

        // Decrypt
        try {
            return Buffer.concat([
                decipher.update(Buffer.from(paddedCipherText, 'hex')),
                decipher.final()
            ]);

        } catch (error) {
           console.log("Decryption failed", error);

       }
    }
}

async function main(){
     const name = "your_base64_encoded_string"; // replace with your base64 encoded string
     const decode = Buffer.from(name, 'base64');

     // Read key
     let secretKey;

     try{
         secretKey = await fsPromises.readFile('some.key', { encoding: "utf8" });

      } catch (error) {
          console.log("Error reading file", error);

       }

    return decrypt(decode.toString(), secretKey).toString();
}

main().then((result) => {
    console.log(result);
}).catch((error) => {
    console.log(error);
});


Note: Replace `"your_base64_encoded_string"` with your actual base64 encoded string. Also, make sure you have a file named `some.key` in the same directory as your script, containing the secret key.