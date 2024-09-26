const WL = {
  EncryptedCache: {
    write: (key, value, onCompleteHandler, onErrorHandler) => {
      try {
        localStorage.setItem(key, value);
        onCompleteHandler();
      } catch (error) {
        onErrorHandler(error);
      }
    }
  }
};

const userId = 12345;
const onCompleteHandler = () => console.log("Write successful");
const onErrorHandler = (error) => console.error("Write failed:", error);

WL.EncryptedCache.write("USER_ID", userId.toString(), onCompleteHandler, onErrorHandler);