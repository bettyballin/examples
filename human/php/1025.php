$recording = Recording::create($attributes);
$recording->hash = base64_encode(Hash::make($recording->recordID . Config::get('APP_KEY')));
$recording->save();