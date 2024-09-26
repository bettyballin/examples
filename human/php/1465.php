<?php

$rules = [
    ".read" => "auth != null",
    ".write" => "auth != null",
    "conversations" => [
        "$uid" => [
            ".indexOn" => ["userId"]
        ]
    ]
];

echo json_encode($rules);

?>