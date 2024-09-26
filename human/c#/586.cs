csharp
using System;
using System.Collections.Generic;

public class EntityInfo
{
    public string EntityState { get; set; }
}

public class ContextProvider
{
    public delegate Dictionary<Type, List<EntityInfo>> BeforeSaveEntitiesDelegate(Dictionary<Type, List<EntityInfo>> arg);
    public BeforeSaveEntitiesDelegate BeforeSaveEntitiesDelegate { get; set; }
}

public class Program
{
    private ContextProvider _contextProvider = new ContextProvider();

    public Program()
    {
        _contextProvider.BeforeSaveEntitiesDelegate = BeforeSaveEntities;
    }

    private Dictionary<Type, List<EntityInfo>> BeforeSaveEntities(Dictionary<Type, List<EntityInfo>> arg)
    {
        var resultToReturn = new Dictionary<Type, List<EntityInfo>>();
        foreach (var type in arg.Keys)
        {
            var entityName = type.FullName;
            var list = arg[type];
            if (entityName == "xyz" && list[0].EntityState != "Added")
            {
                resultToReturn.Add(type, list);
            }
        }
        return arg;
    }

    public static void Main(string[] args)
    {
        Program program = new Program();
        Dictionary<Type, List<EntityInfo>> dict = new Dictionary<Type, List<EntityInfo>>();
        // populate dict for testing
        var result = program._contextProvider.BeforeSaveEntitiesDelegate(dict);
    }
}