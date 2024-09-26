<?php

use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\DB;

// Hash all existing clear text codes in the database.
Stuff::query()->update([
    'code' => DB::raw("CONCAT('$2y$', SUBSTR(code, 1))")
]);

// When a user submits a form with a new code:
$hashedInput = bcrypt($request->code);
$usedCode = Stuff::whereRaw('BINARY `code` = ?', [$hashedInput])->get();