
   $context = stream_context_create([
       'ssl' => [
           'verify_peer' => false,
           'verify_peer_name' => false,
       ],
   ]);

   $client = new SoapClient("https://example.com/WSDL/
