package controllers;

import Utils.AppUtils;
import models.Article;
import play.mvc.*;
import views.html.*;
import play.api.i18n.Messages;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
//    	Article article = new Article();
//    	article.name = "Article 1 name";
//    	article.code = "A12345";
//    	article.description = "Article 1 description";
//    	article.save();
        return ok(index.render(""));
    }
    
    public Result login(){
    	return ok(login.render(""));
    }
    
    public Result main(){
    	return ok(main.render(""));
    }

}
