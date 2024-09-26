namespace App\Fields;

use Backpack\ImageFieldType;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Carbon;

class CustomImageField extends ImageFieldType {
    public function getTemporaryUrl() {
        $disk = Storage::disk($this->attributes['disk']);
        return $disk->temporaryUrl(
            $this->value,
            Carbon::now()->addMinutes(5)
        );
    }
}