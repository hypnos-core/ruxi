package org.example.util;



//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.ocean.angel.tool.doucment.dto.*;
//import lombok.extern.slf4j.Slf4j;
//import java.util.ArrayList;
//import java.util.List;

/**
 * Doc文档生成的格式模板
 */
public class SourceDoc {
//
//
//    /**
//     * 将swagger /v2/api-docs接口返回的数据转化成标准数据
//     * @param documentData
//     * @param jsonString
//     */
//    public static void dataHandler(DocumentData documentData, String jsonString) {
//
//        try {
//            // 将字符串转换为JSON对象
//            JSONObject jsonObject = JSONObject.parseObject(jsonString);
//
//            // 文档标题
//            if(StrUtil.isEmpty(documentData.getTitle())) {
//                String title = jsonObject.getJSONObject("info").getString("title");
//                documentData.setTitle(title);
//            }
//
//            // swagger definitions 数据
//            JSONObject definitionsJSONObject = jsonObject.getJSONObject("definitions");
//
//            // swagger paths 数据
//            JSONObject paths = jsonObject.getJSONObject("paths");
//
//            // 接口tags数据，用于定义文档的二级目录
//            List<ApiTag> tags = tagsHandler(paths, definitionsJSONObject);
//            documentData.setTags(tags);
//
//        } catch (Exception e) {
//            log.error("SwaggerApiDataHandlerUtil.dataHandler() error. {}", e.getMessage(), e);
//        }
//    }
//
//    /**
//     * Tags数据处理
//     * @param pathsJSONObject
//     * @return
//     */
//    private static List<ApiTag> tagsHandler(JSONObject pathsJSONObject, JSONObject definitionsJSONObject) {
//
//        List<ApiTag> tags = new ArrayList<>();
//
//        for (String path : pathsJSONObject.keySet()) {
//
//            ApiData apiData = new ApiData();
//
//            // 请求url
//            apiData.setPath(path);
//
//            JSONObject apiJSONObject = pathsJSONObject.getJSONObject(path);
//            for(String type: apiJSONObject.keySet()) {
//
//                // 请求方式
//                apiData.setType(type);
//                JSONObject apiDataJSONObject = apiJSONObject.getJSONObject(type);
//
//                // 接口名称
//                apiData.setName(apiDataJSONObject.getString("description"));
//
//                // 接口tag
//                apiData.setTag(apiDataJSONObject.getJSONArray("tags").getString(0));
//
//                // 请求参数数据处理
//                JSONArray parametersJSONArray = apiDataJSONObject.getJSONArray("parameters");
//                requestParamHandler(parametersJSONArray, definitionsJSONObject, apiData);
//
//                // 响应数据和响应码数据处理
//                JSONObject responsesJSONObject = apiDataJSONObject.getJSONObject("responses");
//                responseHandler(responsesJSONObject, definitionsJSONObject, apiData);
//
//                // 数据组装，将api划归到tag下
//                tagsDataHandler(tags, apiData);
//            }
//        }
//
//        return tags;
//    }
//
//    /**
//     * 请求参数处理
//     * @param parametersJSONArray
//     * @param definitionsJSONObject
//     * @return
//     */
//    private static void requestParamHandler(JSONArray parametersJSONArray, JSONObject definitionsJSONObject, ApiData apiData) {
//
//        List<ApiParam> list = new ArrayList<>();
//        for (Object object : parametersJSONArray) {
//            JSONObject jsonObject = (JSONObject) object;
//            JSONObject schemaJSONObject = jsonObject.getJSONObject("schema");
//            if(null == schemaJSONObject) {
//
//                // 普通参数
//                ApiParam apiParam = JSONObject.parseObject(JSON.toJSONString(object), ApiParam.class);
//                list.add(apiParam);
//            } else {
//
//                // 对象参数
//                String ref = schemaJSONObject.getString("$ref").replace("#/definitions/", "");
//                JSONObject propertiesJSONObject = definitionsJSONObject.getJSONObject(ref).getJSONObject("properties");
//
//                // 对象参数转换，对象参数不能再嵌套
//                for (String name : propertiesJSONObject.keySet()) {
//                    ApiParam apiParam = new ApiParam();
//                    apiParam.setName(name);
//                    apiParam.setType(propertiesJSONObject.getJSONObject(name).getString("type"));
//                    apiParam.setDescription(propertiesJSONObject.getJSONObject(name).getString("description"));
//                    apiParam.setRequired(false);
//                    list.add(apiParam);
//                }
//            }
//        }
//        // 更新接口参数
//        apiData.setParameters(list);
//    }
//
//    private static void responseHandler(JSONObject responsesJSONObject, JSONObject definitionsJSONObject, ApiData apiData) {
//
//        // 响应码列表
//        List<ApiResponseCode> codes = new ArrayList<>();
//        for (String code : responsesJSONObject.keySet()) {
//
//            // 响应码
//            ApiResponseCode apiResponseCode = new ApiResponseCode();
//            apiResponseCode.setCode(code);
//            JSONObject codeJSONObject = responsesJSONObject.getJSONObject(code);
//            apiResponseCode.setMsg(codeJSONObject.getString("description"));
//            codes.add(apiResponseCode);
//
//            // 响应数据
//            if("200".equals(code)) {
//
//                JSONObject schemaJSONObject = codeJSONObject.getJSONObject("schema");
//                if(null != schemaJSONObject) {
//                    // 响应数据逻辑
//                    List<ApiParam> responses = new ArrayList<>();
//                    String ref = schemaJSONObject.getString("$ref").replace("#/definitions/", "");
//                    // 引用对象参数处理
//                    List<ApiParam> params = refParamHandler(ref, definitionsJSONObject);
//                    if(CollUtil.isNotEmpty(params)) {
//                        boolean flag = true;
//                        while (flag) {
//                            responses.addAll(params);
//                            flag = false;
//
//                            List<ApiParam> itemParams = new ArrayList<>();
//                            for (ApiParam param : params) {
//                                if(StrUtil.isNotEmpty(param.getRef())) {
//                                    itemParams.addAll(refParamHandler(param.getRef(), definitionsJSONObject));
//                                }
//                            }
//
//                            if(itemParams.size() > 0) {
//                                params = itemParams;
//                                flag = true;
//                            }
//                        }
//                    }
//                    // 更新接口响应数据
//                    apiData.setResponses(responses);
//                }
//            }
//        }
//        // 更新接口响应码
//        apiData.setCodes(codes);
//    }
//
//    /**
//     * 将引用对象，转化为apiParam列表
//     * @param ref
//     * @param definitionsJSONObject
//     * @return
//     */
//    private static List<ApiParam> refParamHandler(String ref, JSONObject definitionsJSONObject) {
//
//        JSONObject propertiesJSONObject = definitionsJSONObject.getJSONObject(ref).getJSONObject("properties");
//
//        List<ApiParam> params = new ArrayList<>();
//        for (String name : propertiesJSONObject.keySet()) {
//
//            ApiParam apiParam = new ApiParam();
//            apiParam.setName(name);
//            apiParam.setType(propertiesJSONObject.getJSONObject(name).getString("type"));
//            String description = propertiesJSONObject.getJSONObject(name).getString("description");
//            apiParam.setDescription(description);
//
//            JSONObject dataJSONObject = propertiesJSONObject.getJSONObject(name);
//            if(null != dataJSONObject && "data".equals(name)) {
//                String itemRef = dataJSONObject.getString("$ref");
//                apiParam.setRef(itemRef);
//                continue;
//            }
//
//            JSONObject rowsJSONObject = propertiesJSONObject.getJSONObject(name);
//            if(null != rowsJSONObject && "rows".equals(name)) {
//                JSONObject itemsJSONObject = rowsJSONObject.getJSONObject("items");
//                String itemRef = itemsJSONObject.getString("$ref").replace("#/definitions/", "");
//                apiParam.setRef(itemRef);
//            }
//
//            params.add(apiParam);
//
//        }
//
//        return params;
//    }
//
//    /**
//     * 接口API分类处理，划归到制定tag下
//     * @param tags
//     * @param apiData
//     */
//    private static void tagsDataHandler(List<ApiTag> tags, ApiData apiData) {
//
//        if (CollUtil.isNotEmpty(tags)) {
//            for (ApiTag tag : tags) {
//                if(apiData.getTag().equals(tag.getName())) {
//                    tag.getApis().add(apiData);
//                    return;
//                }
//            }
//        }
//
//        List<ApiData> apis = new ArrayList<>();
//        apis.add(apiData);
//
//        ApiTag apiTag = new ApiTag();
//        apiTag.setApis(apis);
//        apiTag.setName(apiData.getTag());
//
//        tags.add(apiTag);
//    }
}
