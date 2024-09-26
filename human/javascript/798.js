const cache = new Proxy({
  isSet: false,
  data: {}
}, {
  set(obj, prop, value) {
    if (prop === 'isSet') throw new ReferenceError()
    if (obj.isSet) throw new Error('Cache already set')
    obj.isSet = true
    return Reflect.set(...arguments)
  }
})

try {
  cache.data = { foo: 'bar' }
  console.log(cache)
} catch (e) {
  console.error(e)
}

try {
  cache.data = { baz: 'qux' }
  console.log(cache)
} catch (e) {
  console.error(e)
}