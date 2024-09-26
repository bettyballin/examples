
const crypto = require("crypto");
const config = require("../../amazonConfig.json");

exports.createS3Policy = function(callback) {
  const date = new Date();

  // Make sure the expiration date is in the future and formatted correctly
  const s3Policy = {
    "expiration
