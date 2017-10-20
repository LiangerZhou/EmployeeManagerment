function submitPage() {
	
		 var cpname = $("#status").val()
		 
		 $.ajax({
	    	dataType: "json",
	        data: {
	       	cpname: cpname,
	        },
	        type: "post", 
	        url: 'task_findByCpname.action',
	        success : function (data) {
	        	console.log(data);
	        	$("#taskTable").bootstrapTable('load', data);
	       },
	        error: function(){
	        	alert("错误");
	        }
	   })
}


//导出考核表
function exportE() {
	var cpname = $("#status").val();
	$.ajax({
	    dataType: "text",
	    data: {
	    	cpname,
	    },
	    type: "post", 
	    url: 'task_exportExcel.action',
	    success: function (data) {
	    }
	});
}