<?php

class RandomStringGenerator {
  /**
   * Generates a random string of a given length, using the random source of
   * the operating system. The string contains only characters of this
   * alphabet: +/0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
   * @param int $length Number of characters the string should have.
   * @return string A random base64 encoded string.
   */
  public static function generateRandomBase64String($length)
  {
    if (!defined('MCRYPT_DEV_URANDOM')) throw new Exception('The MCRYPT_DEV_URANDOM source is required (PHP 5.3).');

    // Generate random bytes, using the operating system's random source.
    // Since PHP 5.3 this also uses the random source on a Windows server.
    // Unlike /dev/random, the /dev/urandom does not block the server, if
    // there is not enough entropy available.
    $binaryLength = (int)($length * 3 / 4 + 1);
    $randomBinaryString = mcrypt_create_iv($binaryLength, MCRYPT_DEV_URANDOM);
    $randomBase64String = base64_encode($randomBinaryString);
    return substr($randomBase64String, 0, $length);
  }
}

// Test the function
echo RandomStringGenerator::generateRandomBase64String(32);

?>