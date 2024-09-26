const WL = {
  EncryptedCache: {
    write: (key, value, onComplete, onError) => {
      try {
        // Simulating writing to cache
        console.log(`Writing ${value} to ${key}`);
        onComplete();
      } catch (error) {
        onError(error);
      }
    }
  }
};

const userId = "some_user_id";
const onCompleteHandler = () => console.log("Write complete");
const onErrorHandler = (error) => console.error("Write error:", error);

WL.EncryptedCache.write("USER_ID", userId, onCompleteHandler, onErrorHandler);