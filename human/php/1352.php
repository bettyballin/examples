class Model extends Eloquent
{
    /*
        Attribute which are protected from updating.
    */

    protected $protected = [
        'name', 'email'
    ];

    protected static function boot()
    {
        parent::boot();

        static::saving(function ($model) {
            if($model->id){
                foreach($model->protected as $attribute){
                    $model->$attribute = $model->getOriginal($attribute);
                }
            }
        });
    }
}