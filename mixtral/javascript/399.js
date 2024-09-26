Here is the modified JavaScript code:


var password = "my_password";

// Generate a random IV
const iv = CryptoJS.lib.WordArray.random(128 / 8);

function encryptFile() {
    var fileInput = document.getElementById("file-input");

    if (fileInput && fileInput.files[0]) {
        const reader = new FileReader();

        // Read the selected file as a binary string
        reader.readAsBinaryString(fileInput.files[0]);

        reader.onloadend = function () {
            var encryptedData;

            try {
                // Encrypt using AES
                const key = CryptoJS.PBKDF2(password, iv);

                encryptedData = CryptoJS.AES.encrypt(reader.result, key, {
                    mode: CryptoJS.mode.CBC,
                    padding: CryptoJS.pad.Pkcs7,
                    iv: iv
                });

                // Download the encrypted file
                const blob = new Blob([encryptedData.toString()], { type: 'application/octet-stream' });
                const url = URL.createObjectURL(blob);
                const a = document.createElement('a');
                a.href = url;
                a.download = 'encrypted_file';
                a.click();

            } catch (e) {
                console.error(e);
            }

        };

        reader.onerror = function (e) {
            console.error(e);
        };

    }
}

function decryptFile() {
    // implement decryption logic here
}