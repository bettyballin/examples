
$firebase = new \Firebase\FirebaseLib('https://AppNameGoesHere.firebaseio.com/');

$data = array(
    'field1' => $response_array['field1'],
    'field2' => $response_array['field2'],
    'field3' => $response_array['field3']
);

// Include the Firebase Auth Token in your request
$firebaseAuthToken = 'your_firebase_id_token_here';
$path = 'users/' . $
