class FormKeyGenerator {
    private $data = array();

    public function getFormKey()
    {
        if (!$this->getData('_form_key')) {
            $this->setData('_form_key', $this->getRandomString(16));
        }
        return $this->getData('_form_key');
    }

    public function getData($key)
    {
        return isset($this->data[$key]) ? $this->data[$key] : null;
    }

    public function setData($key, $value)
    {
        $this->data[$key] = $value;
    }

    public function getRandomString($length)
    {
        $chars = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
        $string = '';
        for ($i = 0; $i < $length; $i++) {
            $string .= $chars[rand(0, strlen($chars) - 1)];
        }
        return $string;
    }
}

$formKeyGenerator = new FormKeyGenerator();
echo $formKeyGenerator->getFormKey();