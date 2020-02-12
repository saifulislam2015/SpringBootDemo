package com.example.controllers;

import ClassFiles.ProxyTask;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController {


    @GetMapping(value = "/tasks",produces = "application/json")
    public String showTaskList() {
        ProxyTask proxy = new ProxyTask();
        JSONObject obj = XML.toJSONObject(proxy.RetrieveList("","<PARAMETERS></PARAMETERS>"));
        return obj.toString();
    }
}
