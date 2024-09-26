(async () => {

    const getMd5 = async (fileObject) => {
        let md5 = "";
        try {
            const fileObjectUrl = URL.createObjectURL(fileObject);
            const blobText = await fetch(fileObjectUrl)
                .then((res) => res.blob())
                .then((res) => new Response(res).arrayBuffer());                    // Convert to ArrayBuffer       
            const hash = CryptoJS.MD5(CryptoJS.lib.WordArray.create(blobText)); // Import as WordArray
            md5 = hash.toString(CryptoJS.enc.Hex);
        } catch (err) {
            console.log("Error occured getMd5:", err);
        }
        return md5;
    };

    const blob = new Blob([new Uint8Array([0x01, 0x02, 0x03, 0x7f, 0x80, 0x81, 0xfd, 0xfe, 0xff])]);
    console.log(await getMd5(blob));

})();