csharp
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.DataProtection;
using Windows.Storage;

public class DataStorage
{
    private ApplicationDataContainer _roamingSettings;

    public DataStorage()
    {
        _roamingSettings = ApplicationData.Current.RoamingSettings;
    }

    public void StoreData(IBuffer buffProtected)
    {
        DataReader reader = DataReader.FromBuffer(buffProtected);
        byte[] array = new byte[reader.UnconsumedBufferLength];
        reader.ReadBytes(array);
        _roamingSettings.Values["apiPublic"] = array;
    }

    public IBuffer RetrieveData()
    {
        byte[] deserializedArray = (byte[])_roamingSettings.Values["apiPublic"];
        return CryptographicBuffer.CreateFromByteArray(deserializedArray);
    }
}