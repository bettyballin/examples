<?php
if (isset($_REQUEST['data'])) {
    $data = $_REQUEST['data'];
    if (!empty($data)) {
        // Process the form data
        Security::checkToken();
        // Save the data
        $myModel = new MyModel();
        $myModel->saveAll($data);
    }
}
?>