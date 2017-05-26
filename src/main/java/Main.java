import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

import com.codecool.shop.controller.CartController;
import com.codecool.shop.controller.LoginController;
import com.codecool.shop.controller.ProductController;
import com.codecool.shop.dao.*;
import com.codecool.shop.dao.jdbc.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.jdbc.ProductDaoJdbc;
import com.codecool.shop.dao.jdbc.SupplierDaoJdbc;
import com.codecool.shop.dao.jdbc.UserDaoJdbc;
import com.codecool.shop.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.TemplateEngine;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        TemplateEngine templateEngine = new ThymeleafTemplateEngine();
        CartController cartController = CartController.getInstance();
        ProductController productController = ProductController.getInstance();
        LoginController loginController = LoginController.getInstance();

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        // populate some data for the memory storage

        //populateData();


        // Always add generic routes to the end
        get("/", productController::renderProducts, templateEngine);
        // Equivalent with above

        get("/index", (Request req, Response res) ->
                productController.renderProducts(req, res), templateEngine);

        get("/cartview", (Request req, Response res) ->
                templateEngine.render(cartController.renderCart(req, res))
        );

        get("/category/:id", (Request req, Response res) ->
                templateEngine.render(productController.renderProductsbyCategory(req, res))
        );

        get("/supplier/:id", (Request req, Response res) ->
                templateEngine.render(productController.renderProductsbySupplier(req, res))
        );

        get("/addtocart/:id", (Request req, Response res) ->
                cartController.addItemToCart(req, res)

        );

        get("/login", (Request req, Response res) ->
                templateEngine.render(loginController.renderLogin(req, res))
        );


        post("/login", (Request req, Response res) ->
                templateEngine.render(loginController.renderLoginPost(req, res))
        );

        get("/addtocart/:id", cartController::addItemToCart);

        // Add this line to your project to enable the debug screen
        enableDebugScreen();
        logger.info("Application is running");
    }
}