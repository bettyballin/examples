<?php
$data = ["key" => "value"];

if (is_array($data)) {
    $jsonData = json_encode($data);

    if ($jsonData !== false) {
        echo "<script>var data = {$jsonData};</script>";
    } else {
        echo "Error encoding data to JSON.";
    }
}
?>