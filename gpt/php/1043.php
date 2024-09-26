
   use Illuminate\Support\Facades\Storage;

   class YourModel extends Model
   {
       // ...

       public function getImageUrlAttribute()
       {
           $filePath = $this->attributes['image']; // your image field name
           return $filePath ? Storage::disk('s3')->temporaryUrl($filePath, now()->addMinutes(5)) : null;
       }

       // ...
   }
   
