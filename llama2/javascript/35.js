// Import required libraries
const SecureRandom = require('secure-random');
const RabbitCipher = require('rabbit-cipher');
const $ = require('jquery');

// Generate keys
const encryptionKey = SecureRandom.generateKey();
const decryptionKey = SecureRandom.generateKey();

// Event listener for encryption button click
$('.encrypt').on('click', function() {
  // Get plaintext value
  const plaintext = $('.plaintext').val();
  
  // Encrypt plaintext using RabbitCipher
  const ciphertext = RabbitCipher.encrypt(plaintext, encryptionKey);
  
  // Set ciphertext value
  $('.ciphertext').val(ciphertext);
});