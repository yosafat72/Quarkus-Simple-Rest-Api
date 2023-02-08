package org.acme.controller;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.entity.ProductEntity;
import org.acme.service.ProductService;

@ApplicationScoped
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @Inject
    private ProductService productService;

    @GET
    @Path("/index")
    @Produces(MediaType.TEXT_HTML)
    public String productIndex() {
        return "Product controllers";
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductEntity entity) {
        productService.addProduct(entity);
        return Response.ok().build();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct() {
        List<ProductEntity> lists = productService.getProduct();
        return Response.ok(lists).build();
    }

    @GET
    @Path("/single/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSingleProduct(@PathParam(value = "id") Long id) {
        ProductEntity productEntity = productService.getSinglEntity(id);
        return Response.ok(productEntity).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteSingleProduct(@PathParam(value = "id") Long id) {
        productService.deleteProduct(id);
        return Response.ok().build();
    }

}
