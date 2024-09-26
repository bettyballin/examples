
function myHmac(string $data, string $key, callable $algoFn, int $algoBlockSizeInBytes): string
{
  if (strlen($key) > $algoBlockSizeInBytes) {
    $key = $algoFn($key); // keys longer than blocksize are shortened
  }

  if (strlen($key) < $algoBlockSizeInBytes) {
    // keys shorter than blocksize are zero-padded (chr(0) is the null byte)
    $key = str_pad($key, $algoBlockSizeInBytes, "\0", STR_PAD_RIGHT);
  }

  // str_repeat should be used with the chr function to get the
