const crypto = require('crypto');
const uuidv4 = require('uuid/v4');

// Generate a random GUID for the session
const sessionGuid = uuidv4();

// Get the current epoch time (number of seconds since January 1, 1970)
const epochTime = Math.floor(Date.now() / 1000);

// Encrypt the epoch time
const encryptedEpochTime = crypto.createCipher('aes-256-cbc', 'your_secret_key').update(epochTime.toString(), 'utf8', 'hex');

// Combine the session GUID and encrypted epoch time
const authValue = sessionGuid + encryptedEpochTime;

// Store the session GUID in a session
sessionStorage.setItem('EVENTKEY', sessionGuid);

// Set the auth value in a hidden field
document.getElementById('hfAuth').value = authValue;