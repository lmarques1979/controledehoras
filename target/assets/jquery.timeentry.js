(function(f){function n(){this._disabledInputs=[];this.regional=[];this.regional[""]={show24Hours:!1,separator:":",ampmPrefix:"",ampmNames:["AM","PM"],spinnerTexts:["Hora Atual","Anterior","Pr\ufffdximo","Incrementar","Decrementar"]};this._defaults={appendText:"",showSeconds:!1,timeSteps:[1,1,1],initialField:0,noSeparatorEntry:!1,useMouseWheel:!0,defaultTime:null,minTime:null,maxTime:null,spinnerImage:"spinnerDefault.png",spinnerSize:[20,20,8],spinnerBigImage:"",spinnerBigSize:[40,40,16],spinnerIncDecOnly:!1,
spinnerRepeat:[500,250],beforeShow:null,beforeSetTime:null};f.extend(this._defaults,this.regional[""])}f.extend(n.prototype,{markerClassName:"hasTimeEntry",propertyName:"timeEntry",_appendClass:"timeEntry_append",_controlClass:"timeEntry_control",_expandClass:"timeEntry_expand",setDefaults:function(a){f.extend(this._defaults,a||{});return this},_attachPlugin:function(a,b){var d=f(a);if(!d.hasClass(this.markerClassName)){var e={options:f.extend({},this._defaults,b),input:d,_field:0,_selectedHour:0,
_selectedMinute:0,_selectedSecond:0};d.data(this.propertyName,e).addClass(this.markerClassName).bind("focus."+this.propertyName,this._doFocus).bind("blur."+this.propertyName,this._doBlur).bind("click."+this.propertyName,this._doClick).bind("keydown."+this.propertyName,this._doKeyDown).bind("keypress."+this.propertyName,this._doKeyPress).bind("paste."+this.propertyName,function(a){setTimeout(function(){c._parseTime(e)},1)});this._optionPlugin(a,b)}},_optionPlugin:function(a,b,d){a=f(a);var c=a.data(this.propertyName);
if(!b||"string"==typeof b&&null==d){var g=b;return(b=(c||{}).options)&&g?b[g]:b}a.hasClass(this.markerClassName)&&(b=b||{},"string"==typeof b&&(g=b,b={},b[g]=d),d=this._extractTime(c),f.extend(c.options,b),c._field=0,d&&this._setTime(c,new Date(0,0,0,d[0],d[1],d[2])),a.next("span."+this._appendClass).remove(),a.parent().find("span."+this._controlClass).remove(),f.fn.mousewheel&&a.unmousewheel(),b=c.options.spinnerImage?f('<span class="'+this._controlClass+'" style="display: inline-block; background: url(\''+
c.options.spinnerImage+"') 0 0 no-repeat; width: "+c.options.spinnerSize[0]+"px; height: "+c.options.spinnerSize[1]+'px;"></span>'):null,a.after(c.options.appendText?'<span class="'+this._appendClass+'">'+c.options.appendText+"</span>":"").after(b||""),c.options.useMouseWheel&&f.fn.mousewheel&&a.mousewheel(this._doMouseWheel),b&&b.mousedown(this._handleSpinner).mouseup(this._endSpinner).mouseover(this._expandSpinner).mouseout(this._endSpinner).mousemove(this._describeSpinner))},_enablePlugin:function(a){this._enableDisable(a,
!1)},_disablePlugin:function(a){this._enableDisable(a,!0)},_enableDisable:function(a,b){var d=f.data(a,this.propertyName);d&&(a.disabled=b,a.nextSibling&&"span"==a.nextSibling.nodeName.toLowerCase()&&c._changeSpinner(d,a.nextSibling,b?5:-1),c._disabledInputs=f.map(c._disabledInputs,function(b){return b==a?null:b}),b&&c._disabledInputs.push(a))},_isDisabledPlugin:function(a){return-1<f.inArray(a,this._disabledInputs)},_destroyPlugin:function(a){a=f(a);a.hasClass(this.markerClassName)&&(a.removeClass(this.markerClassName).removeData(this.propertyName).unbind("."+
this.propertyName),f.fn.mousewheel&&a.unmousewheel(),this._disabledInputs=f.map(this._disabledInputs,function(b){return b==a[0]?null:b}),a.siblings("."+this._appendClass+",."+this._controlClass).remove())},_setTimePlugin:function(a,b){var d=f.data(a,this.propertyName);d&&(null===b||""===b?d.input.val(""):this._setTime(d,b?"object"==typeof b?new Date(b.getTime()):b:null))},_getTimePlugin:function(a){return(a=(a=f.data(a,this.propertyName))?this._extractTime(a):null)?new Date(0,0,0,a[0],a[1],a[2]):
null},_getOffsetPlugin:function(a){return(a=(a=f.data(a,this.propertyName))?this._extractTime(a):null)?1E3*(3600*a[0]+60*a[1]+a[2]):0},_doFocus:function(a){a=a.nodeName&&"input"==a.nodeName.toLowerCase()?a:this;if(c._lastInput==a||c._isDisabledPlugin(a))c._focussed=!1;else{var b=f.data(a,c.propertyName);c._focussed=!0;c._lastInput=a;c._blurredInput=null;f.extend(b.options,f.isFunction(b.options.beforeShow)?b.options.beforeShow.apply(a,[a]):{});c._parseTime(b);setTimeout(function(){c._showField(b)},
10)}},_doBlur:function(a){c._blurredInput=c._lastInput;c._lastInput=null},_doClick:function(a){var b=a.target,d=f.data(b,c.propertyName);if(!c._focussed){var e=d.options.separator.length+2;d._field=0;if(null!=b.selectionStart)for(var g=0;g<=Math.max(1,d._secondField,d._ampmField)&&!(a=g!=d._ampmField?g*e+2:d._ampmField*e+d.options.ampmPrefix.length+d.options.ampmNames[0].length,d._field=g,b.selectionStart<a);g++);else if(b.createTextRange){g=f(a.srcElement);b=b.createTextRange();a=a.clientX+document.documentElement.scrollLeft;
for(var h=g.offset().left,l=parseInt,g=g.css("border-left-width"),h=a-(h+l({thin:2,medium:4,thick:6}[g]||g,10))-b.offsetLeft,g=0;g<=Math.max(1,d._secondField,d._ampmField)&&!(a=g!=d._ampmField?g*e+2:d._ampmField*e+d.options.ampmPrefix.length+d.options.ampmNames[0].length,b.collapse(),b.moveEnd("character",a),d._field=g,h<b.boundingWidth);g++);}}c._showField(d);c._focussed=!1},_doKeyDown:function(a){if(48<=a.keyCode)return!0;var b=f.data(a.target,c.propertyName);switch(a.keyCode){case 9:return a.shiftKey?
c._changeField(b,-1,!0):c._changeField(b,1,!0);case 35:a.ctrlKey?c._setValue(b,""):(b._field=Math.max(1,b._secondField,b._ampmField),c._adjustField(b,0));break;case 36:a.ctrlKey?c._setTime(b):(b._field=0,c._adjustField(b,0));break;case 37:c._changeField(b,-1,!1);break;case 38:c._adjustField(b,1);break;case 39:c._changeField(b,1,!1);break;case 40:c._adjustField(b,-1);break;case 46:c._setValue(b,"");break;default:return!0}return!1},_doKeyPress:function(a){var b=String.fromCharCode(void 0==a.charCode?
a.keyCode:a.charCode);if(" ">b)return!0;a=f.data(a.target,c.propertyName);c._handleKeyPress(a,b);return!1},_doMouseWheel:function(a,b){if(!c._isDisabledPlugin(a.target)){var d=f.data(a.target,c.propertyName);d.input.focus();d.input.val()||c._parseTime(d);c._adjustField(d,b);a.preventDefault()}},_expandSpinner:function(a){a=c._getSpinnerTarget(a);var b=f.data(c._getInput(a),c.propertyName);if(!c._isDisabledPlugin(b.input[0])&&b.options.spinnerBigImage){b._expanded=!0;var d=f(a).offset(),e=null;f(a).parents().each(function(){var a=
f(this);if("relative"==a.css("position")||"absolute"==a.css("position"))e=a.offset();return!e});f('<div class="'+c._expandClass+'" style="position: absolute; left: '+(d.left-(b.options.spinnerBigSize[0]-b.options.spinnerSize[0])/2-(e?e.left:0))+"px; top: "+(d.top-(b.options.spinnerBigSize[1]-b.options.spinnerSize[1])/2-(e?e.top:0))+"px; width: "+b.options.spinnerBigSize[0]+"px; height: "+b.options.spinnerBigSize[1]+"px; background: transparent url("+b.options.spinnerBigImage+') no-repeat 0px 0px; z-index: 10;"></div>').mousedown(c._handleSpinner).mouseup(c._endSpinner).mouseout(c._endExpand).mousemove(c._describeSpinner).insertAfter(a)}},
_getInput:function(a){return f(a).siblings("."+c.markerClassName)[0]},_describeSpinner:function(a){var b=c._getSpinnerTarget(a),d=f.data(c._getInput(b),c.propertyName);b.title=d.options.spinnerTexts[c._getSpinnerRegion(d,a)]},_handleSpinner:function(a){var b=c._getSpinnerTarget(a),d=c._getInput(b);if(!c._isDisabledPlugin(d)){d==c._blurredInput&&(c._lastInput=d,c._blurredInput=null);var e=f.data(d,c.propertyName);c._doFocus(d);var g=c._getSpinnerRegion(e,a);c._changeSpinner(e,b,g);c._actionSpinner(e,
g);c._timer=null;c._handlingSpinner=!0;3<=g&&e.options.spinnerRepeat[0]&&(c._timer=setTimeout(function(){c._repeatSpinner(e,g)},e.options.spinnerRepeat[0]),f(b).one("mouseout",c._releaseSpinner).one("mouseup",c._releaseSpinner))}},_actionSpinner:function(a,b){a.input.val()||c._parseTime(a);switch(b){case 0:this._setTime(a);break;case 1:this._changeField(a,-1,!1);break;case 2:this._changeField(a,1,!1);break;case 3:this._adjustField(a,1);break;case 4:this._adjustField(a,-1)}},_repeatSpinner:function(a,
b){c._timer&&(c._lastInput=c._blurredInput,this._actionSpinner(a,b),this._timer=setTimeout(function(){c._repeatSpinner(a,b)},a.options.spinnerRepeat[1]))},_releaseSpinner:function(a){clearTimeout(c._timer);c._timer=null},_endExpand:function(a){c._timer=null;a=c._getSpinnerTarget(a);var b=c._getInput(a),b=f.data(b,c.propertyName);f(a).remove();b._expanded=!1},_endSpinner:function(a){c._timer=null;a=c._getSpinnerTarget(a);var b=c._getInput(a),d=f.data(b,c.propertyName);c._isDisabledPlugin(b)||c._changeSpinner(d,
a,-1);c._handlingSpinner&&(c._lastInput=c._blurredInput);c._lastInput&&c._handlingSpinner&&c._showField(d);c._handlingSpinner=!1},_getSpinnerTarget:function(a){return a.target||a.srcElement},_getSpinnerRegion:function(a,b){var d=this._getSpinnerTarget(b),c=f(d).offset(),g=[document.documentElement.scrollLeft||document.body.scrollLeft,document.documentElement.scrollTop||document.body.scrollTop],d=a.options.spinnerIncDecOnly?99:b.clientX+g[0]-c.left,c=b.clientY+g[1]-c.top,h=a.options[a._expanded?"spinnerBigSize":
"spinnerSize"],g=a.options.spinnerIncDecOnly?99:h[0]-1-d,l=h[1]-1-c;if(0<h[2]&&Math.abs(d-g)<=h[2]&&Math.abs(c-l)<=h[2])return 0;h=Math.min(d,c,g,l);return h==d?1:h==g?2:h==c?3:4},_changeSpinner:function(a,b,c){f(b).css("background-position","-"+(c+1)*a.options[a._expanded?"spinnerBigSize":"spinnerSize"][0]+"px 0px")},_parseTime:function(a){var b=this._extractTime(a);b?(a._selectedHour=b[0],a._selectedMinute=b[1],a._selectedSecond=b[2]):(b=this._constrainTime(a),a._selectedHour=b[0],a._selectedMinute=
b[1],a._selectedSecond=a.options.showSeconds?b[2]:0);a._secondField=a.options.showSeconds?2:-1;a._ampmField=a.options.show24Hours?-1:a.options.showSeconds?3:2;a._lastChr="";a._field=Math.max(0,Math.min(Math.max(1,a._secondField,a._ampmField),a.options.initialField));""!=a.input.val()&&this._showTime(a)},_extractTime:function(a,b){b=b||a.input.val();var c=b.split(a.options.separator);""==a.options.separator&&""!=b&&(c[0]=b.substring(0,2),c[1]=b.substring(2,4),c[2]=b.substring(4,6));if(2<=c.length){var e=
!a.options.show24Hours&&-1<b.indexOf(a.options.ampmNames[0]),f=!a.options.show24Hours&&-1<b.indexOf(a.options.ampmNames[1]),h=parseInt(c[0],10),h=isNaN(h)?0:h,h=((e||f)&&12==h?0:h)+(f?12:0),e=parseInt(c[1],10),e=isNaN(e)?0:e,c=3<=c.length?parseInt(c[2],10):0,c=isNaN(c)||!a.options.showSeconds?0:c;return this._constrainTime(a,[h,e,c])}return null},_constrainTime:function(a,b){if(null==b){var c=this._determineTime(a.options.defaultTime,a)||new Date;b=[c.getHours(),c.getMinutes(),c.getSeconds()]}for(var c=
!1,e=0;e<a.options.timeSteps.length;e++)c?b[e]=0:1<a.options.timeSteps[e]&&(b[e]=Math.round(b[e]/a.options.timeSteps[e])*a.options.timeSteps[e],c=!0);return b},_showTime:function(a){var b=this._formatNumber(a.options.show24Hours?a._selectedHour:(a._selectedHour+11)%12+1)+a.options.separator+this._formatNumber(a._selectedMinute)+(a.options.showSeconds?a.options.separator+this._formatNumber(a._selectedSecond):"")+(a.options.show24Hours?"":a.options.ampmPrefix+a.options.ampmNames[12>a._selectedHour?
0:1]);this._setValue(a,b);this._showField(a)},_showField:function(a){var b=a.input[0];if(!a.input.is(":hidden")&&c._lastInput==b){var d=a.options.separator.length+2,d=a._field!=a._ampmField?a._field*d:a._ampmField*d-a.options.separator.length+a.options.ampmPrefix.length,e=d+(a._field!=a._ampmField?2:a.options.ampmNames[0].length);if(b.setSelectionRange)b.setSelectionRange(d,e);else if(b.createTextRange){var f=b.createTextRange();f.moveStart("character",d);f.moveEnd("character",e-a.input.val().length);
f.select()}b.disabled||b.focus()}},_formatNumber:function(a){return(10>a?"0":"")+a},_setValue:function(a,b){b!=a.input.val()&&a.input.val(b).trigger("change")},_changeField:function(a,b,c){var e=""==a.input.val()||a._field==(-1==b?0:Math.max(1,a._secondField,a._ampmField));e||(a._field+=b);this._showField(a);a._lastChr="";return e&&c},_adjustField:function(a,b){""==a.input.val()&&(b=0);this._setTime(a,new Date(0,0,0,a._selectedHour+(0==a._field?b*a.options.timeSteps[0]:0)+(a._field==a._ampmField?
12*b:0),a._selectedMinute+(1==a._field?b*a.options.timeSteps[1]:0),a._selectedSecond+(a._field==a._secondField?b*a.options.timeSteps[2]:0)))},_setTime:function(a,b){b=this._determineTime(b,a);var c=this._constrainTime(a,b?[b.getHours(),b.getMinutes(),b.getSeconds()]:null);b=new Date(0,0,0,c[0],c[1],c[2]);b=this._normaliseTime(b);var c=this._normaliseTime(this._determineTime(a.options.minTime,a)),e=this._normaliseTime(this._determineTime(a.options.maxTime,a));b=c&&b<c?c:e&&b>e?e:b;f.isFunction(a.options.beforeSetTime)&&
(b=a.options.beforeSetTime.apply(a.input[0],[this._getTimePlugin(a.input[0]),b,c,e]));a._selectedHour=b.getHours();a._selectedMinute=b.getMinutes();a._selectedSecond=b.getSeconds();this._showTime(a)},_determineTime:function(a,b){var d=function(a){var b=new Date;b.setTime(b.getTime()+1E3*a);return b},e=function(a){var d=c._extractTime(b,a),e=new Date,f=d?d[0]:e.getHours(),m=d?d[1]:e.getMinutes(),e=d?d[2]:e.getSeconds();if(!d)for(var d=/([+-]?[0-9]+)\s*(s|S|m|M|h|H)?/g,k=d.exec(a);k;){switch(k[2]||
"s"){case "s":case "S":e+=parseInt(k[1],10);break;case "m":case "M":m+=parseInt(k[1],10);break;case "h":case "H":f+=parseInt(k[1],10)}k=d.exec(a)}e=new Date(0,0,10,f,m,e,0);/^!/.test(a)&&(10<e.getDate()?e=new Date(0,0,10,23,59,59):10>e.getDate()&&(e=new Date(0,0,10,0,0,0)));return e};return a?"string"==typeof a?e(a):"number"==typeof a?d(a):a:null},_normaliseTime:function(a){if(!a)return null;a.setFullYear(1900);a.setMonth(0);a.setDate(0);return a},_handleKeyPress:function(a,b){if(b==a.options.separator)this._changeField(a,
1,!1);else if("0"<=b&&"9">=b){var c=parseInt(b,10),e=parseInt(a._lastChr+b,10),c=this._constrainTime(a,[0!=a._field?a._selectedHour:a.options.show24Hours?24>e?e:c:(1<=e&&12>=e?e:0<c?c:a._selectedHour)%12+(12<=a._selectedHour?12:0),1!=a._field?a._selectedMinute:60>e?e:c,a._field!=a._secondField?a._selectedSecond:60>e?e:c]);this._setTime(a,new Date(0,0,0,c[0],c[1],c[2]));a.options.noSeparatorEntry&&a._lastChr?this._changeField(a,1,!1):a._lastChr=b}else!a.options.show24Hours&&(b=b.toLowerCase(),b==a.options.ampmNames[0].substring(0,
1).toLowerCase()&&12<=a._selectedHour||b==a.options.ampmNames[1].substring(0,1).toLowerCase()&&12>a._selectedHour)&&(c=a._field,a._field=a._ampmField,this._adjustField(a,1),a._field=c,this._showField(a))}});var p=["getOffset","getTime","isDisabled"];f.fn.timeEntry=function(a){var b=Array.prototype.slice.call(arguments,1),d;d="option"==a&&(0==b.length||1==b.length&&"string"==typeof b[0])?!0:-1<f.inArray(a,p);return d?c["_"+a+"Plugin"].apply(c,[this[0]].concat(b)):this.each(function(){if("string"==
typeof a){if(!c["_"+a+"Plugin"])throw"Unknown command: "+a;c["_"+a+"Plugin"].apply(c,[this].concat(b))}else{var d=f.fn.metadata?f(this).metadata():{};c._attachPlugin(this,f.extend({},d,a||{}))}})};var c=f.timeEntry=new n})(jQuery);