<?php

function get_coordinates($city, $street, $province) {
    $address = urlencode($city .', '. $street .', '. $province);
    $url = 'https://maps.googleapis.com/maps/api/geocode/json?address='. $address .'&key=YOUR_API_KEY';
    $response = json_decode(file_get_contents($url), true);
    if ($response['status'] == 'OK') {
        return $response['results'][0]['geometry']['location'];
    } else {
        return false;
    }
}

function GetDrivingDistance($lat1, $lat2, $long1, $long2) {
    $url = 'https://maps.googleapis.com/maps/api/distancematrix/json?origins='. $lat1 .','. $long1 .'&destinations='. $lat2 .','. $long2 .'&mode=driving&key=YOUR_API_KEY';
    $response = json_decode(file_get_contents($url), true);
    if ($response['rows'][0]['elements'][0]['status'] == 'OK') {
        return array(
            'distance' => $response['rows'][0]['elements'][0]['distance']['text'],
            'time' => $response['rows'][0]['elements'][0]['duration']['text']
        );
    } else {
        return false;
    }
}

$city = 'Krakow';
$country = 'Poland';

$coordinates1 = get_coordinates('Tychy', 'Jana Pawła II', 'Śląskie');
$coordinates2 = get_coordinates($city, '', $country);
if ( !$coordinates1 || !$coordinates2 )
{
    echo 'Bad address.';
}
else
{
    $dist = GetDrivingDistance($coordinates1['lat'], $coordinates2['lat'], $coordinates1['lng'], $coordinates2['lng']);
    echo 'Distance: <b>'.$dist['distance'].'</b><br>Travel time duration: <b>'.$dist['time'].'</b>';
}
?>