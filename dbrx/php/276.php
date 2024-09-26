<?php

function isMagicNumberOk($fileStream) {
    $magicNumbers = [
        'ai' => ['255044462d2d0a', 8],
    ];

    foreach ($magicNumbers as $extension => list($hex, $length)) {
        $buffer = '';
        $consumed = 0;

        $filter = stream_filter_append($fileStream, 'magic_number_filter', STREAM_FILTER_READ, function () use (&$buffer, &$consumed, $hex) {
            static $i = 0;
            while (($c = fgetc(STDIN)) !== false && isset($hex[$i])) {
                if ($c === chr(hexdec(substr($hex, $i, 2)))) {
                    ++$i;
                    $buffer .= $c;
                    ++$consumed;
                    continue;
                }

                // Reset state and return failure
                $buffer = '';
                $consumed = -1;
                $i = 0;
                return false;
            }

            // Return success when all bytes match the magic number
            if ($consumed === strlen($hex) / 2) {
                return true;
            }
        });

        if ($filter !== false) {
            break;
        } else {
            throw new RuntimeException('Failed to append stream filter');
        }
    }

    // Read the remaining bytes from the file
    while (($data = fread($fileStream, 1024)) !== '') {}

    return $consumed === -1 ? null : true;
}

// Usage:
$streamContextOptions = [
    'ssl' => ['verify_peer' => false],
];

$fileUrl = "https://example.com/file.ai";
$fileResource = fopen($fileUrl, 'r', false, stream_context_create($streamContextOptions));

if (isMagicNumberOk($fileResource)) {
    // File is valid
} else {
    // Invalid file or unsupported format
}