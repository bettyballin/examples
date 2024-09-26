
const crypto = require('crypto');
const express = require('express');
const app = express();

app.get("/test", function(req, res) {
  const key = Buffer.from("12345678901234567890123456789012"); // 32 bytes for AES-256
  const iv = Buffer.from("123456789012"); // 12 bytes recommended for GCM
  
  // Encrypt
  const cipher = crypto.createCipheriv('aes-256-gcm', key, iv);
  let encrypted = cipher.update("bla", 'utf8', 'hex');
  encrypted += cipher.final('hex');
  const authTag = cipher.getAuthTag
