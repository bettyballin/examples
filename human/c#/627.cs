csharp
using System.Net;
using System.Web.Http;
using System.Web.Http.Controllers;

namespace YourApp.Web.ApiControllers
{
    [AllowAnonymous]
    public class ProductsController : ApiController
    {
        private readonly IProductRepository _repository;

        public ProductsController(IProductRepository repository)
        {
            _repository = repository;
        }

        [HttpGet]
        public HttpResponseMessage Products()
        {
            var result = new ProductResult();
            result.Products = _repository.GetProducts();
            return Request.CreateResponse(HttpStatusCode.OK, result);
        }
    }

    public class ProductResult
    {
        public Product[] Products { get; set; }
    }

    public interface IProductRepository
    {
        Product[] GetProducts();
    }

    public class Product
    {
        public int Id { get; set; }
        public string Name { get; set; }
    }

    public class ProductRepository : IProductRepository
    {
        public Product[] GetProducts()
        {
            return new Product[]
            {
                new Product { Id = 1, Name = "Product 1" },
                new Product { Id = 2, Name = "Product 2" },
            };
        }
    }
}