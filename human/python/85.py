import json
import numpy as np

def numpy_default(obj):
    if isinstance(obj, np.ndarray):
        return {'_npdata': obj.tostring(), 
                '_npdtype': obj.dtype.name,
                '_npshape': obj.shape}
    else:
        return json.JSONEncoder.default(json.JSONEncoder(), obj)

def dumps(obj):
    return json.dumps(obj, default=numpy_default)

def numpy_hook(obj):
    try:
        data = obj['_npdata']
    except KeyError:
        return obj
    return np.fromstring(data, obj['_npdtype']).reshape(obj['_npshape'])

def loads(obj):
    return json.loads(obj, object_hook=numpy_hook)

# example usage
if __name__ == "__main__":
    array = np.array([1, 2, 3, 4, 5])
    print("Original array: ", array)

    dumped_array = dumps(array)
    print("Dumped array: ", dumped_array)

    loaded_array = loads(dumped_array)
    print("Loaded array: ", loaded_array)