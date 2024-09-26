(async () => {
  const hexStringToUint8Array = (hexString) => {
    const bytes = new Uint8Array(Math.ceil(hexString.length / 2));
    for (let i = 0; i < bytes.length; i++)
      bytes[i] = parseInt(hexString.substr(i * 2, 2), 16);
    return bytes;
  };

  const verifySignature = async (body, header, tolerance = 300) => {
    header = header.split(',').reduce((accum, x) => {
      const [k, v] = x.split('=');
      return { ...accum, [k]: v };
    }, {});

    const encoder = new TextEncoder();

    const key = await crypto.subtle.importKey(
      "raw",
      encoder.encode('whsec_bPYHe4WqVVG9jri3FwIHBLZgQSHTIS6j'),
      { name: "HMAC", hash: "SHA-256" },
      false,
      ["verify"]
    );

    const verified = await crypto.subtle.verify(
      "HMAC",
      key,
      hexStringToUint8Array(header.v1),
      encoder.encode(`${header.t}.${body}`)
    );

    const elapsed = Math.floor(Date.now() / 1000) - Number(header.t);
    return verified && !(tolerance && elapsed > tolerance)
  };

  var body = `{
    "id": "evt_1JAc3EFj0bmn6HyUJpVSB1hC",
    "object": "event",
    "api_version": "2020-08-27",
    "created": 1625669316,
    "data": {
      "object": {
        "id": "prod_Jkre4DaakpOaCt",
        "object": "product",
        "active": true,
        "attributes": [

        ],
        "created": 1624892313,
        "description": null,
        "images": [
          "https://files.stripe.com/links/MDB8YWNjdF8xSXR3Y3BGajBibW42SHlVfGZsX3Rlc3RfaHlGSVhUVHFmOHVLSzFhUUVGV0FWNlc300bY6GO8NE"
        ],
        "livemode": false,
        "metadata": {
          "brand": "DOM",
          "series": "1D",
          "key_codes_start": "1",
          "key_codes_end": "114"
        },
        "name": "DOM 1D serie 1-114",
        "package_dimensions": null,
        "shippable": null,
        "statement_descriptor": null,
        "type": "service",
        "unit_label": "sleutel",
        "updated": 1625669316,
        "url": null
      },
      "previous_attributes": {
        "description": "test",
        "updated": 1625665952
      }
    },
    "livemode": false,
    "pending_webhooks": 1,
    "request": {
      "id": "req_SxhB93mIUlcaKW",
      "idempotency_key": null
    },
    "type": "product.updated"
  }`;

  var header = `t=1625700981,v1=08a60e9f42416808d1fbd3efb852695830af8f7e0da71d351dd5fbbf135d7974,v0=3ff951917ae810ac14236a0db7ce046011a1ce4d949f267650766b1c9bb1b3e2`;

  const elapsed = Math.floor(Date.now() / 1000) - Number(1625700981);
  console.log("Elapsed time in s:", elapsed)
  console.log("Verification without considering tolerance:", await verifySignature(body, header, null));
  console.log("Verification with enough tolerance:        ", await verifySignature(body, header, elapsed));
  console.log("Verification with default tolerance:       ", await verifySignature(body, header)); // default: tolerance = 300
})();