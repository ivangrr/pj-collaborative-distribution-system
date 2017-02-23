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
    
    public Result showArticle(){
    	return ok(show_article.render(Article.find.all()));
    }
    
    public Result articleCreate(){
    	return ok(management_article.render(null));
    }
    
    public Result articleUpdate(Long id){
    	Article article = Article.find.byId(id);
    	return ok(management_article.render(article));
    }
    
    public Result showDemand(){
    	return ok(show_demand.render(Demand.find.all()));
    }

}
