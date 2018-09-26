App = {
    config:{
        url:(function(){
            //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
            var curWwwPath=window.document.location.href;
            //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName=window.document.location.pathname;
            var pos=curWwwPath.indexOf(pathName);
            //获取主机地址，如： http://localhost:8083
            var localhostPaht=curWwwPath.substring(0,pos);
            //获取带"/"的项目名，如：/uimcardprj
            var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
            return(localhostPaht+projectName);
        }()),
        isLogin:false
    },
    cookie:{
        setCookie:function(c_name,value,expiredays){
            var exdate=new Date();
            exdate.setDate(exdate.getDate()+expiredays);
            document.cookie=c_name+ "=" +escape(value)+";path=/"+
                ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
        },
        getCookie:function(c_name){
            if (document.cookie.length>0) {
                c_start=document.cookie.indexOf(c_name + "=");
                if (c_start!=-1) {
                    c_start=c_start + c_name.length+1;
                    c_end=document.cookie.indexOf(";",c_start);
                    if (c_end==-1) c_end=document.cookie.length;
                    return unescape(document.cookie.substring(c_start,c_end));
                }
            }
            return "";
        }
    }
};
/**
 * 前端字典处理JS组件，从后台缓存/数据库中查询所有字典数据，然后再浏览器Cookie中保存，
 * HTML中显示字典直接从Cookie中获取获取数据，效率更高。
 * @author TanDong
 * @since 2015-4-23 11:48 create
 */

//获取所有字典数据
var DictCache = function() {
	if (typeof DictCache.instance === 'object') {
		return DictCache.instance;
	}
	DictCache.instance = this;
	this.dictTypes = new Array();
	this.dictItems = new Array();
	this.getDictItemName = getDictItemName;
	this.getDictItems = getDictItems;
	this.getDictItemsCallBack = getDictItemsCallBack;
	this.sync = sync;
	this.dictData = new Object();
	
	//获取字典项名称typeCode：字典类型编码，itemCode：字典项编码
	function getDictItemName(typeCode, itemCode){
		if(this.dictTypes.length <= 0){
			return "";
		}
		var items = this.dictData[typeCode];
		for(var i=0; i<items.length; i++){
			if(items[i].itemCode != itemCode){
				continue;
			}
			return items[i].itemName;
		}
	}
	
	//获取所有字典项typeCode：字典类型编码
	function getDictItems(typeCode){
		var ret = new Array();
		if(null == this.dictData){
			return ret;
		}
		ret = this.dictData[typeCode];
		return ret;
	}
	
	
	//获取所有字典项typeCode：字典类型编码
	function getDictItemsCallBack(typeCode, callback){
		if(this.dictTypes.length <= 0){
			return new Array();
		}
		var ret = this.getDictItems(typeCode);
		callback({"data":ret});
	}
	
	function sync(url) {
		if (this.dictTypes.length == 0) {
			console.log("Sync dict from cache.");
			//loadAllDict(this, url);
			loadAllDictFromCache(this, url);
		}
	}
};
//字典缓存数据JS对象
var dictCache = new DictCache();
dictCache.sync();


function loadAllDictFromCache(glcache, url) {
	var requestUrl = url;
	if(null == requestUrl || undefined == requestUrl){
		requestUrl = App.config.url+"/dict/getAllFromCache";
	}
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		processData : false,
		success : function(data, textStatus, jqXHR) {
			var ret = eval(data);
			if(ret.success){
				glcache.dictData = ret.data;
				glcache.dictTypes = ret.data.dictTypes;
			}else{
				console.log("Sync dict from cache has error.");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			var result = JSON.parse(XMLHttpRequest.responseText);
			console.log("Sync dict from cache has error :"+result);
		}
	});
}

function loadAllDict(glcache, url) {
	var requestUrl = url;
	if(null == requestUrl || undefined == requestUrl){
		requestUrl = App.config.url+"/dict/getAllFromCache";
	}
	$.ajax({
		url : requestUrl,
		method : 'post',
		async : false,
		contentType : 'application/json;charset=UTF-8',
		dataType : 'json',
		processData : false,
		success : function(data, textStatus, jqXHR) {
			var ret = eval(data);
			if(ret.success){
				glcache.dictTypes = ret.data.dictTypes;
				glcache.dictItems = ret.data.dictItems;
			}else{
				console.log("Sync dict from cache has error.");
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			var result = JSON.parse(XMLHttpRequest.responseText);
			console.log("Sync dict from cache has error :"+result);
		}
	});
}