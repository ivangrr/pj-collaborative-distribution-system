package controllers;

import java.util.List;

import models.Article;
import play.api.data.*;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.*;
import views.html.*;

public class Articles extends Controller {
	
	public Result save() {
		DynamicForm dynamicForm = DynamicForm.form().bindFromRequest();
		Article article = new Article(Long.valueOf(dynamicForm.get("code")), dynamicForm.get("code"), dynamicForm.get("name"), dynamicForm.get("description"));
		article.save();		
		return redirect(routes.PageController.showArticle());
	}
	
	public Result update(Long id) {
		DynamicForm dynamicForm = DynamicForm.form().bindFromRequest();
		Article article = new Article(Long.valueOf(dynamicForm.get("code")), dynamicForm.get("code"), dynamicForm.get("name"), dynamicForm.get("description"));
		article.save();		
		return redirect(routes.PageController.showArticle());
	}
	
	public Result remove(Long id){
		Article article = Article.find.ref(id); 
		article.delete();
		return redirect(routes.PageController.showArticle());
	}

}
