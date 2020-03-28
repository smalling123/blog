/**
* 请求接口服务器地址（跨域请求，前后端分离时使用，默认为空）
* 例如： var AppURL = "";
*/
var AppURL = "";

/**
* 身份验证/token信息延时
*/
function AppToken() {
	var url = window.location.href.split("Views")[0];

	if (window.sessionStorage.getItem("token") == null || window.sessionStorage.getItem("token")=="") {
		top.location.href = "/login.html";
		return false;
	}

	$.ajax({
		type: "Post",
		url: AppURL +"/Permission/ValidToken",
		async: true,
		data: {
			"token": window.sessionStorage.getItem("token")
		},
		dataType: "json",
		success: function (data) {
			if (data.code == 0) {
				if (data.token) {
                    window.sessionStorage.setItem("token", data.token);
				}
			}
			else {
				top.location.href = "/login.html";
			}
		}, 
		error: function () {
			top.location.href = "/login.html";
		}
	});
}

/**
* get方式请求数据
* @param ajaxs ajax请求内容
*/
function GetAppAjax(ajaxs) {
	AppToken();
	$.ajax({
		type: "Get",
		url: ajaxs.url,
		async: true,
		data: ajaxs.data,
		beforeSend: function(request) {
			request.setRequestHeader("token", window.sessionStorage.getItem("token"));
		},
		dataType: ajaxs.dataType || "json",
		success: ajaxs.success,
		error: ajaxs.error
	});
}
/**
* 自定义方式请求数据
* @param ajaxs ajax请求内容
*/
function NoneAppAjax(ajaxs) {
	AppToken();
	$.ajax(ajaxs);
}

/**
* post方式请求数据
* @param ajaxs ajax请求内容
*/
function PostAppAjax(ajaxs) {
	AppToken();
	$.ajax({
		type: "Post",
		url:  ajaxs.url,
		async: true,
		data: ajaxs.data,
		beforeSend: function(request) {
			request.setRequestHeader("token", window.sessionStorage.getItem("token"));
		},
		dataType: ajaxs.dataType || "json",
		contentType:  ajaxs.contentType || "application/x-www-form-urlencoded; charset=UTF-8",
		success: ajaxs.success,
		error: ajaxs.error
	});
}

/**
* 退出方法（token注销）
*/
function AppExit() {
	sessionStorage.clear();
	window.location.href = "/login.html";
}

/**
*获取URL中的参数
*/
function getUrlParameter(name){
	name = name.replace(/[]/,"\[").replace(/[]/,"\[").replace(/[]/,"\\\]");
	var regexS = "[\\?&]"+name+"=([^&#]*)";
	var regex = new RegExp( regexS );
	var results = regex.exec(window.location.href );
	if( results == null ) return ""; else {
		return results[1];
	}
};

/**
 *对Date的扩展，将 Date 转化为指定格式的String
 *月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
 *年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 *例子：
 *(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 *(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
 */
Date.prototype.format = function (fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份
		"d+": this.getDate(), //日
		"h+": this.getHours(), //小时
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度
		"S": this.getMilliseconds() //毫秒
	};
	if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for (var k in o)
		if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));	
	return fmt;
}

/**
* 打开弹出窗口
*/
function openAppWindow(p){
	var index = parent.layer.open({
		type: 2,
		title: p.title,
		fix: true,
		maxmin: p.maxmin || false,
		btnAlign: 'r',
		shadeClose: false,
        shade: p.shade || 0 ,
		tipsMore: true,
		area: p.area || "auto",
        content: p.url,
        resizing: function (layero) {
            var iframe = parent.window[layero.find('iframe')[0]['name']];
            var iframeid = layero.find('iframe')[0]['name'];
            var iframeHeight = layero[0].clientHeight;
            parent.$("#" + iframeid).height(iframeHeight-42);
        },
        full: function (layero) {
            var iframe = parent.window[layero.find('iframe')[0]['name']];
            var iframeid = layero.find('iframe')[0]['name'];
            var iframeHeight = layero[0].clientHeight;
            parent.$("#" + iframeid).height(iframeHeight - 42);
        },
        min: function (layero) {
            var iframe = parent.window[layero.find('iframe')[0]['name']];
            var iframeid = layero.find('iframe')[0]['name'];
            var iframeHeight = layero[0].clientHeight;
            parent.$("#" + iframeid).height(iframeHeight - 42);
        },
        restore: function (layero) {
            var iframe = parent.window[layero.find('iframe')[0]['name']];
            var iframeid = layero.find('iframe')[0]['name'];
            var iframeHeight = layero[0].clientHeight;
            parent.$("#" + iframeid).height(iframeHeight - 42);
        },
		success: p.success,
		skin: 'layui-layer-lan'
	});
}


/** iframe页面关闭方法 */
function iframecloses() {
    //当你在iframe页面关闭自身时
    var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
    parent.layer.close(index); //再执行关闭   
}

/**
 * 动态获取后台数据绑定下拉列表
 * @param {String} id 下拉列表的id (!!需要配合bootstrap-select 开启 data-live-search="true"  使用!!)
 * @param {Function} fun 获取后台数据的方法(!!需要动态写上填充和刷新 select的方法 !!)
 */
function SelectFrom(id, fun) {
	//延迟一秒后监听select输入内容，防止样式未加载注册监听不起作用
	//键入字符触发事件:动态获得后台传入select选项数据
	//选择得到搜索栏input，松开按键后触发事件
	var control1 =$(id).next('button').next('.open').children('.bs-searchbox').find('input');
	$(id).next('button').next('.open').children('.bs-searchbox').append("<i class='appbtn' style='float:right; margin-right:11px;margin-top:-26px' > <i class='glyphicon glyphicon-search'></i></i>");
	var control2 =$(id).next('button').next('.open').children('.bs-searchbox').find('.appbtn');
	control1.keyup(function (event) {
		if (event.which == 13) {
			var inputManagerName = control1.val();
			//键入的值
			//判定键入的值不为空，才调用ajax
			if (inputManagerName != '') {
				fun(inputManagerName);
			} else {
				//如果输入的字符为空，清除之前option标签
				$(id).empty();
				$(id).append("<option value=''>--请选择--</option>");
			}
			$(id).selectpicker('refresh');
		}
	});
	control2.click(function () {
		var inputManagerName = control1.val();
		//键入的值
		//判定键入的值不为空，才调用ajax
		if (inputManagerName != '') {
			fun(inputManagerName);
		} else {
			//如果输入的字符为空，清除之前option标签
			$(id).empty();
			$(id).append("<option value=''>--请选择--</option>");
		}
		$(id).selectpicker('refresh');
		return false;
	});
}


/**
*Trigger触发时回调的方法
**/
var Triggers = new Array();

/**
 * 数据联动触发器回调方法注册
 * @param {Function(key)} fun 记录方法
 */
function onTrigger(fun) {
	Triggers.push(fun);
}

/**
*当数据提交变更，希望更新查询时的，触发数据联动的方法，传入触发的Key
**/
function doTrigger(key){
	window.sessionStorage.setItem("SessionTrigger", key);//在session池写入以发生改变的项	
	window.sessionStorage.removeItem('SessionTrigger');//在清除session池中刚刚写入的发生改变的项，防止单一项频繁触发造成监听不到修改
}

/**
* 动态监听session池变化
*/
window.addEventListener("storage",  function (e) {
	if (e.key == 'SessionTrigger' && e.oldValue) {
		var vals = e.oldValue.split(",");//获得当前session池中发生更改的项
		for (var x = 0; x < vals.length; x++) {
			for(var j=0; j<Triggers.length; j++){
				Triggers[j](vals[x]); //回调注册的Trigger方法
			}
		}
	}
}, true);


if (typeof jQuery === "undefined") { throw new Error("Bootstrap's JavaScript requires jQuery") }

!function ($) {
	'use strict';
	var Validate = function (form, options) {
		var self = this;
		this.options = $.extend({}, $.fn.validate.defaults, options)
		this.$form = $(form).attr("novalidate", 'novalidate');
		this.$form.submit(function () {
			return onsubmit.call(self);
		});
		this.disabled = false;
		this.$form.on('blur keyup change update', 'input, select, textarea', function (e) {
			if (self.disabled) return;
			var $target = $(e.target);
			if ($target.attr("disabled")) return;
			update.call(self, $target);
		});
		this.errors = {};
	};
	Validate.rules = {};

	Validate.setRule = function (name, method, msg) {
		var oldRule = Validate.rules[name];
		if (oldRule && !method) {
			method = oldRule.method
		}
		Validate.rules[name] = {
			method: method,
			msg: msg
		};
	};
	Validate.setMsg = function (name, msg) {
		Validate.setRule(name, undefined, msg)
	}

	Validate.prototype = {
		disable: function () {
			this.disabled = true;
			this.hideError();
		},
		enable: function () {
			this.disabled = false;
		},
		showError: function ($input, errorMsg, errorName) {
			showError.call(this, $input, errorMsg, errorName);
		},
		hideError: function ($input, errorName) {
			hideError.call(this, $input, errorName);
		}
	}

	var onsubmit = function () {
		if (this.disabled) return true;
		var hasError, self;
		self = this;
		hasError = false;
		var errorInputs = [];
		this.$form.find("input, select, textarea").each(function () {
			var $input, error;
			$input = $(this);
			error = update.call(self, this);
			if (error && !hasError) {
				$input.focus();
			}
			if (error) {
				errorInputs.push($input);
				return hasError = true;
			}
		});
		if (hasError) {
			this.options.fail.call(this, errorInputs, this.$form);
		} else {
			var result = this.options.success.call(this, this.$form);
			if (result === false) {
				return false;
			}
		}
		return !hasError;
	};
	var update = function (input) {
		var $input = $(input);
		var rules = {};
		var dataRules = ($input.data("rules") || "").split('|');
		var inputName = $input.attr("name");
		for (var i = 0; i < dataRules.length; i++) {
			if (!dataRules[i]) continue;
			var tokens = dataRules[i].split('=');
			tokens[1] = tokens[1] || undefined;
			rules[tokens[0]] = tokens[1];
		}
		var configRules = (this.options.rules && this.options.rules[inputName]) || {};
		rules = $.extend(rules, configRules)
		var error = false;
		var msg = null;
		for (var name in rules) {
			var value = rules[name];

			var currentRule = Validate.rules[name];
			if (!currentRule) { //未定义的rule
				throw new Error("未定义的校验规则：" + name);
			}
			var inputVal = val($input);
			if ((!inputVal) && name !== 'required') {  //特殊处理，如果当前输入框没有值，并且当前不是required，则不报错
				error = false;
				hideError.call(this, $input);
				continue
			}
			var result = true
			// 如果规则值是一个函数，则直接用此函数的返回值
			if ($.isFunction(value)) {
				result = value.call(this, $input)
			} else {
				result = currentRule.method.call(this, inputVal, $input, value)
			}
			if (result) {
				error = false;
				hideError.call(this, $input, name);
			} else {
				error = true;
				msg = currentRule.msg;
				if ($.isFunction(msg)) msg = msg($input, value)
				//如果不是required规则，则可以使用自定义错误消息
				if (name !== 'required') {
					if ($input.data("error-msg")) {
						msg = $input.data("error-msg")
					}
					if (this.options.messages && this.options.messages[inputName]) {
						msg = this.options.messages[inputName]
						if ($.isFunction(msg)) msg = msg($input, value)
						if ($.isArray(msg)) msg = msg[1]
					}
				}
				//如果是required规则
				if (name === 'required') {
					if ($input.data("empty-msg")) {
						msg = $input.data("empty-msg")
					}
					if (this.options.messages && this.options.messages[inputName]) {
						var _msg = this.options.messages[inputName]
						if ($.isFunction(_msg)) _msg = msg($input, value)
						if ($.isArray(_msg)) msg = _msg[0]
					}
				}
				this.showError($input, msg.replace('$0', value), name);
				break;
			}
		}
		return error;
	};
	var showError = function ($input, errorMsg, errorName) {
		errorName = errorName || "anonymous"  //匿名的，一般是手动调用showError并且没有指定一个名称时候会显示一个匿名的错误
		if (typeof $input === typeof "a") $input = this.$form.find("[name='" + $input + "']");
		$input = $($input);
		var inputName = $input.attr("name")
		var $errors = this.errors[inputName] || (this.errors[inputName] = {});
		var $currentError = $errors[errorName]
		if (!$currentError) {
			$currentError = ($errors[errorName] = $(this.options.errorTpl.replace("$errorMsg", errorMsg)));
			this.options.placeError.call(this, $input, $currentError);
		}
		for (var k in $errors) {
			if (k !== errorName) $errors[k].hide()
		}
		this.options.highlight.call(this, $input, $currentError, this.options.inputErrorClass)
		$input.trigger("highlight");
	};
	var hideError = function ($input, errorName) {
		var self = this;
		var hideInputAllError = function ($input) {
			var $errors = self.errors[$input.attr('name')];
			for (var k in $errors) {
				self.options.unhighlight.call(self, $input, $errors[k], self.options.inputErrorClass);
			}
		}
		if (!$input) { //没有任何参数，则隐藏所有的错误
			this.$form.find('input, select, textarea').each(function () {
				var $this = $(this);
				if ($this.attr("disabled")) return;
				hideInputAllError($this);
			});
		}
		if (typeof $input === typeof "a") $input = this.$form.find("[name='" + $input + "']");
		$input = $($input);
		var $errors = this.errors[$input.attr('name')];
		if (!$errors) return;
		if (!errorName) {
			//未指定errorName则隐藏所有ErrorMsg
			hideInputAllError($input);
			return;
		}
		var $error = $errors[errorName];
		if (!$error) return;
		this.options.unhighlight.call(this, $input, $error, this.options.inputErrorClass)
		$input.trigger("unhighlight");
	};

	//根据不同的input类型来取值
	var val = function (input) {
		var $input = $(input);
		if (!$input[0]) return undefined;
		var tagName = $input[0].tagName.toUpperCase();
		var type = ($input.attr("type") || 'text').toUpperCase()
		var name = $input.attr("name")
		var $form = $input.parents("form")
		switch (tagName) {
			case 'INPUT':
				switch (type) {
					case 'CHECKBOX':
					case 'RADIO':
						return $form.find("[name='" + name + "']:checked").val()
					default:
						return $input.val()
				}
				break;
			case 'TEXTAREA':
				return $input.val()
				break;
			default:
			return $input.val()
		}
	}

	var old = $.fn.validate;

	$.fn.extend({
		validate: function (options) {
			var args = arguments;
			return this.each(function () {
				var $this = $(this),
					data = $this.data("validate")
				if (!data) $this.data('validate', (data = new Validate(this, options)))
				if (typeof options == 'string') data[options].apply(data, Array.prototype.slice.call(args, 1));
			})
		}
	})
	$.fn.validate.Constructor = Validate

	$.fn.validate.defaults = {
		errorTpl: '<div class="sui-msg msg-error help-inline">\n  <div class="msg-con">\n    <span>$errorMsg</span>\n </div>   <i class="msg-icon"></i>\n  \n</div>',
		inputErrorClass: 'input-error',
		placeError: function ($input, $error) {
			$input = $($input);
			var $wrap = $input.parents(".controls-wrap");
			if (!$wrap[0]) {
				$wrap = $input.parents(".controls");
			}
			if (!$wrap[0]) {
				$wrap = $input.parent();
			}
			$error.appendTo($wrap[0]);
		},
		highlight: function ($input, $error, inputErrorClass) {
			$input.addClass(inputErrorClass)
			//使多控件校验规则错误框可以自动定位出错的控件位置，先将自身移动去该位置附近显示
			//对单体校验控件，因为是自身append到自身的位置，native不会有行为
			$.fn.validate.defaults.placeError($input, $error);
			$error.show()
		},
		unhighlight: function ($input, $error, inputErrorClass) {
			if (!$error.is(":visible")) return;
			$input.removeClass(inputErrorClass)
			$error.hide()
		},
		rules: undefined,
		messages: undefined,
		success: $.noop,
		fail: $.noop
	};

	$.fn.validate.noConflict = function () {
		$.fn.validate = old
		return this
	}

	$.validate = Validate;

	//自动加载
	$(function () {
		$(".sui-validate").validate()
	})
}(window.jQuery);

/**
 * Html5加Ajax请求提交表单
 * @param {string} id 表单id
 * @param {Function} fun 表单提交请求方法
 */
function AppValidate(id,fun) {
	$(id).on("submit", function (event) {
		fun();
		//阻止submit表单提交
		event.preventDefault();
	});
}

// add rules
!function ($) {
	Validate = $.validate;
	trim = function (v) {
		if (!v) return v;
		return v.replace(/^\s+/g, '').replace(/\s+$/g, '')
	};
	var required = function (value, element, param) {
		var $input = $(element)
		return !!trim(value);
    };
	var requiredMsg = function ($input, param) {
		var getWord = function ($input) {
			var tagName = $input[0].tagName.toUpperCase();
			var type = $input[0].type.toUpperCase();
			if (type == 'CHECKBOX' || type == 'RADIO' || tagName == 'SELECT') {
				return '选择'
			}
			return '填写'
		}
		return "请" + getWord($input)
	}
	Validate.setRule("required", required, requiredMsg);

	var prefill = function (value, element, param) {
		var $input = $(element)
		if (param && typeof param === typeof 'a') {
			var $form = $input.parents("form")
			var $required = $form.find("[name='" + param + "']")
			return !!$required.val()
		}
		return true
	}
	Validate.setRule("prefill", prefill, function ($input, param) {
		var getWord = function ($input) {
			var tagName = $input[0].tagName.toUpperCase();
			var type = $input[0].type.toUpperCase();
			if (type == 'CHECKBOX' || type == 'RADIO' || tagName == 'SELECT') {
				return '选择'
			}
			return '填写'
		}
		if (param && typeof param === typeof 'a') {
			var $form = $input.parents("form")
			var $required = $form.find("[name='" + param + "']")
			if (!$required.val()) {
				return "请先" + getWord($required) + ($required.attr("title") || $required.attr("name"))
			}
		}
		return '错误'
	});
	var match = function (value, element, param) {
		value = trim(value);
		return value == $(element).parents('form').find("[name='" + param + "']").val()
	};
	Validate.setRule("match", match, '必须与$0相同');
	var number = function (value, element, param) {
		value = trim(value);
		return (/^\d+(.\d*)?$/).test(value)
	};
	Validate.setRule("number", number, '请输入数字');
	var digits = function (value, element, param) {
		value = trim(value);
		return (/^\d+$/).test(value)
	};
	Validate.setRule("digits", digits, '请输入整数');
	var mobile = function (value, element, param) {
		return (/^0?1[3|4|5|7|8][0-9]\d{8,9}$/).test(trim(value));
	};
	Validate.setRule("mobile", mobile, '请填写正确的手机号码');
	var tel = function (value, element, param) {
		return (/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,11})+$/).test(trim(value));
	};
	Validate.setRule("tel", tel, '请填写正确的电话号码');
	var email = function (value, element, param) {
		return (/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/).test(trim(value)); //"
	};
	Validate.setRule("email", email, '请填写正确的email地址');
	var zip = function (value, element, param) {
		return (/^[1-9][0-9]{5}$/).test(trim(value));
	};
	Validate.setRule("zip", zip, '请填写正确的邮编');
	var date = function (value, element, param) {
		param = param || "-";
		var reg = new RegExp("^[1|2]\\d{3}" + param + "[0-2][0-9]" + param + "[0-3][0-9]$");
		return reg.test(trim(value));
	};
	Validate.setRule("date", date, '请填写正确的日期');
	var time = function (value, element, param) {
		return (/^[0-2]\d:[0-6]\d$/).test(trim(value));
	};
	Validate.setRule("time", time, '请填写正确的时间');
	var datetime = function (value, element, param) {
		var reg = new RegExp("^[1|2]\\d{3}-[0-2][0-9]-[0-3][0-9] [0-2]\\d:[0-6]\\d$");
		return reg.test(trim(value));
	};
	Validate.setRule("datetime", datetime, '请填写正确的日期和时间');
	var url = function (value, element, param) {
		var urlPattern;
		value = trim(value);
		urlPattern = /(http|ftp|https):\/\/([\w-]+\.)+[\w-]+\.(com|net|cn|org|me|io|info|xxx)/;
		if (!/^http/.test(value)) {
			value = 'http://' + value;
		}
		return urlPattern.test(value);
	};
	Validate.setRule("url", url, '请填写正确的网址');
	var minlength = function (value, element, param) {
		return trim(value).length >= param;
	};
	Validate.setRule("minlength", minlength, '长度不能少于$0');
	var maxlength = function (value, element, param) {
		return trim(value).length <= param;
	};
	Validate.setRule("maxlength", maxlength, '长度不能超过$0');

	var gt = function (value, element, param) {
		return Number(value) > param;
	};
	Validate.setRule("gt", gt, '必须大于$0');

	var lt = function (value, element, param) {
		return Number(value) < param;
	};
	Validate.setRule("lt", lt, '必须小于$0');

}(window.jQuery)