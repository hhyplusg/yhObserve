$.fn.extend({          
    fillForm:function(jsonStr){      
    	var obj = eval("("+jsonStr+")");
    	var key,value,tagName,type,arr;
    	for(x in obj){
    		key = x;
    		value = obj[x];
    		$("[name='"+key+"'],[name='"+key+"[]']").each(function(){
    			tagName = $(this)[0].tagName;
    			type = $(this).attr('type');
    			if(tagName=='INPUT'){
    				if(type=='radio'){
    					$(this).attr('checked',$(this).val()==value);
    				}else if(type=='checkbox'){
    					arr = value.split(',');
    					for(var i =0;i<arr.length;i++){
    						if($(this).val()==arr[i]){
    							$(this).attr('checked',true);
    							break;
    						}
    					}
    				}else{
    					$(this).val(value);
    				}
    			}else if(tagName=='SELECT' || tagName=='TEXTAREA'){
    				$(this).val(value);
    			}
    			
    		});
    	}          
    }
});

/**
 * 验证表单
 */
var FormValidator = function() {  
    var handleSubmit = function() {  
        $('.form-horizontal').validate({  
            errorElement : 'span',  
            errorClass : 'help-block',  
            focusInvalid : false,  
            rules : {  
                merNo : {  
                    required : true  
                },  
                password : {  
                    required : true  
                },  
                intro : {  
                    required : true  
                }  
            },  
            messages : {  
                merNo : {  
                    required : "Username is required."  
                },  
                password : {  
                    required : "Password is required."  
                },  
                intro : {  
                    required : "Intro is required."  
                }  
            },  
  
            highlight : function(element) {  
                $(element).closest('.form-group').addClass('has-error');  
            },  
  
            success : function(label) {  
                label.closest('.form-group').removeClass('has-error');  
                label.remove();  
            },  
  
            errorPlacement : function(error, element) {  
                element.parent('div').append(error);  
            },  
  
            submitHandler : function(form) {  
                form.submit();  
            }  
        });  
  
        $('.form-horizontal input').keypress(function(e) {  
            if (e.which == 13) {  
                if ($('.form-horizontal').validate().form()) {  
                    $('.form-horizontal').submit();  
                }  
                return false;  
            }  
        });  
    }  
    return {  
        init : function() {  
            handleSubmit();  
        }  
    };  
  
}();  