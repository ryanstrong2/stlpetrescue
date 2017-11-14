package org.ryanstrong.springbonjour.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {
        String name = request.getParameter("name");// needs to match query string
        if (name == null) {
            name = "world!";
        }
        return "Hello " + name;
    }
    @RequestMapping(value="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

//    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    @ResponseBody
//    public String helloForm(){
//        String html = "<form method='post'>" +
//                "<input type='text' name='name' />" +
//                "<input type='submit' value='Greet Me />" +
//                "</form>";
//        return html;
//    }

    @RequestMapping(value = "foreignHello", method = RequestMethod.GET)
    @ResponseBody
    public String foreignForm() {
        String html = "<form method='post'>" +
                "<input type='text' name ='name'/>" +
                "<select name='lang'><option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='bosnian'>Bosnian</option>" +
                "<option value='vietnamese'>Vietnamese</option>" +
                "<option value='german'>German</option>" +
//                "<option value='spanish'>Spanish</option>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form>";
        return html;
        }
        @RequestMapping(value = "foreignHello", method = RequestMethod.POST)
        @ResponseBody
        public String foreignPost (HttpServletRequest request) {
            String name = request.getParameter("name");
            String language = request.getParameter("lang");
            return createMessage(name, language);
        }
        public static String createMessage(String name, String language){
            String helloTranslation="";
            switch (language){
                case "french":
                    helloTranslation = "Bonjour ";
                    break;
                case "spanish":
                    helloTranslation = "Hola ";
                    break;
                case "bosnian":
                    helloTranslation = "Zdravo ";
                    break;
                case "vietnamese":
                    helloTranslation = "Xin Chao ";
                    break;
                case "german":
                    helloTranslation = "Guten Tag ";
                    break;

            }
            return helloTranslation + name;
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
            return "Hello" + name;
    }
//    @RequestMapping(value = "hello", method = RequestMethod.POST)
//    public String helloPost(HttpServletRequest request){
//        String name = request.getParameter("name");// key must match form
//        return "Hello" + name;
//    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "goodbye";
    }

}
