/*
 Highcharts JS v4.0.4 (2014-09-02)

 Standalone Highcharts Framework

 License: MIT License
*/
var HighchartsAdapter=function(){function r(c){function b(b,a,d){b.removeEventListener(a,d,!1)}function d(b,a,d){d=b.HCProxiedMethods[d.toString()];b.detachEvent("on"+a,d)}function a(a,c){var g=a.HCEvents,k,f,l;if(a.removeEventListener)k=b;else if(a.attachEvent)k=d;else return;c?(f={},f[c]=!0):f=g;for(l in f)if(g[l])for(f=g[l].length;f--;)k(a,l,g[l][f])}c.HCExtended||Highcharts.extend(c,{HCExtended:!0,HCEvents:{},bind:function(b,a){var d=this,c=this.HCEvents,f;d.addEventListener?d.addEventListener(b,
a,!1):d.attachEvent&&(f=function(b){b.target=b.srcElement||window;a.call(d,b)},d.HCProxiedMethods||(d.HCProxiedMethods={}),d.HCProxiedMethods[a.toString()]=f,d.attachEvent("on"+b,f));c[b]===u&&(c[b]=[]);c[b].push(a)},unbind:function(c,h){var g,k;c?(g=this.HCEvents[c]||[],h?(k=HighchartsAdapter.inArray(h,g),-1<k&&(g.splice(k,1),this.HCEvents[c]=g),this.removeEventListener?b(this,c,h):this.attachEvent&&d(this,c,h)):(a(this,c),this.HCEvents[c]=[])):(a(this),this.HCEvents={})},trigger:function(b,a){var d=
this.HCEvents[b]||[],c=d.length,f,l,m;l=function(){a.defaultPrevented=!0};for(f=0;f<c;f++){m=d[f];if(a.stopped)break;a.preventDefault=l;a.target=this;a.type||(a.type=b);!1===m.call(this,a)&&a.preventDefault()}}});return c}var u,m=document,s=[],n=[],t,p={},q;Math.easeInOutSine=function(c,b,d,a){return-d/2*(Math.cos(Math.PI*c/a)-1)+b};return{init:function(c){m.defaultView||(this._getStyle=function(b,d){var a;if(b.style[d])return b.style[d];"opacity"===d&&(d="filter");a=b.currentStyle[d.replace(/\-(\w)/g,
function(b,a){return a.toUpperCase()})];"filter"===d&&(a=a.replace(/alpha\(opacity=([0-9]+)\)/,function(b,a){return a/100}));return""===a?1:a},this.adapterRun=function(b,d){var a={width:"clientWidth",height:"clientHeight"}[d];if(a)return b.style.zoom=1,b[a]-2*parseInt(HighchartsAdapter._getStyle(b,"padding"),10)});Array.prototype.forEach||(this.each=function(b,d){for(var a=0,c=b.length;a<c;a++)if(!1===d.call(b[a],b[a],a,b))return a});Array.prototype.indexOf||(this.inArray=function(b,d){var a,c=0;
if(d)for(a=d.length;c<a;c++)if(d[c]===b)return c;return-1});Array.prototype.filter||(this.grep=function(b,d){for(var a=[],c=0,h=b.length;c<h;c++)d(b[c],c)&&a.push(b[c]);return a});q=function(b,c,a){this.options=c;this.elem=b;this.prop=a};q.prototype={update:function(){var b;b=this.paths;var d=this.elem,a=d.element;if(p[this.prop])p[this.prop](this);else b&&a?d.attr("d",c.step(b[0],b[1],this.now,this.toD)):d.attr?a&&d.attr(this.prop,this.now):(b={},b[this.prop]=this.now+this.unit,Highcharts.css(d,
b));this.options.step&&this.options.step.call(this.elem,this.now,this)},custom:function(b,c,a){var e=this,h=function(a){return e.step(a)},g;this.startTime=+new Date;this.start=b;this.end=c;this.unit=a;this.now=this.start;this.pos=this.state=0;h.elem=this.elem;h()&&1===n.push(h)&&(t=setInterval(function(){for(g=0;g<n.length;g++)n[g]()||n.splice(g--,1);n.length||clearInterval(t)},13))},step:function(b){var c=+new Date,a;a=this.options;var e=this.elem,h;if(e.stopAnimation||e.attr&&!e.element)a=!1;else if(b||
c>=a.duration+this.startTime){this.now=this.end;this.pos=this.state=1;this.update();b=this.options.curAnim[this.prop]=!0;for(h in a.curAnim)!0!==a.curAnim[h]&&(b=!1);b&&a.complete&&a.complete.call(e);a=!1}else e=c-this.startTime,this.state=e/a.duration,this.pos=a.easing(e,0,1,a.duration),this.now=this.start+(this.end-this.start)*this.pos,this.update(),a=!0;return a}};this.animate=function(b,d,a){var e,h="",g,k,f;b.stopAnimation=!1;if("object"!==typeof a||null===a)e=arguments,a={duration:e[2],easing:e[3],
complete:e[4]};"number"!==typeof a.duration&&(a.duration=400);a.easing=Math[a.easing]||Math.easeInOutSine;a.curAnim=Highcharts.extend({},d);for(f in d)k=new q(b,a,f),g=null,"d"===f?(k.paths=c.init(b,b.d,d.d),k.toD=d.d,e=0,g=1):b.attr?e=b.attr(f):(e=parseFloat(HighchartsAdapter._getStyle(b,f))||0,"opacity"!==f&&(h="px")),g||(g=d[f]),k.custom(e,g,h)}},_getStyle:function(c,b){return window.getComputedStyle(c,void 0).getPropertyValue(b)},addAnimSetter:function(c,b){p[c]=b},getScript:function(c,b){var d=
m.getElementsByTagName("head")[0],a=m.createElement("script");a.type="text/javascript";a.src=c;a.onload=b;d.appendChild(a)},inArray:function(c,b){return b.indexOf?b.indexOf(c):s.indexOf.call(b,c)},adapterRun:function(c,b){return parseInt(HighchartsAdapter._getStyle(c,b),10)},grep:function(c,b){return s.filter.call(c,b)},map:function(c,b){for(var d=[],a=0,e=c.length;a<e;a++)d[a]=b.call(c[a],c[a],a,c);return d},offset:function(c){var b=document.documentElement;c=c.getBoundingClientRect();return{top:c.top+
(window.pageYOffset||b.scrollTop)-(b.clientTop||0),left:c.left+(window.pageXOffset||b.scrollLeft)-(b.clientLeft||0)}},addEvent:function(c,b,d){r(c).bind(b,d)},removeEvent:function(c,b,d){r(c).unbind(b,d)},fireEvent:function(c,b,d,a){var e;m.createEvent&&(c.dispatchEvent||c.fireEvent)?(e=m.createEvent("Events"),e.initEvent(b,!0,!0),e.target=c,Highcharts.extend(e,d),c.dispatchEvent?c.dispatchEvent(e):c.fireEvent(b,e)):!0===c.HCExtended&&(d=d||{},c.trigger(b,d));d&&d.defaultPrevented&&(a=null);a&&a(d)},
washMouseEvent:function(c){return c},stop:function(c){c.stopAnimation=!0},each:function(c,b){return Array.prototype.forEach.call(c,b)}}}();