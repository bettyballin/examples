
function calculateMD5(file, chunkSize) {
    var blobSlice = File.prototype.slice || File.prototype.mozSlice || File.prototype.webkitSlice,
        chunks = Math.ceil(file.size / chunkSize),
        currentChunk = 0,
        spark = new SparkMD5.ArrayBuffer(), // Initialize a new instance of SparkMD5
        fileReader = new FileReader();

    fileReader.onload = function(e) {
        spark.append(e.target.result); // Append array buffer
        currentChunk++;

        if (currentChunk < chunks) {
            loadNext();
        } else {
            var md5 = spark.end(); // Finalize the hash
            console.log('MD5 hash:', md5); // Output the result
            // Here you can also resolve a promise or call a callback function
        }
    };

    fileReader.onerror = function
