package com.springapi;

import com.com.tools.Result;
import com.com.tools.Tools;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ncov")
@CrossOrigin
public class NcovApi {

    //发生的事件
    @RequestMapping(value = "timeline",method = RequestMethod.POST)
    public Result<JSONObject> timeline() {
        Tools tools = new Tools();
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("pageNo","1");
        paramMap.put("pageSize", "100");
        JSONObject response =  tools.sendGet("https://wuhan.wbjiang.cn/api/timeline",paramMap);
        System.out.println(response);
        return Result.success(response);
    }

    //整体数据
    @RequestMapping(value = "stats",method = RequestMethod.POST)
    public Result<JSONObject> stats() {
        Tools tools = new Tools();
        JSONObject response =  tools.sendGet("https://wuhan.wbjiang.cn/api/stats",null);
        System.out.println(response);
        return Result.success(response);
    }


    @RequestMapping(value = "cityStats",method = RequestMethod.POST)
    public Result<JSONObject> cityStats(@RequestBody Map<String,String> map) {
        Tools tools = new Tools();
        System.out.println(map.get("city"));
        JSONObject response =  tools.sendGet("https://wuhan.wbjiang.cn/api/city_stats/"+map.get("city")+"",null);
        System.out.println(response);
        return Result.success(response);
    }




}
