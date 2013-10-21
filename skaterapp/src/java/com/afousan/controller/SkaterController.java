/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afousan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author MacMini
 */
@Controller
public class SkaterController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
