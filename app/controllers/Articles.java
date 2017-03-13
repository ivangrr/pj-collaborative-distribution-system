package controllers;

import java.util.List;

import org.springframework.util.StringUtils;

import models.Article;
import play.api.data.*;
import play.data.DynamicForm;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.*;
import views.html.*;
import Utils.PageUtils;
import com.avaje.ebean.Ebean;

public class Articles extends Controller {

	public Result save() {
		DynamicForm dynamicForm = DynamicForm.form().bindFromRequest();
		Article article = new Article();
		String code = PageUtils.generateID(PageUtils.ARTICLE_CODE);
		article.code= code;
		article.name = dynamicForm.get("name");
		article.description = dynamicForm.get("description");
		article.save();
		flash("success", Messages.get("article.created", code));		
		return redirect(routes.PageController.articleCreate());
	}

	public Result update() {
		DynamicForm dynamicForm = DynamicForm.form().bindFromRequest();
		Article article = Article.find
				.byId(Long.valueOf(dynamicForm.get("id")));
		article.name = dynamicForm.get("name");
		article.description = dynamicForm.get("description");
		Ebean.save(article);
		return redirect(routes.PageController.showArticle());
	}

	public Result remove(Long id) {
		Article article = Article.find.ref(id);
		flash("success", Messages.get("article.deleted", article.code));
		article.delete();	
		return redirect(routes.PageController.showArticle());
	}

}
