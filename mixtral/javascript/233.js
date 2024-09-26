Here is the executable JavaScript code:


class RestrictedResolver {
  constructor(options) {
    this.maxDepth = options && typeof options === 'object' ? (options.depth || Infinity) : Infinity;
  }

  apply(resolver) {
    resolver
      .getHook('described-resolve')
        .tapAsync("RestrictedResolver", (request, resolveContext, callback) => {
          const requestedPath = request.path;

          if (!/^\.\/\//.test(requestedPath)) return callback();

          let depthCounter = 0;

          for (let i = 1; i < requestedPath.length - 2; ++i) {
            // Count the number of "../" in the path
            if (requestedPath[i] === '.' && requestedPath[i + 1] === '/') depthCounter++;

            if(depthCounter > this.maxDepth){
              return callback({
                message: `Importing from ${this.maxDepth} levels up is not allowed`,
                request,
                path: null
              });

            }
          }

          // If the requestedPath doesn't go beyond max depth
          if (depthCounter <= this.maxDepth) return callback();
        })
      .end()

    resolver
      .getHook('resolve')
        .for("module")
        .tapAsync("RestrictedResolver", (request, resolveContext, callback) => {
          const requestedPath = request.path;

          if (!/^\.\/\//.test(requestedPath)) return callback();

          let depthCounter = 0;

          for (let i = 1; i < requestedPath.length - 2; ++i) {
            // Count the number of "../" in the path
            if (requestedPath[i] === '.' && requestedPath[i + 1] === '/') depthCounter++;

            if(depthCounter > this.maxDepth){
              return callback({
                message: `Importing from ${this.maxDepth} levels up is not allowed`,
                request,
                path: null
              });

            }
          }

          // If the requestedPath doesn't go beyond max depth
          if (depthCounter <= this.maxDepth) return callback();
        })
      .end()
  }
}