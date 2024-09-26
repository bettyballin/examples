csharp
using System;
using System.Web.Mvc;
using System.Collections.Generic;

public class Product
{
    public int Id { get; set; }
    public string Name { get; set; }
}

public class ProductsListView
{
    public List<Product> Products { get; set; }
}

public class ProductsRepository
{
    public List<Product> GetProducts()
    {
        return new List<Product>
        {
            new Product { Id = 1, Name = "Product 1" },
            new Product { Id = 2, Name = "Product 2" },
            new Product { Id = 3, Name = "Product 3" }
        };
    }
}

public class ProductsController : Controller
{
    private readonly ProductsRepository _repository;

    public ProductsController()
    {
        _repository = new ProductsRepository();
    }

    public ActionResult Index()
    { 
        var view = new ProductsListView();
        view.Products = _repository.GetProducts();
        return View(view);
    }
}