<?php

class VerifyCodeGenerator {
    protected $minLength;
    protected $maxLength;

    public function __construct($minLength = 5, $maxLength = 10) {
        $this->minLength = $minLength;
        $this->maxLength = $maxLength;
    }

    protected function generateVerifyCode()
    {
        $characters = 'ããããããããããããããããŸã¡ã¤ã¦ã¨ãªã«ã¬ã­ã®ã¯ã²ãµã¸ã»ã¾ã¿ãããããããããããããã';
        return substr(str_shuffle($characters), 0, $this->minLength + ($this->maxLength - $this->minLength) * mt_rand(0, 1));
    }

    public function getVerifyCode() {
        return $this->generateVerifyCode();
    }
}

$generator = new VerifyCodeGenerator();
echo $generator->getVerifyCode();

?>