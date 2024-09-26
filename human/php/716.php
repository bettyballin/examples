public function testCreateDigest(DOMDocument $request, $expectedDigest) {
    $ns = $request->documentElement->namespaceURI;
    $body = $request
        ->getElementsByTagNameNS($ns, 'Body')
        ->item(0);

    $content = $body->C14N(true, true); // <-- exclusive, with comments

    $actualDigest = base64_encode(hash('sha1', $content, true));

    $this->assertEquals($expectedDigest, $actualDigest);
}