function md5File(file) {
    const CHUNK_SIZE = 4 * 1024 * 1024; // 4MB
    let offset = 0;
    let chunkSize;

    return new Promise((resolve, reject) => {
        let fileReader = new FileReader();

        function readSlice() {
            if (file.size > offset + CHUNK_SIZE)
                chunkSize = CHUNK_SIZE
            else
                chunkSize = file.size - offset;

            const blob = file.slice(offset, offset + chunkSize);

            fileReader.readAsArrayBuffer(blob);
        }

        let md5Hash = CryptoJS.algo.MD5.create();

        fileReader.onloadend = function (evt) {

            if (!file || !md5Hash) return;

            var arrayBuff = evt.target.result
                byteArray = new Uint8Array(arrayBuff);

            md5Hash.update(byteArray);

            if (offset + chunkSize < file.size) {
                offset += chunkSize;
                readSlice();
            } else {
                resolve(md5Hash.finalize().toString(CryptoJS.enc.Hex));
            }
        };

        fileReader.onerror = function (evt) {
            reject(evt);
        };

        readSlice();
    });
}