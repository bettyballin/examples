<?php

use Illuminate\Support\Facades\Crypt;
use Illuminate\Support\Facades\Input;

$question_id = Crypt::decrypt(Input::get('question_id'));