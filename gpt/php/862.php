
// Serialized data which includes an array and an object
$serializedData = serialize(array('a' => 'b', 'c' => 20, 'obj' => new stdClass()));

// Unserialize with all classes disallowed
$data = unserialize($serializedData, array('allowed_classes' => false));

print_r($data);

