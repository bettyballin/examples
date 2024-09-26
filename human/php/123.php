<?php

class HashProcessor {
    private $_rainbowTable = array();
    private $_expectedKeys = array();

    public function processPostData($spinnerKey) {
        $spinner = $_POST[$spinnerKey];
        $values = array();

        foreach ($_POST as $key => $value) {
            if ($key !== $spinnerKey) {
                $values[$this->deHash($key, $spinner)] = $value;
            }
        }
        return $values;
    }

    private function deHash($hashedKey, $spinner) {
        $rt = $this->getRainbowTable($spinner);

        return isset($rt[$hashedKey]) ? $rt[$hashedKey] : NULL;
    }

    private function getRainbowTable($spinner) {
        if (count($this->_rainbowTable) > 0) {
            return $this->_rainbowTable;
        }

        foreach ($this->_expectedKeys as $key) {
            $this->_rainbowTable[hash($key, $spinner)] = $key;
        }

        return $this->_rainbowTable;
    }
}

$hashProcessor = new HashProcessor();
$hashProcessor->_expectedKeys = array('key1', 'key2', 'key3'); // Define your expected keys
$spinnerKey = 'spin';
$values = $hashProcessor->processPostData($spinnerKey);

print_r($values);

?>