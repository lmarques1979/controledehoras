DateInput=function(c){function d(a,b){"object"!=typeof b&&(b={});c.extend(this,d.DEFAULT_OPTS,b);this.input=c(a);this.bindMethodsToObj("show","hide","hideIfClickOutside","keydownHandler","selectDate");this.build();this.selectDate();this.hide()}d.DEFAULT_OPTS={month_names:"January February March April May June July August September October November December".split(" "),short_month_names:"Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" "),short_day_names:"Sun Mon Tue Wed Thu Fri Sat".split(" "),
start_of_week:1};d.prototype={build:function(){var a=c('<p class="month_nav"><span class="button prev" title="[Page-Up]">&#171;</span> <span class="month_name"></span> <span class="button next" title="[Page-Down]">&#187;</span></p>');this.monthNameSpan=c(".month_name",a);c(".prev",a).click(this.bindToObj(function(){this.moveMonthBy(-1)}));c(".next",a).click(this.bindToObj(function(){this.moveMonthBy(1)}));var b=c('<p class="year_nav"><span class="button prev" title="[Ctrl+Page-Up]">&#171;</span> <span class="year_name"></span> <span class="button next" title="[Ctrl+Page-Down]">&#187;</span></p>');
this.yearNameSpan=c(".year_name",b);c(".prev",b).click(this.bindToObj(function(){this.moveMonthBy(-12)}));c(".next",b).click(this.bindToObj(function(){this.moveMonthBy(12)}));var a=c('<div class="nav"></div>').append(a,b),e="<table><thead><tr>";c(this.adjustDays(this.short_day_names)).each(function(){e+="<th>"+this+"</th>"});e+="</tr></thead><tbody></tbody></table>";this.dateSelector=this.rootLayers=c('<div class="date_selector"></div>').append(a,e).insertAfter(this.input);c.browser.msie&&7>c.browser.version&&
(this.ieframe=c('<iframe class="date_selector_ieframe" frameborder="0" src="#"></iframe>').insertBefore(this.dateSelector),this.rootLayers=this.rootLayers.add(this.ieframe),c(".button",a).mouseover(function(){c(this).addClass("hover")}),c(".button",a).mouseout(function(){c(this).removeClass("hover")}));this.tbody=c("tbody",this.dateSelector);this.input.change(this.bindToObj(function(){this.selectDate()}));this.selectDate()},selectMonth:function(a){var b=new Date(a.getFullYear(),a.getMonth(),1);if(!this.currentMonth||
this.currentMonth.getFullYear()!=b.getFullYear()||this.currentMonth.getMonth()!=b.getMonth()){this.currentMonth=b;for(var b=this.rangeStart(a),e=this.rangeEnd(a),e=this.daysBetween(b,e),f="",d=0;d<=e;d++){var g=new Date(b.getFullYear(),b.getMonth(),b.getDate()+d,12,0);this.isFirstDayOfWeek(g)&&(f+="<tr>");f=g.getMonth()==a.getMonth()?f+('<td class="selectable_day" date="'+this.dateToString(g)+'">'+g.getDate()+"</td>"):f+('<td class="unselected_month" date="'+this.dateToString(g)+'">'+g.getDate()+
"</td>");this.isLastDayOfWeek(g)&&(f+="</tr>")}this.tbody.empty().append(f);this.monthNameSpan.empty().append(this.monthName(a));this.yearNameSpan.empty().append(this.currentMonth.getFullYear());c(".selectable_day",this.tbody).click(this.bindToObj(function(a){this.changeInput(c(a.target).attr("date"))}));c("td[date="+this.dateToString(new Date)+"]",this.tbody).addClass("today");c("td.selectable_day",this.tbody).mouseover(function(){c(this).addClass("hover")});c("td.selectable_day",this.tbody).mouseout(function(){c(this).removeClass("hover")})}c(".selected",
this.tbody).removeClass("selected");c("td[date="+this.selectedDateString+"]",this.tbody).addClass("selected")},selectDate:function(a){"undefined"==typeof a&&(a=this.stringToDate(this.input.val()));a||(a=new Date);this.selectedDate=a;this.selectedDateString=this.dateToString(this.selectedDate);this.selectMonth(this.selectedDate)},changeInput:function(a){this.input.val(a).change();this.hide()},show:function(){this.rootLayers.css("display","block");c([window,document.body]).click(this.hideIfClickOutside);
this.input.unbind("focus",this.show);c(document.body).keydown(this.keydownHandler);this.setPosition()},hide:function(){this.rootLayers.css("display","none");c([window,document.body]).unbind("click",this.hideIfClickOutside);this.input.focus(this.show);c(document.body).unbind("keydown",this.keydownHandler)},hideIfClickOutside:function(a){a.target==this.input[0]||this.insideSelector(a)||this.hide()},insideSelector:function(a){var b=this.dateSelector.position();b.right=b.left+this.dateSelector.outerWidth();
b.bottom=b.top+this.dateSelector.outerHeight();return a.pageY<b.bottom&&a.pageY>b.top&&a.pageX<b.right&&a.pageX>b.left},keydownHandler:function(a){switch(a.keyCode){case 9:case 27:this.hide();return;case 13:this.changeInput(this.selectedDateString);break;case 33:this.moveDateMonthBy(a.ctrlKey?-12:-1);break;case 34:this.moveDateMonthBy(a.ctrlKey?12:1);break;case 38:this.moveDateBy(-7);break;case 40:this.moveDateBy(7);break;case 37:this.moveDateBy(-1);break;case 39:this.moveDateBy(1);break;default:return}a.preventDefault()},
stringToDate:function(a){var b;return(b=a.match(/^(\d{1,2}) ([^\s]+) (\d{4,4})$/))?new Date(b[3],this.shortMonthNum(b[2]),b[1],12,0):null},dateToString:function(a){return a.getDate()+" "+this.short_month_names[a.getMonth()]+" "+a.getFullYear()},setPosition:function(){var a=this.input.offset();this.rootLayers.css({top:a.top+this.input.outerHeight(),left:a.left});this.ieframe&&this.ieframe.css({width:this.dateSelector.outerWidth(),height:this.dateSelector.outerHeight()})},moveDateBy:function(a){a=new Date(this.selectedDate.getFullYear(),
this.selectedDate.getMonth(),this.selectedDate.getDate()+a);this.selectDate(a)},moveDateMonthBy:function(a){var b=new Date(this.selectedDate.getFullYear(),this.selectedDate.getMonth()+a,this.selectedDate.getDate());b.getMonth()==this.selectedDate.getMonth()+a+1&&b.setDate(0);this.selectDate(b)},moveMonthBy:function(a){a=new Date(this.currentMonth.getFullYear(),this.currentMonth.getMonth()+a,this.currentMonth.getDate());this.selectMonth(a)},monthName:function(a){return this.month_names[a.getMonth()]},
bindToObj:function(a){var b=this;return function(){return a.apply(b,arguments)}},bindMethodsToObj:function(){for(var a=0;a<arguments.length;a++)this[arguments[a]]=this.bindToObj(this[arguments[a]])},indexFor:function(a,b){for(var c=0;c<a.length;c++)if(b==a[c])return c},monthNum:function(a){return this.indexFor(this.month_names,a)},shortMonthNum:function(a){return this.indexFor(this.short_month_names,a)},shortDayNum:function(a){return this.indexFor(this.short_day_names,a)},daysBetween:function(a,b){a=
Date.UTC(a.getFullYear(),a.getMonth(),a.getDate());b=Date.UTC(b.getFullYear(),b.getMonth(),b.getDate());return(b-a)/864E5},changeDayTo:function(a,b,c){a=c*(Math.abs(b.getDay()-a-7*c)%7);return new Date(b.getFullYear(),b.getMonth(),b.getDate()+a)},rangeStart:function(a){return this.changeDayTo(this.start_of_week,new Date(a.getFullYear(),a.getMonth()),-1)},rangeEnd:function(a){return this.changeDayTo((this.start_of_week-1)%7,new Date(a.getFullYear(),a.getMonth()+1,0),1)},isFirstDayOfWeek:function(a){return a.getDay()==
this.start_of_week},isLastDayOfWeek:function(a){return a.getDay()==(this.start_of_week-1)%7},adjustDays:function(a){for(var b=[],c=0;c<a.length;c++)b[c]=a[(c+this.start_of_week)%7];return b}};c.fn.date_input=function(a){return this.each(function(){new d(this,a)})};c.date_input={initialize:function(a){c("input.date_input").date_input(a)}};return d}(jQuery);