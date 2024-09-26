
function update_user($update_data) {
    global $pdo;

    $update = array();
    $data_values = array();
    
    foreach ($update_data as $field => $data) {
        $update[]
