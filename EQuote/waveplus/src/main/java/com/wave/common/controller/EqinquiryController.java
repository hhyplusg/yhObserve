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

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wave.base.action.BaseController;
import com.wave.base.dao.mapper.EqinquirytargetMapper;
import com.wave.base.vo.entity.Eqinquiry;
import com.wave.base.vo.entity.EqinquiryPojo;
import com.wave.base.vo.entity.Eqinquirytarget;
import com.wave.base.vo.entity.Syscorpinfor;
import com.wave.base.vo.entity.VEqinquiry;
import com.wave.base.vo.entity.VEqinquiryTarget;
import com.wave.common.service.EqinquiryService;
import com.wave.common.service.EqinquiryTargetService;
import com.wave.common.service.VEqinquiryTargetService;
import com.wave.core.util.StringUtil;

/**
 * @author han
 * @dateTime 2018-1-25 上午11:29:48
 */
@Controller
@RequestMapping("inquiry")
public class EqinquiryController extends BaseController{
	
	@Autowired
	private EqinquiryService eqinquiryServices;
	
	@Autowired
	private EqinquirytargetMapper eqinquirytargetMapper;
	
	@Autowired
	@Qualifier(value="eqinquiryTargetServices")
	private EqinquiryTargetService eqinquiryTargetService;
	
	@Autowired
	@Qualifier(value="vEqinquiryTargetService")
	private VEqinquiryTargetService vEqinquiryTargetService;
	/**
	 * @author han
	 * @param request
	 * @dateTime 2018-1-25 上午11:32:12
	 * @param mav the redirect and response params object
	 * @param username
	 * @param password
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	@RequestMapping(value = "/askPrice11", method = RequestMethod.POST)
	protected ModelAndView login(final HttpServletRequest request, final ModelAndView mav) {
		mav.setViewName("/askPrice");
		return mav;

	}
	
	@RequestMapping(value = "/askPrice", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> askPrice(@RequestParam Integer pageSize,
			@RequestParam Integer currentPage, @RequestParam String bankName) throws ApplicationException {

		List<Eqinquiry> ret = null;
		try{
			ret = eqinquiryServices.getAllInquiries();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Map<String, Object> retResult = new HashMap<String, Object>();
		retResult.put("pageSize", pageSize);
		retResult.put("currentPage", currentPage);
		retResult.put("total", 20);
		retResult.put("data", ret);
		return retResult;
	}
	
	/**
	 * @author han
	 * @param request
	 * @dateTime 2018-2-5 上午11:32:12
	 * @param username
	 * @param password
	 * @return 
	 */
	
	@RequestMapping(value = "/insert", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> insertInquiry(@RequestBody EqinquiryPojo eqinquiryPojo,HttpServletRequest request) throws ApplicationException {
		Eqinquiry inquiry = new Eqinquiry();
		inquiry.setInquirycontent(eqinquiryPojo.getInquirycontent());
		inquiry.setInquirydate(new Date());
		Map<String, Object> ret = new HashMap<String, Object>();
		Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		inquiry.setCorpid(syscorpinfor.getId());
		try {
			eqinquiryServices.saveEqinquiry(inquiry);
			//保存询价机构
			Integer inquiryId = inquiry.getId();
			
			String ids = eqinquiryPojo.getIds();
			if (StringUtil.isNotEmpty(ids)) {
				String[] split = null;
				if(ids.contains(",")){
					split = ids.split(",");
					for (int i = 0; i < split.length; i++) {
						Integer corpId = Integer.parseInt(split[i].trim());
						Eqinquirytarget iqTarget = new Eqinquirytarget();
						iqTarget.setInquiryid(inquiryId);
						iqTarget.setCorpid(corpId);
						iqTarget.setLastupdatedate(new Date());
						iqTarget.setCreationdate(new Date());
						eqinquirytargetMapper.insert(iqTarget);
					}
				}else{
					Integer corpId = Integer.parseInt(ids.trim());
					Eqinquirytarget iqTarget = new Eqinquirytarget();
					iqTarget.setInquiryid(inquiryId);
					iqTarget.setCorpid(corpId);
					iqTarget.setLastupdatedate(new Date());
					iqTarget.setCreationdate(new Date());
					eqinquirytargetMapper.insert(iqTarget);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace ();
		}
		ret.put ("success", true);
		return ret;
	}
	
	/**
	 * 机构查询询价信息
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/showInquiryList", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	@ResponseBody
	public  List<VEqinquiry> showInquiryList(@RequestParam String corpName,
			@RequestParam String inquiryDateStart,@RequestParam String inquiryDateEnd,
			HttpServletRequest request) throws ApplicationException {
		Syscorpinfor syscorpinfor = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		corpName = syscorpinfor.getCorpname();
		List<VEqinquiry> ret = eqinquiryServices.getInquiriesByCorp(corpName, inquiryDateStart, inquiryDateEnd);
		return ret;
	}
	
	/**
	 * 银行查询询价信息
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/showInquiryLists", produces = "application/json; charset=utf-8",method = RequestMethod.GET)
	@ResponseBody
	public  List<VEqinquiry> showInquiryLists(@RequestParam String corpName,HttpServletRequest request,@RequestParam String inquiryDateStart,@RequestParam String inquiryDateEnd) throws ApplicationException {
		List<VEqinquiry> ret = null;
		List<VEqinquiry> rets = new ArrayList<VEqinquiry>();
		
		//获取当前登录的银行id
		Syscorpinfor userInfo = (Syscorpinfor) request.getSession().getAttribute("userInfo");
		int corpId = userInfo.getId();
		
		//查询出所有的时间段内的询价记录
		ret = eqinquiryServices.getInquiriesByCorp(corpName, inquiryDateStart, inquiryDateEnd);
		for(VEqinquiry equiry: ret){
			//查询当前询价的所有关联对象
			List<Eqinquirytarget> equiryTarget = eqinquiryTargetService.getAllInquiries(equiry.getId());
		    if(equiryTarget!=null&&equiryTarget.size()>0){
		    	for(Eqinquirytarget equirytarget :equiryTarget){
		    		//判断当前询价是否含此机构
		    		if(corpId == equirytarget.getCorpid()){
		    			//展示对此机构的询价
		    			rets.add(equiry);
		    			continue;
		    		}
		    	}
		    } else{
		    	//展示公开询价
		    	rets.add(equiry);
		    }
		}
		return rets;
	}
	
	/**
	 * 查询询价对象信息
	 * 
	 * @return
	 * @throws ApplicationException
	 */
	@RequestMapping(value = "/a", produces = "application/json; charset=utf-8",method = RequestMethod.POST)
	@ResponseBody
	public  List<VEqinquiryTarget> showInquiryTargets(@RequestParam String corpName,
			@RequestParam String inquiryDateStart,@RequestParam String inquiryDateEnd,HttpServletRequest request) throws ApplicationException {
		System.out.println("===============aaaa==================================");
		List<VEqinquiryTarget> ret = null;
//		Date date = new Date();
//		
//		//获取当前登录的银行id
//		HttpSession session = request.getSession();
//		Syscorpinfor userInfo = (Syscorpinfor) session.getAttribute("userInfo");
//		int corpId = userInfo.getId();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		
//		//判断起始日期是否为空，若为空，展示当天时间
//		if(StringUtils.isBlank(inquiryDateStart)){
//			inquiryDateStart = sdf.format(date);
//		}
//		//判断结束日期是否为空，若为空，展示当天时间
//		if(StringUtils.isBlank(inquiryDateEnd)){
//			inquiryDateEnd = sdf.format(date);
//		}
//		inquiryDateStart = inquiryDateStart + " 00:00:00";
//		inquiryDateEnd = inquiryDateEnd + " 23:59:59";
//		//查询出所有的时间段内的询价记录
//		ret = vEqinquiryTargetService.getInquiresByBank(corpName, inquiryDateStart, inquiryDateEnd, userInfo);

		return ret;
	}
}
