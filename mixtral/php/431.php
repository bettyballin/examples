public function load(): void
{
    $iterator = $this->createFinder()->getIterator();

    foreach ($iterator as $file) {
        // Read the file content
        $content = file_get_contents($file);

        if (false === $content) {
            throw new \RuntimeException("Failed to read config \"{$file->getRealPath()}\".");
        }

        // Parse tokens
        $tokens = token_get_all('<?php ' . $content);

        foreach ($tokens as $token) {

            if (is_array($token)) {
                list($id, $text) = $token;
            }
        }
    }
}