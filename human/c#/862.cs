csharp
using System;
using System.Collections.Generic;

public enum CKA
{
    CKA_TOKEN,
    CKA_KEY_TYPE
}

public enum CKK
{
    CKK_DES3
}

public class ObjectAttribute
{
    public CKA Type { get; set; }
    public object Value { get; set; }

    public ObjectAttribute(CKA type, object value)
    {
        Type = type;
        Value = value;
    }
}

class Program
{
    static void Main()
    {
        List<ObjectAttribute> objectAttributes = new List<ObjectAttribute>();
        objectAttributes.Add(new ObjectAttribute(CKA.CKA_TOKEN, true));
        objectAttributes.Add(new ObjectAttribute(CKA.CKA_KEY_TYPE, CKK.CKK_DES3));
    }
}