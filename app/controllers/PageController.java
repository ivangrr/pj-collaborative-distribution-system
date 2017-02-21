package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import models.Article;
import models.Demand;

public class PageController extends Controller {

    public Result home() {
        return ok(home.render(""));
    }
    
    public Result login(){
    	return ok(login.render(""));
    }
    
    public Result article(){
    	return ok(article.render(Article.find.all()));
    }
    
    public Result articleCreate(){
    	return ok(create_article.render());
    }
    
    public Result demand(){
    	return ok(demand.render(Demand.find.all()));
    }

}
