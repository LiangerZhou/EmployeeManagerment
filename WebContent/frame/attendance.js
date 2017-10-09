
    $(function(){  
       $("tr:odd").addClass("tr_odd");//奇数行背景色  
       $("tr:even").addClass("tr_even");//偶数行背景色  
    //全选框    
       $("#ckb_head").click(function(){
        var CheckBox = $("input[name='ckb']");
        for(i=0;i<CheckBox.length;i++){
            if(this.checked){
                CheckBox[i].checked=true;
            }else{
                CheckBox[i].checked=false;
            }
        }
    }); 
     //单选框
      $("input[name='ckb']").bind("click",function(){
    	  if($("input[name='ckb']:not(:checked)").length != 0){//读取未选中的个数，选中的是input[name='ckb']:checked
    		  document.getElementById("ckb_head").checked=false;
    	  }else{
    		  document.getElementById("ckb_head").checked=true;
    	  }
       });
    });
    
    function attend() {
		var str='';
		var stime = $("#begintime").val();
		var dtime = $("#endtime").val();
		var obj =  $("input[name='ckb']");
		for(var i=0;i<obj.length;i++){
			if(obj[i].checked){
				str+=obj[i].value+',';
			}
			
		}
		$.ajax({
	        dataType: "json",
	        data: {
	        	eids : str.toString(),
	        	stime: stime,
				dtime: dtime,
				Alldays: getAll(stime,dtime),
	        },
	        type: "post", 
	        url: 'employee_exportExcel.action',
	        success : function (data) {
	        }
	  });
	}
 
    //获取所有的工作日（未实现法定节假日剔除） 
    function getAll(begin, end) {  
        var ab = begin.split("-");  
        var ae = end.split("-");  
        var db = new Date();  
        db.setUTCFullYear(ab[0], ab[1] - 1, ab[2]);  
        var de = new Date();   
        de.setUTCFullYear(ae[0], ae[1] - 1, ae[2]);  
        var unixDb = db.getTime();  
        var unixDe = de.getTime();  
        
        var workdays = '';
        
        for (var k = unixDb; k <= unixDe;) {  
        	
        	if((new Date(parseInt(k))).getDay()%6 !=0){//剔除周六周日
        		var workday = (new Date(parseInt(k))).format();  
        		workdays += workday +',';
        	}
            k = k + 24 * 60 * 60 * 1000; 
        } 
        
        return (workdays);
    }
    
    //format方法 转换成 yyyy/MM/dd形式
    Date.prototype.format = function() {  
        var s = '';  
        var mouth = (this.getMonth() + 1)>=10?(this.getMonth() + 1):('0'+(this.getMonth() + 1));  
        var day = this.getDate()>=10?this.getDate():('0'+this.getDate());  
        s += this.getFullYear() + '/'; // 获取年份。  
        s += mouth + "/"; // 获取月份。  
        s += day; // 获取日。  
        return (s); // 返回日期。  
    };
