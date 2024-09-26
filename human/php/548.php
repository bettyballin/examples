Here is the PHP code equivalent to the provided Delphi code:


<?php

class TmfmDelphi_to_PHP_Symetric {
  private $rgTestVectors;
  private $rgChainMode;
  private $edtPassword;
  private $memoPlaintext;
  private $lblPassword;
  private $lblPlaintext;
  private $cryptoMain;
  private $codecAES;
  private $memoOutput;
  private $btnEncrypt;
  private $actlstMain;
  private $actEncrypt;
  private $edtSeed;
  private $lblSeed;
  private $btnRandomize;
  private $actRandomize;
  private $rgCipher;

  public function __construct() {
    $this->rgTestVectors = 0;
    $this->rgChainMode = 0;
    $this->edtPassword = '';
    $this->memoPlaintext = '';
    $this->lblPassword = 'Password';
    $this->lblPlaintext = 'Plaintext';
    $this->cryptoMain = null;
    $this->codecAES = null;
    $this->memoOutput = '';
    $this->btnEncrypt = 'Encrypt';
    $this->actlstMain = null;
    $this->actEncrypt = null;
    $this->edtSeed = '1';
    $this->lblSeed = 'Seed';
    $this->btnRandomize = 'Randomize';
    $this->actRandomize = null;
    $this->rgCipher = 0;
  }

  public function actEncryptExecute() {
    $testCases = array('Test Vector 1', 'Test Vector 2', 'Custom');
    $cipher = 'AES-128-CFB';
    $chainMode = 'CFB';

    switch ($this->rgChainMode) {
      case 0:
        $chainMode = 'CFB';
        break;
      case 1:
        $chainMode = 'CBC';
        break;
      case 2:
        $chainMode = 'ECB';
        break;
    }

    switch ($this->rgCipher) {
      case 0:
        $cipher = 'AES-128-CFB';
        break;
    }

    $password = $this->edtPassword;
    $plaintext = $this->memoPlaintext;
    $seed = (int)$this->edtSeed;

    $randomStream = new TRandomStream();
    $randomStream->Seed = $seed;

    $key = hash('sha256', $password, true);
    $iv = hash('md5', $password, true);

    $ciphertext = openssl_encrypt($plaintext, $cipher, $key, OPENSSL_RAW_DATA, $iv);

    $this->memoOutput .= "Test case = " . $testCases[$this->rgTestVectors] . "\n";
    $this->memoOutput .= "Cipher = " . $cipher . "\n";
    $this->memoOutput .= "Chain mode = " . $chainMode . "\n";
    $this->memoOutput .= "PRNG seed = " . $seed . "\n";
    $this->memoOutput .= "Password (UTF-8) = '" . $password . "'\n";
    $this->memoOutput .= "------------\n";
    $this->memoOutput .= "Key as hex = " . bin2hex($key) . "\n";
    $this->memoOutput .= "Plaintext (UTF-8) = '" . $plaintext . "'\n";
    $this->memoOutput .= "------------\n";
    $this->memoOutput .= "Ciphertext (base64) [Includes prepended IV and block quantisation] = '" . base64_encode($ciphertext) . "'\n";
    $this->memoOutput .= "------------\n";
    $this->memoOutput .= "Ciphertext (hex) [Includes prepended IV and block quantisation] = '" . bin2hex($ciphertext) . "'\n";
    $this->memoOutput .= "------------\n";
  }

  public function actRandomizeExecute() {
    $randomStream = new TRandomStream();
    $randomStream->Randomize();
    $this->edtSeed = (string)$randomStream->Seed;
  }

  public function rgTestVectorsClick() {
    switch ($this->rgTestVectors) {
      case 0:
        $this->edtPassword = 'Your lips are smoother than vasoline.';
        $this->memoPlaintext = 'Leeeeeeeeeroy Jenkins!';
        $this->edtSeed = '1';
        $this->rgChainMode = 0;
        $this->rgCipher = 0;
        break;
      case 1:
        $this->edtPassword = 'ORATIO IN L. CATILINAM PRIMA';
        $this->memoPlaintext = 'Quo usque tandem abutere, Catili';
        $this->edtSeed = '333';
        $this->rgChainMode = 0;
        $this->rgCipher = 0;
        break;
      case 2:
        break;
    }

    $isCustom = $this->rgTestVectors == 2;
    $this->edtPassword = $isCustom ? '' : $this->edtPassword;
    $this->memoPlaintext = $isCustom ? '' : $this->memoPlaintext;
    $this->edtSeed = $isCustom ? '' : $this->edtSeed;
    $this->rgChainMode = $isCustom ? 0 : $this->rgChainMode;
    $this->rgCipher = $isCustom ? 0 : $this->rgCipher;
  }

  public function SpaceOut($sCompacted) {
    $newLineSpacing = 70;
    $bunchSpacing = 6;

    $result = '';
    $i = 0;

    for ($j = 0; $j < strlen($sCompacted); $j++) {
      if (($j % $newLineSpacing) == 0 && $j != 0) {
        $result .= "\n";
      } elseif (($j % $bunchSpacing) == 0 && $j != 0) {
        $result .= ' ';
      }

      $result .= $sCompacted[$j];
    }

    return $result;
  }
}

class TRandomStream {
  public $Seed;

  public function Randomize() {
    $this->Seed = rand(1, 1000000);
  }
}

$mfmdelphi_to_php_symetric = new TmfmDelphi_to_PHP_Symetric();
$mfmdelphi_to_php_symetric->actEncryptExecute();

?>