package com.wave.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.ClientDatatModel;
import com.wave.base.action.BaseController;
import com.wave.common.cnstants.Constants;
import com.wave.common.service.CDictService;
import com.wave.common.vo.CDictVo;

@ResponseBody
@Controller
public class CDictController  extends BaseController {
    @Autowired
    CDictService cDictService;
    
    /**
     *  根据数据字典的key列表返回相应字典数据
     * @param cDictVoList   多个值用半角逗号分割即可
     * @return
     */
    @RequestMapping(value = "/getDictListBytypes",method = RequestMethod.GET)
    public ClientDatatModel<Map<String,  List<CDictVo>>>  getDictListBytypes(@RequestParam("cDictTypeList") List<String> cDictTypeList){ 
        if (log.isDebugEnabled()) {
            log.debug("getDictListBytypes( ) is start");
            log.debug("getDictListBytypes( ) 传入参数：\r\n" + cDictTypeList);
        } 
       ClientDatatModel<Map<String,  List<CDictVo>>> ClientDatatModel = new ClientDatatModel<>();
       Map<String,  List<CDictVo>> cDictMap = null;
       if (cDictTypeList.size() < 1) {
           ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
           ClientDatatModel.setMsg("字典类型为空");
       } else {
    	   cDictMap = cDictService.getDictListBytypes(cDictTypeList);
           ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
           ClientDatatModel.setMsg(""); 
           ClientDatatModel.setData(cDictMap); 
       } 
       if (log.isDebugEnabled()) {
           
           log.debug("getDictListBytypes( ) 返回值：\r\n" + ClientDatatModel);
           log.debug("getDictListBytypes( ) is end");
       } 
       return ClientDatatModel;
    }
    
    /**
     *  通过数据字典Pid取得数据字典
     * @param cDictPids   多个值用半角逗号分割即可
     * @return
     */
    @RequestMapping(value = "/getDictListByPids",method = RequestMethod.GET)
    public ClientDatatModel<Map<String,  List<CDictVo>>>  getDictListByPids(@RequestParam("cDictPidList") List<String> cDictPidList){ 
        if (log.isDebugEnabled()) {
            log.debug("getDictListBytypes( ) is start");
            log.debug("getDictListBytypes( ) 传入参数：\r\n" + cDictPidList);
        } 
       ClientDatatModel<Map<String,  List<CDictVo>>> ClientDatatModel = new ClientDatatModel<>();
       if (cDictPidList.size() < 1) {
           ClientDatatModel.setCode(Constants.CONTROLLER_FAIL);
           ClientDatatModel.setMsg("字典Pid为空!"); 
       } else {
           Map<String,  List<CDictVo>> cDictMap = cDictService.getCDictByPid(cDictPidList);
           ClientDatatModel.setCode(Constants.CONTROLLER_SUCCE);
           ClientDatatModel.setMsg(""); 
           ClientDatatModel.setData(cDictMap); 
       } 
       if (log.isDebugEnabled()) {
           log.debug("getDictListBytypes( ) 返回值：\r\n" + ClientDatatModel);
           log.debug("getDictListBytypes( ) is end");
       } 
       return ClientDatatModel;
    }
}