namespace App\Http\Controllers\Admin;

use Illuminate\Support\Facades\Storage;

class CustomImageUploadHandler extends \Backpack\CRUD\app\Library\Uploaders\FileUploader
{
    public function getUrl($path)
    {
        return Storage::disk('s3')->temporaryUrl(
            $this->getDiskPath($path),
            now()->addMinutes(5)
        );
    }
}