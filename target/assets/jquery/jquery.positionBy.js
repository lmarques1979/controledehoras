(function(p){var d=function(b,c,d,p){this.x1=b;this.x2=d;this.y1=c;this.y2=p};d.prototype.contains=function(b){return this.x1<=b.x1&&b.x2<=this.x2&&this.y1<=b.y1&&b.y2<=this.y2};d.prototype.transform=function(b,c){return new d(this.x1+b,this.y1+c,this.x2+b,this.y2+c)};p.fn.positionBy=function(b){if(0==this.length)return this;b=p.extend({target:null,targetPos:null,elementPos:null,x:null,y:null,positions:null,addClass:!1,force:!1,container:window,hideAfterPosition:!1},b);if(null!=b.x)var c=b.x,h=b.y,
s=0,t=0;else var n=p(p(b.target)[0]),s=n.outerWidth(),t=n.outerHeight(),n=n.offset(),c=n.left,h=n.top;var l=c+s,m=h+t;return this.each(function(){var q=p(this);q.is(":visible")||q.css({left:-3E3,top:-3E3}).show();var g=q.outerWidth(),e=q.outerHeight(),f=[],k=[];f[0]=new d(l,h,l+g,h+e);k[0]=[1,7,4];f[1]=new d(l,m-e,l+g,m);k[1]=[0,6,4];f[2]=new d(l,m,l+g,m+e);k[2]=[1,3,10];f[3]=new d(l-g,m,l,m+e);k[3]=[1,6,10];f[4]=new d(c,m,c+g,m+e);k[4]=[1,6,9];f[5]=new d(c-g,m,c,m+e);k[5]=[6,4,9];f[6]=new d(c-g,
m-e,c,m);k[6]=[7,1,4];f[7]=new d(c-g,h,c,h+e);k[7]=[6,0,4];f[8]=new d(c-g,h-e,c,h);k[8]=[7,9,4];f[9]=new d(c,h-e,c+g,h);k[9]=[0,7,4];f[10]=new d(l-g,h-e,l,h);k[10]=[0,7,3];f[11]=new d(l,h-e,l+g,h);k[11]=[0,10,3];f[12]=new d(l-g,h,l,h+e);k[12]=[13,7,10];f[13]=new d(l-g,m-e,l,m);k[13]=[12,6,3];f[14]=new d(c,m-e,c+g,m);k[14]=[15,1,4];f[15]=new d(c,h,c+g,h+e);k[15]=[14,0,9];if(null!==b.positions)var a=b.positions[0];else null!=b.targetPos&&null!=b.elementPos&&(a=[[]],a[0][0]=15,a[0][1]=7,a[0][2]=8,a[0][3]=
9,a[1]=[],a[1][0]=0,a[1][1]=12,a[1][2]=10,a[1][3]=11,a[2]=[],a[2][0]=2,a[2][1]=3,a[2][2]=13,a[2][3]=1,a[3]=[],a[3][0]=4,a[3][1]=5,a[3][2]=6,a[3][3]=14,a=a[b.targetPos][b.elementPos]);var n=f[a];if(!b.force)for($window=p(window),g=$window.scrollLeft(),e=$window.scrollTop(),g=new d(g,e,g+$window.width(),e+$window.height()),a=b.positions?b.positions:[a],e=[];0<a.length;){var r=a.shift();if(!e[r])if(e[r]=!0,g.contains(f[r])){n=f[r];break}else null===b.positions&&(a=jQuery.merge(a,k[r]))}q.parents().each(function(){var a=
p(this);if("static"!=a.css("position"))return a=a.offset(),n=n.transform(-a.left,-a.top),!1});f={left:n.x1,top:n.y1};b.hideAfterPosition&&(f.display="none");q.css(f);b.addClass&&q.removeClass("positionBy0 positionBy1 positionBy2 positionBy3 positionBy4 positionBy5 positionBy6 positionBy7 positionBy8 positionBy9 positionBy10 positionBy11 positionBy12 positionBy13 positionBy14 positionBy15").addClass("positionBy"+r)})}})(jQuery);