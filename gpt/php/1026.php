
public function decrypt($encryptedBuffer)
{
    ini_set('memory_limit', '1G');

    $f = fopen('myfile', 'wb+');
    $chunkSize = 2048;
    $progress = 0
