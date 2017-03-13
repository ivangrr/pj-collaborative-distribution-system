package controllers;

import java.security.NoSuchAlgorithmException;

import play.data.DynamicForm;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import views.html.*;
import models.Article;
import models.Demand;
import Utils.AppUtils;

public class PageController extends Controller {

    public Result home() {
        return ok(home.render(""));
    }
    
    public Result login(){
    	return ok(login.render(""));
    }
    
    public Result logout(){
    	session().clear();
    	return ok(login.render(""));
    }
    
    public Result validateLogin() throws NoSuchAlgorithmException{
    	String passwordDefault = "e10adc3949ba59abbe56e057f20f883e";
    	String userDefault = "admin";
    	DynamicForm dynamicForm = DynamicForm.form().bindFromRequest();
    	String user = dynamicForm.get("user");
    	String password = dynamicForm.get("password");
    	String encripted = AppUtils.getEncrypt(password);
    	if(!user.equalsIgnoreCase(userDefault) && !password.equalsIgnoreCase(passwordDefault)){
    		flash("error", Messages.get("login.error"));
    		return ok(login.render(""));
    	}
    	session("connected", user);
    	return ok(home.render(user));
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
