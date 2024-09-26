<?php

namespace App\Http\Controllers\Admin;

use Illuminate\Support\Facades\Storage;
use Backpack\CRUD\app\Library\Uploaders\FileUploader;

class CustomImageUploadHandler extends FileUploader
{
    public function getUrl($path)
    {
        return Storage::disk('s3')->temporaryUrl(
            $this->getDiskPath($path),
            now()->addMinutes(5)
        );
    }
}