package com.hmkcode;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hmkcode.vo.Article;


public class App 
{
    
    public static void printThingsUppercaseStrings (List things){
    int i = 0;
    try {
        while(true){
            Object o = things.get(i);
            System.out.println(o);
            if(o.getClass() == String.class){
                String so = (String) o;
                so = so.toUpperCase();
                System.out.println(so);
            }
            i++;
        }
    } catch (IndexOutOfBoundsException e){
        //iteration complete
    }
}
    public static void notSoFinal() throws NoSuchFieldException, IllegalAccessException, InterruptedException {
    ExampleClass example = new ExampleClass(10);
    System.out.println("Final value was: "+ example.finalValue);
    Field f = example.getClass().getDeclaredField("finalValue");
    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
    f.setInt(example, 77);
    System.out.println("Final value was: "+ example.finalValue);
}
 
public static class ExampleClass {
    final int finalValue;
 
    public ExampleClass(int finalValue){
        this.finalValue = finalValue;
    }
}
    
    public static void horribleIteration(String [] words){
    int i = 0;
    try {
        while(true){
            System.out.println(words[i]);
            i++;
        }
    } catch (IndexOutOfBoundsException e){
        //iteration complete
    }
}
    
    public static void main( String[] args )
    {
    	Gson gson = new Gson();
    	

    	List<Article> articles = new LinkedList<Article>();
    	
    	articles.add(createArticle());
    	articles.add(createArticle());
    	
    	// Java --> JSON
    	String json = gson.toJson(articles);
    	System.out.println("toJson: "+json);
    	
    	
    	// JSON --> Java
    	List list = gson.fromJson(json, List.class);
    	System.out.println("fromJson: "+list);
    	System.out.println("Class Type: "+list.get(0).getClass());

    	// JSON --> Java "Get the actual type"
    	Type type = new TypeToken<List<Article>>(){}.getType();
    	list = gson.fromJson(json, type);
    	System.out.println("fromJson: "+list);
    	System.out.println("Class Type: "+list.get(0).getClass());


    }
    private static Article createArticle(){
    	
    	Article article = new Article();
    	
    	article.setTitle("GSON - Java JSON Library");
    	article.setUrl("http://hmkcode.com/gson-json-java");
    	article.addCategory("Java");
    	article.addTag("Java");
    	article.addTag("GSON");
    	article.addTag("JSON");
    	
    	return article;
    }
}
