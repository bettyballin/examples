<?php
$config = [
    'posts' => [
        'HTML.AllowedAttributes' => ['blockquote.data-author'],
        'HTML.AllowedAttributeValues' => [
            'blockquote.data-author' => ['string', 'trim']
        ]
    ]
];

print_r($config);
?>