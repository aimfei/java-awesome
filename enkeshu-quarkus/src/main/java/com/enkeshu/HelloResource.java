package com.enkeshu;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * （自定义类描述）
 *
 * @author yemengard
 * @date 2021/5/16
 **/
@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String world(@Context UriInfo uriInfo, @QueryParam("order") String order, @HeaderParam("Authorization")String authorization) {

        return String.format("URI:%s - Order = %s  authorization=%s", uriInfo.getRequestUri(), order,authorization);
    }
}
