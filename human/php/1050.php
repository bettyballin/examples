try {
    $result = password_verify($this->password, $data['password_hash']);
} catch (Exception $ex) {
    error_log(get_class($this) . '::' . __FUNCTION__ . ': password_verify() failed.');
}