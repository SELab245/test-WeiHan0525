package fcu.android.backend.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fcu.android.backend.data.Shop;
import fcu.android.backend.db.ShopDBManager;

@Path("shop/")
public class ShopService {

	private ShopDBManager dbManager = ShopDBManager.getInstance();

	@POST
	@Path("register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Shop register(@FormParam("shopName") String userName, @FormParam("password") String password,
			@FormParam("email") String email, @FormParam("phone") String phone) {
		Shop shop = new Shop();
		shop.setShopName(userName);
		shop.setPassword(password);
		shop.setEmail(email);
		shop.setPhone(phone);
		dbManager.addShop(shop);
		return shop;
	}

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	@GET
	@Path("ok/{email}/{password}")
	@Produces(MediaType.TEXT_PLAIN)
	public String ok(@PathParam("email") String email, @PathParam("password") String pass) {
		if (email.equals("a") && pass.equals("b")) {
			return "true";
		}

		return "false";
	}

	@POST
	@Path("validate")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String isValidShop(@FormParam("email") String email, @FormParam("password") String password) {
		boolean valid = dbManager.validateShop(email, password);
		return String.valueOf(valid);
	}

	@GET
	@Path("{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Shop getShop(@PathParam("email") String email) {

		return dbManager.getShop(email);
	}

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shop> listShops() {
		return dbManager.listAllShops();
	}

}
