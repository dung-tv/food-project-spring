package com.main.food.modules.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/endpoints")
public class EndPointsController {
    
//    @Autowired
//    private RequestMappingHandlerMapping requestMappingHandlerMapping;
//
//    @GetMapping
//    public ResultDto<List<EndPointResDto>>getAll(){
//        Map<String, EndPointResDto> map = new HashMap<String, EndPointDto>();
//        requestMappingHandlerMapping.getHandlerMethods().forEach((key, value) -> {
//            Set<String> setUrl = key.getPatternsCondition().getPatterns();
//            ArrayList listUrl = new ArrayList(setUrl);
//            String url = listUrl.size() == 0 ? "/" : listUrl.get(0).toString();
//
//            Set<RequestMethod> setMethod = key.getMethodsCondition().getMethods();
//            ArrayList listMethod = new ArrayList(setMethod);
//            String method = listMethod.size() == 0 ? "*" : listMethod.get(0).toString();
//
//            map.put(url, new EndPointResDto(url, method));
//        });
//        return new ResultUtil<List<EndPointResDto>>().setData(new ArrayList<>(map.values()));
//    }
}
