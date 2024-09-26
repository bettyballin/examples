// Define the function findIPsWithWebRTC
async function findIPsWithWebRTC() {
    return new Promise((resolve, reject) => {
        // Simulating a successful IP retrieval
        const ipInfo = { ip: "192.168.1.100" };
        resolve(ipInfo);
    });
}

// In an `async` function
(async () => {
    try {
        const ipInfo = await findIPsWithWebRTC();
        console.log(ipInfo); // ...use `ipInfo`...
    } catch (error) {
        console.error(error); // Handle/report error
    }
})();