use Illuminate\Support\Facades\Storage;

Class Product extends Model
{
    // ..

    public function setPhotoAttribute($value)
    {
        $disk = Storage::disk('s3');
        $photoName = time().'.'.$value->getClientOriginalExtension();
        $disk->put($photoName, file_get_contents($value));
        $this->attributes['photo'] = $photoName;
    }

    public function getPhotoAttribute($value)
    {
        $disk = Storage::disk('s3');
        if ($disk->exists($value)) {
            return $disk->temporaryUrl($value, now()->addMinutes(5));
        }
        return null;
    }
}