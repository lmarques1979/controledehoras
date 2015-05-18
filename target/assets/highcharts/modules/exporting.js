(function(f){var C=f.Chart,x=f.addEvent,D=f.removeEvent,n=f.createElement,s=f.discardElement,z=f.css,m=f.merge,v=f.each,t=f.extend,F=Math.max,l=document,E=window,G=f.isTouchDevice,H=f.Renderer.prototype.symbols,w=f.getOptions(),p;t(w.lang,{printChart:"Print chart",downloadPNG:"Download PNG image",downloadJPEG:"Download JPEG image",downloadPDF:"Download PDF document",downloadSVG:"Download SVG vector image",contextButtonTitle:"Chart context menu"});w.navigation={menuStyle:{border:"1px solid #A0A0A0",
background:"#FFFFFF",padding:"5px 0"},menuItemStyle:{padding:"0 10px",background:"none",color:"#303030",fontSize:G?"14px":"11px"},menuItemHoverStyle:{background:"#4572A5",color:"#FFFFFF"},buttonOptions:{symbolFill:"#E0E0E0",symbolSize:14,symbolStroke:"#666",symbolStrokeWidth:3,symbolX:12.5,symbolY:10.5,align:"right",buttonSpacing:3,height:22,theme:{fill:"white",stroke:"none"},verticalAlign:"top",width:24}};w.exporting={type:"image/png",url:"http://export.highcharts.com/",buttons:{contextButton:{menuClassName:"highcharts-contextmenu",
symbol:"menu",_titleKey:"contextButtonTitle",menuItems:[{textKey:"printChart",onclick:function(){this.print()}},{separator:!0},{textKey:"downloadPNG",onclick:function(){this.exportChart()}},{textKey:"downloadJPEG",onclick:function(){this.exportChart({type:"image/jpeg"})}},{textKey:"downloadPDF",onclick:function(){this.exportChart({type:"application/pdf"})}},{textKey:"downloadSVG",onclick:function(){this.exportChart({type:"image/svg+xml"})}}]}}};f.post=function(b,a,d){var c;b=n("form",m({method:"post",
action:b,enctype:"multipart/form-data"},d),{display:"none"},l.body);for(c in a)n("input",{type:"hidden",name:c,value:a[c]},null,b);b.submit();s(b)};t(C.prototype,{getSVG:function(b){var a=this,d,c,B,h,g=m(a.options,b);l.createElementNS||(l.createElementNS=function(a,b){return l.createElement(b)});b=n("div",null,{position:"absolute",top:"-9999em",width:a.chartWidth+"px",height:a.chartHeight+"px"},l.body);c=a.renderTo.style.width;h=a.renderTo.style.height;c=g.exporting.sourceWidth||g.chart.width||/px$/.test(c)&&
parseInt(c,10)||600;h=g.exporting.sourceHeight||g.chart.height||/px$/.test(h)&&parseInt(h,10)||400;t(g.chart,{animation:!1,renderTo:b,forExport:!0,width:c,height:h});g.exporting.enabled=!1;g.series=[];v(a.series,function(a){B=m(a.options,{animation:!1,enableMouseTracking:!1,showCheckbox:!1,visible:a.visible});B.isInternal||g.series.push(B)});d=new f.Chart(g,a.callback);v(["xAxis","yAxis"],function(b){v(a[b],function(a,c){var g=d[b][c],f=a.getExtremes(),h=f.userMin,f=f.userMax;g&&(void 0!==h||void 0!==
f)&&g.setExtremes(h,f,!0,!1)})});c=d.container.innerHTML;g=null;d.destroy();s(b);c=c.replace(/zIndex="[^"]+"/g,"").replace(/isShadow="[^"]+"/g,"").replace(/symbolName="[^"]+"/g,"").replace(/jQuery[0-9]+="[^"]+"/g,"").replace(/url\([^#]+#/g,"url(#").replace(/<svg /,'<svg xmlns:xlink="http://www.w3.org/1999/xlink" ').replace(/ href=/g," xlink:href=").replace(/\n/," ").replace(/<\/svg>.*?$/,"</svg>").replace(/(fill|stroke)="rgba\(([ 0-9]+,[ 0-9]+,[ 0-9]+),([ 0-9\.]+)\)"/g,'$1="rgb($2)" $1-opacity="$3"').replace(/&nbsp;/g,
"\u00a0").replace(/&shy;/g,"\u00ad").replace(/<IMG /g,"<image ").replace(/height=([^" ]+)/g,'height="$1"').replace(/width=([^" ]+)/g,'width="$1"').replace(/hc-svg-href="([^"]+)">/g,'xlink:href="$1"/>').replace(/id=([^" >]+)/g,'id="$1"').replace(/class=([^" >]+)/g,'class="$1"').replace(/ transform /g," ").replace(/:(path|rect)/g,"$1").replace(/style="([^"]+)"/g,function(a){return a.toLowerCase()});return c=c.replace(/(url\(#highcharts-[0-9]+)&quot;/g,"$1").replace(/&quot;/g,"'")},exportChart:function(b,
a){b=b||{};var d=this.options.exporting,d=this.getSVG(m({chart:{borderRadius:0}},d.chartOptions,a,{exporting:{sourceWidth:b.sourceWidth||d.sourceWidth,sourceHeight:b.sourceHeight||d.sourceHeight}}));b=m(this.options.exporting,b);f.post(b.url,{filename:b.filename||"chart",type:b.type,width:b.width||0,scale:b.scale||2,svg:d},b.formAttributes)},print:function(){var b=this,a=b.container,d=[],c=a.parentNode,f=l.body,h=f.childNodes;b.isPrinting||(b.isPrinting=!0,v(h,function(a,b){1===a.nodeType&&(d[b]=
a.style.display,a.style.display="none")}),f.appendChild(a),E.focus(),E.print(),setTimeout(function(){c.appendChild(a);v(h,function(a,b){1===a.nodeType&&(a.style.display=d[b])});b.isPrinting=!1},1E3))},contextMenu:function(b,a,d,c,f,h,g){var e=this,m=e.options.navigation,u=m.menuItemStyle,q=e.chartWidth,r=e.chartHeight,l="cache-"+b,k=e[l],y=F(f,h),p,A,s,w=function(a){e.pointer.inClass(a.target,b)||A()};k||(e[l]=k=n("div",{className:b},{position:"absolute",zIndex:1E3,padding:y+"px"},e.container),p=
n("div",null,t({MozBoxShadow:"3px 3px 10px #888",WebkitBoxShadow:"3px 3px 10px #888",boxShadow:"3px 3px 10px #888"},m.menuStyle),k),A=function(){z(k,{display:"none"});g&&g.setState(0);e.openMenu=!1},x(k,"mouseleave",function(){s=setTimeout(A,500)}),x(k,"mouseenter",function(){clearTimeout(s)}),x(document,"mouseup",w),x(e,"destroy",function(){D(document,"mouseup",w)}),v(a,function(a){if(a){var b=a.separator?n("hr",null,null,p):n("div",{onmouseover:function(){z(this,m.menuItemHoverStyle)},onmouseout:function(){z(this,
u)},onclick:function(){A();a.onclick.apply(e,arguments)},innerHTML:a.text||e.options.lang[a.textKey]},t({cursor:"pointer"},u),p);e.exportDivElements.push(b)}}),e.exportDivElements.push(p,k),e.exportMenuWidth=k.offsetWidth,e.exportMenuHeight=k.offsetHeight);a={display:"block"};d+e.exportMenuWidth>q?a.right=q-d-f-y+"px":a.left=d-y+"px";c+h+e.exportMenuHeight>r&&"top"!==g.alignOptions.verticalAlign?a.bottom=r-c-y+"px":a.top=c+h-y+"px";z(k,a);e.openMenu=!0},addButton:function(b){var a=this,d=a.renderer,
c=m(a.options.navigation.buttonOptions,b),l=c.onclick,h=c.menuItems,g,e,n={stroke:c.symbolStroke,fill:c.symbolFill},u=c.symbolSize||12;a.btnCount||(a.btnCount=0);a.exportDivElements||(a.exportDivElements=[],a.exportSVGElements=[]);if(!1!==c.enabled){var q=c.theme,r=q.states,s=r&&r.hover,r=r&&r.select,k;delete q.states;l?k=function(){l.apply(a,arguments)}:h&&(k=function(){a.contextMenu(e.menuClassName,h,e.translateX,e.translateY,e.width,e.height,e);e.setState(2)});c.text&&c.symbol?q.paddingLeft=f.pick(q.paddingLeft,
25):c.text||t(q,{width:c.width,height:c.height,padding:0});e=d.button(c.text,0,0,k,q,s,r).attr({title:a.options.lang[c._titleKey],"stroke-linecap":"round"});e.menuClassName=b.menuClassName||"highcharts-menu-"+a.btnCount++;c.symbol&&(g=d.symbol(c.symbol,c.symbolX-u/2,c.symbolY-u/2,u,u).attr(t(n,{"stroke-width":c.symbolStrokeWidth||1,zIndex:1})).add(e));e.add().align(t(c,{width:e.width,x:f.pick(c.x,p)}),!0,"spacingBox");p+=(e.width+c.buttonSpacing)*("right"===c.align?-1:1);a.exportSVGElements.push(e,
g)}},destroyExport:function(b){b=b.target;var a,d;for(a=0;a<b.exportSVGElements.length;a++)if(d=b.exportSVGElements[a])d.onclick=d.ontouchstart=null,b.exportSVGElements[a]=d.destroy();for(a=0;a<b.exportDivElements.length;a++)d=b.exportDivElements[a],D(d,"mouseleave"),b.exportDivElements[a]=d.onmouseout=d.onmouseover=d.ontouchstart=d.onclick=null,s(d)}});H.menu=function(b,a,d,c){return["M",b,a+2.5,"L",b+d,a+2.5,"M",b,a+c/2+.5,"L",b+d,a+c/2+.5,"M",b,a+c-1.5,"L",b+d,a+c-1.5]};C.prototype.callbacks.push(function(b){var a,
d=b.options.exporting,c=d.buttons;p=0;if(!1!==d.enabled){for(a in c)b.addButton(c[a]);x(b,"destroy",b.destroyExport)}})})(Highcharts);