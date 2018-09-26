/**
 * @author hannj
 * @dateTime 2018-1-25 上午11:29:48
 */
package com.wave.common.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wave.base.action.BaseController;
import com.wave.base.dao.mapper.EquotetargetMapper;
import com.wave.base.vo.entity.Equote;
import com.wave.base.vo.entity.EquotePojo;
import com.wave.base.vo.entity.Equotetarget;
import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.VEquote;
import com.wave.common.service.EquoteService;
import com.wave.common.service.EquoteTargetService;
import com.wave.common.service.SyscorpinforService;
import com.wave.common.service.VEquoteService;

/**
 * @author han
 * @dateTime 2018-1-25 上午11:29:48
 */
@Controller
@RequestMapping("equote")
public class EquoteController extends BaseController{
	
	@Autowired
	private EquoteService equoteServices;
	
	
	@Autowired
	private VEquoteService vequoteServices;

	@Autowired
	@Qualifier(value="syscorpinforServices")
	private SyscorpinforService syscorpinforService;


	@Autowired
	private EquotetargetMapper equotetargetMapper;
	
	@Autowired
	@Qualifier(value="EquoteTargetServices")
	private EquoteTargetService equotetargetService;

	/**
	 * @author han
	 * @param request
	 * @dateTime 2018-1-25 上午11:32:12
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	
	@RequestMapping(value = "/equoteM", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getEquotes(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String bankName, 
			@RequestParam String quoteDateStart,@RequestParam String quoteDateEnd,@RequestParam String inquiryContent,
			HttpServletRequest request) throws ApplicationException {

		Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		String corpName = bankName;
		
		List<VEquote> ret = vequoteServices.getVEquoteByBank(corpName, quoteDateStart, quoteDateEnd, inquiryContent, syscorpinfor);
		 
		Map<String, Object> retResult = new HashMap<String, Object>();
		retResult.put("pageSize", pageSize);
		retResult.put("currentPage", currentPage);
		retResult.put("total", ret.size());
		retResult.put("data", ret);
		return retResult;
	}
	
	/**
	 * @author yuanzl
	 * @param request
	 * @dateTime 2018-02-07 上午11:32:12
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 */
	@RequestMapping(value = "/equoteS", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getEquoteSelect(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String inquiryContent,
			@RequestParam String quoteDateStart,@RequestParam String quoteDateEnd, HttpServletRequest request) throws ApplicationException {
		HttpSession session = request.getSession();
		Syscorpinfor userInfo = (Syscorpinfor) session.getAttribute("userInfo");
		List<VEquote> ret = vequoteServices.getBankEquotes(quoteDateStart, quoteDateEnd, inquiryContent, userInfo);
		Map<String, Object> retResult = new HashMap<String, Object>();
		retResult.put("pageSize", pageSize);
		retResult.put("currentPage", currentPage);
		retResult.put("total", ret.size());
		retResult.put("data", ret);
		return retResult;
	}
	
	/**
	 * @author yuanzl
	 * @param request
	 * @dateTime 2018-02-07 下午13:09:12
	 * @param username
	 * @param password
	 */
	@RequestMapping(value = "/corpSelect", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	public @ResponseBody List<Syscorpinfor> getCorpSelect(@RequestParam String id) throws ApplicationException {
        //获取所有报价对象
		List<Equotetarget> allInquiries = equotetargetService.getAllInquiries(Integer.parseInt(id));
		List<Integer> lst = new ArrayList<Integer>();
		if(allInquiries!=null && allInquiries.size()>0){
			for(Equotetarget equotetarget:allInquiries){
				lst.add(equotetarget.getCorpid());
			}
		}
		
		
		List<Syscorpinfor> ret = null;
		try{
			if (lst.size() > 0) {
				ret = syscorpinforService.getAllCorps(lst);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ret;
	}
	/**
	 * @author han
	 * @param request
	 * @dateTime 2018-1-25 上午11:32:12
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 * @return 
	 */
	
	@RequestMapping(value = "/insert", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertEquote(@RequestBody EquotePojo equotePoJo,HttpServletRequest request) throws ApplicationException {

		Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		Map<String, Object> ret = new HashMap<String, Object>();
		try{
			if(syscorpinfor != null){
				equotePoJo.setCorpid(syscorpinfor.getId());
			}
			equoteServices.saveEquote(equotePoJo);
			//保存询价机构
			Integer equoteId = equotePoJo.getId();
			String[] ids = equotePoJo.getIds();
			if (ids != null && ids.length>0) {
				Equotetarget eqTarget = new Equotetarget();
					for (int i = 0; i < ids.length; i++) {
						Integer corpId = Integer.parseInt(ids[i].trim());
						eqTarget.setQuoteid(equoteId);
						eqTarget.setCorpid(corpId);
						eqTarget.setLastupdatedate(new Date());
						eqTarget.setCreationdate(new Date());
						equotetargetMapper.insert(eqTarget);
					}
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ret.put("success", true);
		return ret;
	}
	
	/**
	 * 机构补录报价
	 * @param equotePoJo
	 * @param request
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/insertByCorp", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertEquoteByCorp(@RequestBody EquotePojo equotePoJo,HttpServletRequest request) throws ApplicationException {

		Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		Map<String, Object> ret = new HashMap<String, Object>();
		try{
			String[] ids = equotePoJo.getIds();
			if (ids != null && ids.length>0) {
				for (int i = 0; i < ids.length; i++) {
					Integer corpId = Integer.parseInt(ids[i].trim());
					equotePoJo.setCorpid(corpId);
					equoteServices.saveEquoteByCorp(equotePoJo);
					if(syscorpinfor != null){
						Equotetarget eqTarget = new Equotetarget();
						eqTarget.setQuoteid(equotePoJo.getId());
						eqTarget.setCorpid(syscorpinfor.getId());
						eqTarget.setLastupdatedate(new Date());
						eqTarget.setCreationdate(new Date());
						equotetargetMapper.insert(eqTarget);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ret.put("success", true);
		return ret;
	}
	/**
	 * @author yuanzl
	 * @param request
	 * @dateTime 2018-1-31 
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> updateEquote(@RequestBody Equote equote) throws ApplicationException {

		Map<String, Object> ret = new HashMap<String, Object>();
		equoteServices.updateEquote(equote);
		ret.put("success", true);
		return ret;
	}
	
	
	/**
	 * @author yuanzl
	 * @param request
	 * @dateTime 2018-1-31 
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> deleteEquote(@RequestBody Equote equote) throws ApplicationException {
		Map<String, Object> ret = new HashMap<String, Object>();
		System.out.println(equote.getId());
		equoteServices.delEquote(equote.getId());
		ret.put("success", true);
		return ret;
	}
}
