
Schema::table('users', function ($table) {
    $table->string('session_id')->nullable();
});

