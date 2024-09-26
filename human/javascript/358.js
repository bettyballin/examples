_contextProvider.BeforeSaveEntitiesDelegate = BeforeSaveEntities;

function BeforeSaveEntities(arg) {
    var resultToReturn = {};
    for (var type in arg) {
        var entityName = type;
        var list = arg[type];
        if (entityName === "xyz" && list[0].EntityState !== "Added") {
            resultToReturn[type] = list;
        }
    }
    return arg;
}